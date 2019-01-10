package com.xuhr.signup.mapper;

import com.xuhr.signup.model.Userinfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

public interface UserinfoMapper extends Mapper<Userinfo> {
    Userinfo selectOneByUserId(String user_id);
    void  updatePasswordByUserId(Map<String,String> map);
}