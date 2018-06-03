package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;

import java.util.List;

public interface IVoieDao {

    public Voie findById(int pId);
    public List<Voie> findBySecteur(Secteur pSecteur);
    public List<Voie> findByCotation(Cotation pCotation);
    public List<Voie> findAll();
    public Voie create(Voie pSpot);
    public Voie update(Voie pSpot);
    public void delete(Voie pSpot);
}
