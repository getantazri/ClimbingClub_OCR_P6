package com.antazri.climbingclub.webapp.service.contract;

import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;

import java.util.List;

public interface IGestionVoieService {

    Voie findVoieById(int pId);
    Voie findVoieByName(String pName);
    List<Voie> findVoieBySecteur(Secteur pSecteur);
    List<Voie> findVoieByCotation(Cotation pCotation);
    List<Voie> findAllVoie();
    int addVoie(String pName, int pNbrPoints, String pDescription, int pSecteurId, int pCotationId);
    int updateVoie(int pVoieId, String pName, int pNbrPoints, String pDescription, int pSecteurId, int pCotationId);
    void deleteVoie(int pVoieId);
}
