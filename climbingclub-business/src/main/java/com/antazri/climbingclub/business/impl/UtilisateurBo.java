package com.antazri.climbingclub.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.consumer.contract.IUtilisateurDao;
import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;

public class UtilisateurBo implements IUtilisateurBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private IUtilisateurDao utilisateurDao;

    @Transactional
    public Utilisateur findById(int pId) {
        return utilisateurDao.findById(pId);
    }

    @Transactional
    public List<Utilisateur> findByStatut(Statut pStatut) {
        return utilisateurDao.findByStatut(pStatut);
    }

    @Transactional
    public Utilisateur findByName(String pName) {
        return utilisateurDao.findByName(pName);
    }

    @Transactional
    public Utilisateur findByPseudo(String pPseudo) {
        return utilisateurDao.findByPseudo(pPseudo);
    }

    @Transactional
    public List<Utilisateur> findAll() {
        return utilisateurDao.findAll();
    }

    @Transactional
    public int create(final Utilisateur pUtilisateur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return utilisateurDao.create(pUtilisateur);
            }
        });
    }

    @Transactional
    public int update(final Utilisateur pUtilisateur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return utilisateurDao.update(pUtilisateur);
            }
        });
    }

    @Transactional
    public void delete(final Utilisateur pUtilisateur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                utilisateurDao.delete(pUtilisateur);
            }
        });
    }
}
