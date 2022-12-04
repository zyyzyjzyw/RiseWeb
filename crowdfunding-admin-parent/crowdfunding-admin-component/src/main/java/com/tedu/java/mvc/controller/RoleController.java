package com.tedu.java.mvc.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.java.entity.Role;
import com.tedu.java.service.api.RoleService;
import com.tedu.java.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author： zyy
 * @date： 2022/11/21 19:56
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Controller
@ResponseBody
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PreAuthorize("hasAuthority('menu:delete')")
    @RequestMapping("/role/remove/by/role/id/array.json")
    public ResultEntity<String> remove(@RequestBody List<Integer> roleIdList){
        roleService.removeRole(roleIdList);
        return ResultEntity.successWithoutData();
    }

    /**
     * 角色修改
     * @param role
     * @return
     */
    @PreAuthorize("hasAuthority('menu:update')")
    @RequestMapping("/role/update.json")
    public ResultEntity<String> updateRole(Role role){
        roleService.updateRole(role);
        return ResultEntity.successWithoutData();
    }

    /**
     * 角色新增
     * @param role
     * @return
     */
    @PreAuthorize("hasAuthority('menu:add')")
    @RequestMapping("/role/save.json")
    public ResultEntity<String> saveRole(Role role){
        roleService.saveRole(role);
        return ResultEntity.successWithoutData();
    }

    /**
     * 获取分页数据
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    @PreAuthorize("hasAuthority('role:get')")
    @RequestMapping("/role/get/page/info.json")
    public ResultEntity<PageInfo<Role>> getPageInfo(
            @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
            @RequestParam(value = "keyword" ,defaultValue = "") String keyword
    ){
        //调用service方法获取分页数据
        PageInfo<Role> pageInfo = null;
        try {
            pageInfo = roleService.getPageInfo(pageNum, pageSize, keyword);
            return ResultEntity.successWithData(pageInfo);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResultEntity.failed(exception.getMessage());
        }
    }
}
