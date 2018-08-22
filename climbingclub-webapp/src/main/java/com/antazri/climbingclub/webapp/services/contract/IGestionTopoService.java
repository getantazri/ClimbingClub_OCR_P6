package com.antazri.climbingclub.webapp.services.contract;

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
    int addTopo(String pName, int pRegionId, int pUtilisateurId);
    int updateTopo(int pId, String pName, int pRegionId, int pUtilisateurId);
    void deleteTopo(int pTopoId);

}
