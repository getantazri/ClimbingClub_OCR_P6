package com.antazri.climbingclub.model.beans;

public class Spot {

    private int spot_id;
    private Topo topo;
    private Region region;
    private String nom;
    private String description;
    private String hauteur;

    public int getSpot_id() {
        return spot_id;
    }

    public void setSpot_id(int spot_id) {
        this.spot_id = spot_id;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHauteur() {
        return hauteur;
    }

    public void setHauteur(String hauteur) {
        this.hauteur = hauteur;
    }
}
