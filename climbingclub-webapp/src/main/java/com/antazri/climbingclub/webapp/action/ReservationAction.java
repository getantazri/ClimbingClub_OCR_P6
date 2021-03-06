package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.antazri.climbingclub.webapp.services.contract.IReservationService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

public class ReservationAction extends ActionSupport {

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IGestionTopoService gestionTopoService;

    @Autowired
    private ICompteUtilisateurService compteUtilisateurService;

    Logger logger = LogManager.getLogger();

    // =======================================================================
    // Attributs de l'action
    // =======================================================================
    private int empruntId;
    private int utilisateurId;
    private int topoId;
    private String dateDebut;
    private String dateFin;
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

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
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
        clearErrorsAndMessages();
        emprunts = reservationService.findAllReservations();

        return ActionSupport.SUCCESS;
    }

    public String doListByUtilisateur() {
        clearErrorsAndMessages();
            if  (utilisateurId > 0) {
                try {
                    emprunts = reservationService.findReservationByUtilisateur(compteUtilisateurService.findUtilisateurById(utilisateurId));
                    return ActionSupport.SUCCESS;
                } catch (NullPointerException pE) {
                    addActionMessage("Vous n'avez aucune réservation");
                    logger.info("Aucune donnée retrouvée dans la table réservation avec l'identifiant de l'utilisateur", pE);
                    return ActionSupport.SUCCESS;
                }
            } else {
                addActionError("Utilisateur inconnu");
                return ActionSupport.ERROR;
            }
    }

    public String doAddReservation() {
        clearErrorsAndMessages();
        if (topoId > 0) {
            topo = gestionTopoService.findTopoById(topoId);
            emprunts = reservationService.getUpcomingReservations(reservationService.findReservationByTopo(topo));

        }

        if (dateDebut != null && dateFin != null) {
            try {
                if (dateFin.compareTo(dateDebut) > 0 && LocalDate.parse(dateDebut).compareTo(LocalDate.now()) > 0) {

                    if(!reservationService.isBooked(emprunts, LocalDate.parse(dateDebut), LocalDate.parse(dateFin))) {
                        int row = reservationService.addReservation(LocalDate.parse(dateDebut), LocalDate.parse(dateFin), utilisateurId, topoId);

                        if (row > 0) {
                            addActionMessage("Le topo " + topo.getTopoNom() + " a été réservé !");
                            return ActionSupport.SUCCESS;
                        } else {
                            addActionError("Erreur : votre réservation n'a pas pu être enregistrée");
                            return ActionSupport.ERROR;
                        }
                    } else {
                        addActionError("Le topo n'est pas disponible dans cette période");
                        return ActionSupport.ERROR;
                    }
                } else {
                    addActionError("Les dates de la réservation ne sont pas valides");
                    return ActionSupport.ERROR;
                }
            } catch (Exception pE) {
                addActionError("La réservation n'a pas pu être validée");
                logger.error("Informations renseignées pour la réservation invalides", pE);
                return ActionSupport.ERROR;
            }
        }

        return ActionSupport.INPUT;
    }

    public String doGetReservationToUpdate() {
        clearErrorsAndMessages();
        if (empruntId > 0) {
            emprunt = reservationService.findReservationById(empruntId);
            topo = gestionTopoService.findTopoById(emprunt.getTopo().getTopoId());
            emprunts = reservationService.getUpcomingReservations(reservationService.findReservationByTopo(topo));

            for (Iterator<Emprunt> iterator = emprunts.iterator(); iterator.hasNext(); ) {
                Emprunt item = iterator.next();
                if (emprunt.getEmpruntId() == item.getEmpruntId()) {
                    iterator.remove();
                }
            }
        } else {
            addActionError("La réservation n'a pas été trouvée !");
            return ActionSupport.ERROR;
        }

        return ActionSupport.INPUT;
    }

    public String doUpdateReservation() {
        clearErrorsAndMessages();
        if (empruntId > 0) {
            emprunt = reservationService.findReservationById(empruntId);
            topo = gestionTopoService.findTopoById(topoId);
            emprunts = reservationService.getUpcomingReservations(reservationService.findReservationByTopo(topo));

            for (Iterator<Emprunt> iterator = emprunts.iterator(); iterator.hasNext(); ) {
                Emprunt item = iterator.next();
                if (emprunt.getEmpruntId() == item.getEmpruntId()) {
                    iterator.remove();
                }
            }
        }

        if (dateDebut != null && dateFin != null) {
            try {
                if (dateFin.compareTo(dateDebut) > 0 && LocalDate.parse(dateDebut).compareTo(LocalDate.now()) > 0) {

                    if(!reservationService.isBooked(emprunts, LocalDate.parse(dateDebut), LocalDate.parse(dateFin))) {
                        int row = reservationService.updateReservation(emprunt.getEmpruntId(), LocalDate.parse(dateDebut), LocalDate.parse(dateFin));

                        if (row > 0) {
                            addActionMessage("La réservation pour le topo " + topo.getTopoNom() + " a été modifiée !");
                            return ActionSupport.SUCCESS;
                        } else {
                            addActionError("Erreur : votre modification de réservation n'a pas pu être enregistrée");
                            return ActionSupport.ERROR;
                        }
                    } else {
                        addActionError("Le topo n'est pas disponible dans cette période");
                        return ActionSupport.ERROR;
                    }
                } else {
                    addActionError("Les dates de la réservation ne sont pas valides");
                    return ActionSupport.ERROR;
                }
            } catch (Exception pE) {
                addActionError("La réservation n'a pas pu être validée");
                return ActionSupport.ERROR;
            }
        }

        return ActionSupport.INPUT;
    }

    public String doDeleteReservation() {
        clearErrorsAndMessages();
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
                logger.error("Réservation introuvable : erreur dans l'identifiant", pE);
                vResult = Action.ERROR;
            }
        } else {
            this.addActionError("La réservation n'a pas été trouvée");
            vResult = Action.ERROR;
        }

        return vResult;
    }
}
