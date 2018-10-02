package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RegionAction extends ActionSupport {

    @Autowired
    private IRegionBo regionBo;

    @Autowired
    private ICompteUtilisateurService compteUtilisateurService;

    @Autowired
    private IGestionTopoService gestionTopoService;

    Logger logger = LogManager.getLogger();

    // =======================================================================
    // Attributs de l'action
    // =======================================================================
    private int regionId;
    private int topoId;
    private List<Region> regions;
    private Region region;
    private  List<Topo> topos;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
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

    public List<Topo> getTopos() {
        return topos;
    }

    public void setTopos(List<Topo> topos) {
        this.topos = topos;
    }

    // =======================================================================
    // Méthodes
    // =======================================================================
    public String doRegions() {
        clearErrorsAndMessages();
        regions = regionBo.findAll();

        return ActionSupport.SUCCESS;
    }

    public String doRegionDetails() {
        clearErrorsAndMessages();
        this.setRegion(regionBo.findById(region.getRegionId()));

        if(region != null) {
            topos = gestionTopoService.findTopoByRegion(region);

            if (topos.isEmpty()) {
                topos = null;
                addActionMessage("Oups, aucun topo disponible dans cette région");
            }

        } else {
            addActionError("Aucune région n'a été sélectionnée");
            return Action.ERROR;
        }

        return Action.SUCCESS;
    }
}
