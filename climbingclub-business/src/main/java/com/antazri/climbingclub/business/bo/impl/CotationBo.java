package com.antazri.climbingclub.business.bo.impl;

import com.antazri.climbingclub.business.bo.contract.ICotationBo;
import com.antazri.climbingclub.consumer.contract.ICotationDao;
import com.antazri.climbingclub.model.beans.Cotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class CotationBo implements ICotationBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private ICotationDao cotationDao;

    public Cotation findById(int pId) {
        return cotationDao.findById(pId);
    }

    public Cotation findByName(String pName) {
        return cotationDao.findByName(pName);
    }

    public List<Cotation> findAll() {
        return cotationDao.findAll();
    }

    public int create(final Cotation pCotation) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return cotationDao.create(pCotation);
            }
        });
    }

    public int update(final Cotation pCotation) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return cotationDao.update(pCotation);
            }
        });
    }

    public void delete(final Cotation pCotation) {
        TransactionTemplate vTranscationTemplate = new TransactionTemplate(platformTransactionManager);
        vTranscationTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                cotationDao.delete(pCotation);
            }
        });
    }
}
