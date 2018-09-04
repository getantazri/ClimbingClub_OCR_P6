package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.ISpotBo;
import com.antazri.climbingclub.consumer.contract.ISpotDao;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Implémentation de l'interface ISpotBo. SpotBo permet de transférer les données, récupérées avec l'objet SpotDao de la couche consumer,
 * via le transactionManager aux Services du module Webapp
 *
 * @author Anthony T
 * @version 1.0
 */
public class SpotBo extends AbstractBo implements ISpotBo {

    @Autowired
    private ISpotDao spotDao;

    /**
     * La méthode findById permet de récupérer un objet Spot via le SpotDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pId est l'identifiant de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Spot retourné par la couche DAO
     */
    @Transactional
    public Spot findById(int pId) {
        return spotDao.findById(pId);
    }

    /**
     * La méthode findByName permet de récupérer un objet Spot via le SpotDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pName est le nom de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Spot retourné par la couche DAO
     */
    @Transactional
    public Spot findByName(String pName) {
        return spotDao.findByName(pName);
    }

    /**
     * La méthode findByTopo permet de récupérer des objets Spot via le SpotDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pTopo est l'objet Topo permettant de filtrer les instances que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Spot retournée par la couche DAO
     */
    @Transactional
    public List<Spot> findByTopo(Topo pTopo) {
        return spotDao.findByTopo(pTopo);
    }

    /**
     * La méthode findByHauteur permet de récupérer des objets Spot via le SpotDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pHauteur est un entier permettant de filtrer les instances que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Spot retournée par la couche DAO
     */
    @Transactional
    public List<Spot> findByHauteur(int pHauteur) {
        return spotDao.findByHauteur(pHauteur);
    }

    /**
     * La méthode findAll permet de récupérer l'ensemble des instances de Spot via le SpotDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @return une List d'objets Spot retournée par la couche DAO
     */
    @Transactional
    public List<Spot> findAll() {
        return spotDao.findAll();
    }

    /**
     * La méthode create permet de créer une instance Spot via le SpotDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pSpot est un objet Spot que l'on souhaite enregistrer dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int create(final Spot pSpot) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return spotDao.create(pSpot);
            }
        });
    }

    /**
     * La méthode update permet de mettre à jour une instance Spot via le SpotDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pSpot est un objet Spot que l'on souhaite modifier dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int update(final Spot pSpot) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return spotDao.update(pSpot);
            }
        });
    }

    /**
     * La méthode delete permet de supprimer une instance Spot via le SpotDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pSpot est un objet Spot que l'on souhaite supprimer dans la base de données
     */
    @Transactional
    public void delete(final Spot pSpot) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                spotDao.delete(pSpot);
            }
        });
    }
}
