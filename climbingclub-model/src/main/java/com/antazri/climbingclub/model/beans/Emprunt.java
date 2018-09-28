package com.antazri.climbingclub.model.beans;

import java.time.LocalDate;

public class Emprunt {

    private int empruntId;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Utilisateur utilisateur;
    private Topo topo;

    public int getEmpruntId() {
        return empruntId;
    }

    public void setEmpruntId(int empruntId) {
        this.empruntId = empruntId;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }
}
