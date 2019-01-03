package com.xuhr.signup.service;

import com.xuhr.signup.dao.Userinfo;

import java.util.List;

/*
 *@ClassName UserService
 *@Description TODO
 *@Author xuhr12
 *@Date 2018-12-28 15:55
 *@Version 1.0
 */
public interface UserService{
    public Integer login(String user_id,String user_password);
    public String register(String user_id,String user_name,String user_telephone,String user_password);
    public List<Userinfo> selectAll();
    public Userinfo selectOneById(String user_id);
    public Userinfo selectOneByName(String user_name);
}
