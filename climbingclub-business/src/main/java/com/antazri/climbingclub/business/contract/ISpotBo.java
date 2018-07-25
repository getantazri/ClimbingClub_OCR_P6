package com.antazri.climbingclub.business.contract;

import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;

import java.util.List;

public interface ISpotBo {

    Spot findById(int pId);
    Spot findByName(String pName);
    List<Spot> findByTopo(Topo pTopo);
    List<Spot> findByHauteur(int pHauteur);
    List<Spot> findAll();
    int create(Spot pSpot);
    int update(Spot pSpot);
    void delete(Spot pSpot);
}
