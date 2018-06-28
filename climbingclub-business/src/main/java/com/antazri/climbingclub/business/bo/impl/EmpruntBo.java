package com.antazri.climbingclub.business.bo.impl;

import com.antazri.climbingclub.business.bo.contract.IEmpruntBo;
import com.antazri.climbingclub.consumer.contract.IEmpruntDao;
import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class EmpruntBo implements IEmpruntBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private IEmpruntDao empruntDao;

    public Emprunt findById(int pId) {
        return empruntDao.findById(pId);
    }

    public List<Emprunt> findByUtilisateur(Utilisateur pUtilisateur) {
        return empruntDao.findByUtilisateur(pUtilisateur);
    }

    public List<Emprunt> findByTopo(Topo pTopo) {
        return empruntDao.findByTopo(pTopo);
    }

    public List<Emprunt> findAll() {
        return empruntDao.findAll();
    }

    public int create(final Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return empruntDao.create(pEmprunt);
            }
        });
    }

    public int update(final Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return empruntDao.update(pEmprunt);
            }
        });
    }

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
