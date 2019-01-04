package com.xuhr.signup.service;

import com.xuhr.signup.dao.Task;

import java.util.Date;
import java.util.List;

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
    public void changeTaskState(Integer task_id, String task_name, String task_info , String task_state, String start_time, String finish_time);
    //查看所有任务
    public List<Task> getAllTask();
    //根据任务状态查找任务
    public List<Task> findTasksByState(String task_state);
}
