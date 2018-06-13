package com.antazri.climbingclub.business.bo.contract;

import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface ITopoBo {

    Topo findById(int pId);
    List<Topo> findByUser(Utilisateur pUtilisateur);
    List<Topo> findByName(String pName);
    List<Topo> findByAvailability(Boolean pDisponiblite);
    List<Topo> findAll();
    Topo create(Topo pTopo);
    Topo update(Topo pTopo);
    void delete(Topo pTopo);
}
