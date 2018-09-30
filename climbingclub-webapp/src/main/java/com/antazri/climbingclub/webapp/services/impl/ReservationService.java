package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.IEmpruntBo;
import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de l'interface IRechercheService. RechercheService permet à la WebApp d'utiliser les Business Objects pour récupérer ou envoyer des objets/données,
 * liés au module de réservation de topo de l'application, à la base de données.
 *
 * @author Anthony T
 * @version 1.0
 */
public class ReservationService implements IReservationService {

    @Autowired
    private IEmpruntBo empruntBo;

    @Autowired
    private IUtilisateurBo utilisateurBo;

    @Autowired
    private ITopoBo topoBo;

    /**
     * La méthode findReservationById permet de retourner un objet Emprunt depuis la couche Business grâce à l'objet EmpruntBo, affecté par Spring avec l'annotation @Autowired.
     * @param pId est l'identifiant de l'instance d'Emprunt retournée depuis la couche business
     * @return un objet Emprunt
     */
    public Emprunt findReservationById(int pId) {
        Emprunt emprunt = empruntBo.findById(pId);
        emprunt.setTopo(topoBo.findById(emprunt.getTopo().getTopoId()));
        emprunt.setUtilisateur(utilisateurBo.findById(emprunt.getUtilisateur().getUtilisateurId()));

        return emprunt;
    }

    /**
     * La méthode findReservationByUtilisateur permet de retourner des objets, ayant comme attribut Utilisateur l'instance pUtilisateur passée en paramètre, Emprunt depuis la
     * couche Business grâce à l'objet EmpruntBo, affecté par Spring avec l'annotation @Autowired.
     * @param pUtilisateur est un objet Utilisateur permettant de filtrer les instances d'Emprunt à retourner depuis la couche business
     * @return une List d'objets Emprunt
     */
    public List<Emprunt> findReservationByUtilisateur(Utilisateur pUtilisateur) {
        List<Emprunt> emprunts = empruntBo.findByUtilisateur(pUtilisateur);

        for (Emprunt emprunt : emprunts) {
            emprunt.setTopo(topoBo.findById(emprunt.getTopo().getTopoId()));
            emprunt.setUtilisateur(utilisateurBo.findById(emprunt.getUtilisateur().getUtilisateurId()));
        }

        return emprunts;
    }

    /**
     * La méthode findReservationByTopo permet de retourner des objets, ayant comme attribut Topo l'instance pTopo passée en paramètre, Emprunt depuis la
     * couche Business grâce à l'objet EmpruntBo, affecté par Spring avec l'annotation @Autowired.
     * @param pTopo est un objet Topo permettant de filtrer les instances d'Emprunt à retourner depuis la couche business
     * @return une List d'objets Emprunt
     */
    public List<Emprunt> findReservationByTopo(Topo pTopo) {
        List<Emprunt> emprunts = empruntBo.findByTopo(pTopo);

        for (Emprunt emprunt : emprunts) {
            emprunt.setTopo(topoBo.findById(emprunt.getTopo().getTopoId()));
            emprunt.setUtilisateur(utilisateurBo.findById(emprunt.getUtilisateur().getUtilisateurId()));
        }

        return emprunts;
    }

    /**
     * La méthode findAllReservation permet de retourner l'ensemble des instances de Emprunt depuis la couche Business grâce à l'objet EmpruntBo,
     * affecté par Spring avec l'annotation @Autowired.
     * @return une List d'objets Emprunt
     */
    public List<Emprunt> findAllReservations() {
        List<Emprunt> emprunts = empruntBo.findAll();

        for (Emprunt emprunt : emprunts) {
            emprunt.setTopo(topoBo.findById(emprunt.getTopo().getTopoId()));
            emprunt.setUtilisateur(utilisateurBo.findById(emprunt.getUtilisateur().getUtilisateurId()));
        }

        return emprunts;
    }

    /**
     * La méthode addReservation permet de créer une instance de Emprunt transférée vers la couche Business grâce à l'objet EmpruntBo,
     * affecté par Spring avec l'annotation @Autowired.
     * @param pDateDebut est un objet Date pour fixer une date de début de réservation
     * @param pDateFin est un objet Date pour fixer une date de fin de réservation
     * @param pUtilisateurId est un Integer spécifiant l'identifiant unique de l'Utilisateur effectuant la réservation
     * @param pTopoId est un Integer spécifiant l'identifiant unique du Topo concerné
     * @return un Integer (1 ou 0) permettant de définir si une ligne a été ajoutée ou non
     */
    public int addReservation(LocalDate pDateDebut, LocalDate pDateFin, int pUtilisateurId, int pTopoId) {
        Emprunt emprunt = new Emprunt();
        emprunt.setDateDebut(pDateDebut);
        emprunt.setDateFin(pDateFin);
        emprunt.setUtilisateur(utilisateurBo.findById(pUtilisateurId));
        emprunt.setTopo(topoBo.findById(pTopoId));

        return empruntBo.create(emprunt);
    }

