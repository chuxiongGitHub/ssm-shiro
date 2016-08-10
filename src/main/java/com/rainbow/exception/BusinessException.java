package com.rainbow.exception;

import com.rainbow.common.ErrorConstants;
import org.apache.commons.lang.StringUtils;

/**
 * Created by rainbow on 2016/8/10.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class BusinessException extends Exception {

    //异常代码
    private String errCode;

    //异常信息
    private String errMessage;


    //构造函数

    public BusinessException() {
        super();
    }

    public BusinessException(String errMessage) {
        super(errMessage);
    }

    public BusinessException(String errCode, Throwable cause) {
        super(errCode, cause);
    }

    public BusinessException(String errCode, String errMessage) {
        super(errMessage);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public static BusinessException parseException(Exception e) {
        if (e instanceof BusinessException) {
            return (BusinessException) e;
        }
        Throwable ex = e.getCause();
        if (ex instanceof BusinessException) {
            return (BusinessException) ex;
        }
        try {
            return new BusinessException(e.getMessage());
        } catch (Exception eex) {
            return new BusinessException("未知异常");
        }
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println(this.errMessage);
    }
}
