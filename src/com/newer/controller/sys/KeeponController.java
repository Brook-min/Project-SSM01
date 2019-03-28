package com.newer.controller.sys;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newer.service.sys.KeeponService;
import com.newer.service.sys.UserService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.MsgUtil;
import com.newer.pojo.sys.User;

/**
 * 备案信息控制层
 *
 * @author 卿超
 */

@RequestMapping("/keepon")
@Controller
public class KeeponController {

    //自动注入
    @Autowired
    private KeeponService keeponService;
    @Autowired
    private UserService userService;

    /**
     * 回访记录查询
     *
     * @param dataTable
     * @param condition
     * @param session
     * @return
     */
    @RequestMapping("/keepReturn")
    @ResponseBody
    public BootstrapDataTable keepReturn(BootstrapDataTable dataTable, Condition condition, HttpServletRequest request) {
        return keeponService.keepReturn(dataTable, condition, request);
    }

    /**
     * 待上门记录查询
     *
     * @param dataTable
     * @param condition
     * @param session
     * @return
     */
    @RequestMapping("/keepVisit")
    @ResponseBody
    public BootstrapDataTable keepVisit(BootstrapDataTable dataTable, Condition condition, HttpServletRequest request) {
        return keeponService.keepVisit(dataTable, condition, request);
    }

    /**
     * 省市县查询
     *
     * @param province 省
     * @param city     市
     * @param area     县
     * @return
     */
    @RequestMapping("/selectByPCA")
    @ResponseBody
    public List<User> selectByPCA(String province, String city, String area) {
        return userService.selectByPCA(province, city, area);
    }

    /**
     * 未上门
     *
     * @param id
     * @return
     */
    @RequestMapping("notVis")
    @ResponseBody
    public MsgUtil notVis(Integer id) {
        boolean flag = keeponService.notVis(id);
        if (flag) {
            return MsgUtil.result(true, "操作成功");
        }
        return MsgUtil.result(false, "操作失败");
    }


}
