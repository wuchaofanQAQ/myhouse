package com.story.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = LoggerFactory.getLogger(AuthorityInterceptor.class);

    private static final String XHR_OBJECT_NAME = "XMLHttpRequest";

    private static final String HEADER_REQUEST_WITH = "x-requested-with";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("2am 权限拦截器--》通过");
        return true;
    }

//    @Resource
//    private ResourceDao resourceDao;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        AuthorityResource annotation;
//        if (handler instanceof HandlerMethod) {
//            annotation = ((HandlerMethod) handler).getMethodAnnotation(AuthorityResource.class);
//            // 如果是拦截的方法,则判断该方法是否标有权限验证的注解
//            String currentUser = LoginContextUtil.getLoginContext().getUserID();
//            if (annotation != null && StringUtils.isNotEmpty(annotation.value())) {
//                boolean permit = hasUserPermission(annotation.value());
//                if (!permit) {
//                    logger.info("<<" + currentUser + ">> trying to access url : " + annotation.value() + " denied!!");
//                    throw new PriviledgeException("您没有操作权限");
//                } else if (!isAjaxRequest(request)) {
//                    String source = request.getParameter("source");
//                    request.setAttribute("pageUrl", annotation.value());
//                    request.setAttribute("source", source);
//                }
//            }
//
//        }
//        return true;
//    }
//
//    private boolean hasUserPermission(String path) {
//        String roleID = LoginContextUtil.getLoginContext().getRoleID();
//        if (StringUtils.equals(roleID, SysConst.USER_TYPE_ADMIN)) {
//            // 管理员不作拦截
//            return true;
//        }
//        List<Res> list = resourceDao.queryMenuListByRoleID(roleID);
//        for (Res res : list) {
//            if (StringUtils.equals(res.getUrl(), path)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static boolean isAjaxRequest(HttpServletRequest request) {
//        return XHR_OBJECT_NAME.equals(request.getHeader(HEADER_REQUEST_WITH));
//    }

}
