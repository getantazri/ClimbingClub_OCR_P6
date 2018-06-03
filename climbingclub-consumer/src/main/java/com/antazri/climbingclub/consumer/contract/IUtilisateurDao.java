package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface IUtilisateurDao {

    public Utilisateur findById(int pId);
    public List<Utilisateur> findByStatut(Statut pStatut);
    public List<Utilisateur> findByName(String pName);
    public List<Utilisateur> findAll();
    public Utilisateur create(Utilisateur pTopUtilisateurpo);
    public Utilisateur update(Utilisateur pUtilisateur);
    public void delete(Utilisateur pUtilisateur);
}
