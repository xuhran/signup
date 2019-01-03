package com.xuhr.signup.service.impl;

import com.xuhr.signup.dao.Task;
import com.xuhr.signup.dao.Userinfo;
import com.xuhr.signup.dao.Userpassword;
import com.xuhr.signup.mapper.UserinfoMapper;
import com.xuhr.signup.mapper.UserpasswordMapper;
import com.xuhr.signup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.jws.soap.SOAPBinding;
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
    private UserinfoMapper userinfoMapper;
    @Autowired
    private UserpasswordMapper userpasswordMapper;
    @Override
    public Integer login(String user_id, String user_password) {
//        Example example = new Example(Userpassword.class);
//        example.createCriteria().andEqualTo("userId",user_id);
//        Userpassword user = userpasswordMapper.selectOneByExample(example);
        Userpassword user = userpasswordMapper.selectByUserId(user_id);
        System.out.println(user);
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
        if (user_id!=null&&user_name!=""&&user_telephone!=""&&user_telephone.length()==11&&user_password!="") {
            Userinfo user = userinfoMapper.selectByPrimaryKey(user_id);
            while(user==null){
                    Userinfo userinfo = new Userinfo();
                    Userpassword userpassword = new Userpassword();
                    userinfo.setUserId(user_id);
                    userinfo.setUserName(user_name);
                    userinfo.setUserTelephone(user_telephone);
                    userpassword.setUserId(user_id);
                    userpassword.setUserPassword(user_password);
                    try {
                        userinfoMapper.insert(userinfo);
                        userpasswordMapper.insert(userpassword);
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
    public List<Userinfo> selectAll(){
        try {
            List<Userinfo> userList = userinfoMapper.selectAll();
            return userList;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Userinfo selectOneById(String user_id) {
        try {
            return userinfoMapper.selectByUserId(user_id);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }

    }

    @Override
    public Userinfo selectOneByName(String user_name) {
        return null;
    }

    //
//    @Override
//    public User setById(String id){
//        return null;
//    }
//    @Override
//    public User selectOneByName(String name){
//        return null;
//    }
}
