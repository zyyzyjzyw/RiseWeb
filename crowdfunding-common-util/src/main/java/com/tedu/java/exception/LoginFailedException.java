package com.tedu.java.exception;

/**
 * @author： zyy
 * @date： 2022/11/15 20:46
 * @description： TODO
 * @version: 1.0
 * @描述：登陆失败后抛出的异常
 **/
public class LoginFailedException extends RuntimeException{
    public LoginFailedException() {
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    public LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
