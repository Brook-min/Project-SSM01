package com.newer.service.sys.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.dao.sys.ResourceMapper;
import com.newer.dao.sys.RoleMapper;
import com.newer.pojo.sys.Resource;
import com.newer.pojo.sys.Role;
import com.newer.pojo.sys.examples.RoleExample;
import com.newer.pojo.sys.examples.RoleExample.Criteria;
import com.newer.service.sys.RoleService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.IsNotNullUtil;

/**
 * 角色业务逻辑处理层
 *
 * @author 奉小军
 */
@Service
public class RoleServiceImpl implements RoleService {

    /**
     * 注入RoleMapper对象 dao层
     */
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 注入ResourceMapper对象 dao层
     */
    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public BootstrapDataTable listAll(BootstrapDataTable dataTable, Condition condition) {
        // 给PageHelper设参数
        PageHelper.offsetPage(dataTable.getOffset(), dataTable.getLimit());
        // 实例化条件对象
        RoleExample roleExample = new RoleExample();
        // 去重
        roleExample.setDistinct(true);
        // 排序
        if (IsNotNullUtil.isNotNull(dataTable.getSort()) && IsNotNullUtil.isNotNull(dataTable.getOrder())) {
            roleExample.setOrderByClause(dataTable.getSort() + " " + dataTable.getOrder());
        }
        // 实例化字段级筛选对象
        Criteria createCriteria = roleExample.createCriteria();

        // 添加未删除状态
        createCriteria.andDeletestatusEqualTo(0);

        // 判断条件是否为空
        if (IsNotNullUtil.isNotNull(condition)) {

            // 判断是否为空
            if (IsNotNullUtil.isNotNull(condition.getRoleName())) {
                createCriteria.andRolenameLike("%" + condition.getRoleName() + "%");
            }
        }

        // 调用mpper层方法查询所有角色
        List<Role> list = roleMapper.selectByExample(roleExample);
        // 实例一个PageInfo对象 ，并设置参数list
        PageInfo<Role> info = new PageInfo<Role>(list);
        // 实例一个数据表对象
        BootstrapDataTable bootDataTable = new BootstrapDataTable();
        // 设值
        bootDataTable.setTotal((int) info.getTotal());
        bootDataTable.setRows(info.getList());
        // 返回对象
        return bootDataTable;
    }

    /**
     * 根据id查询角色
     *
     * @param role 角色实体
     * @param
     * @return
     */
    @Override
    public Role selectById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    /**
     * 假删除
     */
    @Override
    public int fakeDelete(Integer id) {
        // 实例化角色对象
        Role role = new Role();

        // 设置id
        role.setId(id);

        // 修改删除状态为1
        role.setDeletestatus(1);
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 根据id修改角色
     */
    @Override
    public int updateRoleByid(Role role) {
        // 调用mapper层方法实现修改角色
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * 查询角色名是否存在
     */
    @Override
    public Map<String, Boolean> checkRoleName(String rolename) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        // 根据角色名查询角色
        Role role = roleMapper.selectByRoleName(rolename);
        // 设置结果值
        boolean result = true;
        // 判断集合是否为空
        if (role != null) {
            // 判断数据库角色名是否与页面传来的一致
            if (role.getRolename().equals(rolename)) {
                result = false;
            }
        }
        // 设置参数
        map.put("valid", result);
        return map;
    }

    /**
     * 添加角色
     */
    @Override
    public int addRole(Role role) {
        // 设创建角色的时间
        role.setCreatetime(new Date());
        // 设默认值
        role.setIsdefault(0);
        // 设删除状态为0, 1:删除状态 ,0:未删除状态
        role.setDeletestatus(0);
        // 调用mapper层方法插入角色对象
        return roleMapper.insertSelective(role);
    }

    /**
     * 查询资源树
     */
    @Override
    public List<Resource> tree() {
        return resourceMapper.selectByExample(null);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteByIds(String ids) {
        // 然后使用split方法将字符串拆解到字符串数组中
        String[] strArr = ids.split(",");
        // 定义一个长度与上述的字符串数组长度相通的整型数组
        Integer[] intArr = new Integer[strArr.length];
        for (int a = 0; a < strArr.length; a++) {
            // 然后遍历字符串数组，使用包装类Integer的valueOf方法将字符串转为整型
            intArr[a] = Integer.valueOf(strArr[a]);
        }
        for (int b = 0; b < intArr.length; b++) {
            System.out.println(intArr[b]);
        }
        return roleMapper.deleteByIds(intArr);
    }

    /**
     * 根据角色id查询权限对应的资源id
     */
    @Override
    public List<Integer> selJurisdictionByRoleId(Integer roleId) {
        return roleMapper.selJurisdictionByRoleId(roleId);
    }

    /**
     * 根据角色id给角色授权 roleId:角色id rids:以逗号分隔的多个资源id
     */
    @Override
    public void grant(Integer roleId, String rids) {
        try {
            // 删除所有关于本角色的资源数据
            roleMapper.delteByRoleId(roleId);
            List<Role> roles = new ArrayList<Role>();
            // 判断资源ids是否为空字符串
            if (rids != null && !rids.equalsIgnoreCase("")) {
                // 分隔字符串，遍历字符串数组
                for (String resourceId : rids.split(",")) {
                    // 循环插入数据
                    Role role = new Role();
                    role.setId(roleId);
                    role.setResourceid(Integer.parseInt(resourceId));
                    roles.add(role);
                }
                roleMapper.grant(roles);
            }
        } catch (Exception e) {
        }
    }

    /**
     * 查询所有未删除的角色
     */
    @Override
    public List<Role> selectAll() {
        // 实例化条件对象
        RoleExample roleExample = new RoleExample();
        // 去重
        roleExample.setDistinct(true);
        // 实例化字段级筛选对象
        Criteria createCriteria = roleExample.createCriteria();

        // 添加未删除状态
        createCriteria.andDeletestatusEqualTo(0);
        return roleMapper.selectByExample(roleExample);
    }

    /**
     * 根据用户id查询用户所对应的多个角色id
     *
     * @param userid
     * @return
     */
    @Override
    public List<Integer> selectRoleId(Integer userid) {
        return roleMapper.selectRoleId(userid);
    }

    /**
     * 根据用户id查询该用户所拥有的角色code
     */
    @Override
    public Set<String> getRoleCodes(Integer uid) {

        return roleMapper.getRoleCodes(uid);
    }

    /**
     * 根据用户id查询该用户所拥有的角色名称
     */
    @Override
    public List<String> getRoleName(Integer roid) {
        // TODO Auto-generated method stub
        return roleMapper.getRoleName(roid);
    }

}
