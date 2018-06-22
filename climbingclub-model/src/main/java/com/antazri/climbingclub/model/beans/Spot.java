package com.antazri.climbingclub.model.beans;

public class Spot {

    private int spotId;
    private Topo topo;
    private Region region;
    private String spotNom;
    private String spotDescription;
    private String hauteur;

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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
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

    public String getHauteur() {
        return hauteur;
    }

    public void setHauteur(String hauteur) {
        this.hauteur = hauteur;
    }
}
