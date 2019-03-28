package com.newer.controller.message;

import com.newer.pojo.message.Message;
import com.newer.service.message.MessageService;
import com.newer.util.sys.BootstrapDataTable;
import com.newer.util.sys.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Brook_min
 * @date 2019/3/27 0027 - 9:41
 */
@Controller
@RequestMapping("/mes")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping("/goToMessage")
    public String goToMessage() {
        return "message/messageList";
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public BootstrapDataTable listAll(BootstrapDataTable bootstrapDataTable, String Search) {
        BootstrapDataTable table = messageService.selectAllMessage(bootstrapDataTable, Search);
        return table;
    }

    @RequestMapping("/selectById")
    public String selectById(Integer id, Model model) {
        Message message = this.messageService.selectByid(id);
        model.addAttribute("message", message);
        return "message/message_edit";
    }

    @RequestMapping("/deleteMes")
    @ResponseBody
    public MsgUtil deleteMes(@RequestParam("id") Integer id) {
        try {
            if (this.messageService.deleteMes(id)) {
                return MsgUtil.result(true, "操作成功！");
            }
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙，请稍后重试！");
        }
        return MsgUtil.result(false, "系统繁忙，请稍后重试！");
    }

    @RequestMapping("batchdelete/{ids}")
    @ResponseBody
    public MsgUtil deleteUserByIds(@PathVariable("ids") String ids) {
        MsgUtil msgUtil = new MsgUtil();
        try {
            if (this.messageService.batchDeleteMes(ids)) {
                msgUtil.setFlag(true);
            }
        } catch (Exception e) {
            msgUtil.setFlag(false);
        }
        return msgUtil;
    }

    @RequestMapping("addMes")
    @ResponseBody
    public MsgUtil addMes(Message message) {
        try {
            if (this.messageService.insertMes(message)) {
                return MsgUtil.result(true, "操作成功！");
            }
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙，请稍后重试！");
        }
        return MsgUtil.result(false, "系统繁忙，请稍后重试！");
    }

    @RequestMapping("GoToMessage_add")
    public String GoToMessage_add() {
        return "message/message_add";
    }

    /**
     * @author brook-min
     * 页面跳转
     */
    @RequestMapping("goToMessage_edit/{id}")
    public String goToMessage_edit(@PathVariable("id") Integer id, Model model) {
        Message message = this.messageService.selectByid(id);
        model.addAttribute("meslist", message);
        return "message/message_edit";
    }

    /**
     * @author brook-min
     * 修改，异步
     */
    @RequestMapping("updateMessage")
    @ResponseBody
    public MsgUtil updateMessage(Message message) {
        try {
            if (this.messageService.updateMes(message)) {
                return MsgUtil.result(true, "操作成功！");
            }
        } catch (Exception e) {
            return MsgUtil.result(false, "系统繁忙，请稍后重试！");
        }
        return MsgUtil.result(false, "系统繁忙，请稍后重试！");
    }


}
