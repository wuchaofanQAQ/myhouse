package com.story.common.tools;


import javax.servlet.http.HttpServletRequest;

public class WebUtil {

    /**
     * 判断请求类型(1:Http请求 2:Ajax->Html 3:Ajax->Json)
     * @param request
     * @return
     */
    public static int getRequestType(HttpServletRequest request) {
        if (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1) {
            if (request.getHeader("accept").indexOf("application/json") > -1) {
                //ajax json请求
                return 3;
            } else if (request.getHeader("accept").indexOf("text/html") > -1) {
                //ajax html请求
                return 2;
            } else {
                return -1;
            }
        } else {
            //html请求
            return 1;
        }
    }
}
