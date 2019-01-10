package com.xuhr.signup.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "task")
public class Task {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(generator = "JDBC")
    private Integer taskId;

    @Column(name = "task_name")
    private String taskName;

    @Column(name = "task_info")
    private String taskInfo;

    private String taskstate;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "finish_time")
    private String finishTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return task_id
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * @param taskId
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * @return task_name
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * @param taskName
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * @return task_info
     */
    public String getTaskInfo() {
        return taskInfo;
    }

    /**
     * @param taskInfo
     */
    public void setTaskInfo(String taskInfo) {
        this.taskInfo = taskInfo;
    }

    /**
     * @return taskstate
     */
    public String getTaskstate() {
        return taskstate;
    }

    /**
     * @param taskstate
     */
    public void setTaskstate(String taskstate) {
        this.taskstate = taskstate;
    }

    /**
     * @return start_time
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return finish_time
     */
    public String getFinishTime() {
        return finishTime;
    }

    /**
     * @param finishTime
     */
    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}