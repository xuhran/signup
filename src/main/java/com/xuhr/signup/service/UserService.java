package com.xuhr.signup.service;

import com.xuhr.signup.dao.Userinfo;
import jdk.nashorn.internal.ir.BlockLexicalContext;

import java.util.List;
import java.util.Map;

/*
 *@ClassName UserService
 *@Description TODO
 *@Author xuhr12
 *@Date 2018-12-28 15:55
 *@Version 1.0
 */
public interface UserService{
    //用户登录
    public Integer login(String user_id,String user_password);
    //用户注册
    public String register(String user_id,String user_name,String user_telephone,String user_password);
    //查看所有用户信息
    public List<Userinfo> selectAll();
    //根据user_id查找相关用户信息
    public Userinfo selectOneById(String user_id);
    //根据user_name查找相关用户信息
    public Userinfo selectOneByName(String user_name);
    //根据user_id更改密码
    public Integer updatePwdByUserId(Map<String ,String > maps);
}
