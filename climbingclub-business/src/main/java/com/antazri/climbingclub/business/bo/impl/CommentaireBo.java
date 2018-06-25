package com.antazri.climbingclub.business.bo.impl;

import com.antazri.climbingclub.business.bo.contract.ICommentaireBo;
import com.antazri.climbingclub.consumer.contract.ICommentaireDao;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class CommentaireBo implements ICommentaireBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private ICommentaireDao commentaireDao;

    public Commentaire findById(int pId) {
        return commentaireDao.findById(pId);
    }

    public List<Commentaire> findBySpot(Spot pSpot) {
        return commentaireDao.findBySpot(pSpot);
    }

    public List<Commentaire> findByTopo(Topo pTopo) {
        return commentaireDao.findByTopo(pTopo);
    }

    public List<Commentaire> findAll() {
        return commentaireDao.findAll();
    }

    public int create(final Commentaire pCommentaire) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return commentaireDao.create(pCommentaire);
            }
        });
    }

    public int update(final Commentaire pCommentaire) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return commentaireDao.create(pCommentaire);
            }
        });
    }

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
