package com.antazri.climbingclub.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.antazri.climbingclub.business.contract.IEmpruntBo;
import com.antazri.climbingclub.consumer.contract.IEmpruntDao;
import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

public class EmpruntBo implements IEmpruntBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private IEmpruntDao empruntDao;

    @Transactional
    public Emprunt findById(int pId) {
        return empruntDao.findById(pId);
    }

    @Transactional
    public List<Emprunt> findByUtilisateur(Utilisateur pUtilisateur) {
        return empruntDao.findByUtilisateur(pUtilisateur);
    }

    @Transactional
    public List<Emprunt> findByTopo(Topo pTopo) {
        return empruntDao.findByTopo(pTopo);
    }

    @Transactional
    public List<Emprunt> findAll() {
        return empruntDao.findAll();
    }

    @Transactional
    public int create(final Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return empruntDao.create(pEmprunt);
            }
        });
    }

    @Transactional
    public int update(final Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return empruntDao.update(pEmprunt);
            }
        });
    }

    @Transactional
    public void delete(final Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                empruntDao.delete(pEmprunt);
            }
        });
    }
}
