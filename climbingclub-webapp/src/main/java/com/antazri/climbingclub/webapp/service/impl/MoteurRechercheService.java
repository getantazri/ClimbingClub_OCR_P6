package com.antazri.climbingclub.webapp.service.impl;

import com.antazri.climbingclub.business.contract.IRechercheBo;
import com.antazri.climbingclub.business.contract.ITopoBo;
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
    public ResultatRecherche find(String pType, String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax) {
        // Initialisation de l'objet ResultatRecherche à retourner et de la List à setter
        ResultatRecherche results = new ResultatRecherche();

        if ("Topo".equals(pType)) {
            List<Topo> topos = rechercheBo.rechercherTopo(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
            results.addAllTopo(topos);
        }

        else if ("Spot".equals(pType)) {
            List<Spot> spots = rechercheBo.rechercherSpot(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
            results.addAllSpot(spots);
        }

        else if ("Secteur".equals(pType)) {
            List<Secteur> secteurs = rechercheBo.rechercherSecteur(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
            results.addAllSecteur(secteurs);
        }

        else if ("Voie".equals(pType)) {
            List<Voie> voies = rechercheBo.rechercherVoie(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
            results.addAllVoie(voies);
        }

        else {
            findAllResults(results, pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
        }

        return results;
    }

    public void findAllResults(ResultatRecherche results, String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax) {
        List<Topo> allTopos = rechercheBo.rechercherTopo(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
        results.addAllTopo(allTopos);

        List<Spot> allSpots = rechercheBo.rechercherSpot(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
        results.addAllSpot(allSpots);

        List<Secteur> allSecteurs = rechercheBo.rechercherSecteur(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
        results.addAllSecteur(allSecteurs);

        List<Voie> allVoies = rechercheBo.rechercherVoie(pNom, pNomRegion, pNomCotation, pHauteurMin, pHauteurMax);
        results.addAllVoie(allVoies);
    }

}
