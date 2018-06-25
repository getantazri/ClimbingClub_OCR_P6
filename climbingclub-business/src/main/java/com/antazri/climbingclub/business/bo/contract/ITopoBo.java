package com.antazri.climbingclub.business.bo.contract;

import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface ITopoBo {

    Topo findById(int pId);
    List<Topo> findByUser(Utilisateur pUtilisateur);
    List<Topo> findByName(String pName);
    List<Topo> findAll();
    int create(Topo pTopo);
    int update(Topo pTopo);
    void delete(Topo pTopo);
}
