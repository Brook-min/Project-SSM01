package com.newer.controller.sys;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newer.pojo.sys.Dept;
import com.newer.pojo.sys.Keepon;
import com.newer.pojo.sys.Role;
import com.newer.pojo.sys.User;
import com.newer.pojo.sys.examples.UserExample;
import com.newer.pojo.sys.examples.UserExample.Criteria;
import com.newer.service.sys.BaseService;
import com.newer.service.sys.KeeponService;
import com.newer.service.sys.ResourceService;
import com.newer.service.sys.RoleService;
import com.newer.service.sys.UserService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.IsNotNullUtil;
import com.newer.util.sys.JumpUtil;
import com.newer.util.sys.MD5;
import com.newer.util.sys.MsgUtil;
import com.newer.util.sys.UserSession;

/**
 * 用户信息控制层
 *
 * @author Administrator
 */

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private RoleService roleService;

    @Autowired
    private BaseService baseService;

    @Autowired
    private KeeponService keeponService;

    /**
     * 根据id查询用户数据，返回编辑页面
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("selectUserById/{id}")
    public String selectById(@PathVariable("id") Integer id, Model model) {
        // 根据用户id查询用户信息
        User user = userService.selectById(id);
        // 加载上级名称
        List<User> userlist = userService.loadUpGradName();
        for (Iterator<User> iter = userlist.iterator(); iter.hasNext(); ) {
            User u = iter.next();
            if (id.equals(u.getId())) {
                iter.remove();
            }
        }
        // 查询所有的角色
        List<Role> roles = roleService.selectAll();
        // 根据用户id查询对应角色的多个id
        List<Integer> roleids = roleService.selectRoleId(id);
        // 加载学历
        Set<String> education = baseService.selectEducation("学历");
        model.addAttribute("roleids", roleids);
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        model.addAttribute("userlist", userlist);
        model.addAttribute("education", education);
        return JumpUtil.USER_EDIT;
    }


    /**
     * 根据id查询用户数据，返回个人信息页面
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("selectUserByMyselfInfo")
    public String selectUserByMyselfInfo(HttpServletRequest request, Model model) {
        UserSession userSession = (UserSession) request.getSession().getAttribute("userSession");
        // 根据用户id查询用户信息
        User user = userService.selectById(userSession.getId());
        // 加载上级名称
        List<User> userlist = userService.loadUpGradName();
        for (Iterator<User> iter = userlist.iterator(); iter.hasNext(); ) {
            User u = iter.next();
            if (userSession.getId().equals(u.getId())) {
                iter.remove();
            }
        }
        List<String> roleCodes = roleService.getRoleName(userSession.getId());
        String str = "";
        for (String string : roleCodes) {
            str += string + ",";
        }
        str = str.substring(0, str.length() - 1);

        model.addAttribute("roles", str);
        model.addAttribute("user", user);
        model.addAttribute("userlist", userlist);
        return "myselfinfo";
    }


    /**
     * 加载上级名称和角色名称，学历信息
     *
     * @param request
     * @return
     */
    @RequestMapping("loadUpGradName")
    public String loadUpGradName(HttpServletRequest request) {
        List<User> user = userService.loadUpGradName();
        List<Role> roles = roleService.selectAll();
        Set<String> education = baseService.selectEducation("学历");
        request.setAttribute("roles", roles);
        request.setAttribute("gradName", user);
        request.setAttribute("education", education);
        return JumpUtil.USER_ADD;
    }

    /**
     * 更改密码中转器，将id传递到修改界面
     *
     * @param id
     * @param request
     * @return
     */
    @RequestMapping("changepwd/{id}")
    public String changepwd(@PathVariable("id") Integer id, HttpServletRequest request) {
        request.setAttribute("id", id);
        return JumpUtil.USER_CHANGEPWD;
    }

    /**
     * 主界面，个人修改密码跳转
     *
     * @return
     */
    @RequestMapping("toIndexchangepwd")
    public String toIndexchangepwd() {
        return "pwd";
    }

    /**
     * 修改密码
     *
     * @param user
     * @return
     */
    @RequestMapping("changePassword")
    public @ResponseBody
    MsgUtil changePassword(User user) {
        // 获取传递信息
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(user.getId());
        criteria.andPasswordEqualTo(MD5.md5(user.getPassword()));
        List<User> users = userService.selectByIdAndPwd(example);
        if (users.size() == 0) {
            return MsgUtil.result(false, "原密码错误！");
        } else if (users.size() > 0) {
            int updatepwdById = userService.updatepwdById(user);
            if (updatepwdById > 0) {
                return MsgUtil.result(true, "修改成功！");
            }
        }
        return MsgUtil.result(false, "系统繁忙，请稍后重试！！");
    }

    /**
     * 修改主界面个人密码
     *
     * @param user
     * @return
     */
    @RequestMapping("changeIndexPwds")
    public @ResponseBody
    MsgUtil changeIndexPwds(User user) {
        int updatepwdById = userService.updatepwdById(user);
        if (updatepwdById > 0) {
            return MsgUtil.result(true, "修改成功！");
        } else {
            return MsgUtil.result(false, "系统繁忙，请稍后重试！！");
        }
    }

    /**
     * 根据部门id拿名称
     *
     * @return
     */
    @RequestMapping("showName")
    public @ResponseBody
    MsgUtil showName(User user) {
        if ((IsNotNullUtil.isNotNull(user.getId()))) {
            Dept selectDeptById = userService.selectDeptById(user.getId());
            return MsgUtil.result(true, selectDeptById.getDeptname());
        } else {
            return MsgUtil.result(true, "");
        }

    }

    /**
     * 用户登录
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public MsgUtil login(User user, HttpSession session) {
        // 加密密码
        if (IsNotNullUtil.isNotNull(user)) {
            String md5pwd = MD5.md5(user.getPassword());
            user.setPassword(md5pwd);
        }
        // 验证用户登陆
        User sysUser = userService.login(user);

        if (IsNotNullUtil.isNotNull(sysUser)) {
            if (sysUser.getDeletestatus() == 1) {
                return MsgUtil.result(false, "无效的用户！");
            } else if (sysUser.getLocked() == 1) {
                return MsgUtil.result(false, "该用户已停用！");
            } else {
                // 将查询到的对象信息存入session中
                Set<String> resourceList = resourceService.selectResourcesList(sysUser.getId());
                UserSession userSession = new UserSession();
                userSession.setId(sysUser.getId());
                // 用户真实姓名
                userSession.setRealname(sysUser.getRealname());
                // 用户登陆名
                userSession.setUsername(sysUser.getUsername());
                // 用户的资源
                userSession.setResourceList(resourceList);
                // 左侧菜单
                userSession.setResources(resourceService.selectMenu(sysUser.getId()));
                // 用户拥有的角色
                userSession.setRoleCodes(roleService.getRoleCodes(sysUser.getId()));
                session.setAttribute("userSession", userSession);
                return MsgUtil.result(true, "登陆成功！");
            }
        }
        return MsgUtil.result(false, "账号或密码输入有误！");
    }

    /**
     * 验证手机号码是否存在
     *
     * @param userName
     * @return
     */
    @RequestMapping("selectUserBytelephone")
    public @ResponseBody
    Map<String, Boolean> selectUserBytelephone(String telephone) {
        Map<String, Boolean> result = userService.selectUserBytelephone(telephone);
        return result;
    }

    /**
     * 添加验证邮箱是否重复
     *
     * @param email
     * @return
     */
    @RequestMapping("selectUserByemail")
    public @ResponseBody
    Map<String, Boolean> selectUserByemail(String email) {
        Map<String, Boolean> result = userService.selectUserByemail(email);
        return result;
    }

    /**
     * 根据真实姓名生成用户名
     */
    @RequestMapping("makeUserName")
    public @ResponseBody
    MsgUtil makeUserName(String realname) {
        MsgUtil makeUserName = userService.makeUserName(realname);
        return makeUserName;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @RequestMapping("add")
    public @ResponseBody
    MsgUtil add(User user, String roleid) {
        // 初始化用户信息,1:MD5加密，密码
        if (IsNotNullUtil.isNotNull(user.getPassword())) {
            String md5pwd = MD5.md5(user.getPassword());
            user.setPassword(md5pwd);
        }
        // 2:添加创建时间
        Date date = new Date();
        user.setCreatetime(date);
        // 3:将假删除设置默认值，默认值为0
        user.setDeletestatus(0);
        // 4:执行增加操作
        try {
            // 先执行增加操作
            userService.addUser(user);
            // 根据该对象获得该角色id
            User login = userService.login(user);
            // 获得该用户id
            Integer id = login.getId();
            // 然后使用split方法将字符串拆解到字符串数组中
            String[] strArr = roleid.split(",");
            // 定义一个长度与上述的字符串数组长度相通的整型数组
            Integer[] intArr = new Integer[strArr.length];
            // 转换成int类型数组
            for (int i = 0; i < intArr.length; i++) {
                intArr[i] = Integer.parseInt(strArr[i]);
            }
            // 循环插入
            for (int i = 0; i < intArr.length; i++) {
                userService.insertUserAndRole(id, intArr[i]);
            }
            return MsgUtil.result(true, "添加成功！");
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙，请稍后重试！");
        }

    }

    /**
     * 条件查询初始化用户数据表格
     *
     * @param bootstrapDataTable
     * @param condition
     * @return
     */
    @RequestMapping("select")
    @ResponseBody
    public BootstrapDataTable selectAllUser(BootstrapDataTable bootstrapDataTable, Condition condition) {
        return userService.selectAllUser(bootstrapDataTable, condition);
    }

    /**
     * 修改用户信息验证手机号码是否存在，其中自己的手机号码存在可以放行
     *
     * @param userName
     * @return
     */
    @RequestMapping("selectUserEditBytelephone")
    public @ResponseBody
    Map<String, Boolean> selectUserEditBytelephone(Integer id, String telephone) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        boolean result = false;
        List<User> selectU = userService.selectUserEditById(id);
        if (selectU.size() > 0) {
            if (telephone.equals(selectU.get(0).getTelephone())) {
                result = true;
                map.put("valid", result);
                return map;
            }
        }
        List<User> list = userService.selectUserEditByTelephone(telephone);
        if (list.size() != 0) {
            result = false;
        } else {
            result = true;
        }
        map.put("valid", result);

        return map;
    }

    /**
     * 修改用户信息验证邮箱，其中自己的邮箱可以放行
     *
     * @param id
     * @param email
     * @return
     */
    @RequestMapping("selectUserEditByemail")
    public @ResponseBody
    Map<String, Boolean> selectUserEditByemail(Integer id, String email) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        boolean result = false;
        List<User> selectU = userService.selectUserEditById(id);
        if (selectU.size() > 0) {
            if (email.equals(selectU.get(0).getEmail())) {
                result = true;
                map.put("valid", result);
                return map;
            }
        }
        List<User> list = userService.selectUserEditByEmail(email);
        if (list.size() != 0) {
            result = false;
        } else {
            result = true;
        }
        map.put("valid", result);

        return map;
    }


    /**
     * 修改用户
     *
     * @param user
     * @param roleid
     * @return
     */
    @RequestMapping("update")
    public @ResponseBody
    MsgUtil updateUser(User user, String roleid) {
        try {
            userService.updateUser(user, roleid);
            return MsgUtil.result(true, "修改成功！");
        } catch (Exception e) {
            return MsgUtil.result(true, "修改失败！");
        }

    }

    /**
     * 删除用户，实则做更新，假删除
     *
     * @param user
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public MsgUtil deleteUser(User user) {
        // 实例化传参对象
        User users = new User();
        // 设置值
        users.setId(user.getId());
        users.setDeletestatus(1);

        try {
            int deleteUser = userService.deleteUser(users);
            if (deleteUser > 0) {
                return MsgUtil.result(true, "删除成功！");
            }
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙，请稍后重试！");
        }

        return MsgUtil.result(false, "系统繁忙，请稍后重试！");
    }

    /**
     * 批量删除，假删除
     *
     * @param ids
     * @return
     */
    @RequestMapping("batchdelete/{ids}")
    @ResponseBody
    public MsgUtil deleteUserByIds(@PathVariable("ids") String ids) {
        MsgUtil msgUtil = new MsgUtil();
        try {
            userService.deleteUserByIds(ids);
            msgUtil.setFlag(true);
        } catch (Exception e) {
            msgUtil.setFlag(false);
            msgUtil.setMsg(e.getMessage());
        }
        return msgUtil;
    }


    /**
     * 启用
     *
     * @param user
     * @return
     */
    @RequestMapping("startusing")
    @ResponseBody
    public MsgUtil startusing(User user) {
        if (IsNotNullUtil.isNotNull(user)) {
            if (user.getLocked() == 1) {
                user.setLocked(0);
                try {
                    userService.isDisable(user);
                    return MsgUtil.result(true, "已启用！");
                } catch (Exception e) {
                    return MsgUtil.result(false, "系统繁忙，请稍后重试！");
                }
            }
        }
        return MsgUtil.result(false, "系统繁忙，请稍后重试！");
    }


    /**
     * 停用
     *
     * @param user
     * @return
     */
    @RequestMapping("blockup")
    @ResponseBody
    public MsgUtil blockup(User user) {
        if (IsNotNullUtil.isNotNull(user)) {
            if (user.getLocked() == 0) {
                user.setLocked(1);
                try {
                    userService.isDisable(user);
                    return MsgUtil.result(true, "已停用！");
                } catch (Exception e) {
                    return MsgUtil.result(false, "系统繁忙，请稍后重试！");
                }
            }
        }
        return MsgUtil.result(false, "系统繁忙，请稍后重试！");
    }


    /**
     * 用户注销
     *
     * @param request
     * @return
     */
    @RequestMapping("logOut")
    @ResponseBody
    public MsgUtil logOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return MsgUtil.result(true, "已注销！");
    }


    /**
     * 根据角色名称查询用户
     *
     * @param rolename
     * @return
     */
    @ResponseBody
    @RequestMapping("selectUserByRole")
    public List<User> selectUserByRole(String rolecode1, String rolecode2) {
        return userService.selectUserByRole(rolecode1, rolecode2);
    }

    /**
     * 查询是否有电话号码
     *
     * @param telephone
     * @return
     */
    @RequestMapping("selectBytelephone")
    @ResponseBody
    public Map<String, Boolean> selectBytelephone(String telephone, Integer id) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        boolean result = false;
        Keepon keepon = keeponService.selectKeeponById(id);
        if (id != null) {
            if (telephone.equals(keepon.getTelephone())) {
                result = true;
                map.put("valid", result);
                return map;
            }
        }
        List<Keepon> list = keeponService.selectByTelephone(telephone);
        if (list.size() != 0) {
            result = false;
        } else {
            result = true;
        }
        map.put("valid", result);

        return map;
    }

    /**
     * 查询是否有qq号码
     *
     * @param qq
     * @return
     */
    @RequestMapping("selectByqq")
    @ResponseBody
    public Map<String, Boolean> selectByqq(String qq, Integer id) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        boolean result = false;
        Keepon keepon = keeponService.selectKeeponById(id);
        if (id != null) {
            if (qq.equals(keepon.getQq())) {
                result = true;
                map.put("valid", result);
                return map;
            }
        }

        List<Keepon> list = keeponService.selectByQq(qq);
        if (list.size() != 0) {
            result = false;
        } else {
            result = true;
        }
        map.put("valid", result);

        return map;
    }

}
