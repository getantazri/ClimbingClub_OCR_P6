package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.consumer.contract.IRegionDao;
import com.antazri.climbingclub.model.beans.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class RegionBo extends AbstractBo implements IRegionBo {

    @Autowired
    private IRegionDao regionDao;

    @Transactional
    public Region findById(int pId) {
        return regionDao.findById(pId);
    }

    @Transactional
    public Region findByName(String pName) {
        return regionDao.findByName(pName);
    }

    @Transactional
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    @Transactional
    public int create(final Region pRegion) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return regionDao.create(pRegion);
            }
        });
    }

    @Transactional
    public int update(final Region pRegion) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return regionDao.update(pRegion);
            }
        });
    }

    @Transactional
    public void delete(final Region pRegion) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                regionDao.delete(pRegion);
            }
        });
    }
}
