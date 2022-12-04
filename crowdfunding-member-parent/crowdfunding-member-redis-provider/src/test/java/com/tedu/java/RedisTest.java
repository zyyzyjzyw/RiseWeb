package com.tedu.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author： zyy
 * @date： 2022/12/1 19:58
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void testRedis(){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("apple","red");
    }
}
