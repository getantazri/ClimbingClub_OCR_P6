package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.consumer.contract.IRegionDao;
import com.antazri.climbingclub.model.beans.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Implémentation de l'interface IRegionBo. RegionBo permet de transférer les données, récupérées avec l'objet RegionDao de la couche consumer,
 * via le transactionManager aux Services du module Webapp
 *
 * @author Anthony T
 * @version 1.0
 */
public class RegionBo extends AbstractBo implements IRegionBo {

    @Autowired
    private IRegionDao regionDao;

    /**
     * La méthode findById permet de récupérer un objet Region via le RegionDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pId est l'identifiant de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Region retourné par la couche DAO
     */
    @Transactional
    public Region findById(int pId) {
        return regionDao.findById(pId);
    }

    /**
     * La méthode findByName permet de récupérer un objet Region via le RegionDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pName est le nom de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Region retourné par la couche DAO
     */
    @Transactional
    public Region findByName(String pName) {
        return regionDao.findByName(pName);
    }

    /**
     * La méthode findAll permet de récupérer l'ensemble des instances de Region via le SecteurDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @return une List d'objets Region retournée par la couche DAO
     */
    @Transactional
    public List<Region> findAll() {
        return regionDao.findAll();
    }

    /**
     * La méthode create permet de créer une instance de Region via le RegionDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pRegion est un objet Region que l'on souhaite enregistrer dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int create(final Region pRegion) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return regionDao.create(pRegion);
            }
        });
    }

    /**
     * La méthode update permet de mettre à jour une instance de Region via le RegionDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pRegion est un objet Region que l'on souhaite modifier dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int update(final Region pRegion) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return regionDao.update(pRegion);
            }
        });
    }

    /**
     * La méthode delete permet de supprimer une instance de Region via le RegionDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pRegion est un objet Region que l'on souhaite supprimer dans la base de données
     */
    @Transactional
    public void delete(final Region pRegion) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                regionDao.delete(pRegion);
            }
        });
    }
}
