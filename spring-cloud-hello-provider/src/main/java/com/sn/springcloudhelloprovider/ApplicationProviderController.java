package com.sn.springcloudhelloprovider;

import com.sn.springcloudhelloprovider.Fegin.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ApplicationProviderController {

    @RequestMapping(value = "/search/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public User searchUser(@PathVariable String id, HttpServletRequest sr){
        User user = new User();
        user.setId(id);
        user.setAge(20);
        user.setPassWord("123");
        user.setUserName("EurekaProvider--"+sr.getRequestURL().toString());

        return user;

    }

//Actuator健康端点检测，模拟是否能链接数据库
    public static Boolean isCanLinkDb = true;

    @RequestMapping(value = "/linkDb/{can}", method = RequestMethod.GET)
    public void LinkDb(@PathVariable Boolean can){
        isCanLinkDb = can;
    }
//负载均衡测试demo
    @GetMapping("/add")
    public String addTest(Integer a, Integer b, HttpServletRequest request){
        return " Form port:"+request.getServerPort()+",result:"+ a+b;
    }
}
