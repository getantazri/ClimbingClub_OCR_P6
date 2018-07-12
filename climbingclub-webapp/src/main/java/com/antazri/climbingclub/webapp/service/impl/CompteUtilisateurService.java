package com.antazri.climbingclub.webapp.service.impl;

import com.antazri.climbingclub.business.bo.contract.IStatutBo;
import com.antazri.climbingclub.business.bo.contract.IUtilisateurBo;
import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.service.contract.ICompteUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompteUtilisateurService implements ICompteUtilisateurService {

    @Autowired
    private IUtilisateurBo utilisateurBo;

    @Autowired
    private IStatutBo statutBo;

    public Utilisateur findUtilisateurById(int pId) {
        return utilisateurBo.findById(pId);
    }

    public List<Utilisateur> findUtilisateurByStatut(String pName) {
        return utilisateurBo.findByStatut(statutBo.findByName(pName));
    }

    public Utilisateur findUtilisateurByName(String pName) {
        return utilisateurBo.findByName(pName);
    }

    public Utilisateur findUtilisateurByPseudo(String pPseudo) {
        return utilisateurBo.findByPseudo(pPseudo);
    }

    public List<Utilisateur> containsName(String pName) {
        return utilisateurBo.containsName(pName);
    }

    public List<Utilisateur> containsPseudo(String pPseudo) {
        return utilisateurBo.containsPseudo(pPseudo);
    }

    public List<Utilisateur> findAllUtilisateur() {
        return utilisateurBo.findAll();
    }

    public int addUtilisateur(String pNom, String pPrenom, String pPseudo, String pPassword, String pEmail, String pTelephone, int statutId) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(pNom);
        utilisateur.setPrenom(pPrenom);
        utilisateur.setPseudo(pPseudo);
        utilisateur.setPassword(pPassword);
        utilisateur.setEmail(pEmail);
        utilisateur.setTelephone(pTelephone);
        utilisateur.setStatut(statutBo.findById(statutId));

        return utilisateurBo.create(utilisateur);
    }

    public int updateUtilisateur(int pId, String pNom, String pPrenom, String pPseudo, String pPassword, String pEmail, String pTelephone, int statutId) {
        Utilisateur utilisateur = utilisateurBo.findById(pId);

        utilisateur.setNom(pNom);
        utilisateur.setPrenom(pPrenom);
        utilisateur.setPseudo(pPseudo);
        utilisateur.setPassword(pPassword);
        utilisateur.setEmail(pEmail);
        utilisateur.setTelephone(pTelephone);
        utilisateur.setStatut(statutBo.findById(statutId));

        return utilisateurBo.create(utilisateur);
    }

    public void deleteUtilisateur(int pId) {
        utilisateurBo.delete(utilisateurBo.findById(pId));
    }
}
