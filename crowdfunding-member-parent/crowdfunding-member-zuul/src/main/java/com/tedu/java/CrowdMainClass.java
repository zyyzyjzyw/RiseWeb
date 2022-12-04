package com.tedu.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author： zyy
 * @date： 2022/12/1 20:41
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@EnableEurekaClient
@EnableZuulProxy
@SpringBootApplication
public class CrowdMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CrowdMainClass.class,args);
    }
}
