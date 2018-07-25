package com.antazri.climbingclub.webapp.service.impl;

import com.antazri.climbingclub.business.contract.ICotationBo;
import com.antazri.climbingclub.business.contract.ISecteurBo;
import com.antazri.climbingclub.business.contract.IVoieBo;
import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;
import com.antazri.climbingclub.webapp.service.contract.IGestionVoieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionVoieService implements IGestionVoieService {

    @Autowired
    private IVoieBo voieBo;

    @Autowired
    private ISecteurBo secteurBo;

    @Autowired
    private ICotationBo cotationBo;

    public Voie findVoieById(int pId) {
        return voieBo.findById(pId);
    }

    public Voie findVoieByName(String pName) {
        return voieBo.findByName(pName);
    }

    public List<Voie> findVoieBySecteur(Secteur pSecteur) {
        return voieBo.findBySecteur(pSecteur);
    }

    public List<Voie> findVoieByCotation(Cotation pCotation) {
        return voieBo.findByCotation(pCotation);
    }

    public List<Voie> findAllVoie() {
        return voieBo.findAll();
    }

    public int addVoie(String pName, int pNbrPoints, String pDescription, int pSecteurId, int pCotationId) {
        Voie voie = new Voie();
        voie.setVoieNom(pName);
        voie.setNombrePoints(pNbrPoints);
        voie.setVoieDescription(pDescription);
        voie.setSecteur(secteurBo.findById(pSecteurId));
        voie.setCotation(cotationBo.findById(pCotationId));

        return voieBo.create(voie);
    }

    public int updateVoie(int pVoieId, String pName, int pNbrPoints, String pDescription, int pSecteurId, int pCotationId) {
        Voie voie = voieBo.findById(pVoieId);
        voie.setVoieNom(pName);
        voie.setNombrePoints(pNbrPoints);
        voie.setVoieDescription(pDescription);
        voie.setSecteur(secteurBo.findById(pSecteurId));
        voie.setCotation(cotationBo.findById(pCotationId));

        return voieBo.update(voie);
    }

    public void deleteVoie(int pVoieId) {
        voieBo.delete(voieBo.findById(pVoieId));
    }
}
