package com.newer.controller.sys;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.newer.service.sys.KeeponService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.Condition;
import com.newer.util.sys.JumpUtil;

/**
 * 市场管理控制层
 *
 * @author 奉小军
 */
@RequestMapping("/market_keepon")
@Controller
public class MarketController {

    /**
     * service层注入
     */
    @Autowired
    private KeeponService keeponService;

    /**
     * 是否备案查询
     *
     * @param bootstrapDataTable
     * @param condition
     * @return
     */
    @RequestMapping("selectIsKepoon")
    public @ResponseBody
    BootstrapDataTable selectIsKepoon(BootstrapDataTable bootstrapDataTable, Condition condition) {
        return keeponService.selectIsKeepon(bootstrapDataTable, condition);
    }

    /**
     * 市场人员查询备案信息
     *
     * @param bootstrapDataTable
     * @param condition
     * @return
     */
    @RequestMapping("selectKeppon")
    public @ResponseBody
    BootstrapDataTable selectKeppon(BootstrapDataTable bootstrapDataTable, Condition condition) {
        return keeponService.selectKeeponByPerson(bootstrapDataTable, condition);
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
        return JumpUtil.MARKET_CONSULTATION_ADD;
    }

    /**
     * 查询市场中的备案信息
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
        return keeponService.selectConsultationKeepon(bootstrapDataTable, condition, session, "市场页面");
    }
}
