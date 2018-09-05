package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.ICotationBo;
import com.antazri.climbingclub.business.contract.IVoieBo;
import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;
import com.antazri.climbingclub.webapp.services.contract.IGestionSecteurService;
import com.antazri.climbingclub.webapp.services.contract.IGestionVoieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Implémentation de l'interface IGestionSecteurService. GestionSecteurService permet à la WebApp d'utiliser les Business Objects pour récupérer ou envoyer des objets/données,
 * liés à la fonctionnalité permettant de gérer les objets Voie de l'application, à la base de données.
 *
 * @author Anthony T
 * @version 1.0
 */
public class GestionVoieService implements IGestionVoieService {

    @Autowired
    private IVoieBo voieBo;

    @Autowired
    private ICotationBo cotationBo;

    @Autowired
    private IGestionSecteurService gestionSecteurService;

    /**
     * La méthode findVoieById permet de récupérer un objet Voie grâce à son identifiant unique via l'objet VoieBo. L'objet CotationBo permet de retourner un objet comprenant
     * un objet complet en tant qu'attribut Cotation pour Voie. Ces Business Object sont automatiquement injectés par Spring via les annotations @Autowired
     * @param pId est un Integer spécifiant l'identifiant unique de l'objet Voie à récupérer
     * @return un objet Voie configuré et retourné par la couche Business
     */
    public Voie findVoieById(int pId) {
        Voie voie = voieBo.findById(pId);
        voie.setSecteur(gestionSecteurService.findSecteurById(voie.getSecteur().getSecteurId()));
        voie.setCotation(cotationBo.findById(voie.getCotation().getCotationId()));

        return voie;
    }

    /**
     * La méthode findVoieByName permet de récupérer un objet Voie grâce à son nom via l'objet VoieBo. L'objet CotationBo permet de retourner un objet comprenant
     * un objet complet en tant qu'attribut Cotation pour Voie. Ces Business Object sont automatiquement injectés par Spring via les annotations @Autowired
     * @param pName est un String spécifiant l'attribut Nom de l'objet Voie à récupérer
     * @return un objet Voie configuré et retourné par la couche Business
     */
    public Voie findVoieByName(String pName) {
        Voie voie = voieBo.findByName(pName);
        voie.setSecteur(gestionSecteurService.findSecteurById(voie.getSecteur().getSecteurId()));
        voie.setCotation(cotationBo.findById(voie.getCotation().getCotationId()));

        return voie;
    }

    /**
     * La méthode findVoieBySecteur permet de récupérer un objet Voie grâce à son attribut Secteur via l'objet VoieBo. L'objet CotationBo permet de retourner un objet comprenant
     * un objet complet en tant qu'attribut Cotation pour Voie. Ces Business Object sont automatiquement injectés par Spring via les annotations @Autowired
     * @param pSecteur est un objet Secteur spécifiant l'attribut Secteur de l'objet Voie à récupérer
     * @return une List d'objets Voie configurés retournée par la couche Business
     */
    public List<Voie> findVoieBySecteur(Secteur pSecteur) {

        List<Voie> voies = voieBo.findBySecteur(pSecteur);

        for(Voie voie : voies) {
            voie.setSecteur(gestionSecteurService.findSecteurById(pSecteur.getSecteurId()));
            voie.setCotation(cotationBo.findById(voie.getCotation().getCotationId()));
        }

        return voies;
    }

    /**
     * La méthode findVoieByCotation permet de récupérer un objet Voie grâce à son attribut Cotation via l'objet VoieBo. L'objet CotationBo permet de retourner un objet comprenant
     * un objet complet en tant qu'attribut Cotation pour Voie. Ces Business Object sont automatiquement injectés par Spring via les annotations @Autowired
     * @param pCotation est un objet Cotation spécifiant l'attribut Cotation de l'objet Voie à récupérer
     * @return une List d'objets Voie configurés retournée par la couche Business
     */
    public List<Voie> findVoieByCotation(Cotation pCotation) {

        List<Voie> voies = voieBo.findAll();

        for(Voie voie : voies) {
            voie.setSecteur(gestionSecteurService.findSecteurById(voie.getSecteur().getSecteurId()));
            voie.setCotation(cotationBo.findById(pCotation.getCotationId()));
        }

        return voies;
    }

