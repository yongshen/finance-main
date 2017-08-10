package com.yong.finance.cms.support.common;


import com.alibaba.fastjson.JSONObject;
import com.yong.finance.common.bean.ApiResult;
import com.yong.finance.common.exception.AppRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/3/9 0009.
 */
public class BaseController {

    protected Logger _logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected HttpServletRequest request;

    protected JSONObject invokeMethod(InvokeInterface invokeInterface){
        JSONObject result = new JSONObject();
        try{
            invokeInterface.invokeMethod();
            result.put("code", 0);
        }catch (AppRuntimeException e){
            e.printStackTrace();
            result.put("code", 1);
            result.put("msg", e.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            result.put("code", 1);
            result.put("msg", "系统异常，请联系管理员!");
        }finally {
            return result;
        }
    }

    protected interface InvokeInterface {
        public void invokeMethod() throws Exception;
    }

    protected ApiResult buildAjaxResponse(IWebResponseHandler invokeInterface){
        try{
            Object data = invokeInterface.execute();
            return ApiResult.success(data);
        }catch (AppRuntimeException e){
            e.printStackTrace();
            return ApiResult.fail(e.getMsg());
        }catch (Exception e){
            e.printStackTrace();
            return ApiResult.fail("系统异常，请联系管理员!");
        }
    }

    protected interface IWebResponseHandler {
        Object execute() throws Exception;
    }
}
