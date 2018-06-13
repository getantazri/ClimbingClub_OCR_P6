package com.antazri.climbingclub.business.bo.contract;

import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface IUtilisateurBo {

    Utilisateur findById(int pId);
    List<Utilisateur> findByStatut(Statut pStatut);
    List<Utilisateur> findByName(String pName);
    List<Utilisateur> findAll();
    Utilisateur create(Utilisateur pTopUtilisateurpo);
    Utilisateur update(Utilisateur pUtilisateur);
    void delete(Utilisateur pUtilisateur);
}
