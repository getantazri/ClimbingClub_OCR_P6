package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;

import java.util.List;

public interface ISpotDao {

    Spot findById(int pId);
    Spot findByName(String pName);
    List<Spot> findByTopo(Topo pTopo);
    List<Spot> findByHauteur(int pHauteur);
    List<Spot> findAll();
    int create(Spot pSpot);
    int update(Spot pSpot);
    void delete(Spot pSpot);
}
