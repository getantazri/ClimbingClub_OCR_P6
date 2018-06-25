package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;

import java.util.List;

public interface ISecteurDao {

    Secteur findById(int pId);
    List<Secteur> findBySpot(Spot pSpot);
    List<Secteur> findAll();
    int create(Secteur pSecteur);
    int update(Secteur pSecteur);
    void delete(Secteur pSecteur);
}
