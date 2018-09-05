package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.IEmpruntBo;
import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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
        return empruntBo.findById(pId);
    }

    /**
     * La méthode findReservationByUtilisateur permet de retourner des objets, ayant comme attribut Utilisateur l'instance pUtilisateur passée en paramètre, Emprunt depuis la
     * couche Business grâce à l'objet EmpruntBo, affecté par Spring avec l'annotation @Autowired.
     * @param pUtilisateur est un objet Utilisateur permettant de filtrer les instances d'Emprunt à retourner depuis la couche business
     * @return une List d'objets Emprunt
     */
    public List<Emprunt> findReservationByUtilisateur(Utilisateur pUtilisateur) {
        return empruntBo.findByUtilisateur(pUtilisateur);
    }

    /**
     * La méthode findReservationByTopo permet de retourner des objets, ayant comme attribut Topo l'instance pTopo passée en paramètre, Emprunt depuis la
     * couche Business grâce à l'objet EmpruntBo, affecté par Spring avec l'annotation @Autowired.
     * @param pTopo est un objet Topo permettant de filtrer les instances d'Emprunt à retourner depuis la couche business
     * @return une List d'objets Emprunt
     */
    public List<Emprunt> findReservationByTopo(Topo pTopo) {
        return empruntBo.findByTopo(pTopo);
    }

    /**
     * La méthode findAllReservation permet de retourner l'ensemble des instances de Emprunt depuis la couche Business grâce à l'objet EmpruntBo,
     * affecté par Spring avec l'annotation @Autowired.
     * @return une List d'objets Emprunt
     */
    public List<Emprunt> findAllReservations() {
        return empruntBo.findAll();
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
    public int addReservation(Date pDateDebut, Date pDateFin, int pUtilisateurId, int pTopoId) {
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
    public int updateReservation(int pEmpruntId, Date pDateDebut, Date pDateFin) {
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
    public void deleteReservation(int pEmpruntId) {
        empruntBo.delete(empruntBo.findById(pEmpruntId));
    }
}
