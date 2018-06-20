package com.antazri.climbingclub.model.beans;

public class Commentaire {

    private int commentaireId;
    private Utilisateur utilisateur;
    private String contenu;
    private Commentaire commentaireParent;

    public int getCommentaireId() {
        return commentaireId;
    }

    public void setCommentaireId(int commentaireId) {
        this.commentaireId = commentaireId;
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
