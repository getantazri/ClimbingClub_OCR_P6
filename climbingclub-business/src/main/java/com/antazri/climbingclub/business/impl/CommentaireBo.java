package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.ICommentaireBo;
import com.antazri.climbingclub.consumer.contract.ICommentaireDao;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Implémentation de l'interface ICommentaireBo. CommentaireBo permet de transférer les données, récupérées avec l'objet CommentaireDao de la couche consumer,
 * via le transactionManager aux Services du module Webapp
 *
 * @author Anthony T
 * @version 1.0
 */
public class CommentaireBo extends AbstractBo implements ICommentaireBo {

    @Autowired
    private ICommentaireDao commentaireDao;

    /**
     * La méthode findById permet de récupérer un objet Commentaire via le CommentaireDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pId est l'identifiant de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Commentaire retourné par la couche DAO
     */
    @Transactional
    public Commentaire findById(int pId) {
        return commentaireDao.findById(pId);
    }

    /**
     * La méthode findAll permet de récupérer toutes les instances de Commentaire enregistrées dans la base de données via le CommentaireDao affecté via @Autowired.
     * L'annotation @Transactionnel permet de spécifié à Spring que des données seront transférées dans et depuis la base de données
     * @return une List d'objets Commentaire retournée par la couche DAO
     */
    @Transactional
    public List<Commentaire> findAll() {
        return commentaireDao.findAll();
    }

    /**
     * La méthode findByUtilisateur permet de récupérer des objets Commentaire via le CommentaireDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pUtilisateur est un objet Utilisateur qui permet de filtrer les éléments que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Commentaire retournée par la couche DAO
     */
    @Transactional
    public List<Commentaire> findByUtilisateur(Utilisateur pUtilisateur) {
        return commentaireDao.findByUtilisateur(pUtilisateur);
    }

    /**
     * La méthode create permet d'enregistrer une instance de Commentaire via le CommentaireDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pCommentaire est un objet Commentaire qui sera enregistré dans la base de données
     * @return un entier (1 ou 0) qui définira si une nouvelle ligne a été crée ou non
     */
    @Transactional
    public int create(final Commentaire pCommentaire) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return commentaireDao.create(pCommentaire);
            }
        });
    }

    /**
     * La méthode update permet de mettre à jour une instance de Commentaire via le CommentaireDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pCommentaire est un objet Commentaire qui sera enregistré dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int update(final Commentaire pCommentaire) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return commentaireDao.update(pCommentaire);
            }
        });
    }

    /**
     * La méthode delete permet de supprimer une instance de Commentaire via le CommentaireDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pCommentaire est un objet Commentaire qui sera supprimé dans la base de données
     */
    @Transactional
    public void delete(final Commentaire pCommentaire) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                commentaireDao.delete(pCommentaire);
            }
        });
    }
}
