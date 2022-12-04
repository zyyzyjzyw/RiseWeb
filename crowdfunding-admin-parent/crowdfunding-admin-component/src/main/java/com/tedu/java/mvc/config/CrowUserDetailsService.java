package com.tedu.java.mvc.config;

import com.tedu.java.entity.Admin;
import com.tedu.java.entity.Role;
import com.tedu.java.service.api.AdminService;
import com.tedu.java.service.api.AuthService;
import com.tedu.java.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： zyy
 * @date： 2022/11/26 15:59
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Service
public class CrowUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthService authService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1. 根据username查询admin对象
       Admin admin = adminService.getAdminByLOginAcct(username);
        //2. 获取adminId
        Integer adminId = admin.getId();
        //3. 根据adminId查询角色信息
        List<Role> assignedRoleList = roleService.getAssignedRole(adminId);
        //4. 根据adminId 查询权限的信息
        List<String> authNameList = authService.getAssignedAuthNameByAdminId(adminId);
        //5. 创建集合对象用来存储GrantedAuthority
        List<GrantedAuthority> authorities = new ArrayList<>();
        //6. 遍历assignedRoleList存入角色信息
        for(Role roles:assignedRoleList){
            String roleName = "ROLE_"+roles.getName();
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);
            authorities.add(simpleGrantedAuthority);
        }
        //7 遍历authNameList存入权限的信息
        for(String authName:authNameList){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authName);
            authorities.add(simpleGrantedAuthority);
        }
        return new SecurityAdmin(admin,authorities);

    }
}
