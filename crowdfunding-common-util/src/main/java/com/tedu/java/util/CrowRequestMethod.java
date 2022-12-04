package com.tedu.java.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： zyy
 * @date： 2022/11/14 19:47
 * @description： TODO
 * @version: 1.0
 * @描述：判断请求类型的方法：是普通请求还是ajax请求,true为ajax请求
 **/
public class CrowRequestMethod {
    public static boolean judgeRequest(HttpServletRequest request){
        //获取请求消息头
        String accept = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Requested-With");
        //判断
        if (
                (accept != null && accept.contains("application/json"))
                        ||
                        (xRequestHeader != null && xRequestHeader.equalsIgnoreCase("XMLHttpRequest"))
        ) {
            return true;
        }
        return false;
    }

}
