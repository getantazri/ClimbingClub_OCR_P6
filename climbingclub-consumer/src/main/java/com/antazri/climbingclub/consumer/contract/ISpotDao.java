package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;

import java.util.List;

public interface ISpotDao {

    Spot findById(int pId);
    Spot findByName(String pName);
    List<Spot> findByTopo(Topo pTopo);
    List<Spot> findAll();
    List<Spot> containsName(String pName);
    int create(Spot pSpot);
    int update(Spot pSpot);
    void delete(Spot pSpot);
}
