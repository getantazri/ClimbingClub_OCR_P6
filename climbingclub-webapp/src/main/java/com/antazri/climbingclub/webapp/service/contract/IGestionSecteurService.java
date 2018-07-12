package com.antazri.climbingclub.webapp.service.contract;

import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;

import java.util.List;

public interface IGestionSecteurService {

    Secteur findSecteurById(int pId);
    List<Secteur> findSecteurBySpot(Spot pSpot);
    Secteur findSecteurByName(String pName);
    List<Secteur> findAllSecteur();
    int addSecteur(String pName, int pSpotId);
    int updateSecteur(int pSecteurId, String pName);
    void deleteSecteur(int pSecteurId);

}
