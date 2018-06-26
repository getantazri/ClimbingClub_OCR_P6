package com.antazri.climbingclub.business.bo.contract;

import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;

import java.util.List;

public interface ISecteurBo {

    Secteur findById(int pId);
    List<Secteur> findBySpot(Spot pSpot);
    Secteur findByName(String pName);
    List<Secteur> findAll();
    int create(Secteur pSecteur);
    int update(Secteur pSecteur);
    void delete(Secteur pSecteur);
}
