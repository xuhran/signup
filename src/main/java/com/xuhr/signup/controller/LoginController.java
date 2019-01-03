package com.xuhr.signup.controller;

import com.xuhr.signup.dao.Task;
import com.xuhr.signup.dao.Userinfo;
import com.xuhr.signup.dao.Userpassword;
import com.xuhr.signup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

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
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping(value = "/login")
    public Integer login(@RequestBody Map<String,String> maps){
        String id = maps.get("id");
        String password = maps.get("password");
        System.out.println("in login "+id+" "+ password);
        return userService.login(id,password);
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody Map<String,String> maps){
        String id = maps.get("id");
        String name = maps.get("name");
        String telephone = maps.get("telephone");
        String password = maps.get("password");
        System.out.println("in register"+id +name+ telephone +password);
        return userService.register(id,name,telephone,password);
    }

    @PostMapping("all")
    public List<Userinfo> selectAll(){
        return userService.selectAll();
    }
}
