package com.antazri.climbingclub.model.beans;

public class Topo {

    private int topoId;
    private Utilisateur proprietaire;
    private String topoNom;
    private Region region;
    private boolean disponible;

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
    }

    public Utilisateur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Utilisateur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getTopoNom() {
        return topoNom;
    }

    public void setTopoNom(String topoNom) {
        this.topoNom = topoNom;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
