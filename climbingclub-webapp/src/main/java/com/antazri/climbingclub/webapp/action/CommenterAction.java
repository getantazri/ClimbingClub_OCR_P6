package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.ICommentaireByObjectBo;
import com.antazri.climbingclub.model.beans.*;
import com.antazri.climbingclub.webapp.services.contract.ICommenterService;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionSpotService;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
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

    Logger logger = LogManager.getLogger();

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
        clearErrorsAndMessages();
        return doPublishCommentaire(commenterService.publishCommentaire(utilisateur.getUtilisateurId(), commentaire.getContenu(), LocalDateTime.now()));
    }

    public String doPostTopoCommentaire() {
        clearErrorsAndMessages();
        return doPublishCommentaire(commenterService.publishCommentaire(utilisateur.getUtilisateurId(), commentaire.getContenu(), LocalDateTime.now()));
    }

    public String doGetSpotCommentaireToEdit() {
        clearErrorsAndMessages();
        commentaireSpot = commenterService.findCommentaireSpotByCommentaire(doGetCommentaireToEdit(commentaireId));
        spot = gestionSpotService.findSpotById(commentaireSpot.getSpot().getSpotId());
        commentaire = commenterService.findCommentaireById(commentaireSpot.getCommentaire().getCommentaireId());

        return ActionSupport.INPUT;
    }

    public String doGetTopoCommentaireToEdit() {
        clearErrorsAndMessages();
        commentaireTopo = commenterService.findCommentaireTopoByCommentaire(doGetCommentaireToEdit(commentaireId));
        topo = gestionTopoService.findTopoById(commentaireTopo.getTopo().getTopoId());
        commentaire = commenterService.findCommentaireById(commentaireTopo.getCommentaire().getCommentaireId());

        return ActionSupport.INPUT;
    }

    public String doEditSpotCommentaire() {
        clearErrorsAndMessages();
        return doEditCommentaire(commenterService.editCommentaire(commentaire.getCommentaireId(), commentaire.getContenu()));
    }

    public String doEditTopoCommentaire() {
        clearErrorsAndMessages();
        return doEditCommentaire(commenterService.editCommentaire(commentaire.getCommentaireId(), commentaire.getContenu()));
    }

    public String doDeleteTopoCommentaire() {
        clearErrorsAndMessages();
        commentaireTopo = commenterService.findCommentaireTopoByCommentaire(doGetCommentaireToEdit(commentaireId));
        topo = gestionTopoService.findTopoById(commentaireTopo.getTopo().getTopoId());
        commentaire = commenterService.findCommentaireById(commentaireTopo.getCommentaire().getCommentaireId());

        return doDeleteCommentaire(commenterService.deleteCommentaire(0, topo.getTopoId(), commentaire.getCommentaireId()));
    }

    public String doDeleteSpotCommentaire() {
        clearErrorsAndMessages();
        commentaireSpot = commenterService.findCommentaireSpotByCommentaire(doGetCommentaireToEdit(commentaireId));
        spot = gestionSpotService.findSpotById(commentaireSpot.getSpot().getSpotId());
        commentaire = commenterService.findCommentaireById(commentaireSpot.getCommentaire().getCommentaireId());

        return doDeleteCommentaire(commenterService.deleteCommentaire(spot.getSpotId(), 0, commentaire.getCommentaireId()));
    }

    private String doPublishCommentaire(int pRequest) {
        clearErrorsAndMessages();
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
                logger.error("Informations renseignées pour la publication du commentaires invalides", pE);
                return ActionSupport.ERROR;
            }
        }

        addActionError("Votre commentaire n'a pas été publié : il manque des éléments requis");
        return ActionSupport.ERROR;
    }

    private Commentaire doGetCommentaireToEdit(int pCommentaireId) {
        clearErrorsAndMessages();

        try {
            if (pCommentaireId > 0) {
                commentaire = commenterService.findCommentaireById(pCommentaireId);
            }
        } catch (NullPointerException pE) {
            addActionError("Commentaire introuvable");
            logger.error("Identifiant du commentaire inexistant", pE);
        }

        return commentaire;
    }

    private String doEditCommentaire(int pRequest) {
        clearErrorsAndMessages();
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
            logger.error("Informations renseignées pour la mise à jour du commentaire invalides", pE);
            return ActionSupport.ERROR;
        }
    }

    private String doDeleteCommentaire(int pRequest) {
        clearErrorsAndMessages();
        int delete = pRequest;

        if (delete > 0) {
            this.addActionMessage("Commentaire supprimé");
            return ActionSupport.SUCCESS;
        } else {
            this.addActionError("Le commentaire n'existe pas ou a déjà été supprimé");
            return Action.ERROR;
        }
    }

}
