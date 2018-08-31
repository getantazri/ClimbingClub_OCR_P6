package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.ISecteurBo;
import com.antazri.climbingclub.business.contract.ISpotBo;
import com.antazri.climbingclub.business.contract.IVoieBo;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Voie;
import com.antazri.climbingclub.webapp.services.contract.IGestionSecteurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionSpotService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionSecteurService implements IGestionSecteurService {

    @Autowired
    private ISecteurBo secteurBo;

    @Autowired
    private IVoieBo voieBo;

    @Autowired
    private IGestionSpotService gestionSpotService;

    public Secteur findSecteurById(int pId) {
        Secteur secteur = secteurBo.findById(pId);
        secteur.setSpot(gestionSpotService.findSpotById(secteur.getSpot().getSpotId()));

        return secteur;
    }

    public List<Secteur> findSecteurBySpot(Spot pSpot) {
        List<Secteur> secteurs = secteurBo.findBySpot(pSpot);

        for(Secteur secteur : secteurs) {
            secteur.setSpot(gestionSpotService.findSpotById(secteur.getSpot().getSpotId()));
        }

        return secteurs;
    }

    public Secteur findSecteurByName(String pName) {
        Secteur secteur = secteurBo.findByName(pName);
        secteur.setSpot(gestionSpotService.findSpotById(secteur.getSpot().getSpotId()));

        return secteur;
    }

    public List<Secteur> findAllSecteur() {
        List<Secteur> secteurs = secteurBo.findAll();

        for(Secteur secteur : secteurs) {
            secteur.setSpot(gestionSpotService.findSpotById(secteur.getSpot().getSpotId()));
        }

        return secteurs;
    }

    public int addSecteur(String pName, int pSpotId) {
        Secteur secteur = new Secteur();
        secteur.setSecteurNom(pName);
        secteur.setSpot(gestionSpotService.findSpotById(pSpotId));

        return secteurBo.create(secteur);
    }

    public int updateSecteur(int pSecteurId, String pName) {
        Secteur secteur = secteurBo.findById(pSecteurId);
        secteur.setSecteurNom(pName);

        return secteurBo.update(secteur);
    }

    public int deleteSecteur(int pSecteurId) {
        List<Voie> voies = hasVoies(secteurBo.findById(pSecteurId));

        if (voies.isEmpty()) {
            secteurBo.delete(secteurBo.findById(pSecteurId));
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<Voie> hasVoies(Secteur pSecteur) {

        return voieBo.findBySecteur(pSecteur);
    }
}
