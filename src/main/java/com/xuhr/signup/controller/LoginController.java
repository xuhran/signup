package com.xuhr.signup.controller;

import com.xuhr.signup.model.Userinfo;
import com.xuhr.signup.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/*
 *@ClassName LoginController
 *@Description TODO
 *@Author xuhr12
 *@Date 2018-12-28 15:12
 *@Version 1.0
 */
@CrossOrigin
@Controller
@ResponseBody
@RequestMapping
public class LoginController{
    @Autowired
    private UserService userService;


    @PostMapping(value = "/login" , produces = {"application/json", "application/xml"},consumes = {"application/x-www-form-urlencoded"})
    public JSONObject login(HttpServletRequest request){
        String id = request.getParameter("userName").toString();
        String password = request.getParameter("password").toString();
        System.out.println("in login "+id+","+ password);
        return userService.login(id,password);
    }

    @GetMapping(value = "/register" )
    public String register(@RequestBody Map<String,String> maps){
        String id = maps.get("id");
        String name = maps.get("name");
        String telephone = maps.get("telephone");
        String password = maps.get("password");
        int roleid = Integer.parseInt(maps.get("roleid"));
        System.out.println("in register"+id +name+ telephone +password+roleid);
        return userService.register(id,name,telephone,password,roleid);
    }


    @PostMapping("/getAllUsers")
    public List<Userinfo> selectAll(){
        return userService.selectAll();
    }


    @GetMapping("/updatePassword")
    public Integer updatePwdByUserId(@RequestBody Map<String,String> maps){
        return userService.updatePasswordByUserId(maps);
    }


//    @PostMapping(value = "/login1")
//    public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
//        String username = loginBean.getAccount();
//        String password = loginBean.getPassword();
//        String captcha = loginBean.getCaptcha();...
//        　　　　  // 系统登录认证
//        JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
//
//        return HttpResult.ok(token);
//    }
}
