package com.newer.interceptor.sys;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户是否登陆，权限拦截器
 *
 * @author ZhangZihan
 */
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Override
    // 在handler方法执行完毕后
    // 应用场景:统一异常处理,统一日志处理
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    @Override
    // 进入handler方法之后,返回modelAndView之前
    // 应用场景从modelAndView出发:将公有的模型数据(比如菜单导航)在这里传入视图,也可以在这里统一指定视图
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }

    @Override
    // 进入handler方法之前执行
    // 用于身份验证,身份授权
    // 比如身份认证,如果认证通过,表示当前用户没有登录,需要此方法拦截不在往下执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 获取请求路径
        String action = request.getServletPath();
        String path = request.getContextPath();
        // 判断是否为公开地址
        // 判断是否为公开地址
        if ("/user/login".equals(action) || "/user/checkloginName".equals(action)
                || "/authCode".indexOf(action) != -1 || "/favicon.ico".indexOf(action) != -1 || "/checkCode".indexOf(action) != -1) {
            return true;
        }

        // 判断session中是否有用户
        if (request.getSession().getAttribute("userSession") != null) {
            return true;
        }

        // 表示用户身份需要认真,需要登录
        response.getWriter().write("<script>window.parent.location.href='" + path + "/login.jsp';</script>");

        return false;
    }

}
