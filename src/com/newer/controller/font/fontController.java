package com.newer.controller.font;

import com.newer.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brook_min
 * @date 2019/3/29 0029 - 9:41
 */
@Controller
@RequestMapping("/font")
public class fontController extends HttpServlet {

    @Autowired
    private MessageService messageService;

    /**
     * @author brook-min
     * 页面跳转
     */
    @RequestMapping("goToTalk")
    public String goToTalk() {

        return "font/talk";
    }

    @RequestMapping("autoReply")
    @ResponseBody
    public String autoReply(@RequestParam("content") String content, HttpServletResponse response) {
        return this.messageService.queryByCommand(content);
    }

}
