package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Spot;

import java.util.List;

public interface ICommentaireDao {

    public Commentaire findById(int pId);
    public List<Commentaire> findByParentId(int pId);
    public List<Commentaire> findBySpot(Spot pSpot);
    public List<Commentaire> findByTopo(Topo pTopo);
    public List<Commentaire> findAll();
    public Commentaire create(Commentaire pCommentaire);
    public Commentaire update(Commentaire pCommentaire);
    public void delete(Commentaire pCommentaire);
}
