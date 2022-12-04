package com.tedu.java.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author： zyy
 * @date： 2022/11/15 20:24
 * @description： TODO
 * @version: 1.0
 * @描述：通用的MD5加密
 **/
public class CrowMd5Utils {
    /**
     *
     * @param source MD5加密传入的字符串
     * @return 加密后的结果
     */
    public static String md5(String source){
        // 判断source是否有效
        if(source==null || source.length()==0){
            // 如果不是有效的字符串抛出异常
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
        }
        // 获取MessageDigest对象
        String algorithm = "md5";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            // 获取明文字符串对应的字节数组
            byte[] input = source.getBytes();
            // 执行加密
            byte[] outPut = messageDigest.digest(input);
            //创建BigInteger对象
            int num=1;
            BigInteger bigInteger = new BigInteger(num, outPut);
            // 按照十六进制将bigInteger的值转换为字符串
            int radix = 16;
            String result = bigInteger.toString(radix);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
