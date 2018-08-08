package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class NavigationAction extends ActionSupport {

    @Autowired
    private IRegionBo regionBo;
}
