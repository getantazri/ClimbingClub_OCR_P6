package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;

import java.util.List;

public interface ISecteurDao {

    Secteur findById(int pId);
    List<Secteur> findBySpot(Spot pSpot);
    List<Secteur> findAll();
    Secteur create(Secteur pSecteur);
    Secteur update(Secteur pSecteur);
    void delete(Secteur pSecteur);
}
