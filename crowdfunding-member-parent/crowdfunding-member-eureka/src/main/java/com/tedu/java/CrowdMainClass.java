package com.tedu.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author： zyy
 * @date： 2022/11/27 14:36
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@SpringBootApplication
@EnableEurekaServer
public class CrowdMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class,args);
    }
}
