package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionTopoAction extends ActionSupport {

    @Autowired
    private IGestionTopoService gestionTopoService;

    @Autowired
    private IRegionBo regionBo;

    @Autowired
    private ICompteUtilisateurService compteUtilisateurService;

    // =======================================================================
    // Attributs et paramètres de l'action
    // =======================================================================
    private int topoId;
    private String topoNom;
    private Utilisateur proprietaire;
    private Topo topo;
    private List<Topo> topos;
    private Region region;
    private List<Region> regions;

    // =======================================================================
    // Getters et Setters des attributs l'action
    // =======================================================================

    public IGestionTopoService getGestionTopoService() {
        return gestionTopoService;
    }

    public void setGestionTopoService(IGestionTopoService gestionTopoService) {
        this.gestionTopoService = gestionTopoService;
    }

    public IRegionBo getRegionBo() {
        return regionBo;
    }

    public void setRegionBo(IRegionBo regionBo) {
        this.regionBo = regionBo;
    }

    public ICompteUtilisateurService getCompteUtilisateurService() {
        return compteUtilisateurService;
    }

    public void setCompteUtilisateurService(ICompteUtilisateurService compteUtilisateurService) {
        this.compteUtilisateurService = compteUtilisateurService;
    }

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
    }

    public String getTopoNom() {
        return topoNom;
    }

    public void setTopoNom(String topoNom) {
        this.topoNom = topoNom;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public List<Topo> getTopos() {
        return topos;
    }

    public void setTopos(List<Topo> topos) {
        this.topos = topos;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    // =======================================================================
    // Méthodes / Actions
    // =======================================================================
    public String doListAllTopos() {
        this.setTopos(gestionTopoService.findAllTopo());
        for (Topo topo : topos) {
            topo.setProprietaire(compteUtilisateurService.findUtilisateurById(topo.getProprietaire().getUtilisateurId()));
            topo.setRegion(regionBo.findById(topo.getRegion().getRegionId()));
        }
        return ActionSupport.SUCCESS;
    }

    public String doTopoDetails() {
        this.setTopo(gestionTopoService.findTopoById(topoId));

        if (topo == null) {
            addActionError("Vous devez spécifié un ID existant");
            return ActionSupport.ERROR;
        }

        return ActionSupport.SUCCESS;
    }

    public String doFindTopoByName() {

        if (topo == null) {
            addActionError("Vous devez spécifié un ID existant");
            return ActionSupport.ERROR;
        }

        return ActionSupport.SUCCESS;
    }

    public String doFindTopoByUser() {

        return ActionSupport.SUCCESS;
    }
    public String doFindTopoByRegion() {
        String vResult = ActionSupport.INPUT;

        if (vResult.equals(ActionSupport.INPUT)) {
            regions = regionBo.findAll();
        }

        if (topo != null) {
            try {
                Region vRegion = regionBo.findById(this.region.getRegionId());
                topos = gestionTopoService.findTopoByRegion(vRegion);
            } catch (Exception pE) {
                this.addFieldError("topo.region.regionId", pE.getMessage());
            }
        }

        return vResult;
    }

    public String doAddTopo() {
        String vResult = ActionSupport.INPUT;

        if (this.topo != null) {
            try {
                this.topo.setProprietaire(compteUtilisateurService.findUtilisateurById(topo.getProprietaire().getUtilisateurId()));
                this.topo.setRegion(regionBo.findById(topo.getRegion().getRegionId()));
            } catch (Exception pE) {
                this.addFieldError("topo.region.regionId", pE.getMessage());
            }

            if (!this.hasErrors()) {
                try {
                    gestionTopoService.addTopo(topo);
                    vResult = ActionSupport.SUCCESS;
                    addActionMessage("Topo ajouté");
                    this.setTopo(gestionTopoService.findTopoByName(topo.getTopoNom()));
                } catch (Exception pE) {
                    this.addActionError("Erreur dans l'ajout de votre topo");
                    vResult = ActionSupport.ERROR;
                }
            }
        }

        if (vResult.equals(ActionSupport.INPUT)) {
            regions = regionBo.findAll();
        }

        return vResult;
    }

    public String doUpdateTopo() {
        String vResult = ActionSupport.INPUT;

        if (topoId > 0) {
            this.setTopo(gestionTopoService.findTopoById(topoId));
        }

        return vResult;
    }

    public String doDeleteTopo() {
        String vResult;
        if (this.topoId > 0) {
            gestionTopoService.deleteTopo(topoId);
            this.addActionMessage("Topo supprimé");
            vResult = ActionSupport.SUCCESS;
        } else {
            this.addActionError("Le topo n'existe pas ou a déjà été supprimé");
            vResult = Action.ERROR;
        }

        return vResult;
    }


}
