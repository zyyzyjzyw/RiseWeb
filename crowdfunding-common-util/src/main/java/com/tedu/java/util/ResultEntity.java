package com.tedu.java.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author： zyy
 * @date： 2022/11/13 17:23
 * @description： TODO
 * @version: 1.0
 * @描述：返回结果的工具类(返回结果的同一类型)
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultEntity<T> {
    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";
    //用来封装当前请求处理的结果是成功或者失败
    private String result;
    //请求处理失败时返回的错误消息
    private String message;
    //要返回的数据
    private T data;
    //请求处理成功且不需要返回数据的方法
    public static <E> ResultEntity<E> successWithoutData(){
        return new ResultEntity<E>(SUCCESS,null,null);
    }
    //请求处理成功且需要返回数据的方法
    public static <E> ResultEntity<E> successWithData(E data){
        return new ResultEntity<E>(SUCCESS,null,data);
    }
    //请求处理失败调用的方法
    public static <E> ResultEntity<E> failed(String message){
        return new ResultEntity<E>(FAILED,message,null);
    }
}
