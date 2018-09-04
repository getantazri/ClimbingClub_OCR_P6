package com.antazri.climbingclub.business.impl;

import com.antazri.climbingclub.business.contract.IRechercheBo;
import com.antazri.climbingclub.consumer.contract.IRechercheDao;
import com.antazri.climbingclub.model.beans.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implémentation de l'interface IRechercheBo. RechercheBo permet de transférer les données, récupérées avec l'objet RechercheDao de la couche consumer,
 * via le transactionManager aux Services du module Webapp
 *
 * @author Anthony T
 * @version 1.0
 */
public class RechercheBo implements IRechercheBo {

    @Autowired
    private IRechercheDao rechercheDao;

    /**
     * La méthode rechercherTopo permet de retourner l'ensemble des instances de Topo selon les paramètres via le RechercheDao affecté via @Autowired.
     * L'annotation @Transactionnel permet de spécifié à Spring que des données seront transférées depuis la base de données
     * @param pNom est le nom du ou des éléments à récupérer dans la base de données
     * @param pNomRegion est le nom de l'attribut Region affecté à un objet Topo
     * @param pNomCotation est le nom de l'attribut Cotation affecté à un objet Voie
     * @param pHauteurMin est un entier permettant de fixer la limite basse pour l'attribut Hauteur des objets Spot (qui eux-mêmes sont des attributs de Topo)
     * @param pHauteurMax est un entier permettant de fixer la limite haute pour l'attribut Hauteur des objets Spot (qui eux-mêmes sont des attributs de Topo)
     * @return une List d'objets Topo retournée par la couche DAO
     */
    @Transactional
    public List<Topo> rechercherTopo(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax) {
        return rechercheDao.rechercherTopo(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
    }

    /**
     * La méthode rechercherSpot permet de retourner l'ensemble des instances de Spot selon les paramètres via le RechercheDao affecté via @Autowired.
     * L'annotation @Transactionnel permet de spécifié à Spring que des données seront transférées depuis la base de données
     * @param pNom est le nom du ou des éléments à récupérer dans la base de données
     * @param pNomRegion est le nom de l'attribut Region affecté à un objet Topo
     * @param pNomCotation est le nom de l'attribut Cotation affecté à un objet Voie
     * @param pHauteurMin est un entier permettant de fixer la limite basse pour l'attribut Hauteur des objets Spot (qui eux-mêmes sont des attributs de Topo)
     * @param pHauteurMax est un entier permettant de fixer la limite haute pour l'attribut Hauteur des objets Spot (qui eux-mêmes sont des attributs de Topo)
     * @return une List d'objets Spot retournée par la couche DAO
     */
    @Transactional
    public List<Spot> rechercherSpot(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax) {
        return rechercheDao.rechercherSpot(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
    }

    /**
     * La méthode rechercherSecteur permet de retourner l'ensemble des instances de Secteur selon les paramètres via le RechercheDao affecté via @Autowired.
     * L'annotation @Transactionnel permet de spécifié à Spring que des données seront transférées depuis la base de données
     * @param pNom est le nom du ou des éléments à récupérer dans la base de données
     * @param pNomRegion est le nom de l'attribut Region affecté à un objet Topo
     * @param pNomCotation est le nom de l'attribut Cotation affecté à un objet Voie
     * @param pHauteurMin est un entier permettant de fixer la limite basse pour l'attribut Hauteur des objets Spot (qui eux-mêmes sont des attributs de Topo)
     * @param pHauteurMax est un entier permettant de fixer la limite haute pour l'attribut Hauteur des objets Spot (qui eux-mêmes sont des attributs de Topo)
     * @return une List d'objets Secteur retournée par la couche DAO
     */
    @Transactional
    public List<Secteur> rechercherSecteur(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax) {
        return rechercheDao.rechercherSecteur(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
    }

    /**
     * La méthode rechercherVoie permet de retourner l'ensemble des instances de Voie selon les paramètres via le RechercheDao affecté via @Autowired.
     * L'annotation @Transactionnel permet de spécifié à Spring que des données seront transférées depuis la base de données
     * @param pNom est le nom du ou des éléments à récupérer dans la base de données
     * @param pNomRegion est le nom de l'attribut Region affecté à un objet Topo
     * @param pNomCotation est le nom de l'attribut Cotation affecté à un objet Voie
     * @param pHauteurMin est un entier permettant de fixer la limite basse pour l'attribut Hauteur des objets Spot (qui eux-mêmes sont des attributs de Topo)
     * @param pHauteurMax est un entier permettant de fixer la limite haute pour l'attribut Hauteur des objets Spot (qui eux-mêmes sont des attributs de Topo)
     * @return une List d'objets Voie retournée par la couche DAO
     */
    @Transactional
    public List<Voie> rechercherVoie(String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax) {
        return rechercheDao.rechercherVoie(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
    }

    /**
     * La méthode rechercherUtilisateur permet de retourner l'ensemble des instances de Utilisateur selon le paramètre de la méthode via le RechercheDao affecté via @Autowired.
     * L'annotation @Transactionnel permet de spécifié à Spring que des données seront transférées depuis la base de données
     * @param pPseudo est un String permettant de filtrer les instances de Utilisateur selon leur attribut Pseudo
     * @return une List d'objets Utilisateur retournée par la couche DAO
     */
    @Transactional
    public List<Utilisateur> rechercherUtilisateur(String pPseudo) {
        return rechercheDao.rechercherUtilisateur(pPseudo);
    }
}
