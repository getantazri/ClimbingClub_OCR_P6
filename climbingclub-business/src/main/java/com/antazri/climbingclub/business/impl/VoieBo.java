package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.IVoieBo;
import com.antazri.climbingclub.consumer.contract.IVoieDao;
import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Implémentation de l'interface IVoieBo. VoieBo permet de transférer les données, récupérées avec l'objet VoieDao de la couche consumer,
 * via le transactionManager aux Services du module Webapp
 *
 * @author Anthony T
 * @version 1.0
 */
public class VoieBo extends AbstractBo implements IVoieBo {

    @Autowired
    private IVoieDao voieDao;

    /**
     * La méthode findById permet de récupérer un objet Voie via le VoieDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pId est l'identifiant de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Voie retourné par la couche DAO
     */
    @Transactional
    public Voie findById(int pId) {
        return voieDao.findById(pId);
    }

    /**
     * La méthode findByName permet de récupérer un objet Voie via le VoieDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pName est l'identifiant de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Voie retourné par la couche DAO
     */
    @Transactional
    public Voie findByName(String pName) {
        return voieDao.findByName(pName);
    }

    /**
     * La méthode findBySecteur permet de récupérer des objets Voie via le VoieDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pSecteur est l'instance de Secteur qui permettra de filtrer que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Voie retournée par la couche DAO
     */
    @Transactional
    public List<Voie> findBySecteur(Secteur pSecteur) {
        return voieDao.findBySecteur(pSecteur);
    }

    /**
     * La méthode findByCotation permet de récupérer des objets Voie via le VoieDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pCotation est l'instance de Cotation qui permettra de filtrer que l'on souhaite récupérer dans la base de données
     * @return une List d'objets Voie retournée par la couche DAO
     */
    @Transactional
    public List<Voie> findByCotation(Cotation pCotation) {
        return voieDao.findByCotation(pCotation);
    }

    /**
     * La méthode findAll permet de récupérer toutes les instances de Voie via le VoieDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @return une List d'objets Voie retournée par la couche DAO
     */
    @Transactional
    public List<Voie> findAll() {
        return voieDao.findAll();
    }

    /**
     * La méthode create permet d'enregistrer une instance de Voie via le VoieDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pVoie est l'instance de Voie qui sera enregistrée dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int create(final Voie pVoie) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return voieDao.create(pVoie);
            }
        });
    }

    /**
     * La méthode update permet de mettre à jour une instance de Voie via le VoieDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pVoie est l'instance de Voie qui sera modifiée dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int update(final Voie pVoie) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return voieDao.update(pVoie);
            }
        });
    }

    /**
     * La méthode delete permet de supprimer une instance de Voie via le VoieDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pVoie est l'instance de Voie qui sera supprimée dans la base de données
     */
    @Transactional
    public void delete(final Voie pVoie) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                voieDao.delete(pVoie);
            }
        });
    }
}
