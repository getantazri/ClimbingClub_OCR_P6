package com.antazri.climbingclub.business.bo.impl;

import com.antazri.climbingclub.business.bo.contract.ISecteurBo;
import com.antazri.climbingclub.consumer.contract.ISecteurDao;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class SecteurBo implements ISecteurBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private ISecteurDao secteurDao;

    public Secteur findById(int pId) {
        return secteurDao.findById(pId);
    }

    public List<Secteur> findBySpot(Spot pSpot) {
        return secteurDao.findBySpot(pSpot);
    }

    public Secteur findByName(String pName) {
        return secteurDao.findByName(pName);
    }

    public List<Secteur> containsName(String pName) {
        return secteurDao.containsName(pName);
    }

    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }

    public int create(final Secteur pSecteur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return secteurDao.create(pSecteur);
            }
        });
    }

    public int update(final Secteur pSecteur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return secteurDao.update(pSecteur);
            }
        });
    }

    public void delete(final Secteur pSecteur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                secteurDao.delete(pSecteur);
            }
        });
    }
}
