package com.yong.finance.cms.config;

import com.alibaba.fastjson.JSONObject;
import com.yong.finance.common.bean.ApiResult;
import com.yong.finance.common.exception.AppRuntimeException;
import com.yong.finance.common.exception.UserNotExistException;
import com.yong.finance.constants.Constants;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/3/14 0014.
 * 控制器扩展处理
 */
@ControllerAdvice(annotations = Controller.class, basePackages = "com.yong.finance.cms.controller")
public class ControllerAdviceConfiguration {


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //  参数去掉首位空格
        StringTrimmerEditor stringtrimmer = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrimmer);
    }
    
    @ExceptionHandler(value = AccessDeniedException.class)
    public ModelAndView handleUnAuth(HttpServletRequest request, HttpServletResponse response, Exception exception) {

        if (request.getHeader("X-Requested-With") != null && request
                .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1) {
            response.setContentType("application/json;charset=UTF-8");
            try {
                PrintWriter writer = response.getWriter();
                writer.write(JSONObject.toJSONString(ApiResult.fail(Constants.kCode_UnAuth, "没有访问权限")));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return new ModelAndView("error/403");
    }

    @ExceptionHandler(value = AppRuntimeException.class)
    public ModelAndView handleAppException(HttpServletRequest request, HttpServletResponse response, Exception exception) {

        if (request.getHeader("X-Requested-With") != null && request
                .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1) {
            response.setContentType("application/json;charset=UTF-8");
            try {
                PrintWriter writer = response.getWriter();
                writer.write(JSONObject.toJSONString(ApiResult.fail(exception.getLocalizedMessage())));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return new ModelAndView("error/500");
    }


    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleException(HttpServletRequest request, HttpServletResponse response, Exception exception) {

        exception.printStackTrace();
        if (request.getHeader("X-Requested-With") != null && request
                .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1) {
            response.setContentType("application/json;charset=UTF-8");
            try {
                PrintWriter writer = response.getWriter();
                writer.write(JSONObject.toJSONString(ApiResult.fail(exception.getLocalizedMessage())));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return new ModelAndView("error/500");
    }
    @ExceptionHandler(value = UserNotExistException.class)
    public ModelAndView handleAppException(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
            response.setContentType("application/html;charset=UTF-8");
            try {
                PrintWriter writer = response.getWriter();
                writer.flush();
                writer.println("<script>");
                writer.println("alert('"+exception+"');");
                writer.println("</script>");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }

    //

}
