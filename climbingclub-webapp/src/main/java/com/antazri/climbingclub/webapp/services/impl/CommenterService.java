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
        Commentaire commentaire = commentaireBo.findById(pId);
        commentaire.setUtilisateur(utilisateurBo.findById(commentaire.getUtilisateur().getUtilisateurId()));

        return commentaire;
    }

    public List<Commentaire> findCommentaireBySpot(Spot pSpot) {
        List<Commentaire> commentaires = commentaireBo.findBySpot(pSpot);

        for (Commentaire commentaire : commentaires) {
            commentaire.setUtilisateur(utilisateurBo.findById(commentaire.getUtilisateur().getUtilisateurId()));
            commentaire.setSpot(spotBo.findById(pSpot.getSpotId()));
        }

        return commentaires;
    }

    public List<Commentaire> findCommentaireByTopo(Topo pTopo) {
        List<Commentaire> commentaires = commentaireBo.findByTopo(pTopo);

        for (Commentaire commentaire : commentaires) {
            commentaire.setUtilisateur(utilisateurBo.findById(commentaire.getUtilisateur().getUtilisateurId()));
            commentaire.setTopo(topoBo.findById(pTopo.getTopoId()));
        }

        return commentaires;
    }

    public List<Commentaire> findCommentaireByUtilisateur(String pName) {
        Utilisateur utilisateur = utilisateurBo.findByName(pName);
        List<Commentaire> commentaires = commentaireBo.findByUtilisateur(utilisateur);

        for (Commentaire commentaire : commentaires) {
            commentaire.setUtilisateur(utilisateur);

            if (commentaire.getSpot().getSpotId() > 0) {
                commentaire.setSpot(spotBo.findById(commentaire.getSpot().getSpotId()));
            }

            if (commentaire.getTopo().getTopoId() > 0) {
                commentaire.setTopo(topoBo.findById(commentaire.getTopo().getTopoId()));
            }
        }

        return commentaires;
    }

    public List<Commentaire> findAllCommentaire() {
        List<Commentaire> commentaires = commentaireBo.findAll();

        for (Commentaire commentaire : commentaires) {
            commentaire.setUtilisateur(utilisateurBo.findById(commentaire.getUtilisateur().getUtilisateurId()));

            if (commentaire.getSpot().getSpotId() > 0) {
                commentaire.setSpot(spotBo.findById(commentaire.getSpot().getSpotId()));
            }

            if (commentaire.getTopo().getTopoId() > 0) {
                commentaire.setTopo(topoBo.findById(commentaire.getTopo().getTopoId()));
            }
        }

        return commentaires;
    }

    public int publishCommentaire(int pUtilisateurId, String pContenu, int pSpotId, int pTopoId) {
        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(pContenu);
        commentaire.setUtilisateur(utilisateurBo.findById(pUtilisateurId));

        if (pSpotId > 0) {
            commentaire.setSpot(spotBo.findById(pSpotId));
        } else {
            Spot spot = new Spot();
            spot.setSpotId(0);
            commentaire.setSpot(spot);
        }

        if (pTopoId > 0) {
            commentaire.setTopo(topoBo.findById(pTopoId));
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
