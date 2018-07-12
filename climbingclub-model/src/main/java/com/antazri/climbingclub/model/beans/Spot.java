package com.antazri.climbingclub.model.beans;

public class Spot {

    private int spotId;
    private Topo topo;
    private String spotNom;
    private String spotDescription;
    private int hauteur;

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public String getSpotNom() {
        return spotNom;
    }

    public void setSpotNom(String spotNom) {
        this.spotNom = spotNom;
    }

    public String getSpotDescription() {
        return spotDescription;
    }

    public void setSpotDescription(String spotDescription) {
        this.spotDescription = spotDescription;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
}
