package com.antazri.climbingclub.business.bo.impl;

import com.antazri.climbingclub.business.bo.contract.IUtilisateurBo;
import com.antazri.climbingclub.consumer.contract.IUtilisateurDao;
import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class UtilisateurBo implements IUtilisateurBo {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Autowired
    private IUtilisateurDao utilisateurDao;

    public Utilisateur findById(int pId) {
        return utilisateurDao.findById(pId);
    }

    public List<Utilisateur> findByStatut(Statut pStatut) {
        return utilisateurDao.findByStatut(pStatut);
    }

    public Utilisateur findByName(String pName) {
        return utilisateurDao.findByName(pName);
    }

    public Utilisateur findByPseudo(String pPseudo) {
        return utilisateurDao.findByPseudo(pPseudo);
    }

    public List<Utilisateur> containsName(String pName) {
        return utilisateurDao.containsName(pName);
    }

    public List<Utilisateur> containsPseudo(String pPseudo) {
        return utilisateurDao.containsPseudo(pPseudo);
    }

    public List<Utilisateur> findAll() {
        return utilisateurDao.findAll();
    }

    public int create(final Utilisateur pUtilisateur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return utilisateurDao.create(pUtilisateur);
            }
        });
    }

    public int update(final Utilisateur pUtilisateur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(platformTransactionManager);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return utilisateurDao.update(pUtilisateur);
            }
        });
    }

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
