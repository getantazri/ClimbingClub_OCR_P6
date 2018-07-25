package com.antazri.climbingclub.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.antazri.climbingclub.business.contract.IVoieBo;
import com.antazri.climbingclub.consumer.contract.IVoieDao;
import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;

public class VoieBo implements IVoieBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

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
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return voieDao.create(pVoie);
            }
        });
    }

    @Transactional
    public int update(final Voie pVoie) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return voieDao.update(pVoie);
            }
        });
    }

    @Transactional
    public void delete(final Voie pVoie) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                voieDao.delete(pVoie);
            }
        });
    }
}
