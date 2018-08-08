package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.consumer.contract.ITopoDao;
import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class TopoBo extends AbstractBo implements ITopoBo {

    @Autowired
    private ITopoDao topoDao;

    @Transactional
    public Topo findById(int pId) {
        return topoDao.findById(pId);
    }

    @Transactional
    public List<Topo> findByUser(Utilisateur pUtilisateur) {
        return topoDao.findByUser(pUtilisateur);
    }

    @Transactional
    public Topo findByName(String pName) {
        return topoDao.findByName(pName);
    }

    @Transactional
    public List<Topo> findByRegion(Region pRegion) throws EmptyResultDataAccessException{
        try {
            return topoDao.findByRegion(pRegion);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public List<Topo> findAll() {
        return topoDao.findAll();
    }

    @Transactional
    public int create(final Topo pTopo) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return topoDao.create(pTopo);
            }
        });
    }

    @Transactional
    public int update(final Topo pTopo) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return topoDao.update(pTopo);
            }
        });
    }

    @Transactional
    public void delete(final Topo pTopo) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                topoDao.delete(pTopo);
            }
        });
    }
}
