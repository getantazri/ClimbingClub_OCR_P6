package com.antazri.climbingclub.webapp.services.contract;

import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;

import java.util.List;

public interface IGestionSpotService {

    Spot findSpotById(int pId);
    Spot findSpotByName(String pName);
    List<Spot> findSpotByTopo(Topo pTopo);
    List<Spot> findAllSpot();
    int addSpot(String pName, String pDescription, int pHauteur, int pTopoId);
    int updateSpot(int pSpotId, String pName, String pDescription, int pHauteur);
    int deleteSpot(int pId);
    List<Secteur> hasSecteurs(Spot pSpot);
}
