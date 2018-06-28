package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.Date;
import java.util.List;

public interface IEmpruntDao {

    Emprunt findById(int pId);
    List<Emprunt> findByUtilisateur(Utilisateur pUtilisateur);
    List<Emprunt> findByTopo(Topo pTopo);
    List<Emprunt> findAll();
    int create(Emprunt pEmprunt);
    int update(Emprunt pEmprunt);
    void delete(Emprunt pEmprunt);
}
