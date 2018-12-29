package com.xuhr.signup.service.impl;

import com.sun.corba.se.spi.orb.ParserImplBase;
import com.xuhr.signup.dao.User;
import com.xuhr.signup.mapper.UserMapper;
import com.xuhr.signup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
 *@ClassName UserServiceImpl
 *@Description TODO
 *@Author xuhr12
 *@Date 2018-12-28 16:01
 *@Version 1.0
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Override
    public Integer login(String user_id, String user_password) {
        User user = userMapper.selectByPrimaryKey(user_id);
        if(user!=null) {
            if (user.getUserPassword().equals(user_password)) {
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

    @Override
    public String register(String user_id,String user_name, String user_telephone, String user_password) {
        if (user_id!=null&&user_name!=""&&user_telephone!=""&&user_password!="") {
            User user = userMapper.selectByPrimaryKey(user_id);
            while(user==null){
                    User user1 = new User();
                    user1.setUserId(user_id);
                    user1.setUserName(user_name);
                    user1.setUserTelephone(user_telephone);
                    user1.setUserPassword(user_password);
                    try {
                        userMapper.insert(user1);
                        return "注册成功！";
                    } catch (Exception e) {
                        return e.getLocalizedMessage();
                    }

            }
            return "此id用户已存在!";
        }
        else {
            return "数据不完整！";
        }
    }

    @Override
    public List<User> selectAll(){
        try {
            List<User> userList = userMapper.selectAll();
            return userList;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public User selectOneById(String id){
        return null;
    }
    @Override
    public User selectOneByName(String name){
        return null;
    }
}
