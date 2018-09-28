package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.antazri.climbingclub.webapp.services.contract.IReservationService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ReservationAction extends ActionSupport {

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IGestionTopoService gestionTopoService;

    @Autowired
    private ICompteUtilisateurService compteUtilisateurService;

    // =======================================================================
    // Attributs de l'action
    // =======================================================================
    private int empruntId;
    private int utilisateurId;
    private int topoId;
    private Date dateDebut;
    private Date dateFin;
    private Emprunt emprunt;
    private Utilisateur utilisateur;
    private Topo topo;
    private List<Emprunt> emprunts;
    private List<Topo> topos;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public int getEmpruntId() {
        return empruntId;
    }

    public void setEmpruntId(int empruntId) {
        this.empruntId = empruntId;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
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
    public String doList() {
        emprunts = reservationService.findAllReservations();

        return ActionSupport.SUCCESS;
    }

    public String doListByUtilisateur() {
            if  (utilisateurId > 0) {
                try {
                    emprunts = reservationService.findReservationByUtilisateur(compteUtilisateurService.findUtilisateurById(utilisateurId));
                    return ActionSupport.SUCCESS;
                } catch (NullPointerException pE) {
                    addActionMessage("Vous n'avez aucune réservation");
                    return ActionSupport.SUCCESS;
                }
            } else {
                addActionError("Utilisateur inconnu");
                return ActionSupport.ERROR;
            }
    }

    public String doDetails() {
        if (empruntId > 0) {
            try {
                emprunt = reservationService.findReservationById(empruntId);
                emprunt.setUtilisateur(compteUtilisateurService.findUtilisateurById(emprunt.getUtilisateur().getUtilisateurId()));
                emprunt.setTopo(gestionTopoService.findTopoById(emprunt.getTopo().getTopoId()));

                return ActionSupport.SUCCESS;

            } catch (NullPointerException pE) {
                addActionError("Une erreur est survenue");
                return ActionSupport.ERROR;
            }

        } else {
            addActionError("La réservation n'a pas été trouvée !");
            return ActionSupport.ERROR;
        }
    }

    public String doAddReservation() {
        String vResult = ActionSupport.INPUT;

        topos = gestionTopoService.findAllTopo();

        if (emprunt != null) {
            try {
                if (dateFin.compareTo(dateDebut) > 0) {
                    reservationService.addReservation(emprunt.getDateDebut(), emprunt.getDateFin(), utilisateurId, emprunt.getTopo().getTopoId());
                    addActionMessage("Réservation validée");
                    vResult = ActionSupport.SUCCESS;
                } else {
                    addActionError("Les dates indiquées ne sont pas valides");
                    vResult = ActionSupport.ERROR;
                }
            } catch (Exception pE) {
                addActionError("La réservation n'a pas pu être validée");
                vResult = ActionSupport.ERROR;
            }
        }

        return vResult;
    }

    public String doGetReservationToUpdate() {
        if (empruntId > 0) {
            emprunt = reservationService.findReservationById(empruntId);
        } else {
            addActionError("La réservation n'a pas été trouvée !");
            return ActionSupport.ERROR;
        }

        return ActionSupport.INPUT;
    }

    public String doUpdateReservation() {
        if (emprunt != null) {
            try {
                if (dateFin.compareTo(dateDebut) > 0) {
                    reservationService.updateReservation(emprunt.getEmpruntId(), emprunt.getDateDebut(), emprunt.getDateFin());
                    addActionMessage("Réservation modifiée");
                    return ActionSupport.SUCCESS;
                } else {
                    addActionError("Les dates indiquées ne sont pas valides");
                    return ActionSupport.ERROR;
                }
            } catch (Exception pE) {
                addActionError("La réservation n'a pas pu être modifiée");
                return ActionSupport.ERROR;
            }
        } else {
            addActionError("La réservation n'a pas été trouvée !");
            return ActionSupport.ERROR;
        }
    }

    public String doDeleteReservation() {
        String vResult;
        int delete;

        if (empruntId > 0) {
            try {
                delete = reservationService.deleteReservation(empruntId);

                if (delete > 0) {
                    this.addActionMessage("Réservation supprimée");
                    vResult = ActionSupport.SUCCESS;
                } else {
                    this.addActionError("La réservation n'a pas été supprimée");
                    vResult = ActionSupport.ERROR;
                }
            } catch (Exception pE) {
                this.addActionError("Erreur dans la suppression de la réservation");
                vResult = Action.ERROR;
            }
        } else {
            this.addActionError("La réservation n'a pas été trouvée");
            vResult = Action.ERROR;
        }

        return vResult;
    }
}
