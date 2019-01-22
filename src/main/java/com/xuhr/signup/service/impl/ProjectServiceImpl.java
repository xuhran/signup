package com.xuhr.signup.service.impl;

import com.sun.net.httpserver.Filter;
import com.xuhr.signup.mapper.*;
import com.xuhr.signup.model.ChainInfo;
import com.xuhr.signup.model.Userinfo;
import com.xuhr.signup.service.ProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.lang.model.element.NestingKind;
import javax.swing.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 *@ClassName ProjectSolutionServiceImpl
 *@Description TODO
 *@Author xuhr12
 *@Date 2019-01-17 9:57
 *@Version 1.0
 */
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectMapper projectMapper;
    @Autowired
    UserinfoMapper userinfoMapper;
    @Autowired
    DeviceInfoMapper deviceInfoMapper;
    @Autowired
    ProjectDeviceMapper projectDeviceMapper;
    @Override
    public List<ChainInfo> getChainInfo() {
        List<ChainInfo> chaininfos = projectMapper.getChainInfo();
        //查询所有项目ID
        List<ChainInfo> result = new LinkedList<>();
        //去除重复的项目ID
        for (ChainInfo chaininfo : chaininfos) {
            boolean b = result.stream().anyMatch(u -> u.getProjectId().equals(chaininfo.getProjectId()));
            if (!b) {
                result.add(chaininfo);
            }
        }
        System.out.println(result);
        List<String> projectIds = projectMapper.getAllProjectsId();
        //遍历项目ID
        for(String projectId:projectIds){
            //根据项目ID查找所有设备类型
           List<String> deviceType = projectDeviceMapper.getDeviceTypeByProjectId(projectId);
           //遍历所有首页项目
           for(ChainInfo chainInfo:result){
               if (projectId.equals(chainInfo.getProjectId())) {
                   chainInfo.setDeviceType(deviceType.toString());
               }
               //拿到projectId
               String projectId1 = chainInfo.getProjectId();
               //根据projectId获取支撑经理ID
               String managerId = projectMapper.getManagerIdByProjectId(projectId1);
               //根据支撑经理ID获取支撑经理姓名
               String managerName = userinfoMapper.getNameById(managerId);
               //设置支撑经理姓名
               chainInfo.setManagerName(managerName);
               System.out.println("project:"+projectId1+" managerName："+managerName);
               //根据projectId查询设备ID
               String deviceId = projectDeviceMapper.getDeviceIdByProjectId(projectId1);
               //根据deviceId查询设备当前进展,并插入返回类型中
               if (null!=deviceId) {
                   if (deviceInfoMapper.getLabStateByDeviceId(deviceId) == 0) {
                       chainInfo.setNowState("实验室测试中");
                   } else if (deviceInfoMapper.getDmpStateByDeviceId(deviceId) == 0) {
                       chainInfo.setNowState("DMP对接中");
                   } else if (deviceInfoMapper.getAepStateByDeviceId(deviceId) == 0) {
                       chainInfo.setNowState("AEP对接中");
                   } else {
                       chainInfo.setNowState("AEP对接完成");
                   }
               }
               //根据设备ID获取产业链经理ID
               List<String> chainId = deviceInfoMapper.getChainManagerIdByDeviceId(deviceId);
               for (String j:chainId){
                   //根据产业链经理ID获取姓名
                   String chainName = userinfoMapper.getNameById(j);
                   chainInfo.setChainName(chainName);
                   System.out.println("project："+projectId+" device："+deviceId+" chainame："+chainName);
               }
           }
        }
        return result;
    }
}
