package com.story.web.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.story.common.exception.BizException;
import com.story.common.exception.ParamException;
import com.story.common.exception.PriviledgeException;
import com.story.common.tools.WebUtil;
import com.story.web.dto.CommonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {

    private static final Logger logger = LoggerFactory.getLogger(CustomSimpleMappingExceptionResolver.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object handler, Exception e) {
        String errorMsg;
        // 页面
        String viewName;
        if (e instanceof ParamException) {
            logger.error("参数异常:{}", e.getMessage());
            errorMsg = e.getMessage();
        } else if (e instanceof BizException) {
            logger.error("业务异常:{}", e.getMessage());
            errorMsg = e.getMessage();
        } else if (e instanceof PriviledgeException) {
            logger.error("权限异常:{}", e.getMessage());
            errorMsg = e.getMessage();
        } else {
            logger.error("异常:", e);
            errorMsg = "系统内部错误,请联系管理员!";
        }

        // Http请求
        int type = WebUtil.getRequestType(request);
        switch (type) {
            case 1:
                viewName = determineViewName(e, request);
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                break;
            case 2:
                // Ajax请求
                // 返回指定的错误页
                viewName = "error/error_ajax";
                break;
            case 3:
                try {
                    CommonDto dto = new CommonDto();
                    dto.setCode(CommonDto.CODE_EXCEPTION);
                    dto.setMessage(errorMsg);
                    ObjectMapper objectMapper = new ObjectMapper();
                    response.setContentType("application/json;charset=UTF-8");
                    PrintWriter writer = response.getWriter();
                    writer.write(objectMapper.writeValueAsString(dto));
                    writer.flush();
                } catch (Exception ex) {
                    logger.error("处理Ajax-->Json请求异常", ex);
                }
                viewName = "error/error_ajax";
                break;
            default:
                // 返回vm页面
                viewName = "error/error_ajax";
        }
        // 返回vm页面
        ModelAndView model = new ModelAndView(viewName);
        model.addObject("errorMsg", errorMsg);
        return model;

    }

}