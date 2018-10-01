package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class CompteUtilisateurAction extends ActionSupport {

    @Autowired
    ICompteUtilisateurService compteUtilisateurService;

    // =======================================================================
    // Attributs de l'action
    // =======================================================================
    private int utilisateurId;
    private String nom;
    private String prenom;
    private String pseudo;
    private String email;
    private String telephone;
    private String password;
    private String passwordConfirmed;
    private String oldPassword;
    private Utilisateur utilisateur;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

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

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
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

    public String doEditProfile() {

        if (utilisateurId > 0) {
            utilisateur = compteUtilisateurService.findUtilisateurById(utilisateurId);
        } else {
            return ActionSupport.ERROR;
        }

        return ActionSupport.INPUT;
    }

    public String doUpdateProfile() {
        String vResult = ActionSupport.INPUT;

        try {
            if (StringUtils.isAnyBlank(utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getPseudo(), utilisateur.getEmail(), utilisateur.getTelephone())) {
                addActionError("Il manque des informations requises");
                vResult = ActionSupport.INPUT;
            } else {
                int row = compteUtilisateurService.updateUtilisateur(utilisateurId, utilisateur.getNom(), utilisateur.getPrenom(),
                        utilisateur.getPseudo(), utilisateur.getEmail(), utilisateur.getTelephone(), utilisateur.getStatut().getStatutId());

                if (row > 0) {
                    utilisateur = compteUtilisateurService.findUtilisateurByPseudo(utilisateur.getPseudo());
                    vResult = ActionSupport.SUCCESS;
                } else {
                    addActionError("Le profil n'a pas pu être mis à jour");
                    vResult = ActionSupport.ERROR;
                }
            }
        } catch (Exception pE) {
            addActionError("Une erreur est survenue lors du chargement de votre profile");
            vResult = ActionSupport.ERROR;
        }

        return vResult;
    }

    public String doEditPassword() {

        if (utilisateurId > 0) {
            return ActionSupport.INPUT;
        } else {
            addActionError("Vous n'êtes pas connecté");
            return ActionSupport.ERROR;
        }
    }

    public String doUpdatePassword() {
        String vResult = ActionSupport.INPUT;
        utilisateur = compteUtilisateurService.findUtilisateurById(utilisateurId);

        try {
            int row = compteUtilisateurService.updatePassword(utilisateur.getUtilisateurId(), password, passwordConfirmed, oldPassword, utilisateur.getPassword());

            if (row > 0) {
                addActionMessage("Le mot de passe a été mis à jour");
                vResult = ActionSupport.SUCCESS;
            } else {
                addActionError("Le mot de passe n'a pas été mis à jour");
                vResult = ActionSupport.ERROR;
            }
        } catch (Exception pE) {
            addActionError("Le mot de passe n'a pas pu être changé");
            vResult = ActionSupport.ERROR;
        }

        return vResult;
    }

}
