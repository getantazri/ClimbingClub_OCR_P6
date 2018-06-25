package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface ICommentaireDao {

    Commentaire findById(int pId);
    List<Commentaire> findBySpot(Spot pSpot);
    List<Commentaire> findByTopo(Topo pTopo);
    List<Commentaire> findAll();
    int create(Commentaire pCommentaire);
    int update(Commentaire pCommentaire);
    void delete(Commentaire pCommentaire);

    Topo getTopo(Integer pId);
    Spot getSpot(Integer pId);
    Utilisateur getAuthor(Integer pId);
}
