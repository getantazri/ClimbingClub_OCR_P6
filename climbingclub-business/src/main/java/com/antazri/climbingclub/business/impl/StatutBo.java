package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.IStatutBo;
import com.antazri.climbingclub.consumer.contract.IStatutDao;
import com.antazri.climbingclub.model.beans.Statut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Implémentation de l'interface IStatutBo. StatutBo permet de transférer les données, récupérées avec l'objet StatutDao de la couche consumer,
 * via le transactionManager aux Services du module Webapp
 *
 * @author Anthony T
 * @version 1.0
 */
public class StatutBo extends AbstractBo implements IStatutBo {

    @Autowired
    private IStatutDao statutDao;

    /**
     * La méthode findById permet de récupérer un objet Statut via le StatutDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pId est l'identifiant de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Statut retourné par la couche DAO
     */
    @Transactional
    public Statut findById(int pId) {
        return statutDao.findById(pId);
    }

    /**
     * La méthode findByName permet de récupérer un objet Statut via le StatutDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pName est le nom de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Statut retourné par la couche DAO
     */
    @Transactional
    public Statut findByName(String pName) {
        return statutDao.findByName(pName);
    }

    /**
     * La méthode findAll permet de récupérer l'ensemble des instances de Statut via le StatutDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @return une List d'objets Statut retournée par la couche DAO
     */
    @Transactional
    public List<Statut> findAll() {
        return statutDao.findAll();
    }

    /**
     * La méthode create permet de créer un objet Statut via le StatutDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pStatut est un objet que l'on souhaite enregistrer dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int create(final Statut pStatut) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return statutDao.create(pStatut);
            }
        });
    }

    /**
     * La méthode update permet de mettre à jour un objet Statut via le StatutDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pStatut est un objet que l'on souhaite modifier dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int update(final Statut pStatut) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return statutDao.update(pStatut);
            }
        });
    }

    /**
     * La méthode delete permet de supprimer un objet Statut via le StatutDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pStatut est un objet que l'on souhaite supprimer dans la base de données
     */
    @Transactional
    public void delete(final Statut pStatut) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                statutDao.delete(pStatut);
            }
        });
    }
}
