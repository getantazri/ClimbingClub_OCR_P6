package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CompteUtilisateurAction extends ActionSupport {

    @Autowired
    private ICompteUtilisateurService compteUtilisateurService;

    @Autowired
    private IGestionTopoService gestionTopoService;

    @Autowired
    private IRegionBo regionBo;

    // =======================================================================
    // Attributs et paramètres de l'action
    // =======================================================================
    private int utilisateurId;
    private String pseudo;
    private String nom;
    private String password;
    private Utilisateur utilisateur;
    private List<Utilisateur> utilisateurs;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // ======================================================================
    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    // =======================================================================
    // Méthodes de l'action
    // =======================================================================
    public String doLogin() {
        String vResult = ActionSupport.INPUT;

        utilisateur = compteUtilisateurService.login(pseudo, password);

        if (utilisateur.getUtilisateurId() < 0) {
            addActionError("Pseudo ou mot de passe incorrect");
            vResult = ActionSupport.ERROR;
        } else {

        }

        return vResult;
    }
}
