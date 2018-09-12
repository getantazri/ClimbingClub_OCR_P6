package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.ICommentaireBo;
import com.antazri.climbingclub.business.contract.ISpotBo;
import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.business.impl.CommentaireBySpotBo;
import com.antazri.climbingclub.business.impl.CommentaireByTopoBo;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICommenterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implémentation de l'interface ICommenterService. CommenterService permet à la WebApp d'utiliser les Business Objects pour récupérer ou envoyer des objets/données,
 * liés à la fonctionnalité permettant de commenter sur certaines pages JSP de l'application, à la base de données.
 *
 * @author Anthony T
 * @version 1.0
 */
public class CommenterService implements ICommenterService {

    @Autowired
    private ICommentaireBo commentaireBo;

    @Autowired
    private CommentaireBySpotBo commentaireBySpot;

    @Autowired
    private CommentaireByTopoBo commentaireByTopo;

    @Autowired
    private IUtilisateurBo utilisateurBo;

    @Autowired
    private ISpotBo spotBo;

    @Autowired
    private ITopoBo topoBo;

    /**
     * La méthode findCommentaireById permet de récupérer un objet Commentaire selon son identifiant unique via l'objet CommentaireBo. Cette objet est instancié automatiquement
     * par Spring grâce à l'annotation @Autowired.
     * @param pId est un Integer définissant l'identifiant unique
     * @return un objet Commentaire depuis la couche Business
     */
    public Commentaire findCommentaireById(int pId) {
        Commentaire commentaire = commentaireBo.findById(pId);
        commentaire.setUtilisateur(utilisateurBo.findById(commentaire.getUtilisateur().getUtilisateurId()));

        return commentaire;
    }

    /**
     * La méthode findCommentaireBySpot permet de récupérer des objets Commentaire selon leur attribut Spot via l'objet CommentaireBo. Cette objet est instancié automatiquement
     * par Spring grâce à l'annotation @Autowired.
     * @param pSpot est un objet Spot permettant de filtrer les objets Commentaire retournés
     * @return une List d'objets Commentaire depuis la couche Business
     */
    public List<Commentaire> findCommentaireBySpot(Spot pSpot) {
        List<Commentaire> commentaires = commentaireBySpot.findByObject(pSpot);

        for (Commentaire commentaire : commentaires) {
            commentaire = commentaireBo.findById(commentaire.getCommentaireId());
            commentaire.setUtilisateur(utilisateurBo.findById(commentaire.getUtilisateur().getUtilisateurId()));
        }

        return commentaires;
    }

    /**
     * La méthode findCommentaireByTopo permet de récupérer des objets Commentaire selon leur attribut Topo via l'objet CommentaireBo. Cette objet est instancié automatiquement
     * par Spring grâce à l'annotation @Autowired.
     * @param pTopo est un objet Topo permettant de filtrer les objets Commentaire retournés
     * @return une List d'objets Commentaire depuis la couche Business
     */
    public List<Commentaire> findCommentaireByTopo(Topo pTopo) {
        List<Commentaire> commentaires = commentaireByTopo.findByObject(pTopo);

        for (Commentaire commentaire : commentaires) {
            commentaire = commentaireBo.findById(commentaire.getCommentaireId());
            commentaire.setUtilisateur(utilisateurBo.findById(commentaire.getUtilisateur().getUtilisateurId()));
        }

        return commentaires;
    }

    /**
     * La méthode findCommentaireByUtilisateur permet de récupérer des objets Commentaire selon leur attribut Utilisateur via l'objet CommentaireBo. Cette objet est
     * instancié automatiquement par Spring grâce à l'annotation @Autowired.
     * @param pName est un String permettant de filtrer les objets Commentaire retournés selon l'attribut Pseudo de l'objet Utilisateur
     * @return une List d'objets Commentaire depuis la couche Business
     */
    public List<Commentaire> findCommentaireByUtilisateur(String pName) {
        Utilisateur utilisateur = utilisateurBo.findByName(pName);
        List<Commentaire> commentaires = commentaireBo.findByUtilisateur(utilisateur);

        return commentaires;
    }

    /**
     * La méthode findAllCommentaire permet de récupérer l'ensemble des instances de Commentaire via l'objet CommentaireBo. Cette objet est instancié automatiquement
     * par Spring grâce à l'annotation @Autowired.
     * @return une List d'objets Commentaire depuis la couche Business
     */
    public List<Commentaire> findAllCommentaire() {
        List<Commentaire> commentaires = commentaireBo.findAll();

        return commentaires;
    }

    /**
     *  La méthode publishCommentaire permet de créer une instance de Commentaire dans la base de données via l'objet CommentaireBo. Cette objet est instancié
     *  automatiquement par Spring grâce à l'annotation @Autowired.
     * @param pUtilisateurId est l'identifiant unique (Integer) de l'attribut Utilisateur de Commentaire
     * @param pContenu est un String définissant l'attribut Contenu de Commentaire
     * @return un entier (1 ou 0) qui définira si une ligne a été ajoutée ou non
     */
    public int publishCommentaire(int pUtilisateurId, String pContenu, LocalDateTime pDatePublication) {
        Commentaire commentaire = new Commentaire();
        commentaire.setContenu(pContenu);
        commentaire.setDatePublication(pDatePublication);
        commentaire.setUtilisateur(utilisateurBo.findById(pUtilisateurId));

        return commentaireBo.create(commentaire);
    }

    /**
     *  La méthode publishCommentaire permet de mettre à jour une instance de Commentaire dans la base de données via l'objet CommentaireBo. Cette objet est instancié
     *  automatiquement par Spring grâce à l'annotation @Autowired.
     * @param pCommentaireId est l'identifiant unique (Integer) de l'objet Commentaire à modifier
     * @param pContenu est un String définissant l'attribut Contenu de Commentaire
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    public int editCommentaire(int pCommentaireId, String pContenu) {
        Commentaire commentaire = commentaireBo.findById(pCommentaireId);
        commentaire.setContenu(pContenu);

        return commentaireBo.update(commentaire);
    }

    /**
     *  La méthode publishCommentaire permet de supprimer une instance de Commentaire de la base de données via l'objet CommentaireBo. Cette objet est instancié
     *  automatiquement par Spring grâce à l'annotation @Autowired.
     * @param pId est l'identifiant unique (Integer) de l'objet Commentaire à supprimer
     * @return un entier (1 ou 0) qui définira si une ligne a été supprimée ou non
     */
    public int deleteCommentaire(int pId) {
        try {
            commentaireBo.delete(commentaireBo.findById(pId));
            return 1;
        } catch (Exception pE) {
            return 0;
        }
    }
}
