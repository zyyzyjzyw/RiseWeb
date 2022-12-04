package com.tedu.java.service.api;

import com.tedu.java.entity.Auth;

import java.util.List;
import java.util.Map;

public interface AuthService {
    List<Auth> getAll();

    List<Integer> getAssignedAuthIdByRoleId(Integer roleId);

    void saveRoleAuthList(Map<String,List<Integer>> auths);

    List<String> getAssignedAuthNameByAdminId(Integer adminId);
}
