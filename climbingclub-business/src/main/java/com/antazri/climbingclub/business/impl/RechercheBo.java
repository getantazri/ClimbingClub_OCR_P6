package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.IRechercheBo;
import com.antazri.climbingclub.consumer.contract.IRechercheDao;
import com.antazri.climbingclub.model.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RechercheBo implements IRechercheBo {

    @Autowired
    private IRechercheDao rechercheDao;

    @Transactional
    public List<Topo> rechercherTopo(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax) {
        return rechercheDao.rechercherTopo(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
    }

    @Transactional
    public List<Spot> rechercherSpot(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax) {
        return rechercheDao.rechercherSpot(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
    }

    @Transactional
    public List<Secteur> rechercherSecteur(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax) {
        return rechercheDao.rechercherSecteur(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
    }

    @Transactional
    public List<Voie> rechercherVoie(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax) {
        return rechercheDao.rechercherVoie(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
    }

    @Transactional
    public List<Utilisateur> rechercherUtilisateur(String pPseudo) {
        return rechercheDao.rechercherUtilisateur(pPseudo);
    }
}
