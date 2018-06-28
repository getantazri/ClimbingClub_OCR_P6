package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;

import java.util.List;

public interface IVoieDao {

    Voie findById(int pId);
    Voie findByName(String pName);
    List<Voie> findBySecteur(Secteur pSecteur);
    List<Voie> findByCotation(Cotation pCotation);
    List<Voie> findAll();
    List<Voie> containsName(String pName);
    int create(Voie pSpot);
    int update(Voie pSpot);
    void delete(Voie pSpot);
}
