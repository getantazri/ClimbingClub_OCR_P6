package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.ICommentaireByObjectBo;
import com.antazri.climbingclub.consumer.contract.ICommentaireByObjectDao;
import com.antazri.climbingclub.consumer.impl.CommentaireByTopoDao;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class CommentaireByTopoBo extends AbstractBo implements ICommentaireByObjectBo<Topo> {

    @Autowired
    private CommentaireByTopoDao commentaireByTopoDao;

    /**
     * La méthode findByObject permet de récupérer des objets Commentaire via le CommentaireDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pTopo est un objet Topo qui permet de filtrer les éléments que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Commentaire retournée par la couche DAO
     */
    @Transactional
    public List<Commentaire> findByObject(Topo pTopo) {
        return commentaireByTopoDao.findByObject(pTopo);
    }

    /**
     * La méthode addCommentaire permet d'enregistrer une relation de Commentaire  et de Topo via le CommentaireByTopoDao
     * affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des données seront transférées dans la base de données
     *
     * @param pTopoId est l'identifiant d'un objet Topo
     * @param pCommentaireId est l'identifiant d'un objet Commentaire
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireTopoRM
     */
    @Transactional
    public int addCommentaire(int pTopoId, int pCommentaireId) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return commentaireByTopoDao.addCommentaire(pTopoId, pCommentaireId);
            }
        });
    }

    /**
     * La méthode deleteCommentaire permet de supprimer une relation de Commentaire  et de Topo via le CommentaireByTopoDao
     * affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des données seront transférées dans la base de données
     *
     * @param pTopoId est l'identifiant d'un objet Topo
     * @param pCommentaireId est l'identifiant d'un objet Commentaire
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireTopoRM
     */
    @Transactional
    public void deleteCommentaire(int pTopoId, int pCommentaireId) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                commentaireByTopoDao.deleteCommentaire(pTopoId, pCommentaireId);
            }
        });
    }
}
