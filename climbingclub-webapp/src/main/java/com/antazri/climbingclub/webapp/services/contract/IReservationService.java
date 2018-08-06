package com.antazri.climbingclub.webapp.services.contract;

import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.Date;
import java.util.List;

public interface IReservationService {

    Emprunt findReservationById(int pId);
    List<Emprunt> findReservationByUtilisateur(Utilisateur pUtilisateur);
    List<Emprunt> findReservationByTopo(Topo pTopo);
    List<Emprunt> findAllReservations();
    int addReservation(Date pDateDebut, Date pDateFin, int pUtilisateurId, int pTopoId);
    int updateReservation(int pEmpruntId, Date pDateDebut, Date pDateFin);
    void deleteReservation(int pEmpruntId);
}
