package com.newer.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.newer.pojo.sys.User;
import com.newer.pojo.sys.examples.UserExample;

@Repository("userMapper")
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User login(User user);

    /**
     * 添加用户查询手机是否重复
     *
     * @param telephone
     * @return
     */
    User selectUserBytelephone(@Param("telephone") String telephone);

    /**
     * 添加用户查询邮箱是否重复
     *
     * @param email
     * @return
     */
    User selectUserByemail(@Param("email") String email);

    /**
     * 修改用户检查手机是否重复
     *
     * @param telphone
     * @return
     */
    List<User> selectUserEditByTelephone(@Param("telphone") String telphone);

    /**
     * 修改用户检查邮箱是否重复
     *
     * @param email
     * @return
     */
    List<User> selectUserEditByEmail(@Param("email") String email);

    /**
     * 批量假删除
     *
     * @param intArr
     * @return
     */
    int deleteUserByIds(Integer intArr[]);

    /**
     * 给用户授权
     *
     * @param user
     * @param role
     * @return
     */
    int insertUserAndRole(@Param("user") int user, @Param("role") int role);

    /**
     * 根据用户id清空用户角色
     *
     * @param user
     * @param role
     * @return
     */
    int deleteByUserId(@Param("userid") int userid);

    /**
     * 查询市场专员信息
     *
     * @param rolecode2
     * @param rolename
     * @return
     */
    List<User> selectUserByRole(@Param("rolecode1") String rolecode1, @Param("rolecode2") String rolecode2);


}