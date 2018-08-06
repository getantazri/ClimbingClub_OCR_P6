package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.ISpotBo;
import com.antazri.climbingclub.consumer.contract.ISpotDao;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class SpotBo extends AbstractBo implements ISpotBo {

    @Autowired
    private ISpotDao spotDao;

    @Transactional
    public Spot findById(int pId) {
        return spotDao.findById(pId);
    }

    @Transactional
    public Spot findByName(String pName) {
        return spotDao.findByName(pName);
    }

    @Transactional
    public List<Spot> findByTopo(Topo pTopo) {
        return spotDao.findByTopo(pTopo);
    }

    @Transactional
    public List<Spot> findByHauteur(int pHauteur) {
        return spotDao.findByHauteur(pHauteur);
    }

    @Transactional
    public List<Spot> findAll() {
        return spotDao.findAll();
    }

    @Transactional
    public int create(final Spot pSpot) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return spotDao.create(pSpot);
            }
        });
    }

    @Transactional
    public int update(final Spot pSpot) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return spotDao.update(pSpot);
            }
        });
    }

    @Transactional
    public void delete(final Spot pSpot) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                spotDao.delete(pSpot);
            }
        });
    }
}
