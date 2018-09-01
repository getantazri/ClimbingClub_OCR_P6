package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.ICotationBo;
import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;
import com.antazri.climbingclub.webapp.services.contract.IGestionSecteurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionVoieService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionVoieAction extends ActionSupport {

    @Autowired
    private IGestionVoieService gestionVoieService;

    @Autowired
    private IGestionSecteurService gestionSecteurService;

    @Autowired
    private ICotationBo cotationBo;

    // =======================================================================
    // Attributs et paramètres de l'action
    // =======================================================================
    private int voieId;
    private int secteurId;
    private int cotationId;
    private Voie voie;
    private Secteur secteur;
    private Cotation cotation;
    private List<Voie> voies;
    private List<Cotation> cotations;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public int getVoieId() {
        return voieId;
    }

    public void setVoieId(int voieId) {
        this.voieId = voieId;
    }

    public int getSecteurId() {
        return secteurId;
    }

    public void setSecteurId(int secteurId) {
        this.secteurId = secteurId;
    }

    public int getCotationId() {
        return cotationId;
    }

    public void setCotationId(int cotationId) {
        this.cotationId = cotationId;
    }

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
    }

    public List<Voie> getVoies() {
        return voies;
    }

    public void setVoies(List<Voie> voies) {
        this.voies = voies;
    }

    public List<Cotation> getCotations() {
        return cotations;
    }

    public void setCotations(List<Cotation> cotations) {
        this.cotations = cotations;
    }

    // =======================================================================
    // Méthodes / Actions
    // =======================================================================
    public String doVoieDetails() {
        this.setVoie(gestionVoieService.findVoieById(voieId));

        if (this.voie == null || voie.getVoieId() == 0) {
            addActionError("Vous devez spécifié un ID existant");
            return ActionSupport.ERROR;
        }

        return ActionSupport.SUCCESS;
    }

    public String doAddVoie() {
        secteur = gestionSecteurService.findSecteurById(secteurId);
        cotations = cotationBo.findAll();

        if (voie != null) {
            try {
                if (voie.getVoieNom().replace(" ", "").length() < 3) {
                    addActionError("Le nom de votre n'est pas valide");
                    return ActionSupport.INPUT;
                } else {
                    int row = gestionVoieService.addVoie(voie.getVoieNom(), voie.getNombrePoints(), voie.getVoieDescription(), secteurId, voie.getCotation().getCotationId());

                    if (row > 0) {
                        addActionMessage("La voie a été ajoutée");
                        this.setVoie(gestionVoieService.findVoieByName(voie.getVoieNom()));
                        voieId = voie.getVoieId();
                        return ActionSupport.SUCCESS;
                    } else {
                        addActionError("La voie n'a pas été ajoutée");
                        return ActionSupport.ERROR;
                    }
                }
            } catch (Exception pE) {
                this.addActionError("Erreur dans l'ajout de votre voie");
                return ActionSupport.ERROR;
            }
        }

        return ActionSupport.INPUT;
    }

    public String doGetVoieToUpdate() {
        cotations = cotationBo.findAll();

        if (voieId > 0) {
            voie = gestionVoieService.findVoieById(voieId);
        } else {
            addActionError("Voie introuvable");
            return ActionSupport.ERROR;
        }

        return ActionSupport.INPUT;
    }

    public String doUpdateVoie() {
        String vResult;


        try {
            if (voie.getVoieNom().replace(" ", "").length() < 3) {
                addActionError("Le nom de votre voie n'est pas valide");
                vResult = ActionSupport.INPUT;
            } else {
                int row = gestionVoieService.updateVoie(voie.getVoieId(), voie.getVoieNom(), voie.getNombrePoints(), voie.getVoieDescription(), voie.getSecteur().getSecteurId(), voie.getCotation().getCotationId());

                if (row > 0) {
                    vResult = ActionSupport.SUCCESS;
                    addActionMessage("Voie mise à jour");
                    setVoie(gestionVoieService.findVoieByName(voie.getVoieNom()));
                } else {
                    addActionError("Votre voie n'a pas été mise à jour");
                    vResult = ActionSupport.ERROR;
                }
            }

        } catch (Exception pE) {
            this.addActionError("Erreur dans la mise à jour de votre voie");
            vResult = ActionSupport.ERROR;
        }

        return vResult;
    }

    public String doDeleteVoie() {
        String vResult;
        int delete;

        if (voieId > 0) {
            delete = gestionVoieService.deleteVoie(voieId);

            if (delete > 0) {
                addActionMessage("Voie supprimée");
                vResult = ActionSupport.SUCCESS;
            } else {
                addActionError("La voie n'existe pas ou a déjà été supprimée");
                vResult = Action.ERROR;
            }
        } else {
            addActionError("La voie n'existe pas ou a déjà été supprimée");
            vResult = Action.ERROR;
        }

        return vResult;
    }

}
