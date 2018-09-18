package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.ICommentaireByObjectBo;
import com.antazri.climbingclub.consumer.contract.ICommentaireByObjectDao;
import com.antazri.climbingclub.consumer.impl.CommentaireBySpotDao;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.CommentaireSpot;
import com.antazri.climbingclub.model.beans.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class CommentaireBySpotBo extends AbstractBo implements ICommentaireByObjectBo<Spot, CommentaireSpot> {

    @Autowired
    @Qualifier("commentaireBySpotDao")
    private ICommentaireByObjectDao<Spot, CommentaireSpot> commentaireBySpotDao;

    /**
     * La méthode findByCommentaure permet de récupérer un objet CommentaireSpot via le commentaireBySpotDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pCommentaire est un objet Commentaire qui permet de filtrer les éléments que l'on souhaite récupérer dans la base de données
     * @return un objet CommentaireSpot retourné par la couche DAO
     */
    @Transactional
    public CommentaireSpot findByCommentaire(Commentaire pCommentaire) {
        return commentaireBySpotDao.findByCommentaire(pCommentaire);
    }

    /**
     * La méthode findBySpot permet de récupérer des objets Commentaire via le commentaireBySpotDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pSpot est un objet Spot qui permet de filtrer les éléments que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Commentaire retournée par la couche DAO
     */
    @Transactional
    public List<CommentaireSpot> findByObject(Spot pSpot) {
        return commentaireBySpotDao.findByObject(pSpot);
    }

    /**
     * La méthode addCommentaire permet d'enregistrer une relation de Commentaire  et de Spot via le CommentaireBySpotDao
     * affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des données seront transférées dans la base de données
     *
     * @param pSpotId est l'identifiant d'un objet Spot
     * @param pCommentaireId est l'identifiant d'un objet Commentaire
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireSpotRM
     */
    @Transactional
    public int addCommentaire(int pSpotId, int pCommentaireId) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(status -> commentaireBySpotDao.addCommentaire(pSpotId, pCommentaireId));
    }

    /**
     * La méthode deleteCommentaire permet de supprimer une relation de Commentaire  et de Spot via le CommentaireBySpotDao
     * affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des données seront transférées dans la base de données
     *
     * @param pSpotId est l'identifiant d'un objet Spot
     * @param pCommentaireId est l'identifiant d'un objet Commentaire
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireSpotRM
     */
    @Transactional
    public void deleteCommentaire(int pSpotId, int pCommentaireId) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                commentaireBySpotDao.deleteCommentaire(pSpotId, pCommentaireId);
            }
        });
    }
}
