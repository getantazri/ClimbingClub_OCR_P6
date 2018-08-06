package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.IVoieBo;
import com.antazri.climbingclub.consumer.contract.IVoieDao;
import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class VoieBo extends AbstractBo implements IVoieBo {

    @Autowired
    private IVoieDao voieDao;

    @Transactional
    public Voie findById(int pId) {
        return voieDao.findById(pId);
    }

    @Transactional
    public Voie findByName(String pName) {
        return voieDao.findByName(pName);
    }

    @Transactional
    public List<Voie> findBySecteur(Secteur pSecteur) {
        return voieDao.findBySecteur(pSecteur);
    }

    @Transactional
    public List<Voie> findByCotation(Cotation pCotation) {
        return voieDao.findByCotation(pCotation);
    }

    @Transactional
    public List<Voie> findAll() {
        return voieDao.findAll();
    }

    @Transactional
    public int create(final Voie pVoie) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return voieDao.create(pVoie);
            }
        });
    }

    @Transactional
    public int update(final Voie pVoie) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return voieDao.update(pVoie);
            }
        });
    }

    @Transactional
    public void delete(final Voie pVoie) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                voieDao.delete(pVoie);
            }
        });
    }
}
