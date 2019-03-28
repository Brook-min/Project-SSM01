package com.newer.controller.sys;
/**
 * 前台管理控制层
 *
 * @author ZhangZihan
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.newer.pojo.sys.Keepon;
import com.newer.pojo.sys.User;
import com.newer.service.sys.ConsultationService;
import com.newer.service.sys.KeeponService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.JumpUtil;
import com.newer.util.sys.MsgUtil;

@RequestMapping("/front/keepon")
@Controller
public class FrontController {

    // 自动注入
    @Autowired
    private KeeponService keeponService;

    @Autowired
    private ConsultationService consultationService;

    /**
     * 添加备案信息
     *
     * @param keepon
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public MsgUtil add(Keepon keepon) {
        return keeponService.addKeepon(keepon);
    }

    /**
     * 前台管理数据备案查询
     *
     * @param bootstrapDataTable
     * @param condition
     * @return
     */
    @RequestMapping("selectAll")
    @ResponseBody
    public BootstrapDataTable selectAll(BootstrapDataTable bootstrapDataTable, Condition condition) {
        return keeponService.selectAll(bootstrapDataTable, condition);
    }

    /**
     * 跳转到前台管理的指派咨询师页面 查询咨询师
     *
     * @return
     */
    @RequestMapping("query/assignCounselor/{id}")
    public String frontKeeponAssign(HttpServletRequest request, @PathVariable("id") Integer id) {
        // 根据id查询备案信息
        Keepon keepon = keeponService.selectKeeponById(id);
        // 获得所有咨询师
        List<User> selectConsultant = keeponService.selectConsultant();
        request.setAttribute("consultantObj", keepon);
        request.setAttribute("consultant", selectConsultant);
        return JumpUtil.FRONT_ASSIGN_COUNSELOR;
    }

    /**
     * 跳转到前台管理的指派市场专员页面 查询市场专员
     *
     * @return
     */
    @RequestMapping("query/assignMarker/{id}")
    public String frontKeeponAssignMarker(HttpServletRequest request, @PathVariable("id") Integer id) {
        // 根据id查询备案信息
        Keepon keepon = keeponService.selectKeeponById(id);
        // 获得所有市场专员
        List<User> selectConsultant = keeponService.selectMarker();
        request.setAttribute("consultantObj", keepon);
        request.setAttribute("consultant", selectConsultant);
        return JumpUtil.FRONT_ASSIGN_MARKER;
    }

    /**
     * 指派咨询师
     *
     * @param keepon
     * @return
     */
    @RequestMapping("query/updateKeepon")
    @ResponseBody
    public MsgUtil updateKeepon(Keepon keepon) {
        try {
            keeponService.updateKeepon(keepon);
            return MsgUtil.result(true, "指派成功！");
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙，请稍后重试！");
        }
    }

    /**
     * 指派市场专员
     *
     * @param keepon
     * @return
     */
    @RequestMapping("query/updateKeeponMarker")
    @ResponseBody
    public MsgUtil updateKeeponMarker(Keepon keepon) {
        try {
            keeponService.updateKeepon(keepon);
            return MsgUtil.result(true, "指派成功！");
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙，请稍后重试！");
        }
    }

    /**
     * 查询数据回显到修改名称界面
     *
     * @param request
     * @param id
     * @return
     */
    @RequestMapping("query/nameRemark/{id}")
    public String keepon_remark(HttpServletRequest request, @PathVariable("id") Integer id) {
        // 根据id查询备案信息
        Keepon keepon = keeponService.selectKeeponById(id);
        request.setAttribute("consultantObj", keepon);
        return JumpUtil.FRONT_NAME_REMARK;
    }

    /**
     * 修改备注姓名
     *
     * @param keepon
     * @return
     */
    @RequestMapping("query/updateRemarkName")
    @ResponseBody
    public MsgUtil updateRemarkName(Keepon keepon) {
        try {
            keeponService.updateKeepon(keepon);
            return MsgUtil.result(true, "修改备注姓名成功！");
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙，请稍后重试！");
        }

    }

    /**
     * 跳转到前台管理的转上门页面
     *
     * @return
     */
    @RequestMapping("query/transferVisit/{id}")
    public String frontKeeponTransferVisit(@PathVariable Integer id, HttpServletRequest request) {
        Keepon keepon = keeponService.selectKeeponWithConsultationById(id);
        request.setAttribute("keepon", keepon);
        return JumpUtil.FRONT_TRANSFER_VISIT;
    }

    /**
     * 转上门：修改备案信息和咨询信息表
     *
     * @return
     */
    @RequestMapping("/query/updateKeeponWithConsulation")
    public @ResponseBody
    MsgUtil frontUpdateKeeponWithConsultation(Keepon keepon, Integer consultationid) {
        keepon.getConsultation().setConsultationid(consultationid);
        boolean flag = keeponService.updateKeeponWithConsultation(keepon);
        if (flag) {
            return MsgUtil.result(true, "已转上门！");
        }
        return MsgUtil.result(false, "系统繁忙,请稍后再试！");
    }

    /**
     * 跳转到前台管理的转进班页面
     *
     * @return
     */
    @RequestMapping("query/transferClass/{id}")
    public String frontKeeponTransferClass(HttpServletRequest request, @PathVariable Integer id) {
        // 根据id查询备案信息
        Keepon keepon = keeponService.selectKeeponById(id);
        request.setAttribute("keepon", keepon);
        return JumpUtil.FRONT_TRANSFER_CLASS;
    }

    /**
     * 导入excel表格
     *
     * @param fileName
     * @param session
     * @return
     */
    @RequestMapping("query/importKeepon")
    @ResponseBody
    public MsgUtil ReadExcel(@RequestParam("fileName") CommonsMultipartFile fileName, HttpSession session) {
        String flag = keeponService.ReadExcel(fileName, session);
        if (flag.indexOf("错误") != -1) {
            return MsgUtil.result(false, flag);
        } else {
            return MsgUtil.result(true, "导入成功！");
        }
    }

    /**
     * 跳转到备案信息的咨询进度查询页面
     *
     * @param id
     * @param
     * @return
     */
    @RequestMapping("query/consultionProgress/{id}")
    public String goConsultationProgress(@PathVariable("id") Integer id, ModelMap model) {
        model.put("keeponid", id);
        return JumpUtil.FRONT_CONSULTATION_PROGRESS;
    }

    /**
     * 指定备案信息的咨询进度查询
     *
     * @param id
     * @param bootstrapDataTable
     * @return
     */
    @RequestMapping("query/consultionProgress")
    public @ResponseBody
    BootstrapDataTable consultationProgress(Integer id, BootstrapDataTable bootstrapDataTable) {
        return consultationService.selectConsultationWithKeeponById(id, bootstrapDataTable);
    }

    /**
     * 转进班
     *
     * @return
     */
    @RequestMapping("toInClass")
    @ResponseBody
    public MsgUtil toInClass(Keepon keepon) {
        boolean falg = keeponService.updatetransferToClass(keepon);
        if (falg) {
            return MsgUtil.result(true, "转入成功！");
        }
        return MsgUtil.result(false, "转入失败！");
    }

    /**
     * 跳转到修改备案信息页面
     *
     * @return
     */
    @RequestMapping("query/toKeeponUpdate/{id}")
    public String toKeeponUpdate(@PathVariable("id") Integer id, HttpServletRequest request) {
        Keepon keepon = keeponService.selectKeeponById(id);
        request.setAttribute("keepon", keepon);
        System.out.println("a");
        return JumpUtil.FRONT_KEEPON_UPDATE;
    }

    /**
     * 修改备案信息
     *
     * @param keepon
     * @return
     */
    @RequestMapping("/query/update")
    @ResponseBody
    public MsgUtil updateKeepons(Keepon keepon) {
        boolean falg = keeponService.updateByPrimaryKeySelective(keepon);
        if (falg) {
            return MsgUtil.result(true, "修改成功！");
        }
        return MsgUtil.result(false, "修改失败！");
    }

}
