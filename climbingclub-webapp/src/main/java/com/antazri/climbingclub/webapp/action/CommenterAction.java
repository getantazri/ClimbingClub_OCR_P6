package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICommenterService;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionSpotService;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class CommenterAction extends ActionSupport {

    @Autowired
    private ICommenterService commenterService;

    @Autowired
    private IGestionSpotService gestionSpotService;

    @Autowired
    private IGestionTopoService gestionTopoService;

    @Autowired
    private ICompteUtilisateurService compteUtilisateurService;

    // =======================================================================
    // Attributs de l'action
    // =======================================================================
    private int commentaireId;
    private int spotId;
    private int topoId;
    private int utilisateurId;
    private Commentaire commentaire;
    private Spot spot;
    private Topo topo;
    private Utilisateur utilisateur;
    private List<Commentaire> commentaires;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public int getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(int commentaireId) {
        this.commentaireId = commentaireId;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public Commentaire getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(Commentaire commentaire) {
        this.commentaire = commentaire;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    // =======================================================================
    // Méthodes / Actions
    // =======================================================================
    public String doPostSpotCommentaire() {
        return doPublishCommentaire(commenterService.publishCommentaire(utilisateur.getUtilisateurId(), commentaire.getContenu(), spotId, 0, LocalDateTime.now()));
    }

    public String doPostTopoCommentaire() {
        return doPublishCommentaire(commenterService.publishCommentaire(utilisateur.getUtilisateurId(), commentaire.getContenu(), 0, topoId, LocalDateTime.now()));
    }

    public String doGetCommentaireToEdit() {

        if (commentaireId > 0) {
            commentaire = commenterService.findCommentaireById(commentaireId);
        } else {
            addActionError("Spot introuvable");
            return ActionSupport.ERROR;
        }

        return ActionSupport.INPUT;
    }

    public String doEditSpotCommentaire() {
        return doEditCommentaire(commenterService.editCommentaire(commentaire.getCommentaireId(), commentaire.getContenu()));
    }

    public String doEditTopoCommentaire() {
        return doEditCommentaire(commenterService.editCommentaire(commentaire.getCommentaireId(), commentaire.getContenu()));
    }

    public String doDeleteCommentaire() {
        int delete;

        if (commentaireId > 0) {
            delete = commenterService.deleteCommentaire(commentaireId);

            if (delete > 0) {
                this.addActionMessage("Commentaire supprimé");
                return ActionSupport.SUCCESS;
            } else {
                this.addActionError("Le commentaire n'existe pas ou a déjà été supprimé");
                return Action.ERROR;
            }
        } else {
            this.addActionError("Le commentaire n'existe pas ou a déjà été supprimé");
            return Action.ERROR;
        }
    }

    private String doPublishCommentaire(int pRequest) {

        if (commentaire != null) {
            try {
                if (commentaire.getContenu().replace(" ", "").length() < 3 || commentaire.getContenu() == null) {
                    addActionError("Le contenu n'est pas valide");
                    return ActionSupport.ERROR;
                } else {
                    int row = pRequest;

                    if (row > 0) {
                        addActionMessage("Le commentaire a été publié");
                        return ActionSupport.SUCCESS;
                    } else {
                        addActionError("Le commentaire n'a pas été publié");
                        return ActionSupport.ERROR;
                    }
                }
            } catch (Exception pE) {
                this.addActionError("Erreur dans la publication de votre commentaire");
                return ActionSupport.ERROR;
            }
        }

        addActionError("Votre commentaire n'a pas été publié : il manque des éléments requis");
        return ActionSupport.ERROR;
    }

    private String doEditCommentaire(int pRequest) {
        try {
            if (commentaire.getContenu().replace(" ", "").length() < 3 || commentaire.getContenu() == null) {
                addActionError("Le contenu n'est pas valide");
                return ActionSupport.ERROR;
            } else {
                int row = pRequest;

                if (row > 0) {
                    addActionMessage("Le commentaire a été édité");
                    return ActionSupport.SUCCESS;
                } else {
                    addActionError("Le commentaire n'a pas été modifié");
                    return ActionSupport.ERROR;
                }
            }
        } catch (Exception pE) {
            this.addActionError("Erreur dans la modification de votre commentaire");
            return ActionSupport.ERROR;
        }
    }
}