    /**
     * La méthode updateReservation permet de mettre à jour une instance de Emprunt transférée vers la couche Business grâce à l'objet EmpruntBo,
     * affecté par Spring avec l'annotation @Autowired.
     * @param pDateDebut est un objet Date pour fixer une date de début de réservation
     * @param pDateFin est un objet Date pour fixer une date de fin de réservation
     * @return un Integer (1 ou 0) permettant de définir si une ligne a été modifiée ou non
     */
    public int updateReservation(int pEmpruntId, LocalDate pDateDebut, LocalDate pDateFin) {
        Emprunt emprunt = empruntBo.findById(pEmpruntId);
        emprunt.setDateDebut(pDateDebut);
        emprunt.setDateFin(pDateFin);

        return empruntBo.update(emprunt);
    }

    /**
     * La méthode updateReservation permet de mettre à jour une instance de Emprunt transférée vers la couche Business grâce à l'objet EmpruntBo,
     * affecté par Spring avec l'annotation @Autowired.
     * @param pEmpruntId est l'identifiant unique de l'instance de Emprunt à supprimer
     */
    public int deleteReservation(int pEmpruntId) {
        try {
            empruntBo.delete(empruntBo.findById(pEmpruntId));
            return 1;
        } catch (Exception pE) {
            return 0;
        }
    }

    /**
     * La méthode isPassedReservation permet de vérifier si un objet Emprunt est considéré comme passé : la méthode vérifie l'attribut DateFin et le compare à
     * la date du jour avec la méthode isBefore de la classe LocalDate du package java.time.
     * @param pEmprunt est un objet Emprunt que l'on souhaite analyser
     * @return un booléen qui indique si l'événement est encore en cours (false) ou passé (true)
     */
    @Override
    public boolean isPassedReservation(Emprunt pEmprunt) {
        if (pEmprunt.getDateFin().isBefore(LocalDate.now())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * La méthode hasOnGoingReservation vérifie si un Utilisateur a déjà un objet Emprunt qui lui est attribué dans la base de données. La méthode va vérifier l'attribut DateFin
     * de tous les objets Emprunt récupéré depuis la table emprunt avec l'identifiant unique de l'objet Utilisateur.
     * @param pUtilisateur est un objet Utilisateur correspondant à l'utilisateur auquel la méthode vérifie les emprunts liés dans la base de données
     * @return un booléen qui sera à True très que la boucle aura
     */
    @Override
    public boolean hasOnGoingReservation(Utilisateur pUtilisateur) {
        List<Emprunt> emprunts = new ArrayList<>();

        try {
            emprunts = findReservationByUtilisateur(pUtilisateur);

            for (Emprunt emprunt : emprunts) {
                if (emprunt.getDateFin().isAfter(LocalDate.now()) && emprunt.getDateDebut().isBefore(LocalDate.now())) {
                    return true;
                }
            }
        } catch (NullPointerException pE) {
            return false;
        }

        return false;

    }

    /**
     * La méthode is Booked va vérifier si l'objet Topo en paramètre est déjà réservé en comparant les dates indiquées par l'utilisateurs passées en paramètre et celles des réservations
     * effectuées pour le Topo.
     * @param pTopo est un objet Topo qui permettra de récupérer l'ensemble des objets Emprunt
     * @param pDatedebut est un objet LocalDate récupéré puis comparé aux dates de pTopo
     * @param pDateFin est un objet LocalDate récupéré puis comparé aux dates de pTopo
     * @return un booléen qui sera à True si les dates indiquées croisent des périodes d'autres Emprunt du même topo
     */
    @Override
    public boolean isBooked(Topo pTopo, LocalDate pDatedebut, LocalDate pDateFin) {
        List<Emprunt> emprunts = findReservationByTopo(pTopo);

        for (Emprunt emprunt : emprunts) {
            if (pDatedebut.compareTo(emprunt.getDateDebut()) >= 0 && pDatedebut.compareTo(emprunt.getDateFin()) <= 0) {
                return true;
            }

            if (pDateFin.compareTo(emprunt.getDateDebut()) >= 0 && pDateFin.compareTo(emprunt.getDateFin()) <= 0) {
                return true;
            }
        }

        return false;
    }
}
