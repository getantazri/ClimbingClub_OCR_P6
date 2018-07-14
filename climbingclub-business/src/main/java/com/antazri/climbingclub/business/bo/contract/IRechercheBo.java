package com.antazri.climbingclub.business.bo.contract;

import com.antazri.climbingclub.model.beans.*;

import java.util.List;

public interface IRechercheBo {

    List<Topo> rechercherTopo(String pNom, String pNomRegion);
    List<Spot> rechercherSpot(String pNom);
    List<Secteur> rechercherSecteur(String pNom);
    List<Voie> rechercherVoie(String pNom, String pNomCotation);
    List<Utilisateur> rechercherUtilisateur(String pPseudo);
}
