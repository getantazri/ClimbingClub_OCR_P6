package com.antazri.climbingclub.business.bo.contract;

import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface ITopoBo {

    Topo findById(int pId);
    List<Topo> findByUser(Utilisateur pUtilisateur);
    Topo findByName(String pName);
    List<Topo> findByRegion(Region pRegion);
    List<Topo> containsName(String pName);
    List<Topo> findAll();
    int create(Topo pTopo);
    int update(Topo pTopo);
    void delete(Topo pTopo);
}
