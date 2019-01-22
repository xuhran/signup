package com.xuhr.signup.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.org.apache.regexp.internal.RE;
import com.xuhr.signup.model.ChainInfo;
import com.xuhr.signup.service.ProjectService;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.SimpleSelectAllElementGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLClientInfoException;
import java.util.List;

/*
 *@ClassName ProjectSolutionController
 *@Description TODO
 *@Author xuhr12
 *@Date 2019-01-17 9:58
 *@Version 1.0
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("chain")
@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
public class ProjectSolutionController {
    @Autowired
    ProjectService projectService;

    //产业与方案首页信息接口
    @ResponseBody
    @PostMapping("/list")
    public List<ChainInfo> getSolutionInfo(){
        return projectService.getChainInfo();
    }

    //产业链解决方案首页搜索接口
    @ResponseBody
    @PostMapping(value="/search", produces = {"application/json", "application/xml"},consumes = {"application/x-www-form-urlencoded"})
    public List<ChainInfo> searchLists(HttpServletRequest httpServletRequest){
        //抽取全部项目信息
        List<ChainInfo> lists = getSolutionInfo();

        //提取搜索条件
        String projectType = httpServletRequest.getParameter("projectType").toString();
        String salesDept = httpServletRequest.getParameter("salesDept").toString();
        String industryName = httpServletRequest.getParameter("industryName").toString();
        String managerName = httpServletRequest.getParameter("managerName").toString();
        String connectionType = httpServletRequest.getParameter("connectionType").toString();
        String chainName = httpServletRequest.getParameter("chainName").toString();
        String nowState = httpServletRequest.getParameter("nowState").toString();
        String reviewState = httpServletRequest.getParameter("reviewState").toString();
        String keywords = httpServletRequest.getParameter("keywords").toString();
        //根据条件筛选
        for(int i = 0;i<lists.size();i++){
            ChainInfo chainInfo = lists.get(i);
            System.out.println(chainInfo);
            System.out.println(chainInfo.getChainName());
            if(!(projectType.isEmpty())&&!chainInfo.getProjectType().equals(projectType)){
                lists.remove(chainInfo);
                i=i-1;
                continue;
            }
            else if(!salesDept.isEmpty()&&!chainInfo.getSalesDept().equals(salesDept)){
                lists.remove(chainInfo);
                i=i-1;
                continue;
            }
            else if(!industryName.isEmpty()&&!chainInfo.getIndustryName().equals(industryName)){
                lists.remove(chainInfo);
                i=i-1;
                continue;
            }
            else if(!managerName.isEmpty()&&!chainInfo.getManagerName().equals(managerName)){
                lists.remove(chainInfo);
                i=i-1;
                continue;
            }
            else if(!connectionType.isEmpty()&&!chainInfo.getConnectionType().equals(connectionType)){
                lists.remove(chainInfo);
                i=i-1;
                continue;
            }

            else if(!chainName.isEmpty()&&!chainInfo.getChainName().equals(chainName)){
                lists.remove(chainInfo);
                i=i-1;
                continue;
            }
            else if(!nowState.isEmpty()&&!chainInfo.getNowState().equals(nowState)){
                lists.remove(chainInfo);
                i=i-1;
                continue;
            }
            else if(!reviewState.isEmpty()&&!chainInfo.getReviewState().equals(reviewState)){
                lists.remove(chainInfo);
                i=i-1;
                continue;
            }
            else if(!keywords.isEmpty()&&!chainInfo.toString().matches("(.*?)"+keywords+"(.*?)")){
                lists.remove(chainInfo);
                i=i-1;
                continue;
            }

        }
        return lists;
    }

    @PostMapping(value="/addDevice", produces = {"application/json", "application/xml"},consumes = {"application/x-www-form-urlencoded"})
    public boolean addDevice(HttpServletRequest httpServletRequest){
        String projectId = httpServletRequest.getParameter("projectId");

    }
}
