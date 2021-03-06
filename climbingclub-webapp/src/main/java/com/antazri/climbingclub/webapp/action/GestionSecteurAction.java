package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Voie;
import com.antazri.climbingclub.webapp.services.contract.IGestionSecteurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionSpotService;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.antazri.climbingclub.webapp.services.contract.IGestionVoieService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionSecteurAction extends ActionSupport {

    @Autowired
    private IGestionVoieService gestionVoieService;

    @Autowired
    private IGestionSecteurService gestionSecteurService;

    @Autowired
    private IGestionSpotService gestionSpotService;

    @Autowired
    private IGestionTopoService gestionTopoService;

    Logger logger = LogManager.getLogger();

    // =======================================================================
    // Attributs et paramètres de l'action
    // =======================================================================
    private int secteurId;
    private int spotId;
    private Topo topo;
    private Spot spot;
    private Secteur secteur;
    private List<Secteur> secteurs;
    private List<Voie> voies;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public List<Voie> getVoies() {
        return voies;
    }

    public void setVoies(List<Voie> voies) {
        this.voies = voies;
    }

    // =======================================================================
    // Méthodes / Actions
    // =======================================================================
    public String doSecteurDetails() {
        clearErrorsAndMessages();
        if (secteur == null || secteur.getSecteurId() == 0) {
            addActionError("Vous devez spécifié un ID existant");
            return ActionSupport.ERROR;
        } else {
            try {
                this.setSecteur(gestionSecteurService.findSecteurById(secteur.getSecteurId()));

                this.setVoies(gestionVoieService.findVoieBySecteur(secteur));

                if (voies.isEmpty()) {
                    voies = null;
                    addActionMessage("Aucune voie n'a été ajoutée à ce secteur");
                }

                return ActionSupport.SUCCESS;
            } catch (Exception pE) {
                addActionError("Secteur introuvable");
                logger.error("Identifiant du Secteur introuvable", pE);
                return ActionSupport.ERROR;
            }
        }
    }

    public String doAddSecteur() {
        clearErrorsAndMessages();
        spot = gestionSpotService.findSpotById(spot.getSpotId());

        if (this.secteur != null) {
            try {
                if (secteur.getSecteurNom().replace(" ", "").length() < 3) {
                    addActionError("Le nom de votre secteur n'est pas valide");
                    return ActionSupport.INPUT;
                } else {
                    int row = gestionSecteurService.addSecteur(secteur.getSecteurNom(), spot.getSpotId());

                    if (row > 0) {
                        addActionMessage("Le secteur a été ajouté");
                        this.setSecteur(gestionSecteurService.findSecteurByName(secteur.getSecteurNom()));
                        return ActionSupport.SUCCESS;
                    } else {
                        this.addActionError("Erreur dans l'ajout de votre secteur");
                        return ActionSupport.ERROR;
                    }
                }
            } catch (Exception pE) {
                this.addActionError("Erreur dans l'ajout de votre spot");
                logger.error("Informations renseignées pour le secteur invalides", pE);
                return ActionSupport.ERROR;
            }
        }

        return ActionSupport.INPUT;
    }

    public String doGetSecteurToUpdate() {
        clearErrorsAndMessages();

        if (secteur.getSecteurId() > 0) {
            try {
                secteur = gestionSecteurService.findSecteurById(secteur.getSecteurId());
            } catch (Exception pE) {
                addActionError("Secteur introuvable");
                return ActionSupport.ERROR;
            }
        } else {
            addActionError("Secteur introuvable");
            return ActionSupport.ERROR;
        }

        return ActionSupport.INPUT;
    }

    public String doUpdateSecteur() {
        clearErrorsAndMessages();
        String vResult;

        try {
            if (secteur.getSecteurNom().replace(" ", "").length() < 3) {
                addActionError("Le nom de votre secteur n'est pas valide");
                vResult = ActionSupport.INPUT;
            } else {
                int row = gestionSecteurService.updateSecteur(secteur.getSecteurId(), secteur.getSecteurNom());

                if (row > 0) {
                    vResult = ActionSupport.SUCCESS;
                    addActionMessage("Secteur mis à jour");
                    this.setSpot(gestionSpotService.findSpotByName(spot.getSpotNom()));
                } else {
                    addActionError("Votre secteur n'a pas été mis à jour");
                    vResult = ActionSupport.ERROR;
                }
            }

        } catch (Exception pE) {
            this.addActionError("Erreur dans la mise à jour de votre secteur");
            logger.error("Informations renseignées pour la mise à jour du secteur invalides", pE);
            vResult = ActionSupport.ERROR;
        }

        return vResult;
    }

    public String doDeleteSecteur() {
        clearErrorsAndMessages();
        String vResult;
        int delete;

        if (secteur.getSecteurId() > 0) {
            delete = gestionSecteurService.deleteSecteur(secteur.getSecteurId());

            if (delete > 0) {
                this.addActionMessage("Secteur supprimé");
                vResult = ActionSupport.SUCCESS;
            } else {
                this.addActionError("Le secteur possède des voies : supprimez-les avant de supprimer le secteur");
                vResult = ActionSupport.ERROR;
            }
        } else {
            this.addActionError("Le secteur n'existe pas ou a déjà été supprimé");
            vResult = Action.ERROR;
        }

        return vResult;
    }
}
