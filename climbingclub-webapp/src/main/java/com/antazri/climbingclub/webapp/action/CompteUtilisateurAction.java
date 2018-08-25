package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class CompteUtilisateurAction extends ActionSupport {

    @Autowired
    ICompteUtilisateurService compteUtilisateurService;

    // =======================================================================
    // Attributs de l'action
    // =======================================================================
    private String nom;
    private String prenom;
    private String pseudo;
    private String email;
    private String telephone;
    private String password;
    private String passwordConfirmed;
    private Utilisateur utilisateur;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmed() {
        return passwordConfirmed;
    }

    public void setPasswordConfirmed(String passwordConfirmed) {
        this.passwordConfirmed = passwordConfirmed;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    // =======================================================================
    // Méthodes de l'action
    // =======================================================================
    public String doGetInscription() {
        return ActionSupport.SUCCESS;
    }

    public String doInscription() {
        String vResult;

        int row = compteUtilisateurService.addUtilisateur(nom, prenom, pseudo, password, email, telephone, 2);

        if (row < 0) {
            vResult = ActionSupport.ERROR;
            addActionError("Erreur : l'inscription n'a pas été enregistrée");
        } else {
            if (!password.equals(passwordConfirmed)) {
                vResult = ActionSupport.ERROR;
                addActionError("Erreur : les mots de passe ne sont pas similaires");
            } else {
                vResult = ActionSupport.SUCCESS;
                addActionMessage("Inscription validée : bienvenue !");
            }
        }

        return vResult;
    }

}
