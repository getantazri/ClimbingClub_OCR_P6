package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.ISecteurBo;
import com.antazri.climbingclub.business.contract.ISpotBo;
import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.webapp.services.contract.IGestionSpotService;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Implémentation de l'interface IGestionSecteurService. GestionSecteurService permet à la WebApp d'utiliser les Business Objects pour récupérer ou envoyer des objets/données,
 * liés à la fonctionnalité permettant de gérer les objets Spot de l'application, à la base de données.
 *
 * @author Anthony T
 * @version 1.0
 */
public class GestionSpotService implements IGestionSpotService {

    @Autowired
    private ISpotBo spotBo;

    @Autowired
    private IGestionTopoService gestionTopoService;

    @Autowired
    private ISecteurBo secteurBo;

    /**
     * La méthode findSpotById permet de récupérer un objet Spot grâce à son identifiant unique via l'objet SpotBo. L'objet GestionTopoService permet de récupérer un objet Topo
     * constituant l'attribut Topo de l'objet Spot et de constituer un objet complet avec ses dépendances que sont Region et Utilisateur. Ces Business Object et Service sont automatiquement
     * injectés par Spring via les annotations @Autowired
     * @param pId est un Integer spécifiant l'identifiant unique de l'objet Spot à récupérer
     * @return un objet Spot configuré et retourné par la couche Business
     */
    public Spot findSpotById(int pId) {
        Spot spot = spotBo.findById(pId);
        spot.setTopo(gestionTopoService.findTopoById(spot.getTopo().getTopoId()));

        return spot;
    }

    /**
     * La méthode findSpotById permet de récupérer un objet Spot grâce à son attribut SpotNom via l'objet SpotBo. L'objet GestionTopoService permet de récupérer un objet Topo
     * constituant l'attribut Topo de l'objet Spot et de constituer un objet complet avec ses dépendances que sont Region et Utilisateur. Ces Business Object et Service sont automatiquement
     * injectés par Spring via les annotations @Autowired
     * @param pName est un String spécifiant l'attribut SpotNom de l'objet Spot à récupérer
     * @return un objet Spot configuré et retourné par la couche Business
     */
    public Spot findSpotByName(String pName) {
        Spot spot = spotBo.findByName(pName);
        spot.setTopo(gestionTopoService.findTopoById(spot.getTopo().getTopoId()));

        return spot;
    }

    /**
     * La méthode findSpotByTopo permet de récupérer un objet Spot grâce à son attribut Topo via l'objet SpotBo. L'objet GestionTopoService permet de récupérer un objet Topo
     * constituant l'attribut Topo de l'objet Spot et de constituer un objet complet avec ses dépendances que sont Region et Utilisateur. Ces Business Object et Service sont automatiquement
     * injectés par Spring via les annotations @Autowired
     * @param pTopo est un objet Topo spécifiant l'attribut Topo de l'objet Spot à récupérer
     * @return une List d'objets Spot configurés retournée par la couche Business
     */
    public List<Spot> findSpotByTopo(Topo pTopo) {
        List<Spot> spots = spotBo.findByTopo(pTopo);

        for(Spot spot : spots) {
            spot.setTopo(gestionTopoService.findTopoById(spot.getTopo().getTopoId()));
        }

        return spots;
    }

    /**
     * La méthode findAllSpot permet de récupérer toutes les occurences de Spot via l'objet SpotBo. L'objet GestionTopoService permet de récupérer un objet Topo
     * constituant l'attribut Topo de l'objet Spot et de constituer un objet complet avec ses dépendances que sont Region et Utilisateur. Ces Business Object et Service sont automatiquement
     * injectés par Spring via les annotations @Autowired
     * @return une List d'objets Spot configurés retournée par la couche Business
     */
    public List<Spot> findAllSpot() {
        List<Spot> spots = spotBo.findAll();

        for(Spot spot : spots) {
            spot.setTopo(gestionTopoService.findTopoById(spot.getTopo().getTopoId()));
        }

        return spots;
    }

    /**
     * La méthode addSpot permet de créer un objet Spot grâce via l'objet SpotBo. La méthode utilise en paramètres tous les éléments qui vont constituer les
     * attributs de l'objet pour l'instancier et le transférer aux couches inférieures (dont la DAO) via l'objet, automatiquement instancié par Spring, SpotBo
     * @param pName est un String définissant l'attribut SpotNom de l'objet Spot
     * @param pDescription est un String définissant l'attribut SpotDescription de l'objet Spot
     * @param pHauteur est un Integer définissant l'attribut Hauteur de l'objet Spot
     * @param pTopoId est un Integer définissant l'identifiant unique de l'attribut Topo de l'objet Spot
     * @return un Integer spécifiant le nombre de lignes ajoutées dans la base de données
     */
    public int addSpot(String pName, String pDescription, int pHauteur, int pTopoId) {
        Spot spot = new Spot();
        spot.setSpotNom(pName);
        spot.setSpotDescription(pDescription);
        spot.setHauteur(pHauteur);
        spot.setTopo(gestionTopoService.findTopoById(pTopoId));

        return spotBo.create(spot);
    }

    /**
     * La méthode updateSpot permet de mettre à jour un objet Spot grâce via l'objet SpotBo. La méthode utilise en paramètres tous les éléments qui vont constituer les
     * attributs de l'objet pour l'instancier et le transférer aux couches inférieures (dont la DAO) via l'objet, automatiquement instancié par Spring, SpotBo
     * @param pSpotId est un Integer définissant l'identifiant unique de l'objet Spot
     * @param pName est un String définissant l'attribut SpotNom de l'objet Spot
     * @param pDescription est un String définissant l'attribut SpotDescription de l'objet Spot
     * @param pHauteur est un Integer définissant l'attribut Hauteur de l'objet Spot
     * @return un Integer spécifiant le nombre de lignes modifiées dans la base de données
     */
    public int updateSpot(int pSpotId, String pName, String pDescription, int pHauteur) {
        Spot spot = spotBo.findById(pSpotId);
        spot.setSpotNom(pName);
        spot.setSpotDescription(pDescription);
        spot.setHauteur(pHauteur);

        return spotBo.update(spot);
    }

    /**
     * La méthode deleteSpot permet de supprimer un objet Spot grâce via l'objet SpotBo. La méthode utilise en paramètres tous les éléments qui vont constituer les
     * attributs de l'objet et le supprimer via les couches inférieures (dont la DAO) grâce à l'objet, automatiquement instancié par Spring, SpotBo
     * @param pSpotId est un Integer définissant l'identifiant unique de l'objet Spot
     * @return un Integer spécifiant si oui ou non la ligne a été supprimée dans la base de données
     */
    public int deleteSpot(int pSpotId) {
        List<Secteur> secteurs = hasSecteurs(spotBo.findById(pSpotId));

        if (secteurs.isEmpty()) {
            spotBo.delete(spotBo.findById(pSpotId));
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * La méthode hasSecteurs permet de savoir si l'objet Spot est lié, via l'attribut SpotId (qui est la clé étrangère) des objets Secteur. La méthode va vérifier que
     * l'objet n'est pas utilisé en tant qu'attribut (qu'aucun Id n'est défini comme clé étrangère) avant d'appeler le business object et de valider la suppression.
     * @param pSpot est l'objet Spot qui constitue l'attribut Spot de l'objet Secteur
     * @return une List d'objets Secteur
     */
    @Override
    public List<Secteur> hasSecteurs(Spot pSpot) {

        return secteurBo.findBySpot(pSpot);
    }
}
