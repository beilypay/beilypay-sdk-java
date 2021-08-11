package com.beilypay.pay.sdk.java.exception;

public class BeilypayException extends Exception {

    private static final long serialVersionUID = -238091758285157331L;

    private String errCode;
    private String errMsg;

    public BeilypayException() {
        super();
    }

    public BeilypayException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeilypayException(String message) {
        super(message);
    }

    public BeilypayException(Throwable cause) {
        super(cause);
    }

    public BeilypayException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public static BeilypayException signError() {
        return new BeilypayException("500","签名验证失败");
    }


    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}
