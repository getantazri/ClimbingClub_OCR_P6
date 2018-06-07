package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IUtilisateurDao;
import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilisateurDao extends AbstractDao implements IUtilisateurDao {

    public Utilisateur findById(int pId) {
        return null;
    }

    public List<Utilisateur> findByStatut(Statut pStatut) {
        return null;
    }

    public List<Utilisateur> findByName(String pName) {
        return null;
    }

    public List<Utilisateur> findAll() {
        return null;
    }

    public Utilisateur create(Utilisateur pTopUtilisateurpo) {
        return null;
    }

    public Utilisateur update(Utilisateur pUtilisateur) {
        return null;
    }

    public void delete(Utilisateur pUtilisateur) {

    }
}
