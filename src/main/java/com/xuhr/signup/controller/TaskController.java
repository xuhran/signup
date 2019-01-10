package com.xuhr.signup.controller;

import com.xuhr.signup.model.Task;
import com.xuhr.signup.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
//
    @GetMapping("/addTask")
    public Boolean addtask(@RequestBody Map<String,Object> maps){
        try {
            taskService.addTask(maps.get("task_name").toString(),maps.get("task_info").toString());
            return true;
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }

    }
    @GetMapping("/updateTask")
    public Boolean changeTask(@RequestBody Map<String,Object> maps){
        try {
            System.out.println(maps);
            taskService.updateTask(maps);
            return true;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @PostMapping("/getAllTasks")
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
                return taskService.findTasksByState(maps.get("task_state").toString());
            }
            catch (Exception e){
                System.out.println(e);
                return null;
            }
        }
}
