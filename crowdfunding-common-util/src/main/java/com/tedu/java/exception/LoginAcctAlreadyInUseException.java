package com.tedu.java.exception;

/**
 * @author： zyy
 * @date： 2022/11/20 12:18
 * @description： TODO
 * @version: 1.0
 * @描述：保存admin信息，检测到登录账号重复抛出这个异常
 **/
public class LoginAcctAlreadyInUseException extends RuntimeException{
    public LoginAcctAlreadyInUseException() {
    }

    public LoginAcctAlreadyInUseException(String message) {
        super(message);
    }

    public LoginAcctAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyInUseException(Throwable cause) {
        super(cause);
    }

    public LoginAcctAlreadyInUseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
