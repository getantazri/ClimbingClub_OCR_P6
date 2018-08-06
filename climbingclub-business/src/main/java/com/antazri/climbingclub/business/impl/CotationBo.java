package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.ICotationBo;
import com.antazri.climbingclub.consumer.contract.ICotationDao;
import com.antazri.climbingclub.model.beans.Cotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class CotationBo extends AbstractBo implements ICotationBo {

    @Autowired
    private ICotationDao cotationDao;

    @Transactional
    public Cotation findById(int pId) {
        return cotationDao.findById(pId);
    }

    @Transactional
    public Cotation findByName(String pName) {
        return cotationDao.findByName(pName);
    }

    @Transactional
    public List<Cotation> findAll() {
        return cotationDao.findAll();
    }

    @Transactional
    public int create(final Cotation pCotation) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return cotationDao.create(pCotation);
            }
        });
    }

    @Transactional
    public int update(final Cotation pCotation) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return cotationDao.update(pCotation);
            }
        });
    }

    @Transactional
    public void delete(final Cotation pCotation) {
        TransactionTemplate vTranscationTemplate = new TransactionTemplate(getTransactionManager());
        vTranscationTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                cotationDao.delete(pCotation);
            }
        });
    }
}
