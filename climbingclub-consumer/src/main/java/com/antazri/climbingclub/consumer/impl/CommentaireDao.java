package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ICommentaireDao;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;

import javax.sql.DataSource;
import java.util.List;

public class CommentaireDao extends AbstractDao implements ICommentaireDao {

    public Commentaire findById(int pId) {
        return null;
    }

    public List<Commentaire> findByParentId(int pId) {
        return null;
    }

    public List<Commentaire> findBySpot(Spot pSpot) {
        return null;
    }

    public List<Commentaire> findByTopo(Topo pTopo) {
        return null;
    }

    public List<Commentaire> findAll() {
        return null;
    }

    public Commentaire create(Commentaire pCommentaire) {
        return null;
    }

    public Commentaire update(Commentaire pCommentaire) {
        return null;
    }

    public void delete(Commentaire pCommentaire) {

    }
}
