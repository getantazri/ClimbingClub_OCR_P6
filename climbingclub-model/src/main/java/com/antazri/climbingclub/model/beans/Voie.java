package com.antazri.climbingclub.model.beans;

public class Voie {

    private int voie_id;
    private Secteur secteur;
    private int nombrePoints;
    private String description;
    private Cotation cotation;

    public int getVoie_id() {
        return voie_id;
    }

    public void setVoie_id(int voie_id) {
        this.voie_id = voie_id;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
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
