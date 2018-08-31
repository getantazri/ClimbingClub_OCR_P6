package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.ICotationBo;
import com.antazri.climbingclub.business.contract.IVoieBo;
import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;
import com.antazri.climbingclub.webapp.services.contract.IGestionSecteurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionVoieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionVoieService implements IGestionVoieService {

    @Autowired
    private IVoieBo voieBo;

    @Autowired
    private ICotationBo cotationBo;

    @Autowired
    private IGestionSecteurService gestionSecteurService;

    public Voie findVoieById(int pId) {
        Voie voie = voieBo.findById(pId);
        voie.setSecteur(gestionSecteurService.findSecteurById(voie.getSecteur().getSecteurId()));
        voie.setCotation(cotationBo.findById(voie.getCotation().getCotationId()));

        return voie;
    }

    public Voie findVoieByName(String pName) {
        Voie voie = voieBo.findByName(pName);
        voie.setSecteur(gestionSecteurService.findSecteurById(voie.getSecteur().getSecteurId()));
        voie.setCotation(cotationBo.findById(voie.getCotation().getCotationId()));

        return voie;
    }

    public List<Voie> findVoieBySecteur(Secteur pSecteur) {

        List<Voie> voies = voieBo.findBySecteur(pSecteur);

        for(Voie voie : voies) {
            voie.setSecteur(gestionSecteurService.findSecteurById(pSecteur.getSecteurId()));
            voie.setCotation(cotationBo.findById(voie.getCotation().getCotationId()));
        }

        return voies;
    }

    public List<Voie> findVoieByCotation(Cotation pCotation) {

        List<Voie> voies = voieBo.findAll();

        for(Voie voie : voies) {
            voie.setSecteur(gestionSecteurService.findSecteurById(voie.getSecteur().getSecteurId()));
            voie.setCotation(cotationBo.findById(pCotation.getCotationId()));
        }

        return voies;
    }

    public List<Voie> findAllVoie() {
        List<Voie> voies = voieBo.findAll();

        for(Voie voie : voies) {
            voie.setSecteur(gestionSecteurService.findSecteurById(voie.getSecteur().getSecteurId()));
            voie.setCotation(cotationBo.findById(voie.getCotation().getCotationId()));
        }

        return voies;
    }

    public int addVoie(String pName, int pNbrPoints, String pDescription, int pSecteurId, int pCotationId) {
        Voie voie = new Voie();
        voie.setVoieNom(pName);
        voie.setNombrePoints(pNbrPoints);
        voie.setVoieDescription(pDescription);
        voie.setSecteur(gestionSecteurService.findSecteurById(pSecteurId));
        voie.setCotation(cotationBo.findById(pCotationId));

        return voieBo.create(voie);
    }

    public int updateVoie(int pVoieId, String pName, int pNbrPoints, String pDescription, int pSecteurId, int pCotationId) {
        Voie voie = voieBo.findById(pVoieId);
        voie.setVoieNom(pName);
        voie.setNombrePoints(pNbrPoints);
        voie.setVoieDescription(pDescription);
        voie.setSecteur(gestionSecteurService.findSecteurById(pSecteurId));
        voie.setCotation(cotationBo.findById(pCotationId));

        return voieBo.update(voie);
    }

    public int deleteVoie(int pVoieId) {
        try {
            voieBo.delete(voieBo.findById(pVoieId));
            return 1;
        } catch (Exception pE) {
            pE.printStackTrace();
            return 0;
        }
    }
}
