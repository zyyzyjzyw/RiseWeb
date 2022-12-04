package com.tedu.java;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author： zyy
 * @date： 2022/11/28 21:42
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class MySqlTest {
    @Autowired
    private DataSource dataSource;

    @Test
    public void testMysql1() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
