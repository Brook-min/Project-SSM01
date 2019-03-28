package com.newer.service.sys;

import java.util.List;
import java.util.Set;

import com.newer.pojo.sys.Resource;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.MsgUtil;

/**
 * 资源信息业务处理接口
 *
 * @author LiuKang
 */
public interface ResourceService {


    /**
     * 查询出资源网格视图表格
     *
     * @return
     */
    public BootstrapDataTable treeGrid();

    /**
     * 根据编号单个查询
     *
     * @param id
     * @return
     */
    public Resource selectById(Integer id);


    /**
     * 查询用户所有资源
     *
     * @param id
     * @return
     */
    public Set<String> selectResourcesList(Integer userId);


    /**
     * 根据指定信息修改资源
     *
     * @param resource
     * @return
     */
    public MsgUtil updateResource(Resource resource);

    /**
     * 根据主键删除资源信息
     *
     * @param id
     * @return
     */
    public MsgUtil deleteResource(Integer id);

    /**
     * 查询是否有子节点
     *
     * @param id
     * @param pid
     * @return
     */
    boolean findNode(Integer id, Integer pid);

    /**
     * 查询出左侧导航栏
     *
     * @param userId
     * @return
     */
    public List<Resource> selectMenu(Integer userId);

    /**
     * 查询资源树
     *
     * @return
     */
    public List<Resource> tree();


    /**
     * 修改
     *
     * @param resource
     */
    public void update(Resource resource);

    /**
     * 添加
     *
     * @param resource
     * @return
     */
    public MsgUtil addResource(Resource resource);


}
