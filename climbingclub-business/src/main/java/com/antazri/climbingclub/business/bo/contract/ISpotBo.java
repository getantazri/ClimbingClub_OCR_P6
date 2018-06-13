package com.antazri.climbingclub.business.bo.contract;

import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;

import java.util.List;

public interface ISpotBo {

    Spot findById(int pId);
    List<Spot> findByTopo(Topo pTopo);
    List<Spot> findAll();
    Spot create(Spot pSpot);
    Spot update(Spot pSpot);
    void delete(Spot pSpot);
}
