package com.newer.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.newer.dao.sys.DeptMapper;
import com.newer.dao.sys.UserMapper;
import com.newer.pojo.sys.Dept;
import com.newer.pojo.sys.User;
import com.newer.pojo.sys.examples.UserExample;
import com.newer.pojo.sys.examples.UserExample.Criteria;
import com.newer.service.sys.UserService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.ChangeToPinYin;
import com.newer.util.sys.Condition;
import com.newer.util.sys.IsNotNullUtil;
import com.newer.util.sys.MD5;
import com.newer.util.sys.MsgUtil;


/**
 * 用户信息业务逻辑处理层
 *
 * @author LiuKang
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DeptMapper deptMapper;

    /**
     * 登录
     */
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    /**
     * 验证注册手机是否重复
     */
    @Override
    @ResponseBody
    public Map<String, Boolean> selectUserBytelephone(String telephone) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        User users = userMapper.selectUserBytelephone(telephone);
        boolean result = true;
        if (users != null) {
            result = false;
        }
        map.put("valid", result);
        return map;
    }

    /**
     * 验证注册邮箱是否重复
     */
    @Override
    public Map<String, Boolean> selectUserByemail(String email) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        User users = userMapper.selectUserByemail(email);
        boolean result = true;
        if (users != null) {
            result = false;
        }
        map.put("valid", result);
        return map;
    }

    /**
     * 添加用户
     */
    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * 给用户授权
     */
    @Override
    public int insertUserAndRole(Integer user, Integer role) {
        return userMapper.insertUserAndRole(user, role);
    }

    /**
     * 条件查询初始化用户表格
     */
    @Override
    public BootstrapDataTable selectAllUser(BootstrapDataTable dataTable, Condition condition) {
        // 给PageHelper设参数
        if (IsNotNullUtil.isNotNull(dataTable.getOffset()) && IsNotNullUtil.isNotNull(dataTable.getLimit())) {
            PageHelper.offsetPage(dataTable.getOffset(), dataTable.getLimit());
        }
        // 实例化user条件对象
        UserExample userExample = new UserExample();
        // 实例筛选对象
        // 去重
        userExample.setDistinct(true);
        // 排序
        if (IsNotNullUtil.isNotNull(dataTable.getSort()) && IsNotNullUtil.isNotNull(dataTable.getOrder())) {
            userExample.setOrderByClause(dataTable.getSort() + " " + dataTable.getOrder());
        }

        // 实例筛选对象
        Criteria createCriteria = userExample.createCriteria();
        // 判断查找日期
        if (IsNotNullUtil.isNotNull(condition.getUserSearch())) {
            Criteria createCriteria1 = userExample.createCriteria();
            Criteria createCriteria2 = userExample.createCriteria();
            Criteria createCriteria3 = userExample.createCriteria();
            Criteria createCriteria4 = userExample.createCriteria();
            // 电话
            createCriteria1.andTelephoneLike("%" + condition.getUserSearch() + "%");
            createCriteria1.andDeletestatusEqualTo(0);
            // 邮箱
            createCriteria2.andEmailLike("%" + condition.getUserSearch() + "%");
            createCriteria2.andDeletestatusEqualTo(0);
            // 查询用户名
            createCriteria3.andUsernameLike("%" + condition.getUserSearch() + "%");
            createCriteria3.andDeletestatusEqualTo(0);

            createCriteria4.andRealnameLike("%" + condition.getUserSearch() + "%");
            createCriteria4.andDeletestatusEqualTo(0);
            userExample.or(createCriteria1);
            userExample.or(createCriteria2);
            userExample.or(createCriteria3);
            userExample.or(createCriteria4);
        } else {
            createCriteria.andDeletestatusEqualTo(0);
        }

        // 查询用户列表
        List<User> selectByExample = userMapper.selectByExample(userExample);

        // 设置上级名称
        for (User user : selectByExample) {
            if (IsNotNullUtil.isNotNull(user.getUpno()) && user.getUpno() != 0) {
                user.setUpname(userMapper.selectByPrimaryKey(user.getUpno()).getRealname());
            }
        }
        //设置上级部门名称
        for (User user : selectByExample) {
            if (IsNotNullUtil.isNotNull(user.getDept())) {
                user.setDeptName(user.getDept().getDeptname());
            }
        }
        // 实例一个PageInfo对象 ，并设置参数userlist
        PageInfo<User> info = new PageInfo<User>(selectByExample);

        // 实例一个数据表对象
        BootstrapDataTable bootDataTable = new BootstrapDataTable();

        // 设置值
        bootDataTable.setTotal((int) info.getTotal());
        bootDataTable.setRows(info.getList());

        return bootDataTable;
    }

    /**
     * 修改用户禁用状态
     */
    @Override
    public int isDisable(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 查询修改电话是否存在
     */
    @Override
    public List<User> selectUserEditById(Integer id) {
        UserExample exmaple = new UserExample();
        Criteria createCriteria = exmaple.createCriteria();
        createCriteria.andDeletestatusEqualTo(0);
        createCriteria.andIdEqualTo(id);
        return userMapper.selectByExample(exmaple);
    }

    /**
     * 根据id查询用户信息
     */
    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过id和密码查询密码是否正确
     *
     * @param example
     * @return
     */
    @Override
    public List<User> selectByIdAndPwd(UserExample example) {
        // 查询
        List<User> result = userMapper.selectByExample(example);
        return result;

    }

    /**
     * 根据id查询修改密码
     */
    @Override
    public int updatepwdById(User user) {
        User userExample = new User();
        userExample.setId(user.getId());
        userExample.setPassword(MD5.md5(user.getUsername()));
        return userMapper.updateByPrimaryKeySelective(userExample);
    }

    /**
     * 根据id删除，假删除
     */
    @Override
    public int deleteUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 批量删除，假删除
     */
    @Override
    public int deleteUserByIds(String ids) {
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
        return userMapper.deleteUserByIds(intArr);
    }

    /**
     * 查询修改所有电话信息
     */
    @Override
    public List<User> selectUserEditByTelephone(String telphone) {
        return userMapper.selectUserEditByTelephone(telphone);
    }

    /**
     * 查询修改所有邮箱信息
     */
    @Override
    public List<User> selectUserEditByEmail(String email) {
        return userMapper.selectUserEditByEmail(email);
    }

    /**
     * 加载上级名称
     */
    @Override
    public List<User> loadUpGradName() {
        UserExample example = new UserExample();
        Criteria createCriteria = example.createCriteria();
        createCriteria.andDeletestatusEqualTo(0);
        createCriteria.andLockedEqualTo(0);
        return userMapper.selectByExample(example);
    }

    /**
     * 查找部门
     */
    @Override
    public Dept selectDeptById(Integer id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改用户信息
     */
    @Override
    public void updateUser(User user, String roleid) {

        try {
            //获得用户id
            Integer userid = user.getId();
            deleteByUserId(userid);
            String[] strArr = roleid.split(",");
            // 定义一个长度与上述的字符串数组长度相通的整型数组
            Integer[] intArr = new Integer[strArr.length];
            // 转换成int类型数组
            for (int i = 0; i < intArr.length; i++) {
                intArr[i] = Integer.parseInt(strArr[i]);
            }
            // 循环插入
            for (int i = 0; i < intArr.length; i++) {
                insertUserAndRole(userid, intArr[i]);
            }
            userMapper.updateByPrimaryKeySelective(user);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据用户id清空用户角色
     */
    @Override
    public int deleteByUserId(Integer userid) {
        return userMapper.deleteByUserId(userid);
    }

    /**
     * 查询角色
     */
    @Override
    public List<User> selectUserByRole(String rolecode1, String rolecode2) {
        return userMapper.selectUserByRole(rolecode1, rolecode2);
    }

    /**
     * 省市县查询
     */
    @Override
    public List<User> selectByPCA(String province, String city, String area) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        //省
        criteria.andProvinceEqualTo(province);
        //市
        criteria.andCityEqualTo(city);
        //县
        criteria.andAreaEqualTo(area);
        return userMapper.selectByExample(example);
    }


    /**
     * 拼音转汉字
     */
//*********************************************************************************

    /**
     * 生成用户名
     */
    @Override
    public MsgUtil makeUserName(String realname) {
        ChangeToPinYin c = new ChangeToPinYin();
        //生成拼音
        String str = c.getStringPinYin(realname);

        //查询是否存在该用户
        Boolean flag = selectByMakeUserName(str);

        if (flag) {
            return MsgUtil.result(true, str);
        } else {
            for (int j = 1; j < 1000; j++) {
                Boolean f = selectByMakeUserName(str + j);
                if (f) {
                    return MsgUtil.result(true, str + j);
                }
            }
        }

        return MsgUtil.result(true, null);
    }

    /**
     * 查询用户名是否存在
     */
    @Override
    public Boolean selectByMakeUserName(String name) {
        UserExample example = new UserExample();
        Criteria create = example.createCriteria();
        create.andUsernameEqualTo(name);
        List<User> user = userMapper.selectByExample(example);
        if (user.size() == 0) {
            return true;
        }
        return false;
    }


//*******************************************************************************


}
