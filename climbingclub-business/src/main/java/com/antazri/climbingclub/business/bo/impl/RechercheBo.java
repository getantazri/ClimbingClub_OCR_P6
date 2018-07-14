package com.antazri.climbingclub.business.bo.impl;

import com.antazri.climbingclub.business.bo.contract.IRechercheBo;
import com.antazri.climbingclub.consumer.contract.IRechercheDao;
import com.antazri.climbingclub.model.beans.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RechercheBo implements IRechercheBo {

    @Autowired
    private IRechercheDao rechercheDao;

    public List<Topo> rechercherTopo(String pNom, String pNomRegion) {
        return rechercheDao.rechercherTopo(pNom, pNomRegion);
    }

    public List<Spot> rechercherSpot(String pNom) {
        return rechercheDao.rechercherSpot(pNom);
    }

    public List<Secteur> rechercherSecteur(String pNom) {
        return rechercheDao.rechercherSecteur(pNom);
    }

    public List<Voie> rechercherVoie(String pNom, String pNomCotation) {
        return rechercheDao.rechercherVoie(pNom, pNomCotation);
    }

    public List<Utilisateur> rechercherUtilisateur(String pPseudo) {
        return rechercheDao.rechercherUtilisateur(pPseudo);
    }
}
