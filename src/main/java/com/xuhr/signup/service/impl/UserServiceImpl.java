package com.xuhr.signup.service.impl;

import com.xuhr.signup.model.Userinfo;
import com.xuhr.signup.mapper.UserinfoMapper;
import com.xuhr.signup.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@ClassName UserServiceImpl
 *@Description TODO
 *@Author xuhr12
 *@Date 2018-12-28 16:01
 *@Version 1.0
 */
@Service
public class UserServiceImpl implements UserService{
    //用户表相关mapper
    @Autowired
    private UserinfoMapper userinfoMapper;
    //用户密码表相关mapper
    @Override
    public JSONObject login(String user_id, String user_password) {
//        Example example = new Example(Userpassword.class);
//        example.createCriteria().andEqualTo("userId",user_id);
//        Userpassword user = userpasswordMapper.selectOneByExample(example);
        JSONObject jsonObject = new JSONObject();
        Userinfo user = userinfoMapper.selectOneByUserId(user_id);
        if(null!=user) {
            System.out.println(user);
            if (user.getUserPassword().equals(user_password)) {
                //login success
                jsonObject.put("status","1");
                jsonObject.put("message","登陆成功！");
                return jsonObject;
            } else {
                //password error
                jsonObject.put("status","-1");
                jsonObject.put("message","密码错误！");
                return jsonObject;
            }
        }
        //user doesnot exist
        jsonObject.put("status","0");
        jsonObject.put("message","用户不存在！");
        return jsonObject;
    }

    @Override
    public String register(String user_id,String user_name, String user_telephone, String user_password,Integer role_id) {
        if (null!=user_id&&user_name!=""&&user_telephone!=""&&user_telephone.length()==11&&user_password!=""&&null!=role_id) {
            Userinfo user = userinfoMapper.selectByPrimaryKey(user_id);
            while(user==null){
                    Userinfo userinfo = new Userinfo();
                    userinfo.setUserId(user_id);
                    userinfo.setUserName(user_name);
                    userinfo.setUserTelephone(user_telephone);
                    userinfo.setUserPassword(user_password);
                    userinfo.setRoleId(role_id);
                    try {
                        userinfoMapper.insert(userinfo);
                        return "注册成功！";
                    } catch (Exception e) {
                        return e.getMessage();
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
            return userinfoMapper.selectOneByUserId(user_id);
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


    @Override
    public Integer updatePasswordByUserId(Map<String,String> map){
        String user_id = map.get("id");
        String user_password = map.get("password");
        Map<String,String> map1 = new HashMap<String,String>();
        map1.put("user_id",user_id);
        map1.put("user_password",user_password);
        if(null!=userinfoMapper.selectOneByUserId(user_id)&&user_password!="") {
            try {
                userinfoMapper.updatePasswordByUserId(map1);
                return 1;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return -1;
            }

        }
        return 0;
    }
}
