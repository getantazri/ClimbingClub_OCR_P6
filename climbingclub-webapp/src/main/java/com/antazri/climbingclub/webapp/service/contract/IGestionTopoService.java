package com.antazri.climbingclub.webapp.service.contract;

import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import java.util.List;

public interface IGestionTopoService {

    Topo findTopoById(int pId);
    List<Topo> findTopoByUser(Utilisateur pUtilisateur);
    Topo findTopoByName(String pName);
    List<Topo> findTopoByRegion(Region pRegion);
    List<Topo> findAllDisponible();
    List<Topo> findAllTopo();
    int addTopo(int pUtilisateurId, String pName, boolean pDisponible, int pRegionId);
    int updateTopo(int pTopoId, String pName, boolean pDisponible, int pRegionId);
    void deleteTopo(int pTopoId);

}
