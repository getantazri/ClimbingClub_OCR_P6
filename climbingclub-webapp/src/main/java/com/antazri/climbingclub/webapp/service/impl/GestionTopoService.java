package com.antazri.climbingclub.webapp.service.impl;

import com.antazri.climbingclub.business.bo.contract.IRegionBo;
import com.antazri.climbingclub.business.bo.contract.ITopoBo;
import com.antazri.climbingclub.business.bo.contract.IUtilisateurBo;
import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.service.contract.IGestionTopoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionTopoService implements IGestionTopoService {

    @Autowired
    private ITopoBo topoBo;

    @Autowired
    private IUtilisateurBo utilisateurBo;

    @Autowired
    private IRegionBo regionBo;

    public Topo findTopoById(int pId) {
        return topoBo.findById(pId);
    }

    public List<Topo> findTopoByUser(Utilisateur pUtilisateur) {
        return topoBo.findByUser(pUtilisateur);
    }

    public Topo findTopoByName(String pName) {
        return topoBo.findByName(pName);
    }

    public List<Topo> findTopoByRegion(Region pRegion) {
        return topoBo.findByRegion(pRegion);
    }

    public List<Topo> findAllDisponible() {
        return null;
    }

    public List<Topo> findAllTopo() {
        return topoBo.findAll();
    }

    public int addTopo(int pUtilisateurId, String pName, boolean pDisponible, int pRegionId) {
        Topo topo = new Topo();
        topo.setProprietaire(utilisateurBo.findById(pUtilisateurId));
        topo.setTopoNom(pName);
        topo.setDisponible(pDisponible);
        topo.setRegion(regionBo.findById(pRegionId));

        return topoBo.create(topo);
    }

    public int updateTopo(int pTopoId, String pName, boolean pDisponible, int pRegionId) {
        Topo topo = topoBo.findById(pTopoId);
        topo.setTopoNom(pName);
        topo.setDisponible(pDisponible);
        topo.setRegion(regionBo.findById(pRegionId));

        return topoBo.update(topo);
    }

    public void deleteTopo(int pTopoId) {
        topoBo.delete(topoBo.findById(pTopoId));
    }
}
