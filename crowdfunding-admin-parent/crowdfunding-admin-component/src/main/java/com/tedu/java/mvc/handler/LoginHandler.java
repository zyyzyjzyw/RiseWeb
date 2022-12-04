package com.tedu.java.mvc.handler;

import com.mysql.cj.exceptions.AssertionFailedException;
import com.tedu.java.entity.Admin;
import com.tedu.java.util.CrowdConstant;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author： zyy
 * @date： 2022/11/16 20:48
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
public class LoginHandler extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 通过request对象获取Session对象
        HttpSession session = request.getSession();
        // 通过Session对象获取Admin对象
        Admin admin = (Admin) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_ADMIN);
        // 判断admin对象是否为空
        if(admin==null){
            //抛出异常
            throw new AssertionFailedException(CrowdConstant.MESSAGE_ACCESS_FORBIDEN);
        }
        // 如果admin对象不为空，则放行。
        return true;
    }
}
