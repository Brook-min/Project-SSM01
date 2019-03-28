package com.newer.controller.authcode;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * 生成验证码
 *
 * @author ZhangZihan
 */
@Controller
public class AuthCodeController {

    @Resource
    private Producer captchaProducer;

    /**
     * 获取验证码  链接后面最好是加个随机数
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/authCode")
    public void getCaptchaCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        // 生成验证码文本  在配置文件中设置的
        String capText = captchaProducer.createText();
        String s1 = capText.substring(0, 1);
        String s2 = capText.substring(1, 2);
        //获得总值 存入session中
        int r = Integer.valueOf(s1).intValue() + Integer.valueOf(s2).intValue();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, String.valueOf(r));
        // 利用生成的字符串构建图片
        BufferedImage bi = captchaProducer.createImage(s1 + "+" + s2 + "=?");
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.flush();
        out.close();
    }

    /**
     * 用于bootstrap异步校验验证码 必须是这样的返回值
     *
     * @param code
     * @param request
     * @return
     */
    @RequestMapping(value = "/checkCode")
    public @ResponseBody
    Map<String, Boolean> checkCode(@RequestParam(value = "kaptcha", required = false) String code, HttpServletRequest request) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        boolean result = true;
        try {
            String codeSession = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if (code.equalsIgnoreCase(codeSession)) {
                result = true;
            } else {
                result = false;
            }
            map.put("valid", result);
            return map;
        } catch (Exception e) {
            return map;
        }

    }
}
