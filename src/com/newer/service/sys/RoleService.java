package com.newer.service.sys;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.newer.pojo.sys.Resource;
import com.newer.pojo.sys.Role;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;

/**
 * 角色业务逻辑处理接口
 *
 * @author 奉小军
 */
public interface RoleService {

    /**
     * 根据分页条件查询角色
     *
     * @param role               角色实体
     * @param bootstrapDataTable 分页对象
     * @return
     */
    BootstrapDataTable listAll(BootstrapDataTable bootstrapDataTable, Condition condition);

    /**
     * 根据id查询角色
     *
     * @param role 角色实体
     * @param
     * @return role
     */
    Role selectById(Integer id);


    /**
     * 作假删除：修改删除状态为1
     */
    int fakeDelete(Integer id);


    /**
     * 根据id修改角色
     */
    int updateRoleByid(Role role);


    /**
     * 查询角色名是否存在
     */
    Map<String, Boolean> checkRoleName(String rolename);

    /**
     * 添加角色
     */
    int addRole(Role role);


    /**
     * 查出资源树
     */
    List<Resource> tree();


    /**
     * 批量删除角色
     */
    int deleteByIds(String ids);


    /**
     * 根据角色id查询权限对应的资源id
     */
    List<Integer> selJurisdictionByRoleId(Integer roleId);


    /**
     * 根据角色roleId给角色授权
     * rids:以逗号分隔的多个资源id
     */
    void grant(Integer roleId, String rids);

    /**
     * 查询所有未删除的角色
     */
    List<Role> selectAll();


    /**
     * 根据用户id查询用户所对应的多个角色id
     *
     * @param userid
     * @return
     */
    List<Integer> selectRoleId(Integer userid);

    /**
     * 根据用户id查询出该用户拥有的角色code
     *
     * @param id
     * @return
     */
    Set<String> getRoleCodes(Integer id);

    /**
     * 根据用户id查询该用户拥有的角色名称
     *
     * @param roid
     * @return
     */
    List<String> getRoleName(Integer roid);

}
