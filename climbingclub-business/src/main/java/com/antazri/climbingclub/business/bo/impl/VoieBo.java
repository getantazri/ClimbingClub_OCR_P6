package com.antazri.climbingclub.business.bo.impl;

import com.antazri.climbingclub.business.bo.contract.IVoieBo;
import com.antazri.climbingclub.consumer.contract.IVoieDao;
import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class VoieBo implements IVoieBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private IVoieDao voieDao;

    public Voie findById(int pId) {
        return voieDao.findById(pId);
    }

    public Voie findByName(String pName) {
        return voieDao.findByName(pName);
    }

    public List<Voie> findBySecteur(Secteur pSecteur) {
        return voieDao.findBySecteur(pSecteur);
    }

    public List<Voie> findByCotation(Cotation pCotation) {
        return voieDao.findByCotation(pCotation);
    }

    public List<Voie> findAll() {
        return voieDao.findAll();
    }

    public int create(final Voie pVoie) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return voieDao.create(pVoie);
            }
        });
    }

    public int update(final Voie pVoie) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return voieDao.update(pVoie);
            }
        });
    }

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
