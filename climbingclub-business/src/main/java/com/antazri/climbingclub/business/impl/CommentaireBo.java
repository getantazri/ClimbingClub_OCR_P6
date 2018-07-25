package com.antazri.climbingclub.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.antazri.climbingclub.business.contract.ICommentaireBo;
import com.antazri.climbingclub.consumer.contract.ICommentaireDao;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

public class CommentaireBo implements ICommentaireBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private ICommentaireDao commentaireDao;

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
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return commentaireDao.create(pCommentaire);
            }
        });
    }

    @Transactional
    public int update(final Commentaire pCommentaire) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return commentaireDao.update(pCommentaire);
            }
        });
    }

    @Transactional
    public void delete(final Commentaire pCommentaire) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                commentaireDao.delete(pCommentaire);
            }
        });
    }
}
