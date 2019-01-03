package com.xuhr.signup.controller;

import com.xuhr.signup.dao.Task;
import com.xuhr.signup.mapper.UserpasswordMapper;
import com.xuhr.signup.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.crypto.MacSpi;
import javax.print.DocFlavor;
import java.rmi.MarshalledObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*
 *@ClassName TaskController
 *@Description TODO
 *@Author xuhr12
 *@Date 2019-01-02 14:58
 *@Version 1.0
 */
@CrossOrigin
@Controller
@ResponseBody
@RequestMapping
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/addtask")
    public Boolean addtask(@RequestBody Map<String,Object> maps){
        try {
            System.out.println(maps);
            taskService.addTask(maps.get("task_name").toString(),maps.get("task_info").toString());
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }

    }
    @PostMapping("/changetask")
    public Boolean changeTask(@RequestBody Map<String,Object> maps){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
            Date start = sdf.parse(maps.get("start_time").toString());

            Date finish = sdf.parse(maps.get("finish_time").toString());
            taskService.changeTaskState((Integer) maps.get("task_id"),maps.get("task_name").toString(),maps.get("task_info").toString(),maps.get("task_state").toString(),start,finish);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @PostMapping("/getall")
    public List<Task> getall(){
        try {
            return taskService.getAllTask();
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    @PostMapping("/findTasksByState")
    public List<Task> findTasksByState(@RequestBody Map<String,Object> maps){
            try {
                return taskService.findAllTaskByTaskState(maps.get("task_state").toString());
            }
            catch (Exception e){
                System.out.println(e);
                return null;
            }
        }
}
