package com.antazri.climbingclub.webapp.services.contract;

import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface ICompteUtilisateurService {

    Utilisateur findUtilisateurById(int pId);
    List<Utilisateur> findUtilisateurByStatut(String pName);
    Utilisateur findUtilisateurByName(String pName);
    Utilisateur findUtilisateurByPseudo(String pPseudo);
    List<Utilisateur> findAllUtilisateur();
    int addUtilisateur(String pNom, String pPrenom, String pPseudo, String pPassword, String pEmail, String pTelephone, int statutId);
    int updateUtilisateur(int pId, String pNom, String pPrenom, String pPseudo, String pEmail, String pTelephone, int statutId);
    void deleteUtilisateur(int pId);
    Utilisateur login(String pPseudo, String pPassword);
    boolean updateStatut(int pUtilisateurId, int pStatutId);
    String hashPassword(String pPlainPassword);
    boolean verifyPassword(String pPlainPassword, String pHashedPassword);
}
