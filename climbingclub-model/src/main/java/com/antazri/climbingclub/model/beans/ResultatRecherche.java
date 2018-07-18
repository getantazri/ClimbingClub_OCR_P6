package com.antazri.climbingclub.model.beans;

import java.util.ArrayList;
import java.util.List;

public class ResultatRecherche {

    private List<Topo> resultsTopo = new ArrayList<>();
    private List<Spot> resultsSpot = new ArrayList<>();
    private List<Secteur> resultsSecteur = new ArrayList<>();
    private List<Voie> resultsVoie = new ArrayList<>();

    public List<Topo> getResultsTopo() {
        return resultsTopo;
    }

    public void addTopo(Topo topo) {
        getResultsTopo().add(topo);
    }

    public void addAllTopo(List<Topo> topos) {
        getResultsTopo().addAll(topos);
    }

    public List<Spot> getResultsSpot() {
        return resultsSpot;
    }

    public void addSpot(Spot spot) {
        getResultsSpot().add(spot);
    }

    public void addAllSpot(List<Spot> spots) {
        getResultsSpot().addAll(spots);
    }

    public List<Secteur> getResultsSecteur() {
        return resultsSecteur;
    }

    public void addSecteur(Secteur secteur) {
        getResultsSecteur().add(secteur);
    }

    public void addAllSecteur(List<Secteur> secteurs) {
        getResultsSecteur().addAll(secteurs);
    }

    public List<Voie> getResultsVoie() {
        return resultsVoie;
    }

    public void addVoie(Voie voie) {
        getResultsVoie().add(voie);
    }

    public void addAllVoie(List<Voie> voies) {
        getResultsVoie().addAll(voies);
    }
}
