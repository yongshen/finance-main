package com.yong.finance.common.exception;

import com.yong.finance.constants.Constants;

/**
 * Created by Administrator on 2017/3/28 0028.
 * 未授权异常
 */
public class UnAuthorizedException extends RuntimeException {
	private String code;
    private String msg;

    public UnAuthorizedException() {
        this.code = Constants.kCode_Fail;
        this.msg = "";
    }

    public UnAuthorizedException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public UnAuthorizedException(String message) {
        this.code = Constants.kCode_Fail;
        this.msg = message;
    }

    @Override
    public String getLocalizedMessage() {
        return msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
