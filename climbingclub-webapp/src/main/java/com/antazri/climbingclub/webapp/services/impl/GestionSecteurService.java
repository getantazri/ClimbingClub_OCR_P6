package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.ISecteurBo;
import com.antazri.climbingclub.business.contract.ISpotBo;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.webapp.services.contract.IGestionSecteurService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionSecteurService implements IGestionSecteurService {

    @Autowired
    private ISecteurBo secteurBo;

    @Autowired
    private ISpotBo spotBo;

    public Secteur findSecteurById(int pId) {
        return secteurBo.findById(pId);
    }

    public List<Secteur> findSecteurBySpot(Spot pSpot) {
        return secteurBo.findBySpot(pSpot);
    }

    public Secteur findSecteurByName(String pName) {
        return secteurBo.findByName(pName);
    }

    public List<Secteur> findAllSecteur() {
        return secteurBo.findAll();
    }

    public int addSecteur(String pName, int pSpotId) {
        Secteur secteur = new Secteur();
        secteur.setSecteurNom(pName);
        secteur.setSpot(spotBo.findById(pSpotId));

        return secteurBo.create(secteur);
    }

    public int updateSecteur(int pSecteurId, String pName) {
        Secteur secteur = secteurBo.findById(pSecteurId);
        secteur.setSecteurNom(pName);

        return secteurBo.update(secteur);
    }

    public void deleteSecteur(int pSecteurId) {
        secteurBo.delete(secteurBo.findById(pSecteurId));
    }
}
