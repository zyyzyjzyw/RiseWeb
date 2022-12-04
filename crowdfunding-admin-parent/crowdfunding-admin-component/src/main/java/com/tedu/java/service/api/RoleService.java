package com.tedu.java.service.api;

import com.github.pagehelper.PageInfo;
import com.tedu.java.entity.Role;

import java.util.List;

public interface RoleService {
    PageInfo<Role> getPageInfo(Integer pageNum,Integer pageSize,String keyword);

    void saveRole(Role role);

    void updateRole(Role role);

    void removeRole(List<Integer> roleIdList);

    List<Role> getAssignedRole(Integer adminId);

    List<Role> getUnAssignedRole(Integer adminId);

    void saveAdminRoleList(Integer adminId, List<Integer> roleIdList);
}
