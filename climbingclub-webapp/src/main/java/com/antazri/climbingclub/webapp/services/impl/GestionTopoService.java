package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.business.contract.ISpotBo;
import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class GestionTopoService implements IGestionTopoService {

    @Autowired
    private ITopoBo topoBo;

    @Autowired
    private ISpotBo spotBo;

    @Autowired
    private IUtilisateurBo utilisateurBo;

    @Autowired
    private IRegionBo regionBo;

    public Topo findTopoById(int pId) {
        Topo topo = topoBo.findById(pId);
        topo.setProprietaire(utilisateurBo.findById(topo.getProprietaire().getUtilisateurId()));
        topo.setRegion(regionBo.findById(topo.getRegion().getRegionId()));

        return topo;
    }

    public List<Topo> findTopoByUser(Utilisateur pUtilisateur) {
        List<Topo> topos = topoBo.findByUser(pUtilisateur);

        for (Topo topo : topos) {
            topo.setProprietaire(pUtilisateur);
            topo.setRegion(regionBo.findById(topo.getRegion().getRegionId()));
        }

        return topos;
    }

    public Topo findTopoByName(String pName) {
        Topo topo = topoBo.findByName(pName);
        topo.setProprietaire(utilisateurBo.findById(topo.getProprietaire().getUtilisateurId()));
        topo.setRegion(regionBo.findById(topo.getRegion().getRegionId()));

        return topo;
    }

    public List<Topo> findTopoByRegion(Region pRegion) {
        List<Topo> topos = topoBo.findByRegion(pRegion);

        for (Topo topo : topos) {
            topo.setProprietaire(utilisateurBo.findById(topo.getProprietaire().getUtilisateurId()));
            topo.setRegion(pRegion);
        }

        return topos;
    }

    public List<Topo> findAllDisponible() {
        List<Topo> topos = new ArrayList<>();
        return topos;
    }

    public List<Topo> findAllTopo() {
        List<Topo> topos = topoBo.findAll();

        for (Topo topo : topos) {
            topo.setProprietaire(utilisateurBo.findById(topo.getProprietaire().getUtilisateurId()));
            topo.setRegion(regionBo.findById(topo.getRegion().getRegionId()));
        }

        return topos;
    }

    public int addTopo(String pName, int pRegionId, int pUtilisateurId) {
        Topo topo = new Topo();
        topo.setTopoNom(pName);
        topo.setRegion(regionBo.findById(pRegionId));
        topo.setProprietaire(utilisateurBo.findById(pUtilisateurId));

        return topoBo.create(topo);
    }

    public int updateTopo(int pId, String pName, int pRegionId, int pUtilisateurId) {
        Topo topo = new Topo();
        topo.setTopoId(pId);
        topo.setTopoNom(pName);
        topo.setRegion(regionBo.findById(pRegionId));
        topo.setProprietaire(utilisateurBo.findById(pUtilisateurId));

        return topoBo.update(topo);
    }

    public int deleteTopo(int pTopoId) {
        List<Spot> spots = hasSpots(topoBo.findById(pTopoId));

        if (spots.isEmpty()) {
            topoBo.delete(topoBo.findById(pTopoId));
            return 1;
        } else {
            return 0;
        }

    }

    @Override
    public List<Spot> hasSpots(Topo pTopo) {
        return spotBo.findByTopo(pTopo);
    }
}
