package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.model.beans.*;
import com.antazri.climbingclub.webapp.services.contract.ICommenterService;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionSpotService;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

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

    @Autowired
    private ICommenterService commenterService;

    Logger logger = LogManager.getLogger();

    // =======================================================================
    // Attributs et paramètres de l'action
    // =======================================================================
    private int topoId;
    private Utilisateur proprietaire;
    private Topo topo;
    private List<Topo> topos;
    private Region region;
    private List<Region> regions;
    private List<Spot> spots;
    private List<Commentaire> commentaires;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
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

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    // =======================================================================
    // Méthodes / Actions
    // =======================================================================
    public String doListAllTopos() {
        clearErrorsAndMessages();

        this.setTopos(gestionTopoService.findAllTopo());

        return ActionSupport.SUCCESS;
    }

    public String doTopoDetails() {
        clearErrorsAndMessages();
         if (topoId > 0) {
             try {
                 this.setTopo(gestionTopoService.findTopoById(topoId));
             } catch (Exception pE) {
                 addActionError("Topo introuvable !");
                 logger.error("identifiant topoId inexistant", pE);
                 return ActionSupport.ERROR;
             }

             this.setSpots(gestionSpotService.findSpotByTopo(topo));

             if (spots.isEmpty()) {
                 spots = null;
                 addActionMessage("Aucun spot n'a été ajouté à ce topo");
             }

             this.setCommentaires(commenterService.findCommentaireByTopo(topo));

             if (commentaires.isEmpty()) {
                 commentaires = null;
             }

             return ActionSupport.SUCCESS;
         }
        else {
            addActionError("Vous devez spécifié un ID existant");
             logger.error("identifiant topoId inexistant");
            return ActionSupport.ERROR;
        }
    }

    public String doAddTopo() {
        clearErrorsAndMessages();
        String vResult = ActionSupport.INPUT;

        if (vResult.equals(ActionSupport.INPUT)) {
            regions = regionBo.findAll();
        }

        if (this.topo != null) {
            try {
                if (topo.getTopoNom().replace(" ", "").length() < 3) {
                    clearActionErrors();
                    addActionError("Le nom de votre topo n'est pas valide");
                    vResult = ActionSupport.INPUT;
                } else {
                    int row = gestionTopoService.addTopo(topo.getTopoNom(), topo.getRegion().getRegionId(), topo.getProprietaire().getUtilisateurId(), topo.isDisponible());

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
                logger.error("Informations renseignées pour le topo invalides", pE);
                vResult = ActionSupport.ERROR;
            }
        }

        return vResult;
    }

    public String doGetTopoToUpdate() {
        clearErrorsAndMessages();

        regions = regionBo.findAll();

        if (topoId > 0) {
            topo = gestionTopoService.findTopoById(topoId);
        }

        return ActionSupport.INPUT;
    }

    public String doUpdateTopo() {
        clearErrorsAndMessages();
        String vResult;

        regions = regionBo.findAll();

        try {
            if (topo.getTopoNom().replace(" ", "").length() < 3) {
                addActionError("Le nom de votre topo n'est pas valide");
                vResult = ActionSupport.INPUT;
            } else {
                int row = gestionTopoService.updateTopo(topo.getTopoId(), topo.getTopoNom(), topo.getRegion().getRegionId(), topo.getProprietaire().getUtilisateurId(), topo.isDisponible());

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
            logger.error("Informations renseignées pour le topo invalides", pE);
            vResult = ActionSupport.ERROR;
        }

        return vResult;
    }

    public String doDeleteTopo() {
        clearErrorsAndMessages();
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
