package com.newer.dao.sys;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.newer.pojo.sys.Role;
import com.newer.pojo.sys.examples.RoleExample;

@Repository("roleMapper")
public interface RoleMapper {
    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 批量假删除方法
     */
    int deleteByIds(Integer intArr[]);

    /**
     * 根据角色id查询权限对应的资源id
     */
    @Select("select resourceid from tb_role_resource where roleid=#{roleId}")
    List<Integer> selJurisdictionByRoleId(Integer roleId);

    /**
     * 根据角色id删除role_resource表的数据
     *
     * @param roleId
     * @return int s
     */
    @Delete("delete from tb_role_resource where roleid=#{roleId}")
    int delteByRoleId(Integer roleId);

    /**
     * @param roleid     角色id
     * @param resourceId 资源id
     * @return int
     */
    int grant(@Param("roles") List<Role> roles);

    /**
     * 根据角色名查询角色是否存在
     */
    @Select("select * from tb_role where rolename=#{roleName}")
    Role selectByRoleName(String roleName);

    /**
     * 根据用户id查询user_role的roleid数据
     */
    @Select("select roleid from tb_user_role where userid=#{userid}")
    List<Integer> selectRoleId(Integer userid);

    @Select("SELECT DISTINCT rolecode FROM tb_user_role ur left join tb_role r on  ur.roleid=r.id where userid=#{uid} and deletestatus=0")
    Set<String> getRoleCodes(Integer uid);

    @Select("select tbr.rolename from tb_user t inner join tb_user_role tb on t.id = tb.userid inner join tb_role tbr on tb.roleid = tbr.id where t.id = #{roid}")
    List<String> getRoleName(Integer roid);
}