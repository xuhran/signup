package com.xuhr.signup.service;

import com.xuhr.signup.model.Task;

import java.util.List;
import java.util.Map;

/*
 *@ClassName TaskService
 *@Description TODO
 *@Author xuhr12
 *@Date 2019-01-02 13:32
 *@Version 1.0
 */
public interface TaskService {
    //新建任务
    public void addTask(String task_name,String task_info);
    //更改任务
    public void updateTask(Map<String,Object> map);
    //查看所有任务
    public List<Task> getAllTask();
    //根据任务状态查找任务
    public List<Task> findTasksByState(String task_state);
}
