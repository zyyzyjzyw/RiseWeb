package com.tedu.java.mvc.controller;

import com.github.pagehelper.PageInfo;
import com.tedu.java.entity.Admin;
import com.tedu.java.service.api.AdminService;
import com.tedu.java.util.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author： zyy
 * @date： 2022/11/15 20:55
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PreAuthorize("hasAuthority('user:update')")
    @RequestMapping("/admin/update.html")
    public String update(Admin admin,
                         @RequestParam("pageNum") Integer pageNum,
                         @RequestParam("keyword") String keyword){
        adminService.update(admin);
        return "redirect:/admin/get/page.html";
    }

    /**
     * 用户更新回显
     * @param adminId
     * @param pageNum
     * @param keyword
     * @param modelMap
     * @return
     */
    @PreAuthorize("hasAuthority('user:update')")
    @RequestMapping("admin/to/edit/page.html")
    public String toEditPage(@RequestParam("adminId") Integer adminId,
                             @RequestParam("pageNum") Integer pageNum,
                             @RequestParam("keyword") String keyword,
                             ModelMap modelMap){
       Admin admin = adminService.getAdminById(adminId);
       modelMap.addAttribute("admin",admin);
       return "admin-edit";
    }

    /**
     * 保存用户
     * @param admin
     * @return
     */
    @PreAuthorize("hasAuthority('user:add')")
    @RequestMapping("/admin/save.html")
    public String save(Admin admin){
        adminService.saveAdmin(admin);
        return "redirect:/admin/get/page.html";
    }

    /**
     * 删除单个用户
     * @param adminId
     * @param pageNum
     * @param keyword
     * @return
     */
    @PreAuthorize("hasAuthority('user:delete')")
    @RequestMapping("/admin/remove/{adminId}/{pageNum}/{keyword}.html")
    public String remove(@PathVariable("adminId") Integer adminId,
                         @PathVariable("pageNum") Integer pageNum,
                         @PathVariable("keyword") String keyword){
        //执行删除
        adminService.remove(adminId);
        //页面跳转:回到分页
        return "redirect:/admin/get/page.html?pageNum="+pageNum+"&keyword="+keyword;
    }
    @PreAuthorize("hasAuthority('user:get')")
    @RequestMapping("/admin/get/page.html")
    public String getPageInfo(

            // 使用@RequestParam注解的defaultValue属性，指定默认值，在请求中没有携带对应参数时使用默认值
            // keyword默认值使用空字符串，和SQL语句配合实现两种情况适配
            @RequestParam(value="keyword", defaultValue="") String keyword,

            // pageNum默认值使用1
            @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,

            // pageSize默认值使用5
            @RequestParam(value="pageSize", defaultValue="5") Integer pageSize,

            ModelMap modelMap

    ) {

        // 调用Service方法获取PageInfo对象
        PageInfo<Admin> pageInfo = adminService.getPageInfo(keyword, pageNum, pageSize);

        // 将PageInfo对象存入模型
        modelMap.addAttribute(CrowdConstant.ATTR_NAME_PAGE_INFO, pageInfo);

        return "admin-page";
    }

    /**
     * 退出操作
     * @param session
     * @return
     */
    @RequestMapping("/admin/do/logout.html")
    public String doLoginOut(HttpSession session){
        //强制session失效
        session.invalidate();
        return "redirect:/admin/to/login/page.html";
    }

    /**
     * 登录
     * @param loginAcct
     * @param userPswd
     * @param session
     * @return
     */
    @PostMapping("/admin/do/login.html")
    public String doLogin(@RequestParam("loginAcct") String loginAcct,
                          @RequestParam("userPswd") String userPswd,
                          HttpSession session){
        //执行登录检查,如果这个方法返回admin,说明登陆成功，如果账号或密码不正确，则会抛出异常
        Admin admin = adminService.getAdminByLoginAcct(loginAcct,userPswd);
        // 将登录成功返回的admin对象存入到session
        session.setAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN,admin);
        return "redirect:/admin/to/main/page.html";

    }
}
