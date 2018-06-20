package com.antazri.climbingclub.model.beans;

public class Commentaire {

    private int commentaireId;
    private Spot spot;
    private Topo topo;
    private Utilisateur utilisateur;
    private String contenu;
    private Commentaire commentaireParent;

    public int getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(int commentaireId) {
        this.commentaireId = commentaireId;
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

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Commentaire getCommentaireParent() {
        return commentaireParent;
    }

    public void setCommentaireParent(Commentaire commentaireParent) {
        this.commentaireParent = commentaireParent;
    }
}
