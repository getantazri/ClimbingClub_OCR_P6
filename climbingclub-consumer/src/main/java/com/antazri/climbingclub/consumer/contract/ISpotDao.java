package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;

import java.util.List;

public interface ISpotDao {

    public Spot findById(int pId);
    public List<Spot> findBySpot(Topo pTopo);
    public List<Spot> findAll();
    public Spot create(Spot pSpot);
    public Spot update(Spot pSpot);
    public void delete(Spot pSpot);
}
