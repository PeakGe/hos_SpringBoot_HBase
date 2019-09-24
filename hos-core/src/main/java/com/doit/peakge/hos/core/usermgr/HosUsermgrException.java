package com.doit.peakge.hos.core.usermgr;

import com.doit.peakge.hos.core.HosException;
/**
 *用户管理模块异常
 * @return:
 * @author: gefeng
 * @date: 2019/9/24 14:36
 */

public class HosUsermgrException extends HosException {
    private int errorCode;
    private String errorMessage;

    public HosUsermgrException(int code,String message, Throwable cause){
        super(message, cause);
        this.errorCode = code;
        this.errorMessage = message;
    }
    public HosUsermgrException(int code, String message) {
        super(message, null);
        this.errorCode = code;
        this.errorMessage = message;
    }

    public int getCode() {
        return errorCode;
    }

    public String getMessage() {
        return errorMessage;
    }

    @Override
    public int errorCode() {
        return this.errorCode;
    }
}
