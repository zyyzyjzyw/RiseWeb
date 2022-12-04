package com.tedu.java.mvc.controller;

import com.tedu.java.entity.Auth;
import com.tedu.java.service.api.AuthService;
import com.tedu.java.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author： zyy
 * @date： 2022/11/26 9:46
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @PreAuthorize("hasAuthority('menu:assign')")
    @PostMapping("assign/do/role/assign/auth.json")
    @ResponseBody
    public ResultEntity<String> saveRoleAuthList(@RequestBody Map<String,List<Integer>> auths){
        authService.saveRoleAuthList(auths);
        return ResultEntity.successWithoutData();
    }
    @PreAuthorize("hasAuthority('menu:assign')")
    @PostMapping("assign/get/assigned/auth/id/by/role/id.json")
    @ResponseBody
    public ResultEntity<List<Integer>> getAssignedAuthIdByRoleId(
            @RequestParam("roleId") Integer roleId
    ){
      List<Integer> authIdList =  authService.getAssignedAuthIdByRoleId(roleId);
      return ResultEntity.successWithData(authIdList);
    }
    @PreAuthorize("hasAuthority('role:assign')")
    @PostMapping("assgin/get/all/auth.json")
    @ResponseBody
    public ResultEntity<List<Auth>> getAllAuth(){
        List<Auth> authList = authService.getAll();
        return ResultEntity.successWithData(authList);
    }
}
