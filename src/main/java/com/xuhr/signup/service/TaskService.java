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
    public void addTask(String task_name,String task_info);
    public void changeTaskState(Integer task_id, String task_name, String task_info , String task_state, Date start_time, Date finish_time);
    public List<Task> getAllTask();
    public List<Task> findAllTaskByTaskState(String task_state);
}
