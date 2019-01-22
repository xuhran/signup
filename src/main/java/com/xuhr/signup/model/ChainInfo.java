package com.xuhr.signup.model;

import java.util.Date;

/*
 *@ClassName ChainInfo 产业链与解决方案首页接口
 *@Description TODO
 *@Author xuhr12
 *@Date 2019-01-17 11:24
 *@Version 1.0
 */
public class ChainInfo {
    //商机ID from table project busniess_id
    private String businessId;
    //项目ID from table project project_id
    private String projectId;
    //项目类型 from table project project_type
    private String projectType;
    //产业链拓展经理名称 使用table device_info 中的chain_id 查 table sys_user user_name
    private String chainName;
    //支撑经理名称 使用table project 中的 project_id到sys_user表中查询sys_name
    private String managerName;
    //客户经理 表project中sales
    private String sales;
    //营销单元 表project中sales_dept
    private String salesDept;
    //客户名称 使用project中client_id 到 client 表中查询client_name
    private String clientName;
    //终端厂家名称 显示终端类型的第一个终端厂家名称
    private String oemName;
    //终端名称 显示终端类型的第一个设备名称
    private String deviceName;
    //终端类型 在表device_info中查询所有project_id=projectId的所有设备类型
    private String deviceType;
    //技术类型 表project 中的connection_type
    private String connectionType;
    //应用行业 表project中的industry_name
    private String industryName;
    //当前进展 展示该设备当前进展
    private String nowState;
    //审核状态 显示项目的审核状态
    private String reviewState;
    //添加终端日期 所有设备最近的添加日期 from table device_info create_time
    private Date createTime;
    //更新日期 所有设备最近的更新时间 from table device_info update_time
    private Date updateTime;

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public String getSalesDept() {
        return salesDept;
    }

    public void setSalesDept(String salesDept) {
        this.salesDept = salesDept;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getOemName() {
        return oemName;
    }

    public void setOemName(String oemName) {
        this.oemName = oemName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }
    public String getNowState() {
        return nowState;
    }

    public void setNowState(String nowState) {
        this.nowState = nowState;
    }
    public String getReviewState() {
        return reviewState;
    }

    public void setReviewState (String reviewState) {
        this.reviewState = reviewState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ChainInfo{" +
                "businessId='" + businessId + '\'' +
                ", projectId='" + projectId + '\'' +
                ", projectType='" + projectType + '\'' +
                ", chainName='" + chainName + '\'' +
                ", managerName='" + managerName + '\'' +
                ", sales='" + sales + '\'' +
                ", salesDept='" + salesDept + '\'' +
                ", clientName='" + clientName + '\'' +
                ", oemName='" + oemName + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", connectionType='" + connectionType + '\'' +
                ", industryName='" + industryName + '\'' +
                ", nowState='" + nowState + '\'' +
                ", reviewState='" + reviewState + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
