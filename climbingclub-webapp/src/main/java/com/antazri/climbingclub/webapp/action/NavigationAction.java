package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NavigationAction extends ActionSupport {

    @Autowired
    private IRegionBo regionBo;

    @Autowired
    private ICompteUtilisateurService compteUtilisateurService;

    // =======================================================================
    // Attributs de l'action
    // =======================================================================
    private int regionId;
    private List<Region> regions;
    private Region region;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public IRegionBo getRegionBo() {
        return regionBo;
    }

    public void setRegionBo(IRegionBo regionBo) {
        this.regionBo = regionBo;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    // =======================================================================
    // Méthodes
    // =======================================================================


    @Override
    public String execute() throws Exception {
        this.regions = regionBo.findAll();
        return ActionSupport.SUCCESS;
    }

    public String doRegionsList() {

        return Action.SUCCESS;
    }

    public String doRegionDetails() {
        if(region != null) {
            return Action.SUCCESS;
        } else {
            addActionError("Aucune région n'a été sélectionnée");
            return Action.ERROR;
        }
    }
}
