package com.antazri.climbingclub.webapp.service.impl;

import com.antazri.climbingclub.business.bo.contract.IRechercheBo;
import com.antazri.climbingclub.business.bo.contract.ITopoBo;
import com.antazri.climbingclub.model.beans.*;
import com.antazri.climbingclub.webapp.service.contract.IMoteurRechercheService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MoteurRechercheService implements IMoteurRechercheService {

    @Autowired
    private IRechercheBo rechercheBo;

    @Autowired
    private ITopoBo topoBo;

    /**
     * La méthode rechercher va permettre de faire une recherche dans l'ensemble de la base de données, selon les paramètres renseignées et retourner un ensemble d'objets dans
     * un objet ResultatRecherche qui contient une List d'Object
     * @param pType est le type délément que l'on recherche (par défaut 0 signifie l'ensemble des types)
     * @param pNom est le nom de l'élément recherché
     * @param pNomRegion et le nom d'un élément Region lié à l'objet Topo
     * @param pNomCotation est le nom d'un élément Cotation lié à l'objet Voie
     * @return un objet ResultatRecherche contenant l'ensemble des instances remontées depuis la base de données
     */
    public ResultatRecherche find(String pType, String pNom, String pNomRegion, String pNomCotation) {
        // Initialisation de l'objet ResultatRecherche à retourner et de la List à setter
        ResultatRecherche results = new ResultatRecherche();

        switch (pType) {
            case "Topo" :
                List<Topo> topos = rechercheBo.rechercherTopo(pNom, pNomRegion);
                if (!topos.isEmpty()) {
                    results.addAllResults(topos);
                }
                break;

            case "Spot" :
                List<Spot> spots = rechercheBo.rechercherSpot(pNom);
                if (!spots.isEmpty()) {
                    results.addAllResults(spots);
                }
                break;

            case "Secteur" :
                List<Secteur> secteurs = rechercheBo.rechercherSecteur(pNom);
                if (!secteurs.isEmpty()) {
                    results.addAllResults(secteurs);
                }
                break;

            case "Voie" :
                List<Voie> voies = rechercheBo.rechercherVoie(pNom, pNomCotation);
                if (!voies.isEmpty()) {
                    results.addAllResults(voies);
                }
                break;

            default:
                List<Topo> allTopos = rechercheBo.rechercherTopo(pNom, pNomRegion);
                if (!allTopos.isEmpty()) {
                    results.addAllResults(allTopos);
                }

                List<Spot> allSpots = rechercheBo.rechercherSpot(pNom);
                if (!allSpots.isEmpty()) {
                    results.addAllResults(allSpots);
                }

                List<Secteur> allSecteurs = rechercheBo.rechercherSecteur(pNom);
                if (!allSecteurs.isEmpty()) {
                    results.addAllResults(allSecteurs);
                }

                List<Voie> allVoies = rechercheBo.rechercherVoie(pNom, pNomCotation);
                if (!allVoies.isEmpty()) {
                    results.addAllResults(allVoies);
                }
        }

        return results;
    }

    public Object doTransformObject(Object object) {
        System.out.println(object.getClass());
        System.out.println("=====");

        if (object.getClass().getSimpleName().equals("Topo")) {
            Topo topo = (Topo) object;
            System.out.println("Transformé en topo !");
            System.out.println(topo.getTopoNom());
            return topo;
        }
        return object;
    }

    public String fromObjectToUrl(Object object) {
        return "";
    }

    public void addObjectIntoResultsList(List<Object> objectsList, List<Object> resultsList) {
        for (Object object : objectsList) {
            resultsList.add(object);
        }
    }


}
