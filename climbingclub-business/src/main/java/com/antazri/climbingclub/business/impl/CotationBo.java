package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.ICotationBo;
import com.antazri.climbingclub.consumer.contract.ICotationDao;
import com.antazri.climbingclub.model.beans.Cotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * Implémentation de l'interface ICotationBo. CotationBo permet de transférer les données, récupérées avec l'objet CotationDao de la couche consumer,
 * via le transactionManager aux Services du module Webapp
 *
 * @author Anthony T
 * @version 1.0
 */
public class CotationBo extends AbstractBo implements ICotationBo {

    @Autowired
    private ICotationDao cotationDao;

    /**
     * La méthode findById permet de récupérer un objet Cotation via le CotationDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pId est l'identifiant de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Cotation retourné par la couche DAO
     */
    @Transactional
    public Cotation findById(int pId) {
        return cotationDao.findById(pId);
    }

    /**
     * La méthode findByName permet de récupérer un objet Cotation via le CotationDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pName est le nom de l'objet que l'on souhaite récupérer dans la base de données
     * @return un objet Cotation retourné par la couche DAO
     */
    @Transactional
    public Cotation findByName(String pName) {
        return cotationDao.findByName(pName);
    }

    /**
     * La méthode findByName permet de récupérer toutes les instances de Cotation via le CotationDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @return une List d'objets Cotation retournée par la couche DAO
     */
    @Transactional
    public List<Cotation> findAll() {
        return cotationDao.findAll();
    }

    /**
     * La méthode create permet d'enregistrer une instance de Cotation via le CotationDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pCotation est l'instance de Cotation à enregistrer dans la base de données
     * @return un entier (1 ou 0) qui définira si une nouvelle ligne a été crée ou non
     */
    @Transactional
    public int create(final Cotation pCotation) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return cotationDao.create(pCotation);
            }
        });
    }

    /**
     * La méthode update permet de mettre à jour une instance de Cotation via le CotationDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pCotation est l'instance de Cotation à modifier dans la base de données
     * @return un entier (1 ou 0) qui définira si une ligne a été modifiée ou non
     */
    @Transactional
    public int update(final Cotation pCotation) {
        TransactionTemplate vTransactionTemplate = new TransactionTemplate(getTransactionManager());
        return vTransactionTemplate.execute(new TransactionCallback<Integer>() {
            public Integer doInTransaction(TransactionStatus status) {
                return cotationDao.update(pCotation);
            }
        });
    }

    /**
     * La méthode delete permet de supprimer une instance de Cotation via le CotationDao affecté via @Autowired. L'annotation @Transactionnel permet de spécifié à Spring que des
     * données seront transférées dans et depuis la base de données
     * @param pCotation est l'instance de Cotation à supprimer dans la base de données
     */
    @Transactional
    public void delete(final Cotation pCotation) {
        TransactionTemplate vTranscationTemplate = new TransactionTemplate(getTransactionManager());
        vTranscationTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                cotationDao.delete(pCotation);
            }
        });
    }
}
