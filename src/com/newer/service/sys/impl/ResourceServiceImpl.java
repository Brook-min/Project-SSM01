package com.newer.service.sys.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newer.dao.sys.ResourceMapper;
import com.newer.pojo.sys.Resource;
import com.newer.pojo.sys.examples.ResourceExample;
import com.newer.pojo.sys.examples.ResourceExample.Criteria;
import com.newer.service.sys.ResourceService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.IsNotNullUtil;
import com.newer.util.sys.MsgUtil;

/**
 * 资源信息业务逻辑处理层
 *
 * @author LiuKang
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    // 自动注入
    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 查询出资源网格表
     */
    @Override
    public BootstrapDataTable treeGrid() {
        // 查询出资源文件
        List<Resource> resources = resourceMapper.selectTreeGrid();
        // 实例化表格数据对象
        BootstrapDataTable bootstrapDataTable = new BootstrapDataTable();
        // 设置查询结果
        bootstrapDataTable.setRows(resources);
        return bootstrapDataTable;
    }

    /**
     * 根据编号单个查询
     */
    @Override
    public Resource selectById(Integer id) {
        Resource resource = resourceMapper.selectByPrimaryKey(id);
        if (IsNotNullUtil.isNotNull(resource.getPid())) {
            resource.setpName(resourceMapper.selectByPrimaryKey(resource.getPid()).getName());
        }
        return resource;
    }

    /**
     * 查询出用户的资源树
     */
    @Override
    public Set<String> selectResourcesList(Integer userId) {
        return resourceMapper.selectResourcesList(userId);
    }

    /**
     * 根据指定信息修改资源信息
     */
    @Override
    public MsgUtil updateResource(Resource resource) {
        try {
            // 避免设置父节点为该节点本身
            if (resource.getId().equals(resource.getPid())) {
                return MsgUtil.result(true, "修改成功");
            }
            // 避免父节点放入子节点
            // 通过id查询到该部门的子节点
            boolean flag = findNode(resource.getId(), resource.getPid());
            if (!flag) {
                return MsgUtil.result(false, "不能将此资源设置到下级资源!");
            } else {
                update(resource);
                return MsgUtil.result(true, "修改成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return MsgUtil.result(false, "系统繁忙!!");
        }
    }

    /**
     * 修改信息
     *
     * @param resource
     */
    public void update(Resource resource) {
        resourceMapper.updateByPrimaryKeySelective(resource);
        if ("1".equals(resource.getStatus())) {
            ResourceExample resourceExample = new ResourceExample();
            Criteria createCriteria = resourceExample.createCriteria();
            createCriteria.andPidEqualTo(resource.getId());
            List<Resource> resources = resourceMapper.selectByExample(resourceExample);
            if (resources.size() > 0) {
                for (Resource resource1 : resources) {
                    resource1.setStatus("1");
                    resourceMapper.updateByPrimaryKey(resource1);
                    update(resource1);
                }
            }
        }
    }

    /*
     * 查找子节点
     */
    // 子节点集合
    List<Integer> pids = null;

    @Override
    public boolean findNode(Integer id, Integer pid) {
        pids = new ArrayList<Integer>();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(id);
        return selectSon(pid, ids);
    }

    /**
     * 查询是否有子节点
     *
     * @param pid
     * @param ids
     * @return
     */
    private boolean selectSon(Integer pid, List<Integer> ids) {
        List<Integer> sonIds = resourceMapper.selectResourceSonNode(ids);
        for (Integer p : sonIds) {
            pids.add(p);
        }
        if (sonIds != null && !sonIds.isEmpty()) {
            selectSon(pid, sonIds);
        }
        if (!pids.contains(pid)) {
            return true;
        }
        return false;
    }

    /**
     * 根据编号删除 1.删除角色资源表信息 2.删除子级节点 3.删除本级节点
     */
    @Override
    public MsgUtil deleteResource(Integer id) {
        try {
            del(id);
            return MsgUtil.result(true, "删除成功!");
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙!");
        }
    }

    /**
     * 递归删除
     *
     * @param id
     */
    private void del(Integer id) {
        // 删除资源角色表中的资源信息
        resourceMapper.deleteRoleResource(id);

        // 删除子级资源
        // 实例化条件对象
        ResourceExample resourceExample = new ResourceExample();
        // 字段级筛选对象
        Criteria createCriteria = resourceExample.createCriteria();
        // 根据pid查询所有的子级
        createCriteria.andPidEqualTo(id);
        List<Resource> resources = resourceMapper.selectByExample(resourceExample);
        if (resources.size() > 0) {
            for (Resource resource : resources) {
                // 递归删除
                del(resource.getId());
                resourceMapper.deleteByPrimaryKey(resource.getId());
            }
        }
        // 删除父级资源
        resourceMapper.deleteByPrimaryKey(id);
    }

    /**
     * 查询出左侧菜单树
     */
    @Override
    public List<Resource> selectMenu(Integer userId) {
        // 查询出所有资源
        List<Resource> resources = resourceMapper.selectMenu(userId);

        // 存放菜单树
        List<Resource> resourceMenu = new ArrayList<Resource>();
        List<Resource> resources2 = null;
        for (Resource resource : resources) {
            // 顶级菜单
            if (resource.getType().equals("0")) {
                resourceMenu.add(resource);
                // 双重条件循环
                resources2 = new ArrayList<Resource>();
                for (Resource r : resources) {
                    // if等于
                    if (resource.getId().equals(r.getPid())) {
                        resources2.add(r);
                        resource.setResources(resources2);
                    }
                }
            }
        }
        if (IsNotNullUtil.isNotNull(resourceMenu) && IsNotNullUtil.isNotNull(resources2)) {
            Collections.sort(resourceMenu, new MyComparator());
            Collections.sort(resources2, new MyComparator());
        }
        return resourceMenu;
    }

    /**
     * 内部类 用于list集合排序
     *
     * @author ZhangZihan
     */
    class MyComparator implements Comparator<Resource> {

        @Override
        public int compare(Resource o1, Resource o2) {
            return o1.getSeq().compareTo(o2.getSeq());
        }

    }

    /**
     * 查询资源树
     */
    @Override
    public List<Resource> tree() {
        // 实例化条件对象
        ResourceExample resourceExample = new ResourceExample();
        // 实例化字段级筛选对象
        Criteria createCriteria = resourceExample.createCriteria();
        createCriteria.andTypeNotEqualTo("1");
        List<Resource> resources = resourceMapper.selectByExample(resourceExample);
        for (Resource resource : resources) {
            resource.setUrl(null);
        }
        return resources;
    }

    /**
     * 添加资源
     */
    @Override
    public MsgUtil addResource(Resource resource) {
        try {
            resource.setCreatetime(new Date());
            resourceMapper.insert(resource);
            return MsgUtil.result(true, "操作成功!");
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙!");
        }

    }

}
