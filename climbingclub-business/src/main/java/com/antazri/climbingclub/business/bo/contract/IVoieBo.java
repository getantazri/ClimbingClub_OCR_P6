package com.antazri.climbingclub.business.bo.contract;

import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;

import java.util.List;

public interface IVoieBo {

    Voie findById(int pId);
    List<Voie> findBySecteur(Secteur pSecteur);
    List<Voie> findByCotation(Cotation pCotation);
    List<Voie> findAll();
    int create(Voie pVoie);
    int update(Voie pVoie);
    void delete(Voie pVoie);
}
