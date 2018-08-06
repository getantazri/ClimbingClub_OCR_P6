package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.ISecteurBo;
import com.antazri.climbingclub.consumer.contract.ISecteurDao;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class SecteurBo extends AbstractBo implements ISecteurBo {

    @Autowired
    private ISecteurDao secteurDao;

    @Transactional
    public Secteur findById(int pId) {
        return secteurDao.findById(pId);
    }

    @Transactional
    public List<Secteur> findBySpot(Spot pSpot) {
        return secteurDao.findBySpot(pSpot);
    }

    @Transactional
    public Secteur findByName(String pName) {
        return secteurDao.findByName(pName);
    }

    @Transactional
    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }

    @Transactional
    public int create(final Secteur pSecteur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return secteurDao.create(pSecteur);
            }
        });
    }

    @Transactional
    public int update(final Secteur pSecteur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return secteurDao.update(pSecteur);
            }
        });
    }

    @Transactional
    public void delete(final Secteur pSecteur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                secteurDao.delete(pSecteur);
            }
        });
    }
}