    /**
     * La méthode findAllVoie permet de récupérer toutes les occurences de Voie via l'objet VoieBo. L'objet CotationBo permet de retourner un objet comprenant
     * un objet complet en tant qu'attribut Cotation pour Voie. Ces Business Object sont automatiquement injectés par Spring via les annotations @Autowired
     * @return une List d'objets Voie configurés retournée par la couche Business
     */
    public List<Voie> findAllVoie() {
        List<Voie> voies = voieBo.findAll();

        for(Voie voie : voies) {
            voie.setSecteur(gestionSecteurService.findSecteurById(voie.getSecteur().getSecteurId()));
            voie.setCotation(cotationBo.findById(voie.getCotation().getCotationId()));
        }

        return voies;
    }

    /**
     * La méthode addVoie permet de créer un objet Voie grâce via l'objet VoieBo. La méthode utilise en paramètres tous les éléments qui vont constituer les
     * attributs de l'objet pour l'instancier et le transférer aux couches inférieures (dont la DAO) via l'objet, automatiquement instancié par Spring, VoieBo
     * @param pName est un String définissant l'attribut Nom de l'objet Voie
     * @param pNbrPoints est un Integer définissant l'attribut NombrePoints de l'objet Voie
     * @param pDescription est un String définissant l'attribut VoieDescription de l'objet Voie
     * @param pSecteurId est un Integer définissant l'identifiant unique de l'objet et attribut Secteur de l'objet Voie
     * @param pCotationId est un Integer définissant l'identifiant unique de l'objet et attribut Cotation de l'objet Voie
     * @return un Integer spécifiant le nombre de lignes ajoutées dans la base de données
     */
    public int addVoie(String pName, int pNbrPoints, String pDescription, int pSecteurId, int pCotationId) {
        Voie voie = new Voie();
        voie.setVoieNom(pName);
        voie.setNombrePoints(pNbrPoints);
        voie.setVoieDescription(pDescription);
        voie.setSecteur(gestionSecteurService.findSecteurById(pSecteurId));
        voie.setCotation(cotationBo.findById(pCotationId));

        return voieBo.create(voie);
    }

    /**
     * La méthode updateVoie permet de mettre à jour un objet Voie grâce via l'objet VoieBo. La méthode utilise en paramètres tous les éléments qui vont constituer les
     * attributs de l'objet pour l'instancier et le transférer aux couches inférieures (dont la DAO) via l'objet, automatiquement instancié par Spring, VoieBo
     * @param pVoieId est un Integer définissant l'identifiant unique de l'objet Voie
     * @param pName est un String définissant l'attribut Nom de l'objet Voie
     * @param pNbrPoints est un Integer définissant l'attribut NombrePoints de l'objet Voie
     * @param pDescription est un String définissant l'attribut VoieDescription de l'objet Voie
     * @param pSecteurId est un Integer définissant l'identifiant unique de l'objet et attribut Secteur de l'objet Voie
     * @param pCotationId est un Integer définissant l'identifiant unique de l'objet et attribut Cotation de l'objet Voie
     * @return un Integer spécifiant le nombre de lignes modifiées dans la base de données
     */
    public int updateVoie(int pVoieId, String pName, int pNbrPoints, String pDescription, int pSecteurId, int pCotationId) {
        Voie voie = voieBo.findById(pVoieId);
        voie.setVoieNom(pName);
        voie.setNombrePoints(pNbrPoints);
        voie.setVoieDescription(pDescription);
        voie.setSecteur(gestionSecteurService.findSecteurById(pSecteurId));
        voie.setCotation(cotationBo.findById(pCotationId));

        return voieBo.update(voie);
    }

    /**
     * La méthode deleteVoie permet de supprimer une occurence de Voie dans la base de données. La méthode utilise en paramètres l'identifiant unique de l'objet pour en le retrouver
     * et le supprimer via les couches inférieures (dont la DAO) grâce à l'objet, automatiquement instancié par Spring, VoieBo
     * @param pVoieId est un Integer définissant l'identifiant unique de l'objet Voie
     * @return un Integer spécifiant si oui ou non la ligne a été supprimée dans la base de données
     */
    public int deleteVoie(int pVoieId) {
        try {
            voieBo.delete(voieBo.findById(pVoieId));
            return 1;
        } catch (Exception pE) {
            pE.printStackTrace();
            return 0;
        }
    }
}
