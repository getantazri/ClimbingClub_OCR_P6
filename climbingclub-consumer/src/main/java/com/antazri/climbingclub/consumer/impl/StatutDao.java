package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IStatutDao;
import com.antazri.climbingclub.model.beans.Statut;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatutDao extends AbstractDao implements IStatutDao {

    public Statut findById(int pId) {
        return null;
    }

    public Statut findByName(String pName) {
        return null;
    }

    public List<Statut> findAll() {
        return null;
    }

    public Statut create(Statut pStatut) {
        return null;
    }

    public Statut update(Statut pStatut) {
        return null;
    }

    public void delete(Statut pStatut) {

    }
}
