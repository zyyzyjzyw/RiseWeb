package com.tedu.java.conteoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author： zyy
 * @date： 2022/12/1 20:36
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Controller
public class PortalController {
    @RequestMapping("/")
    public String showPortalPage() {
        // 这里实际开发中需要加载数据......
        return "portal";
    }
}
