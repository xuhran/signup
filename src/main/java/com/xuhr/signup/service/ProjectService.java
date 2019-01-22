package com.xuhr.signup.service;

import com.xuhr.signup.model.ChainInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 *@ClassName ProjectSolutionService
 *@Description TODO
 *@Author xuhr12
 *@Date 2019-01-17 9:57
 *@Version 1.0
 */
@Service
public interface ProjectService {
    public List<ChainInfo> getChainInfo();
}
