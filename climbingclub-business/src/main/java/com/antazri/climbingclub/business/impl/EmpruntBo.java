package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.IEmpruntBo;
import com.antazri.climbingclub.consumer.contract.IEmpruntDao;
import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Implémentation de l'interface IEmpruntBo. EmpruntBo permet de transférer les données, récupérées avec l'objet EmpruntDao de la couche consumer,
 * via le transactionManager aux Services du module Webapp
 *
 * @author Anthony T
 * @version 1.0
 */
public class EmpruntBo extends AbstractBo implements IEmpruntBo {

    @Autowired
    private IEmpruntDao empruntDao;

    /**
     * La méthode findById permet de récupérer un objet Emprunt via le EmpruntDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pId est l'identifiant de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Emprunt retourné par la couche DAO
     */
    @Transactional
    public Emprunt findById(int pId) {
        return empruntDao.findById(pId);
    }

    /**
     * La méthode findById permet de récupérer un objet Emprunt via le EmpruntDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pUtilisateur est un objet Utilisateur permettant de filtrer les instances que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Emprunt retournée par la couche DAO
     */
    @Transactional
    public List<Emprunt> findByUtilisateur(Utilisateur pUtilisateur) {
        return empruntDao.findByUtilisateur(pUtilisateur);
    }

    /**
     * La méthode findByTopo permet de récupérer des objets Emprunt via le EmpruntDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pTopo est un objet Topo permettant de filtrer les instances que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Emprunt retournée par la couche DAO
     */
    @Transactional
    public List<Emprunt> findByTopo(Topo pTopo) {
        return empruntDao.findByTopo(pTopo);
    }

    /**
     * La méthode findAll permet de récupérer l'ensemble des objets Emprunt via le EmpruntDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @return une List d'objets Emprunt retournée par la couche DAO
     */
    @Transactional
    public List<Emprunt> findAll() {
        return empruntDao.findAll();
    }

    /**
     * La méthode create permet de créer une instance de Emprunt via le EmpruntDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pEmprunt est un objet Emprunt que l'on souhaite enregistrer dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int create(final Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return empruntDao.create(pEmprunt);
            }
        });
    }

    /**
     * La méthode update permet de mettre à jour une instance de Emprunt via le EmpruntDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pEmprunt est un objet Emprunt que l'on souhaite modifier dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int update(final Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return empruntDao.update(pEmprunt);
            }
        });
    }

    /**
     * La méthode delete permet de supprimer une instance de Emprunt via le EmpruntDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pEmprunt est un objet Emprunt que l'on souhaite supprimer dans la base de données
     */
    @Transactional
    public void delete(final Emprunt pEmprunt) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                empruntDao.delete(pEmprunt);
            }
        });
    }
}
