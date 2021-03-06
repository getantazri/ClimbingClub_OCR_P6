package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.webapp.services.contract.ICommenterService;
import com.antazri.climbingclub.webapp.services.contract.IGestionSecteurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionSpotService;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionSpotAction extends ActionSupport {

    @Autowired
    private IGestionTopoService gestionTopoService;

    @Autowired
    private IGestionSpotService gestionSpotService;

    @Autowired
    private IGestionSecteurService gestionSecteurService;

    @Autowired
    private ICommenterService commenterService;

    Logger logger = LogManager.getLogger();

    // =======================================================================
    // Attributs et paramètres de l'action
    // =======================================================================
    private int spotId;
    private int topoId;
    private Spot spot;
    private Topo topo;
    private List<Spot> spots;
    private List<Secteur> secteurs;
    private List<Commentaire> commentaires;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    // =======================================================================
    // Méthodes de l'action
    // =======================================================================
    public String doSpotDetails() {
        clearErrorsAndMessages();
        if (spotId < 0) {
            addActionError("Vous devez spécifié un ID existant");
            return ActionSupport.ERROR;
        } else {
            try {
                this.setSpot(gestionSpotService.findSpotById(spotId));
            } catch (Exception pE) {
                addActionError("Spot introuvable");
                logger.error("Identifiant du Spot invalide", pE);
                return ActionSupport.ERROR;
            }

            this.setSecteurs(gestionSecteurService.findSecteurBySpot(spot));

            if (secteurs.isEmpty()) {
                secteurs = null;
                addActionMessage("Aucun secteur n'a été ajouté à ce spot");
            }

            this.setCommentaires(commenterService.findCommentaireBySpot(spot));

            if (commentaires.isEmpty()) {
                commentaires = null;
            }

            return ActionSupport.SUCCESS;
        }
    }

    public String doAddSpot() {
        clearErrorsAndMessages();
        topo = gestionTopoService.findTopoById(topoId);

        if (spot != null) {
                if (spot.getSpotNom().replace(" ", "").length() < 3 || StringUtils.isAnyBlank(spot.getSpotNom(), spot.getSpotDescription())) {
                    addActionError("Les informations ne sont pas valides");
                    return ActionSupport.INPUT;
                } else {

                    try {

                    int row = gestionSpotService.addSpot(spot.getSpotNom(), spot.getSpotDescription(), spot.getHauteur(), topo.getTopoId());

                    if (row > 0) {
                        addActionMessage("Spot ajouté");
                        this.setSpot(gestionSpotService.findSpotByName(spot.getSpotNom()));
                        return ActionSupport.SUCCESS;
                    } else {
                        addActionError("Votre spot n'a pas été ajouté");
                        return ActionSupport.ERROR;
                    }
                } catch (Exception pE) {
                        this.addActionError("Erreur dans l'ajout de votre spot");
                        logger.error("Informations renseignées pour le spot invalides", pE);
                        return ActionSupport.ERROR;
                    }

            }
        }

        return ActionSupport.INPUT;
    }

    public String doGetSpotToUpdate() {
        clearErrorsAndMessages();

        if (spotId > 0) {
            try {
                spot = gestionSpotService.findSpotById(spotId);
                topo = gestionTopoService.findTopoById(spot.getTopo().getTopoId());
            } catch (Exception pE) {
                addActionError("Spot introuvable");
                return ActionSupport.ERROR;
            }
        } else {
            addActionError("Spot introuvable");
            return ActionSupport.ERROR;
        }

        return ActionSupport.INPUT;
    }

    public String doUpdateSpot() {
        clearErrorsAndMessages();
        String vResult;

        try {
            if (spot.getSpotNom().replace(" ", "").length() < 3) {
                addActionError("Le nom de votre spot n'est pas valide");
                vResult = ActionSupport.INPUT;
            } else {
                int row = gestionSpotService.updateSpot(spot.getSpotId(), spot.getSpotNom(), spot.getSpotDescription(), spot.getHauteur());

                if (row > 0) {
                    vResult = ActionSupport.SUCCESS;
                    addActionMessage("Spot mis à jour");
                    this.setSpot(gestionSpotService.findSpotByName(spot.getSpotNom()));
                } else {
                    addActionError("Votre spot n'a pas été mis à jour");
                    vResult = ActionSupport.ERROR;
                }
            }

        } catch (Exception pE) {
            this.addActionError("Erreur dans la mise à jour de votre spot");
            logger.error("Informations renseignées pour la mise à jour du spot invalides", pE);
            vResult = ActionSupport.ERROR;
        }

        return vResult;
    }

    public String doDeleteSpot() {
        clearErrorsAndMessages();
        String vResult;
        int delete;

        if (spotId > 0) {
            delete = gestionSpotService.deleteSpot(spotId);

            if (delete > 0) {
                this.addActionMessage("Spot supprimé");
                vResult = ActionSupport.SUCCESS;
            } else {
                this.addActionError("Le spot possède des secteurs : supprimez-les avant de supprimer le spot");
                vResult = ActionSupport.ERROR;
            }
        } else {
            this.addActionError("Le spot n'existe pas ou a déjà été supprimé");
            vResult = Action.ERROR;
        }

        return vResult;
    }
}
