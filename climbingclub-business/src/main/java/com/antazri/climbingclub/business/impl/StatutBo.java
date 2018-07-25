package com.antazri.climbingclub.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.antazri.climbingclub.business.contract.IStatutBo;
import com.antazri.climbingclub.consumer.contract.IStatutDao;
import com.antazri.climbingclub.model.beans.Statut;

public class StatutBo implements IStatutBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private IStatutDao statutDao;

    @Transactional
    public Statut findById(int pId) {
        return statutDao.findById(pId);
    }

    @Transactional
    public Statut findByName(String pName) {
        return statutDao.findByName(pName);
    }

    @Transactional
    public List<Statut> findAll() {
        return statutDao.findAll();
    }

    @Transactional
    public int create(final Statut pStatut) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return statutDao.create(pStatut);
            }
        });
    }

    @Transactional
    public int update(final Statut pStatut) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return statutDao.update(pStatut);
            }
        });
    }

    @Transactional
    public void delete(final Statut pStatut) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                statutDao.delete(pStatut);
            }
        });
    }
}
