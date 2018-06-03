package com.antazri.climbingclub.model.beans;

public class Secteur {

    private int secteur_id;
    private Spot spot;
    private String nom;

    public int getSecteur_id() {
        return secteur_id;
    }

    public void setSecteur_id(int secteur_id) {
        this.secteur_id = secteur_id;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
