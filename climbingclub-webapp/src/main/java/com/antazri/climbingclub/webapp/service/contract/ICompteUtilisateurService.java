package com.antazri.climbingclub.webapp.service.contract;

import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface ICompteUtilisateurService {

    Utilisateur findUtilisateurById(int pId);
    List<Utilisateur> findUtilisateurByStatut(String pName);
    Utilisateur findUtilisateurByName(String pName);
    Utilisateur findUtilisateurByPseudo(String pPseudo);
    List<Utilisateur> findAllUtilisateur();
    int addUtilisateur(String pNom, String pPrenom, String pPseudo, String pPassword, String pEmail, String pTelephone, int statutId);
    int updateUtilisateur(int pId, String pNom, String pPrenom, String pPseudo, String pPassword, String pEmail, String pTelephone, int statutId);
    void deleteUtilisateur(int pId);
}
