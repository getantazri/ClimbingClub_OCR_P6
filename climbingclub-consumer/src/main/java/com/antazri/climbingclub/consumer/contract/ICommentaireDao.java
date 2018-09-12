package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface ICommentaireDao {

    Commentaire findById(int pId);
    List<Commentaire> findByUtilisateur(Utilisateur pUtilisateur);
    List<Commentaire> findAll();
    int create(Commentaire pCommentaire);
    int update(Commentaire pCommentaire);
    void delete(Commentaire pCommentaire);
}
