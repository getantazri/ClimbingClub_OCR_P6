package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Statut;

import java.util.List;

public interface IStatutDao {

    public Statut findById(int pId);
    public Statut findByName(String pName);
    public List<Statut> findAll();
    public Statut create(Statut pStatut);
    public Statut update(Statut pStatut);
    public void delete(Statut pStatut);
}
