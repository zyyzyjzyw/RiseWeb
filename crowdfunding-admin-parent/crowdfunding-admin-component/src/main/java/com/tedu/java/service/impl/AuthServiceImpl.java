package com.tedu.java.service.impl;

import com.tedu.java.entity.Auth;
import com.tedu.java.entity.AuthExample;
import com.tedu.java.mapper.AuthMapper;
import com.tedu.java.service.api.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author： zyy
 * @date： 2022/11/26 9:47
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthMapper authMapper;

    @Override
    public List<Auth> getAll() {
        return authMapper.selectByExample(new AuthExample());
    }

    @Override
    public List<Integer> getAssignedAuthIdByRoleId(Integer roleId) {
        return authMapper.getAssignedAuthIdByRoleId(roleId);
    }

    @Override
    public void saveRoleAuthList(Map<String, List<Integer>> auths) {
        // 获取roleId的值
        List<Integer> roleIdList = auths.get("roleId");
        Integer roleId = roleIdList.get(0);
        // 获取已有权限的列表并删除
        authMapper.deleteOldAuth(roleId);
        //获取authIdList
        List<Integer> authIdList = auths.get("authIdArray");
        //判断authIdList是否有效
        if(authIdList!=null&authIdList.size()>0){
            authMapper.insertNewAuth(roleId,authIdList);
        }
    }

    @Override
    public List<String> getAssignedAuthNameByAdminId(Integer adminId) {
        return authMapper.selectAssignedAuthNameByAdminId(adminId);
    }
}
