package com.antazri.climbingclub.webapp.services.contract;

import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.time.LocalDate;
import java.util.List;

public interface IReservationService {

    Emprunt findReservationById(int pId);
    List<Emprunt> findReservationByUtilisateur(Utilisateur pUtilisateur);
    List<Emprunt> findReservationByTopo(Topo pTopo);
    List<Emprunt> findAllReservations();
    int addReservation(LocalDate pDateDebut, LocalDate pDateFin, int pUtilisateurId, int pTopoId);
    int updateReservation(int pEmpruntId, LocalDate pDateDebut, LocalDate pDateFin);
    int deleteReservation(int pEmpruntId);
    boolean isPassedReservation(Emprunt pEmprunt);
    boolean hasOnGoingReservation(Utilisateur pUtilisateur);
}
