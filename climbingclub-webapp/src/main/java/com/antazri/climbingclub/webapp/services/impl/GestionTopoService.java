package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.business.contract.ISpotBo;
import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.model.beans.Region;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de l'interface IGestionSecteurService. GestionSecteurService permet à la WebApp d'utiliser les Business Objects pour récupérer ou envoyer des objets/données,
 * liés à la fonctionnalité permettant de gérer les objets Topo de l'application, à la base de données.
 *
 * @author Anthony T
 * @version 1.0
 */
public class GestionTopoService implements IGestionTopoService {

    @Autowired
    private ITopoBo topoBo;

    @Autowired
    private ISpotBo spotBo;

    @Autowired
    private IUtilisateurBo utilisateurBo;

    @Autowired
    private IRegionBo regionBo;

    /**
     * La méthode findTopoById permet de récupérer un objet Topo grâce à son identifiant unique via l'objet TopoBo. Les objets UtilisateurBo et RegionBo permettent de retourner
     * des objets pour les attributs Proprietaire et Region pour Topo. Ces Business Object sont automatiquement injectés par Spring via les annotations @Autowired
     * @param pId est un Integer spécifiant l'identifiant unique de l'objet Topo à récupérer
     * @return un objet Topo configuré et retourné par la couche Business
     */
    public Topo findTopoById(int pId) {
        Topo topo = topoBo.findById(pId);
        topo.setProprietaire(utilisateurBo.findById(topo.getProprietaire().getUtilisateurId()));
        topo.setRegion(regionBo.findById(topo.getRegion().getRegionId()));

        return topo;
    }

    /**
     * La méthode findTopoByUser permet de récupérer un objet Topo grâce à son attribut Proprietaire via l'objet TopoBo. Les objets UtilisateurBo et RegionBo permettent de retourner
     * des objets pour les attributs Proprietaire et Region pour Topo. Ces Business Object sont automatiquement injectés par Spring via les annotations @Autowired
     * @param pUtilisateur est un objet Utilisateur spécifiant l'attribut Utilisateur de l'objet Topo à récupérer
     * @return une List d'objets Topo configurés retournée par la couche Business
     */
    public List<Topo> findTopoByUser(Utilisateur pUtilisateur) {
        List<Topo> topos = topoBo.findByUser(pUtilisateur);

        for (Topo topo : topos) {
            topo.setProprietaire(pUtilisateur);
            topo.setRegion(regionBo.findById(topo.getRegion().getRegionId()));
        }

        return topos;
    }

    /**
     * La méthode findTopoByName permet de récupérer un objet Topo grâce à son attribut TopoNom via l'objet TopoBo. Les objets UtilisateurBo et RegionBo permettent de retourner
     * des objets pour les attributs Proprietaire et Region pour Topo. Ces Business Object sont automatiquement injectés par Spring via les annotations @Autowired
     * @param pName est un Integer spécifiant l'identifiant unique de l'objet Topo à récupérer
     * @return un objet Topo configuré et retourné par la couche Business
     */
    public Topo findTopoByName(String pName) {
        Topo topo = topoBo.findByName(pName);
        topo.setProprietaire(utilisateurBo.findById(topo.getProprietaire().getUtilisateurId()));
        topo.setRegion(regionBo.findById(topo.getRegion().getRegionId()));

        return topo;
    }

    /**
     * La méthode findTopoByRegion permet de récupérer un objet Topo grâce à son attribut Region via l'objet TopoBo. Les objets UtilisateurBo et RegionBo permettent de retourner
     * des objets pour les attributs Proprietaire et Region pour Topo. Ces Business Object sont automatiquement injectés par Spring via les annotations @Autowired
     * @param pRegion est un objet Region spécifiant l'attribut Region de l'objet Topo à récupérer
     * @return une List d'objets Topo configurés retournée par la couche Business
     */
    public List<Topo> findTopoByRegion(Region pRegion) {
        List<Topo> topos = topoBo.findByRegion(pRegion);

        for (Topo topo : topos) {
            topo.setProprietaire(utilisateurBo.findById(topo.getProprietaire().getUtilisateurId()));
            topo.setRegion(pRegion);
        }

        return topos;
    }

    /**
     * La méthode findAllTopo permet de récupérer toutes les occurences de Topo via l'objet TopoBo. Les objets UtilisateurBo et RegionBo permettent de retourner
     * des objets pour les attributs Proprietaire et Region pour Topo. Ces Business Object sont automatiquement injectés par Spring via les annotations @Autowired
     * @return une List d'objets Topo configurés retournée par la couche Business
     */
    public List<Topo> findAllTopo() {
        List<Topo> topos = topoBo.findAll();

        for (Topo topo : topos) {
            topo.setProprietaire(utilisateurBo.findById(topo.getProprietaire().getUtilisateurId()));
            topo.setRegion(regionBo.findById(topo.getRegion().getRegionId()));
        }

        return topos;
    }

