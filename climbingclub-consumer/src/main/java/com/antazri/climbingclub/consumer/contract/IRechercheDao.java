package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.*;

import java.util.List;

public interface IRechercheDao {

    List<Topo> rechercherTopo(String pNom, String pNomRegion);
    List<Spot> rechercherSpot(String pNom);
    List<Secteur> rechercherSecteur(String pNom);
    List<Voie> rechercherVoie(String pNom, String pNomCotation);
    List<Utilisateur> rechercherUtilisateur(String pPseudo);

}
