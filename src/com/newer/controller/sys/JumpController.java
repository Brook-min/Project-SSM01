package com.newer.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newer.util.sys.JumpUtil;

/**
 * 用户页面跳转
 *
 * @author ZhangZihan
 */
@Controller
public class JumpController {

    /**
     * 跳转到首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return JumpUtil.INDEX;
    }

    /**
     * 跳转到用户管理页面
     *
     * @return
     */
    @RequestMapping("user/manager")
    public String userManager() {
        return JumpUtil.USER_MANAGER;
    }

    /**
     * 跳转到个人信息界面
     *
     * @return
     */
    @RequestMapping("user/myselfinfo")
    public String myselfinfo() {
        return JumpUtil.MYSELF_INFO;
    }


    /**
     * 跳转到资源管理页面
     *
     * @return
     */
    @RequestMapping("resource/manager")
    public String resourceManager() {
        return JumpUtil.RESOURCE_MANAGER;
    }

    @RequestMapping("system_manager/resource/add")
    public String resourceEdit() {
        return JumpUtil.RESOURCE_ADD;
    }


    /**
     * 跳转到角色管理页面
     *
     * @return
     */
    @RequestMapping("role/manager")
    public String roleManager() {
        return JumpUtil.ROLE_MANAGER;
    }


    /**
     * 跳转到角色管理页面
     *
     * @return
     */
    @RequestMapping("system_manager/role/add")
    public String roleAdd() {
        return JumpUtil.ROLE_ADD;
    }

    /**
     * 跳转到部门管理页面
     *
     * @return
     */
    @RequestMapping("dept/manager")
    public String deptManager() {
        return JumpUtil.DEPT_MANAGER;
    }

    /**
     * 跳转到部门添加页面
     *
     * @return
     */
    @RequestMapping("system_manager/dept/dept_add")
    public String deptAdd() {
        return JumpUtil.DEPT_ADD;
    }


    /**
     * 跳转到基础数据管理页面
     *
     * @return
     */
    @RequestMapping("base/manager")
    public String baseManager() {
        return JumpUtil.BASE_MANAGER;
    }

    /**
     * 跳转到基础数据添加页面
     *
     * @return
     */
    @RequestMapping("system_manager/base/base_add")
    public String baseAdd() {
        return JumpUtil.BASE_ADD;
    }

    /**
     * 跳转到前台管理的数据备案页面
     *
     * @return
     */
    @RequestMapping("front/keepon")
    public String frontKeepon() {
        return JumpUtil.FRONT_KEEPON;
    }


    /**
     * 跳转到前台管理的数据备案查询页面
     *
     * @return
     */
    @RequestMapping("front/keepon/query")
    public String frontKeeponQuery() {
        return JumpUtil.FRONT_KEEPON_QUERY;
    }

    /**
     * 跳转到前台管理的咨询进度查询页面
     *
     * @return
     */
    @RequestMapping("front/manager/keepon/consultationProgress")
    public String frontKeeponConsultationProgress() {
        return JumpUtil.FRONT_CONSULTATION_PROGRESS;
    }

    /**
     * 跳转到前台管理的姓名备注页面
     *
     * @return
     */
    @RequestMapping("front/keepon/nameRemark")
    public String frontKeeponNameRemark() {
        return JumpUtil.FRONT_NAME_REMARK;
    }

    /**
     * 跳转到咨询管理的数据备案查询页面
     *
     * @return
     */
    @RequestMapping("consultation/keepon/query/select")
    public String consultationKeeponQuery() {
        return JumpUtil.CONSULTATION_KEEPON_QUERY;
    }

    /**
     * 跳转到咨询管理的添加咨询信息页面
     *
     * @return
     */
    @RequestMapping("consultation/keepon/add")
    public String consultationAdd() {
        return JumpUtil.CONSULTATION_ADD;
    }

    /**
     * 跳转到市场管理的备案信息查询页面
     *
     * @return
     */
    @RequestMapping("market/keepon/select")
    public String marketKeeponQuery() {
        return JumpUtil.MARKET_KEEPON_QUERY;
    }

    /**
     * 跳转到市场管理的是否备案查询页面
     *
     * @return
     */
    @RequestMapping("market/keepon/iskeepon/query")
    public String marketIskeeponQuery() {
        return JumpUtil.MARKET_ISKEEPON_QUERY;
    }


}
