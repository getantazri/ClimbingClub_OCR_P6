package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.consumer.contract.ITopoDao;
import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Implémentation de l'interface ITopoBo. TopoBo permet de transférer les données, récupérées avec l'objet TopoDao de la couche consumer,
 * via le transactionManager aux Services du module Webapp
 *
 * @author Anthony T
 * @version 1.0
 */
public class TopoBo extends AbstractBo implements ITopoBo {

    @Autowired
    private ITopoDao topoDao;

    /**
     * La méthode findById permet de récupérer un objet Topo via le TopoDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pId est l'identifiant de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Topo retourné par la couche DAO
     */
    @Transactional
    public Topo findById(int pId) {
        return topoDao.findById(pId);
    }

    /**
     * La méthode findByUser permet de récupérer des objets Topo via le TopoDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pUtilisateur est un objet Utilisateur permettant de filtrer les instances de Topo que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Topo retournée par la couche DAO
     */
    @Transactional
    public List<Topo> findByUser(Utilisateur pUtilisateur) {
        return topoDao.findByUser(pUtilisateur);
    }

    /**
     * La méthode findByName permet de récupérer un objet Topo via le TopoDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pName est le nom de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Topo retourné par la couche DAO
     */
    @Transactional
    public Topo findByName(String pName) {
        return topoDao.findByName(pName);
    }

    /**
     * La méthode findByRegion permet de récupérer des objets Topo via le TopoDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pRegion est un objet Region permettant de filtrer les instances de Topo que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Topo retournée par la couche DAO
     */
    @Transactional
    public List<Topo> findByRegion(Region pRegion) throws EmptyResultDataAccessException{
        try {
            return topoDao.findByRegion(pRegion);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * La méthode findAll permet de récupérer l'ensemble des instances de Topo via le TopoDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @return une List d'objets Topo retournée par la couche DAO
     */
    @Transactional
    public List<Topo> findAll() {
        return topoDao.findAll();
    }

    /**
     * La méthode create permet de créer une instance de Topo via le TopoDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pTopo est un objet Topo que l'on souhaite enregistrer dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int create(final Topo pTopo) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return topoDao.create(pTopo);
            }
        });
    }

    /**
     * La méthode update permet de mettre à jour une instance de Topo via le TopoDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pTopo est un objet Topo que l'on souhaite modifier dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int update(final Topo pTopo) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return topoDao.update(pTopo);
            }
        });
    }

    /**
     * La méthode delete permet de supprimer une instance de Topo via le TopoDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans la base de données
     * @param pTopo est un objet Topo que l'on souhaite supprimer dans la base de données
     */
    @Transactional
    public void delete(final Topo pTopo) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                topoDao.delete(pTopo);
            }
        });
    }
}
