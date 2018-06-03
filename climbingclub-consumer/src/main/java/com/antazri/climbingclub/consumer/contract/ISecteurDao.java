package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;

import java.util.List;

public interface ISecteurDao {

    public Secteur findById(int pId);
    public List<Secteur> findBySpot(Spot pSpot);
    public List<Secteur> findAll();
    public Secteur create(Secteur pSecteur);
    public Secteur update(Secteur pSecteur);
    public void delete(Secteur pSecteur);
}
