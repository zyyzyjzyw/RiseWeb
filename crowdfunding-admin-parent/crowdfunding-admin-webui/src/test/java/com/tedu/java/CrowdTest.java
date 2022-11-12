package com.tedu.java;

import com.tedu.java.entity.Admin;
import com.tedu.java.mapper.AdminMapper;
import com.tedu.java.service.api.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author： zyy
 * @date： 2022/11/10 20:02
 * @description： TODO
 * @version: 1.0
 * @描述：在类上标记必要的注解，Spring整合Junit
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CrowdTest {
    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;
    @Test
    public void logTest(){
        //1.获取Logger对象,这里传入的Class对象就是当前打印日志的类
        Logger logger = LoggerFactory.getLogger(CrowdTest.class);
        //根据不同级别打印日志
        logger.debug("Hello I am Debug level!!!");
        logger.debug("Hello I am Debug level!!!");
        logger.debug("Hello I am Debug level!!!");

        logger.info("Info level");
        logger.info("Info level");
        logger.info("Info level");

        logger.warn("warn level!!!!");
        logger.warn("warn level!!!!");
        logger.warn("warn level!!!!");

        logger.error("error level");
        logger.error("error level");
        logger.error("error level");
    }
    @Test
    public void testInsertAdmin(){
        Admin admin = new Admin(null, "Zyy", "123123", "张遥遥", "zyy@qq.com", null);
        int insert = adminMapper.insert(admin);
        System.out.println(insert);
    }
    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testTx(){
        Admin admin = new Admin(null, "Zyj", "123123", "张玉洁", "zyj@qq.com", null);
        adminService.saveAdmin(admin);
    }
}
