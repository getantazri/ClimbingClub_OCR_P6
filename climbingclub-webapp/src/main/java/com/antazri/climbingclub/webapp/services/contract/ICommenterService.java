package com.antazri.climbingclub.webapp.services.contract;

import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ICommenterService {

    Commentaire findCommentaireById(int pId);
    List<Commentaire> findCommentaireBySpot(Spot pSpot);
    List<Commentaire> findCommentaireByTopo(Topo pTopo);
    List<Commentaire> findCommentaireByUtilisateur(String pName);
    List<Commentaire> findAllCommentaire();
    int publishCommentaire(int pUtilisateurId, String pContenu, LocalDateTime pDatePublication);
    int editCommentaire(int pCommentaireId, String pContenu);
    public int deleteCommentaire(int spotId, int topoId, int pId);
    int getLastCommentaireIdFromUser(Utilisateur pUtilisateur);
}
