package com.antazri.climbingclub.model.beans;

public class Commentaire {

    private int commentaire_id;
    private Spot spot;
    private Topo topo;
    private Utilisateur utilisateur;
    private String contenu;
    private Commentaire commentaireParent;

    public int getCommentaire_id() {
        return commentaire_id;
    }

    public void setCommentaire_id(int commentaire_id) {
        this.commentaire_id = commentaire_id;
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
