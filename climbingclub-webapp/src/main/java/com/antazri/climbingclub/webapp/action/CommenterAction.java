package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.ICommentaireByObjectBo;
import com.antazri.climbingclub.model.beans.*;
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

    @Autowired
    private ICommentaireByObjectBo<Topo, CommentaireTopo> commentaireByTopoBo;

    @Autowired
    private ICommentaireByObjectBo<Spot, CommentaireSpot> commentaireBySpotBo;

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
    private CommentaireSpot commentaireSpot;
    private CommentaireTopo commentaireTopo;

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

    public CommentaireSpot getCommentaireSpot() {
        return commentaireSpot;
    }

    public void setCommentaireSpot(CommentaireSpot commentaireSpot) {
        this.commentaireSpot = commentaireSpot;
    }

    public CommentaireTopo getCommentaireTopo() {
        return commentaireTopo;
    }

    public void setCommentaireTopo(CommentaireTopo commentaireTopo) {
        this.commentaireTopo = commentaireTopo;
    }

    // =======================================================================
    // Méthodes / Actions
    // =======================================================================
    public String doPostSpotCommentaire() {
        return doPublishCommentaire(commenterService.publishCommentaire(utilisateur.getUtilisateurId(), commentaire.getContenu(), LocalDateTime.now()));
    }

    public String doPostTopoCommentaire() {
        return doPublishCommentaire(commenterService.publishCommentaire(utilisateur.getUtilisateurId(), commentaire.getContenu(), LocalDateTime.now()));
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

            if (spotId > 0) {
                delete = commenterService.deleteCommentaire(spotId, 0, commentaireId);
            } else {
                delete = commenterService.deleteCommentaire(0, topoId, commentaireId);
            }


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
        utilisateur = compteUtilisateurService.findUtilisateurById(utilisateur.getUtilisateurId());
        if (commentaire != null) {
            try {
                if (commentaire.getContenu().replace(" ", "").length() < 3 || commentaire.getContenu() == null) {
                    addActionError("Le contenu n'est pas valide");
                    return ActionSupport.ERROR;
                } else {
                    int vId = pRequest;

                    if (vId > 0) {
                        addActionMessage("Le commentaire a été publié");

                        if (spotId > 0) {
                            commentaireBySpotBo.addCommentaire(spotId, vId);
                        } else {
                            commentaireByTopoBo.addCommentaire(topoId, vId);
                        }

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
