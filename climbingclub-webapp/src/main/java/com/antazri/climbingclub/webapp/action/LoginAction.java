package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.model.beans.*;
import com.antazri.climbingclub.webapp.services.contract.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginAction extends ActionSupport implements SessionAware {

    @Autowired
    private ICompteUtilisateurService compteUtilisateurService;

    @Autowired
    private IGestionTopoService gestionTopoService;

    @Autowired
    private IGestionSpotService gestionSpotService;

    @Autowired
    private IGestionSecteurService gestionSecteurService;

    @Autowired
    private IGestionVoieService gestionVoieService;

    @Autowired
    private IRegionBo regionBo;

    Logger logger = LogManager.getLogger();

    // =======================================================================
    // Attributs et paramètres de l'action
    // =======================================================================
    private int utilisateurId;
    private String pseudo = "";
    private String password = "";
    private Utilisateur utilisateur;
    private List<Utilisateur> utilisateurs;
    private Map<String, Object> session;
    private List<Topo> topos;
    private List<Spot> spots;
    private List<Secteur> secteurs;
    private List<Voie> voies;


    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
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

    public List<Topo> getTopos() {
        return topos;
    }

    public void setTopos(List<Topo> topos) {
        this.topos = topos;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public List<Voie> getVoies() {
        return voies;
    }

    public void setVoies(List<Voie> voies) {
        this.voies = voies;
    }

    // =======================================================================
    // Méthodes de l'action
    // =======================================================================
    public String doLogin() {
        clearErrorsAndMessages();
        String vResult = ActionSupport.INPUT;

        if (!getPseudo().isEmpty() && !getPassword().isEmpty()) {

            utilisateur = compteUtilisateurService.login(getPseudo(), getPassword());

            if (utilisateur.getUtilisateurId() < 0) {
                addActionError("Pseudo ou mot de passe incorrect");
                vResult = ActionSupport.ERROR;
            } else {
                this.session.put("user", utilisateur);

                if (utilisateur.getUtilisateurId() == 1) {
                    this.session.put("admin", utilisateur);
                }

                vResult = ActionSupport.SUCCESS;
            }
        }

        return vResult;
    }

    public String doLogout() {
        clearErrorsAndMessages();
        this.session.remove("user");
        this.session.remove("admin");

        return ActionSupport.SUCCESS;
    }

    public String doGetCompte() {
        clearErrorsAndMessages();
        try {
            utilisateur = (Utilisateur) session.get("user");
            topos = new ArrayList<>();
            spots = new ArrayList<>();
            secteurs = new ArrayList<>();
            voies = new ArrayList<>();

            topos = gestionTopoService.findTopoByUser(utilisateur);

            for(Topo topo : topos) {
                List<Spot> tmp = gestionSpotService.findSpotByTopo(topo);

                for(Spot spot : tmp) {
                    spots.add(spot);
                }
            }

            for(Spot spot : spots) {
                List<Secteur> tmp = gestionSecteurService.findSecteurBySpot(spot);

                for(Secteur secteur : tmp) {
                    secteurs.add(secteur);
                }
            }

            for(Secteur secteur : secteurs) {
                List<Voie> tmp = gestionVoieService.findVoieBySecteur(secteur);

                for(Voie voie : tmp) {
                    voies.add(voie);
                }
            }
        } catch(NullPointerException pE) {
            addActionError("Vous devez vous connecter pour accéder à votre compte");
            logger.error("Utilisateur recherché inexistant dans la base de données", pE);
            return ActionSupport.ERROR;
        }

        return ActionSupport.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
