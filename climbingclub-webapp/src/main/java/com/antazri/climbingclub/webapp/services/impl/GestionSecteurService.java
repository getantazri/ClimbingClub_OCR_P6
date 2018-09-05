package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.ISecteurBo;
import com.antazri.climbingclub.business.contract.ISpotBo;
import com.antazri.climbingclub.business.contract.IVoieBo;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Voie;
import com.antazri.climbingclub.webapp.services.contract.IGestionSecteurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionSpotService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Implémentation de l'interface IGestionSecteurService. GestionSecteurService permet à la WebApp d'utiliser les Business Objects pour récupérer ou envoyer des objets/données,
 * liés à la fonctionnalité permettant de gérer les objets Secteur de l'application, à la base de données.
 *
 * @author Anthony T
 * @version 1.0
 */
public class GestionSecteurService implements IGestionSecteurService {

    @Autowired
    private ISecteurBo secteurBo;

    @Autowired
    private IVoieBo voieBo;

    @Autowired
    private IGestionSpotService gestionSpotService;

    /**
     * La méthode findSecteurById permet de récupérer un objet Secteur grâce à son identifiant unique via l'objet SecteurBo. L'objet GestionSpotService permet de récupérer un objet Spot
     * constituant l'attribut Spot de l'objet Secteur et d'affecter un objet complet avec sa dépendance Topo. Ces Business Object et Service sont automatiquement
     * injectés par Spring via les annotations @Autowired
     * @param pId est un Integer spécifiant l'identifiant unique de l'objet Secteur à récupérer
     * @return un objet Secteur configuré et retourné par la couche Business
     */
    public Secteur findSecteurById(int pId) {
        Secteur secteur = secteurBo.findById(pId);
        secteur.setSpot(gestionSpotService.findSpotById(secteur.getSpot().getSpotId()));

        return secteur;
    }

    /**
     * La méthode findSecteurBySpot permet de récupérer un objet Secteur grâce à son attribut Spot via l'objet SecteurBo. L'objet GestionSpotService permet de récupérer un objet Spot
     * constituant l'attribut Spot de l'objet Secteur et d'affecter un objet complet avec sa dépendance Topo. Ces Business Object et Service sont automatiquement
     * injectés par Spring via les annotations @Autowired
     * @param pSpot est un objet Spot spécifiant l'attribut Spot de l'objet Secteur à récupérer
     * @return une List d'objets Secteur configurés retournée par la couche Business
     */
    public List<Secteur> findSecteurBySpot(Spot pSpot) {
        List<Secteur> secteurs = secteurBo.findBySpot(pSpot);

        for(Secteur secteur : secteurs) {
            secteur.setSpot(gestionSpotService.findSpotById(secteur.getSpot().getSpotId()));
        }

        return secteurs;
    }

    /**
     * La méthode findSecteurByName permet de récupérer un objet Secteur grâce à son attribut SecteurNom via l'objet SecteurBo. L'objet GestionSpotService permet de récupérer un objet Spot
     * constituant l'attribut Spot de l'objet Secteur et d'affecter un objet complet avec sa dépendance Topo. Ces Business Object et Service sont automatiquement
     * injectés par Spring via les annotations @Autowired
     * @param pName est un String spécifiant l'attribut SecteurNom de l'objet Secteur à récupérer
     * @return un objet Secteur configuré et retourné par la couche Business
     */
    public Secteur findSecteurByName(String pName) {
        Secteur secteur = secteurBo.findByName(pName);
        secteur.setSpot(gestionSpotService.findSpotById(secteur.getSpot().getSpotId()));

        return secteur;
    }

    /**
     * La méthode findSpotByName permet de récupérer toutes les occurences de Secteur via l'objet SecteurBo. L'objet GestionSpotService permet de récupérer un objet Spot
     * constituant l'attribut Spot de l'objet Secteur et d'affecter un objet complet avec sa dépendance Topo. Ces Business Object et Service sont automatiquement
     * injectés par Spring via les annotations @Autowired
     * @return une List d'objets Secteur configurés retournée par la couche Business
     */
    public List<Secteur> findAllSecteur() {
        List<Secteur> secteurs = secteurBo.findAll();

        for(Secteur secteur : secteurs) {
            secteur.setSpot(gestionSpotService.findSpotById(secteur.getSpot().getSpotId()));
        }

        return secteurs;
    }

    /**
     * La méthode addSecteur permet de créer un nouvel objet Secteur via l'objet SecteurBo. GestionSpotService permet de récupérer un objet Spot
     * constituant l'attribut Spot de Secteur et d'affecter une instance avec sa dépendance Topo. Ces Business Object et Service sont automatiquement
     * injectés par Spring via les annotations @Autowired
     * @param pName est un String spécifiant l'attribut SecteurNom de l'objet Secteur
     * @param pSpotId est un Integer définissant l'identifiant unique de l'attribut Spot de l'objet Secteur
     * @return un Integer spécifiant le nombre de lignes ajoutées dans la base de données
     */
    public int addSecteur(String pName, int pSpotId) {
        Secteur secteur = new Secteur();
        secteur.setSecteurNom(pName);
        secteur.setSpot(gestionSpotService.findSpotById(pSpotId));

        return secteurBo.create(secteur);
    }

    /**
     * La méthode updateSecteur permet de créer un nouvel objet Secteur via l'objet SecteurBo. GestionSpotService permet de récupérer un objet Spot
     * constituant l'attribut Spot de Secteur et d'affecter une instance avec sa dépendance Topo. Ces Business Object et Service sont automatiquement
     * injectés par Spring via les annotations @Autowired
     * @param pSecteurId est un Integer spécifiant l'identifiant unique de l'objet Secteur
     * @param pName est un String spécifiant l'attribut SecteurNom de l'objet Secteur
     * @return un Integer spécifiant le nombre de lignes ajoutées dans la base de données
     */
    public int updateSecteur(int pSecteurId, String pName) {
        Secteur secteur = secteurBo.findById(pSecteurId);
        secteur.setSecteurNom(pName);

        return secteurBo.update(secteur);
    }

    /**
     * La méthode deleteSecteur permet de supprimer Secteur via l'objet SecteurBo. La méthode va vérifier que l'objet n'est pas utilisé en tant qu'attribut (qu'aucun Id n'est défini
     * comme clé étrangère) avant d'appeler le business object et de valider la suppression.
     * @param pSecteurId est un Integer spécifiant l'identifiant unique de l'objet Secteur
     * @return un Integer spécifiant si oui ou non la ligne a été supprimée dans la base de données
     */
    public int deleteSecteur(int pSecteurId) {
        List<Voie> voies = hasVoies(secteurBo.findById(pSecteurId));

        if (voies.isEmpty()) {
            secteurBo.delete(secteurBo.findById(pSecteurId));
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<Voie> hasVoies(Secteur pSecteur) {

        return voieBo.findBySecteur(pSecteur);
    }
}
