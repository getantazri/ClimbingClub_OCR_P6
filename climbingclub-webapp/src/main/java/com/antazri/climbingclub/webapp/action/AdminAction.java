package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.IStatutBo;
import com.antazri.climbingclub.model.beans.*;
import com.antazri.climbingclub.webapp.services.contract.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminAction extends ActionSupport {

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
    private ICommenterService commenterService;

    @Autowired
    private IReservationService reservationService;

    @Autowired
    private IStatutBo statutBo;

    Logger logger = LogManager.getLogger();

    // =======================================================================
    // Attributs de l'action
    // =======================================================================
    private int utilisateurId;
    private Utilisateur utilisateur;
    private List<Utilisateur> utilisateurs;
    private int topoId;
    private Topo topo;
    private List<Topo> topos;
    private int spotId;
    private Spot spot;
    private List<Spot> spots;
    private int secteurId;
    private Secteur secteur;
    private List<Secteur> secteurs;
    private int voieId;
    private Voie voie;
    private List<Voie> voies;
    private int commentaireId;
    private Commentaire commentaire;
    private List<Commentaire> commentaires;
    private List<Commentaire> commentairesByTopo;
    private List<Commentaire> commentairesBySpot;
    private int empruntId;
    private Emprunt emprunt;
    private List<Emprunt> emprunts;
    private List<Statut> statuts;
    private String password;
    private String passwordConfirmed;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
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

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public List<Topo> getTopos() {
        return topos;
    }

    public void setTopos(List<Topo> topos) {
        this.topos = topos;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public int getSecteurId() {
        return secteurId;
    }

    public void setSecteurId(int secteurId) {
        this.secteurId = secteurId;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public int getVoieId() {
        return voieId;
    }

    public void setVoieId(int voieId) {
        this.voieId = voieId;
    }

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    public List<Voie> getVoies() {
        return voies;
    }

    public void setVoies(List<Voie> voies) {
        this.voies = voies;
    }

    public int getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(int commentaireId) {
        this.commentaireId = commentaireId;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public List<Commentaire> getCommentairesByTopo() {
        return commentairesByTopo;
    }

    public void setCommentairesByTopo(List<Commentaire> commentairesByTopo) {
        this.commentairesByTopo = commentairesByTopo;
    }

    public List<Commentaire> getCommentairesBySpot() {
        return commentairesBySpot;
    }

    public void setCommentairesBySpot(List<Commentaire> commentairesBySpot) {
        this.commentairesBySpot = commentairesBySpot;
    }

    public int getEmpruntId() {
        return empruntId;
    }

    public void setEmpruntId(int empruntId) {
        this.empruntId = empruntId;
    }

    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public List<Emprunt> getEmprunts() {
        return emprunts;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public List<Statut> getStatuts() {
        return statuts;
    }

    public void setStatuts(List<Statut> statuts) {
        this.statuts = statuts;
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

    // =======================================================================
    // Méthodes de l'action
    // =======================================================================
    public String doListTopos() {
        topos = gestionTopoService.findAllTopo();
        return ActionSupport.SUCCESS;
    }

    public String doListSpots() {
        spots = gestionSpotService.findAllSpot();
        return ActionSupport.SUCCESS;
    }

    public String doListSecteurs() {
        secteurs = gestionSecteurService.findAllSecteur();
        return ActionSupport.SUCCESS;
    }

    public String doListVoies() {
        voies = gestionVoieService.findAllVoie();
        return ActionSupport.SUCCESS;
    }

    public String doListCommentaires() {
        commentairesByTopo = commenterService.findAllCommentaireByTopo();
        commentairesBySpot = commenterService.findAllCommentaireBySpot();
        return ActionSupport.SUCCESS;
    }

    public String doListReservations() {
        emprunts = reservationService.findAllReservations();
        return ActionSupport.SUCCESS;
    }

    public String doListUtilisateurs() {
        utilisateurs = compteUtilisateurService.findAllUtilisateur();
        return ActionSupport.SUCCESS;
    }

    public String doAddUtilisateur() {
        clearErrorsAndMessages();
        statuts = statutBo.findAll();

        if (utilisateur != null) {
            try {
                int row = compteUtilisateurService.addUtilisateur(utilisateur.getNom(), utilisateur.getPrenom(),
                        utilisateur.getPseudo(), password, utilisateur.getEmail(), utilisateur.getTelephone(), utilisateur.getStatut().getStatutId());

                if (row < 0) {
                    addActionError("Erreur : dans l'ajout de l'utilisateur");
                    logger.warn("Erreur dans la requête SQL INSERT INTO (table 'utilisateur')");
                    return ActionSupport.ERROR;
                } else {
                    if (!password.equals(passwordConfirmed)) {
                        addActionError("Erreur : les mots de passe ne sont pas similaires");
                        logger.error("Erreur utilisateur dans les attributs 'password' et 'passwordConfirmed'");
                        return ActionSupport.ERROR;
                    } else {
                        addActionMessage("Nouvel utilisateur ajouté !");
                        return ActionSupport.SUCCESS;
                    }
                }
            } catch (Exception pE) {
                addActionError("Erreur dans les informations de l'utilisateur");
                logger.warn("Informations saisies non complètes ou éronnées par rapport aux attendus de la base de données", pE);
                return ActionSupport.ERROR;
            }
        }

        return ActionSupport.INPUT;
    }

    public String doGetUtilisateurToUpdate() {
        clearErrorsAndMessages();
        statuts = statutBo.findAll();

        if (utilisateurId > 0) {
            utilisateur = compteUtilisateurService.findUtilisateurById(utilisateurId);
        } else {
            logger.warn("Utilisateur introuvable (utilisateurId inexistant");
            return ActionSupport.ERROR;
        }

        return ActionSupport.SUCCESS;
    }

    public String doUpdateUtilisateur() {
        clearErrorsAndMessages();
        String vResult = ActionSupport.INPUT;
        statuts = statutBo.findAll();

        try {
            if (StringUtils.isAnyBlank(utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getPseudo(), utilisateur.getEmail(), utilisateur.getTelephone())) {
                addActionError("Il manque des informations requises");
                vResult = ActionSupport.INPUT;
            } else {
                int row = compteUtilisateurService.updateUtilisateur(utilisateurId, utilisateur.getNom(), utilisateur.getPrenom(),
                        utilisateur.getPseudo(), utilisateur.getEmail(), utilisateur.getTelephone(), utilisateur.getStatut().getStatutId());

                if (row > 0) {
                    utilisateur = compteUtilisateurService.findUtilisateurByPseudo(utilisateur.getPseudo());
                    addActionMessage("Profil mis à jour");
                    vResult = ActionSupport.SUCCESS;
                } else {
                    addActionError("Le profil n'a pas pu être mis à jour");
                    logger.warn("Erreur dans la requête SQL UPDATE (table 'utilisateur')");
                    vResult = ActionSupport.ERROR;
                }
            }
        } catch (Exception pE) {
            addActionError("Une erreur est survenue lors du chargement de votre profile");
            logger.error("le profil n'a pas été mis à jour : informations manquantes ou éronnées dans le formulaire", pE);
            vResult = ActionSupport.ERROR;
        }

        return vResult;
    }

    public String doDeleteUtilisateur() {
        clearErrorsAndMessages();
        if (utilisateurId > 0) {
            try {
                compteUtilisateurService.deleteUtilisateur(utilisateurId);
                return ActionSupport.SUCCESS;
            } catch (Exception pE) {
                addActionError("Le compte est introuvable ou a déjà été supprimé");
                logger.error("Utilisateur introuvable dans la base de données", pE);
                return ActionSupport.ERROR;
            }
        }

        return ActionSupport.ERROR;
    }
}
