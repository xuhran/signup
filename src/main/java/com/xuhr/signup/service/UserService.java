package com.xuhr.signup.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.xuhr.signup.dao.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.base.select.SelectAllMapper;

import javax.print.DocFlavor;
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
    public List<User> selectAll();
    public User selectOneById(String user_id);
    public User selectOneByName(String user_name);
}
