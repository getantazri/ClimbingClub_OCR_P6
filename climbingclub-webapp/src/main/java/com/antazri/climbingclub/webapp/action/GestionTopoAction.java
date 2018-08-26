package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionSpotService;
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

    @Autowired
    private IGestionSpotService gestionSpotService;

    // =======================================================================
    // Attributs et paramètres de l'action
    // =======================================================================
    private int topoId;
    private String topoNom;
    private Utilisateur proprietaire;
    private Topo topo;
    private Topo comparedTopo;
    private List<Topo> topos;
    private Region region;
    private List<Region> regions;
    private List<Spot> spots;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
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

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public Topo getComparedTopo() {
        return comparedTopo;
    }

    public void setComparedTopo(Topo comparedTopo) {
        this.comparedTopo = comparedTopo;
    }

    // =======================================================================
    // Méthodes / Actions
    // =======================================================================
    public String doListAllTopos() {
        this.setTopos(gestionTopoService.findAllTopo());

        return ActionSupport.SUCCESS;
    }

    public String doTopoDetails() {
        this.setTopo(gestionTopoService.findTopoById(topoId));

        if (topo == null) {
            addActionError("Vous devez spécifié un ID existant");
            return ActionSupport.ERROR;
        }

        this.setSpots(gestionSpotService.findSpotByTopo(topo));

        if (spots.isEmpty()) {
            spots = null;
            addActionMessage("Aucun spot n'a été ajouté à ce topo");
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

        if (vResult.equals(ActionSupport.INPUT)) {
            regions = regionBo.findAll();
        }

        if (this.topo != null) {
            try {
                if (topo.getTopoNom().replace(" ", "").length() < 3) {
                    addActionError("Le nom de votre topo n'est pas valide");
                    vResult = ActionSupport.INPUT;
                } else {
                    int row = gestionTopoService.addTopo(topo.getTopoNom(), topo.getRegion().getRegionId(), topo.getProprietaire().getUtilisateurId());

                    if (row == 1) {
                        vResult = ActionSupport.SUCCESS;
                        addActionMessage("Topo ajouté");
                        this.setTopo(gestionTopoService.findTopoByName(topo.getTopoNom()));
                    } else {
                        addActionError("Votre topo n'a pas été ajouté");
                        vResult = ActionSupport.ERROR;
                    }
                }

            } catch (Exception pE) {
                this.addActionError("Erreur dans l'ajout de votre topo");
                vResult = ActionSupport.ERROR;
            }
        }

        return vResult;
    }

    public String doGetTopoToUpdate() {

        regions = regionBo.findAll();

        if (topoId > 0) {
            topo = gestionTopoService.findTopoById(topoId);
        }

        return ActionSupport.INPUT;
    }

    public String doUpdateTopo() {
        String vResult;

        regions = regionBo.findAll();

        try {
            if (topo.getTopoNom().replace(" ", "").length() < 3) {
                addActionError("Le nom de votre topo n'est pas valide");
                vResult = ActionSupport.INPUT;
            } else {
                int row = gestionTopoService.updateTopo(topo.getTopoId(), topo.getTopoNom(), topo.getRegion().getRegionId(), topo.getProprietaire().getUtilisateurId());

                if (row > 0) {
                    vResult = ActionSupport.SUCCESS;
                    addActionMessage("Topo mis à jour");
                    this.setTopo(gestionTopoService.findTopoByName(topo.getTopoNom()));
                } else {
                    addActionError("Votre topo n'a pas été mis à jour");
                    vResult = ActionSupport.ERROR;
                }
            }

        } catch (Exception pE) {
            this.addActionError("Erreur dans la mise à jour de votre topo");
            vResult = ActionSupport.ERROR;
        }

        return vResult;
    }

    public String doDeleteTopo() {
        String vResult;
        int delete;

        if (this.topoId > 0) {
            delete = gestionTopoService.deleteTopo(topoId);

            if (delete > 0) {
                this.addActionMessage("Topo supprimé");
                vResult = ActionSupport.SUCCESS;
            } else {
                this.addActionError("Le topo possède des spots : supprimez-les avant de supprimer le topo");
                vResult = ActionSupport.ERROR;
            }
        } else {
            this.addActionError("Le topo n'existe pas ou a déjà été supprimé");
            vResult = Action.ERROR;
        }

        return vResult;
    }
}
