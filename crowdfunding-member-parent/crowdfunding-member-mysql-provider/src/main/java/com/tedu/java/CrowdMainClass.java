package com.tedu.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author： zyy
 * @date： 2022/11/27 14:36
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@MapperScan("com.tedu.java.mapper")
@SpringBootApplication
public class CrowdMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class,args);
    }
}
