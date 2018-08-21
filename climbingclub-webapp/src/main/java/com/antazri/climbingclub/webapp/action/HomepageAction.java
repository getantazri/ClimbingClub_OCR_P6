package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.model.beans.Region;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HomepageAction extends ActionSupport {

    @Autowired
    IRegionBo regionBo;

    // =======================================================================
    // Attribut de l'action
    // =======================================================================
    private List<Region> regions;

    // =======================================================================
    // Getters et Setters de l'action
    // =======================================================================
    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    // =======================================================================
    // Méthodes de l'action
    // =======================================================================
    @Override
    public String execute() throws Exception {
        this.regions = regionBo.findAll();

        return ActionSupport.SUCCESS;
    }
}
