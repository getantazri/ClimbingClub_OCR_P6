package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.*;
import com.antazri.climbingclub.webapp.services.contract.*;
import com.opensymphony.xwork2.ActionSupport;
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
        return ActionSupport.SUCCESS;
    }

    public String doGetUtilisateurToUpdate() {
        return ActionSupport.SUCCESS;
    }

    public String doUpdateUtilisateur() {
        return ActionSupport.SUCCESS;
    }

    public String doDeleteUtilisateur() {
        return ActionSupport.SUCCESS;
    }
}
