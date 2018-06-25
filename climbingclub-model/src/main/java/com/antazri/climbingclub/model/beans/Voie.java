package com.antazri.climbingclub.model.beans;

public class Voie {

    private int voieId;
    private String voieNom;
    private Secteur secteur;
    private int nombrePoints;
    private String voieDescription;
    private Cotation cotation;

    public int getVoieId() {
        return voieId;
    }

    public void setVoieId(int voieId) {
        this.voieId = voieId;
    }

    public String getVoieNom() {
        return voieNom;
    }

    public void setVoieNom(String voieNom) {
        this.voieNom = voieNom;
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

    public String getVoieDescription() {
        return voieDescription;
    }

    public void setVoieDescription(String voieDescription) {
        this.voieDescription = voieDescription;
    }

    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
    }
}
