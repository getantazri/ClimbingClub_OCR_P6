package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.ISecteurBo;
import com.antazri.climbingclub.consumer.contract.ISecteurDao;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Implémentation de l'interface ISecteurBo. SecteurBo permet de transférer les données, récupérées avec l'objet SecteurDao de la couche consumer,
 * via le transactionManager aux Services du module Webapp
 *
 * @author Anthony T
 * @version 1.0
 */
public class SecteurBo extends AbstractBo implements ISecteurBo {

    @Autowired
    private ISecteurDao secteurDao;

    /**
     * La méthode findById permet de récupérer un objet Secteur via le SecteurDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pId est l'identifiant de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Secteur retourné par la couche DAO
     */
    @Transactional
    public Secteur findById(int pId) {
        return secteurDao.findById(pId);
    }

    /**
     * La méthode findBySpot permet de récupérer des objets Secteur via le SecteurDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pSpot est un objet Spot permettant de filtrer les instances que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Secteur retournée par la couche DAO
     */
    @Transactional
    public List<Secteur> findBySpot(Spot pSpot) {
        return secteurDao.findBySpot(pSpot);
    }

    /**
     * La méthode findByName permet de récupérer un objet Secteur via le SecteurDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pName est le nom de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Secteur retourné par la couche DAO
     */
    @Transactional
    public Secteur findByName(String pName) {
        return secteurDao.findByName(pName);
    }

    /**
     * La méthode findAll permet de récupérer l'ensemble des objets Secteur via le SecteurDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @return une List d'objets Secteur retournée par la couche DAO
     */
    @Transactional
    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }

    /**
     * La méthode create permet de créer une instance de Secteur via le SecteurDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pSecteur est un objet Secteur que l'on souhaite enregistrer dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int create(final Secteur pSecteur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return secteurDao.create(pSecteur);
            }
        });
    }

    /**
     * La méthode update permet de mettre à jour une instance de Secteur via le SecteurDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pSecteur est un objet Secteur que l'on souhaite modifier dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int update(final Secteur pSecteur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return secteurDao.update(pSecteur);
            }
        });
    }

    /**
     * La méthode delete permet de supprimer une instance de Secteur via le SecteurDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pSecteur est un objet Secteur que l'on souhaite supprimer dans la base de données
     */
    @Transactional
    public void delete(final Secteur pSecteur) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                secteurDao.delete(pSecteur);
            }
        });
    }
}
