package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.IEmpruntBo;
import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class ReservationService implements IReservationService {

    @Autowired
    private IEmpruntBo empruntBo;

    @Autowired
    private IUtilisateurBo utilisateurBo;

    @Autowired
    private ITopoBo topoBo;

    public Emprunt findReservationById(int pId) {
        return empruntBo.findById(pId);
    }

    public List<Emprunt> findReservationByUtilisateur(Utilisateur pUtilisateur) {
        return empruntBo.findByUtilisateur(pUtilisateur);
    }

    public List<Emprunt> findReservationByTopo(Topo pTopo) {
        return empruntBo.findByTopo(pTopo);
    }

    public List<Emprunt> findAllReservations() {
        return empruntBo.findAll();
    }

    public int addReservation(Date pDateDebut, Date pDateFin, int pUtilisateurId, int pTopoId) {
        Emprunt emprunt = new Emprunt();
        emprunt.setDateDebut(pDateDebut);
        emprunt.setDateFin(pDateFin);
        emprunt.setUtilisateur(utilisateurBo.findById(pUtilisateurId));
        emprunt.setTopo(topoBo.findById(pTopoId));

        return empruntBo.create(emprunt);
    }

    public int updateReservation(int pEmpruntId, Date pDateDebut, Date pDateFin) {
        Emprunt emprunt = empruntBo.findById(pEmpruntId);
        emprunt.setDateDebut(pDateDebut);
        emprunt.setDateFin(pDateFin);

        return empruntBo.update(emprunt);
    }

    public void deleteReservation(int pEmpruntId) {
        empruntBo.delete(empruntBo.findById(pEmpruntId));
    }
}
