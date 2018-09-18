package com.antazri.climbingclub.webapp.services.contract;

import com.antazri.climbingclub.model.beans.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ICommenterService {

    Commentaire findCommentaireById(int pId);
    List<Commentaire> findCommentaireBySpot(Spot pSpot);
    List<Commentaire> findCommentaireByTopo(Topo pTopo);
    List<Commentaire> findCommentaireByUtilisateur(String pName);
    CommentaireSpot findCommentaireSpotByCommentaire(Commentaire pCommentaire);
    CommentaireTopo findCommentaireTopoByCommentaire(Commentaire pCommentaire);
    List<Commentaire> findAllCommentaire();
    int publishCommentaire(int pUtilisateurId, String pContenu, LocalDateTime pDatePublication);
    int editCommentaire(int pCommentaireId, String pContenu);
    public int deleteCommentaire(int spotId, int topoId, int pId);
}