    /**
     * La méthode addTopo permet de créer un objet Topo grâce via l'objet TopoBo. La méthode utilise en paramètres tous les éléments qui vont constituer les
     * attributs de l'objet pour l'instancier et le transférer aux couches inférieures (dont la DAO) via l'objet, automatiquement instancié par Spring, Topo
     * @param pName est un String définissant l'attribut TopoNom de l'objet Topo
     * @param pRegionId est un Integer définissant l'identifiant unique de l'objet et attribut Region de l'objet Topo
     * @param pUtilisateurId est un Integer définissant l'identifiant unique de l'objet et attribut Utilisateur/Proprietaire de l'objet TopoBo
     * @return un Integer spécifiant le nombre de lignes ajoutées dans la base de données
     */
    public int addTopo(String pName, int pRegionId, int pUtilisateurId) {
        Topo topo = new Topo();
        topo.setTopoNom(pName);
        topo.setRegion(regionBo.findById(pRegionId));
        topo.setProprietaire(utilisateurBo.findById(pUtilisateurId));

        return topoBo.create(topo);
    }

    /**
     * La méthode updateTopo permet de mettre à jour un objet Topo grâce via l'objet TopoBo. La méthode utilise en paramètres tous les éléments qui vont constituer les
     * attributs de l'objet l'instancier et le transférer aux couches inférieures (dont la DAO) via l'objet, automatiquement instancié par Spring, TopoBo
     * @param pId est un Integer définissant l'identifiant unique de l'objet Topo
     * @param pName est un String définissant l'attribut TopoNom de l'objet Topo
     * @param pRegionId est un Integer définissant l'identifiant unique de l'objet et attribut Region de l'objet Topo
     * @param pUtilisateurId est un Integer définissant l'identifiant unique de l'objet et attribut Utilisateur/Proprietaire de l'objet Topo
     * @return un Integer spécifiant le nombre de lignes modifiées dans la base de données
     */
    public int updateTopo(int pId, String pName, int pRegionId, int pUtilisateurId) {
        Topo topo = new Topo();
        topo.setTopoId(pId);
        topo.setTopoNom(pName);
        topo.setRegion(regionBo.findById(pRegionId));
        topo.setProprietaire(utilisateurBo.findById(pUtilisateurId));

        return topoBo.update(topo);
    }

    /**
     * La méthode deleteTopo permet de supprimer un objet Topo grâce via l'objet TopoBo. La méthode utilise en paramètres tous les éléments qui vont constituer les
     * attributs de l'objet et le supprimer via les couches inférieures (dont la DAO) grâce à l'objet, automatiquement instancié par Spring, TopoBo
     * @param pTopoId est un Integer définissant l'identifiant unique de l'objet Topo
     * @return un Integer spécifiant si oui ou non la ligne a été supprimée dans la base de données
     */
    public int deleteTopo(int pTopoId) {
        List<Spot> spots = hasSpots(topoBo.findById(pTopoId));

        if (spots.isEmpty()) {
            topoBo.delete(topoBo.findById(pTopoId));
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * La méthode hasSpots permet de savoir si l'objet Topo est lié, via l'attribut TopoId (qui est la clé étrangère) des objets Spot. La méthode va vérifier
     * que l'objet n'est pas utilisé en tant qu'attribut (qu'aucun Id n'est défini comme clé étrangère) avant d'appeler le business object et de valider la suppression.
     * @param pTopo est l'objet Topo qui constitue l'attribut Topo de l'objet Spot
     * @return une List d'objets Spot
     */
    @Override
    public List<Spot> hasSpots(Topo pTopo) {
        return spotBo.findByTopo(pTopo);
    }

    /**
     * La méthode getAvailableToposList permet de retourner une liste des topos disponibles pour l'emprunt. La méthode va vérifier l'attribut Disponible de
     * chaque objet Topo de la List passée en paramètre de la méthode
     * @param pTopos est une List de Topo
     * @return une List d'objets Topos dont l'attribut Disponible est à True
     */
    @Override
    public List<Topo> getAvailableToposList(List<Topo> pTopos) {
        List<Topo> topos = new ArrayList<>();

        for (Topo topo : pTopos) {
            if (topo.isDisponible()) {
                topos.add(topo);
            } else {
                continue;
            }
        }
        return topos;
    }
}
