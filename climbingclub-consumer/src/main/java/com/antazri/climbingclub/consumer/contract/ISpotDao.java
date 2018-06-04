package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;

import java.util.List;

public interface ISpotDao {

    Spot findById(int pId);
    List<Spot> findBySpot(Topo pTopo);
    List<Spot> findAll();
    Spot create(Spot pSpot);
    Spot update(Spot pSpot);
    void delete(Spot pSpot);
}
