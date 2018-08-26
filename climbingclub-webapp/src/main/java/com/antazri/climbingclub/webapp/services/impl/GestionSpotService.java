package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.ISecteurBo;
import com.antazri.climbingclub.business.contract.ISpotBo;
import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.webapp.services.contract.IGestionSpotService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionSpotService implements IGestionSpotService {

    @Autowired
    private ISpotBo spotBo;

    @Autowired
    private ITopoBo topoBo;

    @Autowired
    private ISecteurBo secteurBo;

    public Spot findSpotById(int pId) {
        return spotBo.findById(pId);
    }

    public Spot findSpotByName(String pName) {
        return spotBo.findByName(pName);
    }

    public List<Spot> findSpotByTopo(Topo pTopo) {
        List<Spot> spots = spotBo.findByTopo(pTopo);

        for(Spot spot : spots) {
            spot.setTopo(topoBo.findById(spot.getTopo().getTopoId()));
        }

        return spots;
    }

    public List<Spot> findAllSpot() {
        List<Spot> spots = spotBo.findAll();

        for(Spot spot : spots) {
            spot.setTopo(topoBo.findById(spot.getTopo().getTopoId()));
        }

        return spots;
    }

    public int addSpot(String pName, String pDescription, int pHauteur, int pTopoId) {
        Spot spot = new Spot();
        spot.setSpotNom(pName);
        spot.setSpotDescription(pDescription);
        spot.setHauteur(pHauteur);
        spot.setTopo(topoBo.findById(pTopoId));

        return spotBo.create(spot);
    }

    public int updateSpot(int pSpotId, String pName, String pDescription, int pHauteur) {
        Spot spot = spotBo.findById(pSpotId);
        spot.setSpotNom(pName);
        spot.setSpotDescription(pDescription);
        spot.setHauteur(pHauteur);

        return spotBo.update(spot);
    }

    public int deleteSpot(int pId) {

        spotBo.delete(spotBo.findById(pId));
        return 1;
    }

    @Override
    public List<Secteur> hasSecteurs(Spot pSpot) {

        return secteurBo.findBySpot(pSpot);
    }
}
