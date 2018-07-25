package com.antazri.climbingclub.business.contract;

import com.antazri.climbingclub.model.beans.*;

import java.util.List;

public interface IRechercheBo {

    List<Topo> rechercherTopo(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax);
    List<Spot> rechercherSpot(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax);
    List<Secteur> rechercherSecteur(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax);
    List<Voie> rechercherVoie(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax);
    List<Utilisateur> rechercherUtilisateur(String pPseudo);
}
