package com.story.web.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("2am 登陆拦截器--》通过");
        return true;
    }

//    @Resource
//    private LoginService loginService;
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        LoginContext context = this.getLoginContext(request, response);
//        if (context != null && context.isLogin()) {
//            // 判断预约系统内部的登录状态
//            SrmLoginContext user = loginService.readCache(context.getPin());
//            if (user == null) {
//                int requestType = WebUtil.getRequestType(request);
//                if (requestType == 1) {
//                    response.sendRedirect("/logout");
//                } else {
//                    // 会话超时,回写Ajax状态
//                    response.setStatus(303);
//                }
//                return false;
//            } else {
//                LoginContextUtil.setLoginContext(user);
//                request.setAttribute("currentUserPin", user.getUserID());
//                request.setAttribute("currentUserName", user.getUserName());
//                request.setAttribute("isPortal", false);
//            }
//            return true;
//        } else {
//            response.sendRedirect(this.getLoginUrl(request));
//            return false;
//        }
//    }
//
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        LoginContextUtil.remove();
//    }
}
