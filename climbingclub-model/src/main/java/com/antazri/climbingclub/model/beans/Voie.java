package com.antazri.climbingclub.model.beans;

public class Voie {

    private int voieId;
    private String nom;
    private int nombrePoints;
    private String description;
    private Cotation cotation;

    public int getVoieId() {
        return voieId;
    }

    public void setVoieId(int voieId) {
        this.voieId = voieId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombrePoints() {
        return nombrePoints;
    }

    public void setNombrePoints(int nombrePoints) {
        this.nombrePoints = nombrePoints;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
    }
}
