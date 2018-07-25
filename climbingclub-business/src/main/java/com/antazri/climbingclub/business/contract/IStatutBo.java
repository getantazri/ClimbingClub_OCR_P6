package com.antazri.climbingclub.business.contract;

import com.antazri.climbingclub.model.beans.Statut;

import java.util.List;

public interface IStatutBo {

    Statut findById(int pId);
    Statut findByName(String pName);
    List<Statut> findAll();
    int create(Statut pStatut);
    int update(Statut pStatut);
    void delete(Statut pStatut);
}
