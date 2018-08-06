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

public class CommentaireBo extends AbstractBo implements ICommentaireBo {

    private ICommentaireDao commentaireDao;

    @Autowired
    public void setCommentaireDao(ICommentaireDao commentaireDao) {
        this.commentaireDao = commentaireDao;
    }

    @Transactional
    public Commentaire findById(int pId) {
        return commentaireDao.findById(pId);
    }

    @Transactional
    public List<Commentaire> findBySpot(Spot pSpot) {
        return commentaireDao.findBySpot(pSpot);
    }

    @Transactional
    public List<Commentaire> findByTopo(Topo pTopo) {
        return commentaireDao.findByTopo(pTopo);
    }

    @Transactional
    public List<Commentaire> findAll() {
        return commentaireDao.findAll();
    }

    @Transactional
    public List<Commentaire> findByUtilisateur(Utilisateur pUtilisateur) {
        return commentaireDao.findByUtilisateur(pUtilisateur);
    }

    @Transactional
    public int create(final Commentaire pCommentaire) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return commentaireDao.create(pCommentaire);
            }
        });
    }

    @Transactional
    public int update(final Commentaire pCommentaire) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return commentaireDao.update(pCommentaire);
            }
        });
    }

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
