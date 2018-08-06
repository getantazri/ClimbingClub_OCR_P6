package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.ICommentaireBo;
import com.antazri.climbingclub.business.contract.ISpotBo;
import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICommenterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommenterService implements ICommenterService {

    @Autowired
    private ICommentaireBo commentaireBo;

    @Autowired
    private IUtilisateurBo utilisateurBo;

    @Autowired
    private ISpotBo spotBo;

    @Autowired
    private ITopoBo topoBo;

    public Commentaire findCommentaireById(int pId) {
        return commentaireBo.findById(pId);
    }

    public List<Commentaire> findCommentaireBySpot(Spot pSpot) {
        return commentaireBo.findBySpot(pSpot);
    }

    public List<Commentaire> findCommentaireByTopo(Topo pTopo) {
        return commentaireBo.findByTopo(pTopo);
    }

    public List<Commentaire> findCommentaireByUtilisateur(String pName) {
        Utilisateur utilisateur = utilisateurBo.findByName(pName);

        return commentaireBo.findByUtilisateur(utilisateur);
    }

    public List<Commentaire> findAllCommentaire() {
        return commentaireBo.findAll();
    }

    public int publishCommentaire(String pAuteur, String pContenu, int spotId, int topoId) {
        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(pContenu);
        commentaire.setUtilisateur(utilisateurBo.findByName(pAuteur));

        if (spotId != 0) {
            commentaire.setSpot(spotBo.findById(spotId));
        } else {
            Spot spot = new Spot();
            spot.setSpotId(0);
            commentaire.setSpot(spot);
        }

        if (topoId != 0) {
            commentaire.setTopo(topoBo.findById(topoId));
        } else {
            Topo topo = new Topo();
            topo.setTopoId(0);
            commentaire.setTopo(topo);
        }

        return commentaireBo.create(commentaire);
    }

    public int editCommentaire(int pCommentaireId, String pContenu) {
        Commentaire commentaire = commentaireBo.findById(pCommentaireId);
        commentaire.setContenu(pContenu);

        return commentaireBo.update(commentaire);
    }

    public void deleteCommentaire(int pId) {
        commentaireBo.delete(commentaireBo.findById(pId));
    }
}
