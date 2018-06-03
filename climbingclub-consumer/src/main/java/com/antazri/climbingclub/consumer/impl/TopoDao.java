package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ITopoDao;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public class TopoDao extends AbstractDao implements ITopoDao {

    public Topo findById(int pId) {
        return null;
    }

    public List<Topo> findByUser(Utilisateur pUtilisateur) {
        return null;
    }

    public List<Topo> findByName(String pName) {
        return null;
    }

    public List<Topo> findByAvailability(Boolean pDisponiblite) {
        return null;
    }

    public List<Topo> findAll() {
        return null;
    }

    public Topo create(Topo pTopo) {
        return null;
    }

    public Topo update(Topo pTopo) {
        return null;
    }

    public void delete(Topo pTopo) {

    }
}
