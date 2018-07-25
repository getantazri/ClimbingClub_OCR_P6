package com.antazri.climbingclub.business.contract;

import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface ICommentaireBo {
    Commentaire findById(int pId);
    List<Commentaire> findBySpot(Spot pSpot);
    List<Commentaire> findByTopo(Topo pTopo);
    List<Commentaire> findByUtilisateur(Utilisateur pUtilisateur);
    List<Commentaire> findAll();
    int create(Commentaire pCommentaire);
    int update(Commentaire pCommentaire);
    void delete(Commentaire pCommentaire);
}
