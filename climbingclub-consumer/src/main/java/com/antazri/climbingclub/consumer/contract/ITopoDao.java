package com.antazri.climbingclub.consumer.contract;

import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface ITopoDao {

    public Topo findById(int pId);
    public List<Topo> findByUser(Utilisateur pUtilisateur);
    public List<Topo> findByName(String pName);
    public List<Topo> findByAvailability(Boolean pDisponiblite);
    public List<Topo> findAll();
    public Topo create(Topo pTopo);
    public Topo update(Topo pTopo);
    public void delete(Topo pTopo);
}
