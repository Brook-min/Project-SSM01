package com.newer.controller.sys;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newer.pojo.sys.Consultation;
import com.newer.pojo.sys.Keepon;
import com.newer.service.sys.ConsultationService;
import com.newer.service.sys.KeeponService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.JumpUtil;
import com.newer.util.sys.MsgUtil;

/**
 * 咨询管理控制层
 */
@RequestMapping("/consultation_keepon")
@Controller
public class ConsultationController {

    // 自动注入
    @Autowired
    private KeeponService keeponService;

    @Autowired
    private ConsultationService consultationService;

    /**
     * 添加咨询信息
     *
     * @param consultation
     * @param keepon
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public MsgUtil add(Consultation consultation, Keepon keepon) {
        return consultationService.addConsultation(consultation, keepon);
    }

    /**
     * 查询咨询中的备案信息
     *
     * @param bootstrapDataTable
     * @param condition
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("selectConsultationKeepon")
    public BootstrapDataTable selectAll(BootstrapDataTable bootstrapDataTable, Condition condition,
                                        HttpSession session) {
        return keeponService.selectConsultationKeepon(bootstrapDataTable, condition, session, "咨询页面");
    }

    /**
     * 查询备案信息转发到咨询添加页面
     *
     * @param id
     * @return
     */
    @RequestMapping("selectToSultation")
    public String selectToSultation(Integer id, Model model) {
        model.addAttribute("keepon", keeponService.selectKeeponById(id));
        return JumpUtil.CONSULTATION_ADD;
    }

    /**
     * 一条备案信息对应多条咨询信息
     *
     * @param id
     * @param bootstrapDataTable
     * @return
     */
    @ResponseBody
    @RequestMapping("selectConsultationWithKeepon")
    public BootstrapDataTable selectConsultationWithKeepon(Integer id, BootstrapDataTable bootstrapDataTable) {
        return consultationService.selectConsultationWithKeeponById(id, bootstrapDataTable);
    }

    /**
     * 咨询进度跟踪
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("toFollowerConsultation")
    public String toFollowerConsultation(Integer id, Model model) {
        model.addAttribute("id", id);
        return JumpUtil.CONSULTATION_FOLLOWER;
    }
}
