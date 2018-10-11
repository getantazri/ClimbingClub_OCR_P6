package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class CompteUtilisateurAction extends ActionSupport {

    @Autowired
    ICompteUtilisateurService compteUtilisateurService;

    Logger logger = LogManager.getLogger();

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
        clearErrorsAndMessages();
        return ActionSupport.SUCCESS;
    }

    public String doInscription() {
        clearErrorsAndMessages();

        if (!StringUtils.isAnyBlank(nom, prenom, pseudo, password, passwordConfirmed, email, telephone)) {
            if (!password.equals(passwordConfirmed)) {
                addActionError("Erreur : les mots de passe ne sont pas similaires");
                return ActionSupport.ERROR;
            } else {
                try {
                    int row = compteUtilisateurService.addUtilisateur(nom, prenom, pseudo, password, email, telephone, 2);

                    if (row < 0) {
                        addActionError("Erreur : l'inscription n'a pas été enregistrée");
                        return ActionSupport.ERROR;
                    } else {
                        addActionMessage("Inscription validée : bienvenue !");
                        return ActionSupport.SUCCESS;
                    }
                } catch (Exception pE) {
                    addActionError("Erreur dans vos informations pour l'inscription");
                    logger.error("Informations renseignées pour la création du profil invalides", pE);
                    return ActionSupport.ERROR;
                }
            }
        }

        addActionError("Il manque des informations pour votre inscription");
        return ActionSupport.ERROR;
    }

    public String doEditProfile() {
        clearErrorsAndMessages();

        if (utilisateurId > 0) {
            utilisateur = compteUtilisateurService.findUtilisateurById(utilisateurId);
        } else {
            return ActionSupport.ERROR;
        }

        return ActionSupport.INPUT;
    }

    public String doUpdateProfile() {
        clearErrorsAndMessages();
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
            logger.error("Informations renseignées pour la mise à jour du profil invalides", pE);
            vResult = ActionSupport.ERROR;
        }

        return vResult;
    }

    public String doEditPassword() {
        clearErrorsAndMessages();

        if (utilisateurId > 0) {
            return ActionSupport.INPUT;
        } else {
            addActionError("Vous n'êtes pas connecté");
            return ActionSupport.ERROR;
        }
    }

    public String doUpdatePassword() {
        clearErrorsAndMessages();
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
            logger.error("Les mots de passe à modifier sont différents ou invalides", pE);
            vResult = ActionSupport.ERROR;
        }

        return vResult;
    }

}
