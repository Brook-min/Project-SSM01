package com.newer.service.sys;

import java.util.List;
import java.util.Map;


import com.newer.pojo.sys.Dept;
import com.newer.pojo.sys.User;
import com.newer.pojo.sys.examples.UserExample;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.MsgUtil;

/**
 * 用户业务逻辑处理接口
 *
 * @author LiuKang
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 检查手机号码是否存在
     *
     * @param username
     * @return
     */
    Map<String, Boolean> selectUserBytelephone(String telephone);

    /**
     * 检查邮箱是否存在
     *
     * @param email
     * @return
     */
    Map<String, Boolean> selectUserByemail(String email);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 给用户授权
     *
     * @param user
     * @param role
     * @return
     */
    int insertUserAndRole(Integer user, Integer role);

    /**
     * 条件查询初始化用户数据表格
     *
     * @param bootstrapDataTable
     * @param condition
     * @return
     */
    BootstrapDataTable selectAllUser(BootstrapDataTable bootstrapDataTable, Condition condition);

    /**
     * 修改用户是否停用
     *
     * @param user
     * @return
     */
    int isDisable(User user);

    /**
     * 通过id查询用户信息
     */
    User selectById(Integer id);

    /**
     * 通过id和密码查询密码是否正确
     *
     * @param example
     * @return
     */
    List<User> selectByIdAndPwd(UserExample example);

    /**
     * 根据id修改密码
     *
     * @param id
     * @return
     */
    int updatepwdById(User user);

    /**
     * 用于做假删除，实则是一条更新语句
     *
     * @param id
     * @return
     */
    int deleteUser(User user);

    /**
     * 批量删除角色，假删除
     *
     * @param ids
     * @return
     */
    int deleteUserByIds(String ids);

    /**
     * 加载所有上级名称
     *
     * @return
     */
    List<User> loadUpGradName();

    /**
     * 根据部门id查询信息
     *
     * @param id
     * @return
     */
    Dept selectDeptById(Integer id);


    /**
     * 编辑用户判断电话是否重复
     *
     * @param telphone
     * @return
     */
    List<User> selectUserEditById(Integer id);

    /**
     * 编辑用户判断电话是否重复
     *
     * @param telphone
     * @return
     */
    List<User> selectUserEditByTelephone(String telphone);

    /**
     * 编辑用户判断邮箱是否重复
     *
     * @param email
     * @return
     */
    List<User> selectUserEditByEmail(String email);

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    void updateUser(User user, String roleid);

    /**
     * 根据用户id清空用户角色
     *
     * @param use
     * @param role
     * @return
     */
    int deleteByUserId(Integer userid);

    /**
     * 根据角色名称查询用户
     *
     * @param rolename
     * @param rolecode2
     * @return
     */
    List<User> selectUserByRole(String rolecode1, String rolecode2);

    /**
     * 根据省市县查询
     *
     * @param province
     * @param city
     * @param area
     * @return
     */
    List<User> selectByPCA(String province, String city, String area);

    /**
     * 根据真实姓名生成用户名
     *
     * @param realname
     * @return
     */
    MsgUtil makeUserName(String realname);

    /**
     * 根据生成的name判断数据库是否存在，如果存在即将name修改
     *
     * @param name
     * @return
     */
    Boolean selectByMakeUserName(String name);


}
