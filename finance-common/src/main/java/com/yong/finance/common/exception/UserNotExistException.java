package com.yong.finance.common.exception;

import com.yong.finance.constants.Constants;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public class UserNotExistException extends RuntimeException{
	    private String code;
	    private String msg;

	    public UserNotExistException() {
	        this.code = Constants.kCode_Fail;
	        this.msg = "";
	    }

	    public UserNotExistException(String code, String msg) {
	        this.code = code;
	        this.msg = msg;
	    }

	    public UserNotExistException(String message) {
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
