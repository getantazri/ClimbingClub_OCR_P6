package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Statut;

import java.util.List;

public interface IStatutDao {

    Statut findById(int pId);
    Statut findByName(String pName);
    List<Statut> findAll();
    Statut create(Statut pStatut);
    Statut update(Statut pStatut);
    void delete(Statut pStatut);
}
