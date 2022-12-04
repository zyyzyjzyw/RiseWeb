package com.tedu.java.service.api;

import com.github.pagehelper.PageInfo;
import com.tedu.java.entity.Admin;

import java.util.List;

public interface AdminService {
    void saveAdmin(Admin admin);

    List<Admin> getAll();

    Admin getAdminByLoginAcct(String loginAcct, String loginPswd);

    //PageInfo<Admin> getPageInfo(String keyword,Integer pageNum,Integer pageSize,Integer id);
    PageInfo<Admin> getPageInfo(String keyword, Integer pageNum, Integer pageSize);

    void remove(Integer adminId);

    Admin getAdminById(Integer adminId);

    void update(Admin admin);

    Admin getAdminByLOginAcct(String username);
}
