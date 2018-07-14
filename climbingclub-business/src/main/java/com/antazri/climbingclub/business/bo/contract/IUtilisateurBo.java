package com.antazri.climbingclub.business.bo.contract;

import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface IUtilisateurBo {

    Utilisateur findById(int pId);
    List<Utilisateur> findByStatut(Statut pStatut);
    Utilisateur findByName(String pName);
    Utilisateur findByPseudo(String pPseudo);
    List<Utilisateur> findAll();
    int create(Utilisateur pUtilisateur);
    int update(Utilisateur pUtilisateur);
    void delete(Utilisateur pUtilisateur);
}
