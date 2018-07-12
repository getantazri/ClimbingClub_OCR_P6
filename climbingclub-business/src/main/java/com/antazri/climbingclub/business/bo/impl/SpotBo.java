package com.antazri.climbingclub.business.bo.impl;

import com.antazri.climbingclub.business.bo.contract.ISpotBo;
import com.antazri.climbingclub.consumer.contract.ISpotDao;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class SpotBo implements ISpotBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private ISpotDao spotDao;

    public Spot findById(int pId) {
        return spotDao.findById(pId);
    }

    public Spot findByName(String pName) {
        return spotDao.findByName(pName);
    }

    public List<Spot> findByTopo(Topo pTopo) {
        return spotDao.findByTopo(pTopo);
    }

    public List<Spot> findByHauteur(int pHauteur) {
        return spotDao.findByHauteur(pHauteur);
    }

    public List<Spot> findAll() {
        return spotDao.findAll();
    }

    public int create(final Spot pSpot) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return spotDao.create(pSpot);
            }
        });
    }

    public int update(final Spot pSpot) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return spotDao.update(pSpot);
            }
        });
    }

    public void delete(final Spot pSpot) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                spotDao.delete(pSpot);
            }
        });
    }
}
