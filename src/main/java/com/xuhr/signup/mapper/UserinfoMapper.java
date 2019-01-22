package com.xuhr.signup.mapper;

import com.xuhr.signup.model.Userinfo;
import tk.mybatis.mapper.common.Mapper;

public interface UserinfoMapper extends Mapper<Userinfo> {
    String getNameById(String userId);
}