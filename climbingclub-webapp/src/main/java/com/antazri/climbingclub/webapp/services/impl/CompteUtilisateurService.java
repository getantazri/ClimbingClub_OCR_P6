package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.IStatutBo;
import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
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

    public List<Utilisateur> findAllUtilisateur() {
        return utilisateurBo.findAll();
    }

    public int addUtilisateur(String pNom, String pPrenom, String pPseudo, String pPassword, String pEmail, String pTelephone, int statutId) {
        Utilisateur utilisateur = new Utilisateur();

        if (StringUtils.isNoneBlank(pNom, pPrenom, pPseudo, pPassword, pEmail, pTelephone)) {
            if (pPseudo.replace(" ", "").length() < 3) {
                return -1;
            } else {
                utilisateur.setNom(pNom);
                utilisateur.setPrenom(pPrenom);
                utilisateur.setPseudo(pPseudo);
                utilisateur.setPassword(hashPassword(pPassword));
                utilisateur.setEmail(pEmail);
                utilisateur.setTelephone(pTelephone);
                utilisateur.setStatut(statutBo.findById(statutId));

                return utilisateurBo.create(utilisateur);
            }
        } else {
            return -1;
        }
    }

    public int updateUtilisateur(int pId, String pNom, String pPrenom, String pPseudo, String pEmail, String pTelephone, int statutId) {
        Utilisateur utilisateur = utilisateurBo.findById(pId);

        utilisateur.setNom(pNom);
        utilisateur.setPrenom(pPrenom);
        utilisateur.setPseudo(pPseudo);
        utilisateur.setEmail(pEmail);
        utilisateur.setTelephone(pTelephone);
        utilisateur.setStatut(statutBo.findById(statutId));

        return utilisateurBo.update(utilisateur);
    }

    public void deleteUtilisateur(int pId) {
        utilisateurBo.delete(utilisateurBo.findById(pId));
    }

    @Override
    public Utilisateur login(String pPseudo, String pPassword) {
        Utilisateur vUtilisateur = new Utilisateur();

        if (!StringUtils.isAllEmpty(pPseudo, pPassword)) {
            vUtilisateur = utilisateurBo.findByPseudo(pPseudo);

            if (verifyPassword(pPassword, vUtilisateur.getPassword()) > 0) {
                return vUtilisateur;
            }
        }

        vUtilisateur.setUtilisateurId(-1);
        return vUtilisateur;

    }

    @Override
    public int updateStatut(int pUtilisateurId, int pStatutId) {
        Utilisateur vUtilsateur = findUtilisateurById(pUtilisateurId);

        if (vUtilsateur != null) {
            vUtilsateur.setStatut(statutBo.findById(pStatutId));
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String hashPassword(String pPlainPassword) {
        return BCrypt.hashpw(pPlainPassword, BCrypt.gensalt());
    }

    @Override
    public int verifyPassword(String pPlainPassword, String pHashedPassword) {
        if (BCrypt.checkpw(pPlainPassword, pHashedPassword)) {
            return 1;
        } else
            return 0;
    }
}
