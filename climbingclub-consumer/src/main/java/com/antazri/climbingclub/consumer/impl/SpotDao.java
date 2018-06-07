package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ISpotDao;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpotDao extends AbstractDao implements ISpotDao {

    public Spot findById(int pId) {
        return null;
    }

    public List<Spot> findByTopo(Topo pTopo) {
        return null;
    }

    public List<Spot> findAll() {
        return null;
    }

    public Spot create(Spot pSpot) {
        return null;
    }

    public Spot update(Spot pSpot) {
        return null;
    }

    public void delete(Spot pSpot) {

    }
}
