package com.antazri.climbingclub.business.bo.impl;

import com.antazri.climbingclub.business.bo.contract.ITopoBo;
import com.antazri.climbingclub.consumer.contract.ITopoDao;
import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class TopoBo implements ITopoBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private ITopoDao topoDao;

    public Topo findById(int pId) {
        return topoDao.findById(pId);
    }

    public List<Topo> findByUser(Utilisateur pUtilisateur) {
        return topoDao.findByUser(pUtilisateur);
    }

    public Topo findByName(String pName) {
        return topoDao.findByName(pName);
    }

    public List<Topo> findByRegion(Region pRegion) {
        return topoDao.findByRegion(pRegion);
    }

    public List<Topo> containsName(String pName) {
        return topoDao.containsName(pName);
    }

    public List<Topo> findAll() {
        return topoDao.findAll();
    }

    public int create(final Topo pTopo) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return topoDao.create(pTopo);
            }
        });
    }

    public int update(final Topo pTopo) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return topoDao.update(pTopo);
            }
        });
    }

    public void delete(final Topo pTopo) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                topoDao.delete(pTopo);
            }
        });
    }
}
