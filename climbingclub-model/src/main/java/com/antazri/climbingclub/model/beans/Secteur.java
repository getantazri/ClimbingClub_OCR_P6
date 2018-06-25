package com.antazri.climbingclub.model.beans;

public class Secteur {

    private int secteurId;
    private Spot spot;
    private String secteurNom;

    public int getSecteurId() {
        return secteurId;
    }

    public void setSecteurId(int secteurId) {
        this.secteurId = secteurId;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public String getSecteurNom() {
        return secteurNom;
    }

    public void setSecteurNom(String secteurNom) {
        this.secteurNom = secteurNom;
    }
}
