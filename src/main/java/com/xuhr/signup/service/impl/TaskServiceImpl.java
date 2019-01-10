package com.xuhr.signup.service.impl;

import com.xuhr.signup.model.Task;
import com.xuhr.signup.mapper.TaskMapper;
import com.xuhr.signup.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/*
 *@ClassName TaskServiceImpl
 *@Description TODO
 *@Author xuhr12
 *@Date 2019-01-02 13:37
 *@Version 1.0
 */
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Override
    public void addTask(String task_name, String task_info) {
        try {
            Date date = new Date();
            Task task = new Task();
            task.setTaskName(task_name);
            task.setTaskstate("已开工");
            task.setTaskInfo(task_info);
            task.setStartTime(date.toString());
            task.setFinishTime(null);
            taskMapper.insert(task);
            System.out.println(task);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void updateTask(Map<String,Object> map) {
        try {
            Task task = new Task();
            task.setTaskId((Integer) map.get("task_id"));
            task.setTaskName(map.get("task_name").toString());
            task.setTaskInfo(map.get("task_info").toString());
            task.setTaskstate(map.get("task_state").toString());
            task.setStartTime(map.get("start_time").toString());
            task.setFinishTime(map.get("finish_time").toString());
            taskMapper.updateByPrimaryKeySelective(task);
        }
        catch (Exception e){
            System.out.println(e.getMessage());

        }
    }

    @Override
    public List<Task> getAllTask() {
        try {
            return taskMapper.selectAll();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Task> findTasksByState(String task_state) {
        try {
            Example example = new Example(Task.class);
            example.createCriteria().andEqualTo("taskstate",task_state);
            return taskMapper.selectByExample(example);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
