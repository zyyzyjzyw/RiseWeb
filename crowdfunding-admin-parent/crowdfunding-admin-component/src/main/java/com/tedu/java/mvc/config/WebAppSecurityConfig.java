package com.tedu.java.mvc.config;

import com.tedu.java.util.CrowdConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author： zyy
 * @date： 2022/11/26 13:10
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Configuration
@EnableWebSecurity
// 启用全局方法权限控制功能，并且设置prePostEnabled = true。保证@PreAuthority、@PostAuthority、@PreFilter、@PostFilter生效
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 在这里声明，无法在xxx。service获取到。
     * @return
     */
    /*@Bean
    public BCryptPasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }*/
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        // 临时使用内存版登录的模式测试代码
        //builder.inMemoryAuthentication().withUser("tom").password("123123").roles("ADMIN");
        //正视功能使用基于数据库的认证
        builder.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        security
                .authorizeRequests() // 对请求进行授权
                .antMatchers("/admin/to/login/page.html") // 针对登录页进行设置
                .permitAll() // 无条件访问
                .antMatchers("/bootstrap/**") // 针对静态资源进行设置，无条件访问
                .permitAll() // 针对静态资源进行设置，无条件访问
                .antMatchers("/crowd/**") // 针对静态资源进行设置，无条件访问
                .permitAll() // 针对静态资源进行设置，无条件访问
                .antMatchers("/css/**") // 针对静态资源进行设置，无条件访问
                .permitAll() // 针对静态资源进行设置，无条件访问
                .antMatchers("/fonts/**") // 针对静态资源进行设置，无条件访问
                .permitAll() // 针对静态资源进行设置，无条件访问
                .antMatchers("/img/**") // 针对静态资源进行设置，无条件访问
                .permitAll() // 针对静态资源进行设置，无条件访问
                .antMatchers("/jquery/**") // 针对静态资源进行设置，无条件访问
                .permitAll() // 针对静态资源进行设置，无条件访问
                .antMatchers("/layer/**") // 针对静态资源进行设置，无条件访问
                .permitAll() // 针对静态资源进行设置，无条件访问
                .antMatchers("/script/**") // 针对静态资源进行设置，无条件访问
                .permitAll() // 针对静态资源进行设置，无条件访问
                .antMatchers("/ztree/**") // 针对静态资源进行设置，无条件访问
                .permitAll()
                .antMatchers("/admin/get/page.html")// 针对分页显示Admin数据设定访问控制
                .hasRole("用户")
                .antMatchers("/role/to/page.html")// 针对分页显示Admin数据设定访问控制
                .hasRole("角色")
                .antMatchers("/menu/to/page.html")// 针对分页显示Admin数据设定访问控制
                .hasRole("菜单")
                .anyRequest() // 其他任意请求
                .authenticated() // 认证后访问
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new AccessDeniedHandler() {
                    @Override
                    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
                        httpServletRequest.setAttribute("exception",new Exception(CrowdConstant.MESSAGE_ACCESS_DENIED));
                        httpServletRequest.getRequestDispatcher("/WEB-INF/system-error.jsp").forward(httpServletRequest,httpServletResponse);
                    }
                })
                .and()
                .csrf() // 防跨站请求伪造功能
                .disable() // 禁用
                .formLogin() // 开启表单登录的功能
                .loginPage("/admin/to/login/page.html").permitAll() // 指定登录页面
                .loginProcessingUrl("/security/do/login.html") // 指定处理登录请求的地址
                .defaultSuccessUrl("/admin/to/main/page.html")// 指定登录成功后前往的地址
                .usernameParameter("loginAcct") // 账号的请求参数名称
                .passwordParameter("userPswd") // 密码的请求参数名称
                .and().logout()  //开启退出登录功能
                .logoutUrl("/security/do/logout.html")   //指定退出登录地址
                .logoutSuccessUrl("/admin/to/login/page.html");   //指定退出成功以后前往的地址
    }
}
