package com.tedu.java.service.impl;

import com.tedu.java.entity.Admin;
import com.tedu.java.mapper.AdminMapper;
import com.tedu.java.service.api.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author： zyy
 * @date： 2022/11/12 21:23
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.insert(admin);
    }
}
