package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
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

    public int addTopo(Topo pTopo) {
        return topoBo.create(pTopo);
    }

    public int updateTopo(Topo pTopo) {
        return topoBo.update(pTopo);
    }

    public void deleteTopo(int pTopoId) {
        topoBo.delete(topoBo.findById(pTopoId));
    }
}
