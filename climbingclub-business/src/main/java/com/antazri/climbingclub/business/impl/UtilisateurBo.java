package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.consumer.contract.IUtilisateurDao;
import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Implémentation de l'interface IUtilisateurBo. UtilisateurBo permet de transférer les données, récupérées avec l'objet UtilisateurDao de la couche consumer,
 * via le transactionManager aux Services du module Webapp
 *
 * @author Anthony T
 * @version 1.0
 */
public class UtilisateurBo extends AbstractBo implements IUtilisateurBo {

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
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return utilisateurDao.create(pUtilisateur);
            }
        });
    }

    @Transactional
    public int update(final Utilisateur pUtilisateur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return utilisateurDao.update(pUtilisateur);
            }
        });
    }

    @Transactional
    public void delete(final Utilisateur pUtilisateur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                utilisateurDao.delete(pUtilisateur);
            }
        });
    }
}
