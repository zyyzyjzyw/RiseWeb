package com.tedu.java.mvc.controller;

import com.tedu.java.entity.Role;
import com.tedu.java.service.api.AdminService;
import com.tedu.java.service.api.AuthService;
import com.tedu.java.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author： zyy
 * @date： 2022/11/25 19:43
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Controller
public class AssignController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthService authService;

    @PreAuthorize("hasAuthority('user:assign')")
    @RequestMapping("/assign/do/role/assign.html")
    public String saveAdminRoleList(@RequestParam("adminId") Integer adminId,
                                    @RequestParam("pageNum") Integer pageNum,
                                    @RequestParam("keyword") String keyword,
                                    //允许用户在页面上取消所有已分配的角色，可以不提供请求参数
                                    @RequestParam(value = "roleIdList",required = false) List<Integer> roleIdList){
        roleService.saveAdminRoleList(adminId,roleIdList);

        return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
    }

    @PreAuthorize("hasAuthority('user:assign')")
    @RequestMapping("/assign/to/assign/role/page.html")
    public String toAssignRolePage(@RequestParam("adminId") Integer adminId,
                                   ModelMap modelMap){
        //查询已分配角色
        List<Role> assignRoleList = roleService.getAssignedRole(adminId);
        //查询未分配角色
        List<Role> UnAssignedRoleList = roleService.getUnAssignedRole(adminId);
        //存入模型
        modelMap.addAttribute("assignRoleList",assignRoleList);
        modelMap.addAttribute("unAssignedRoleList",UnAssignedRoleList);
        return "assign-role";
    }
}
