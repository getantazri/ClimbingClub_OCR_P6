package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.business.contract.ICotationBo;
import com.antazri.climbingclub.business.contract.IRegionBo;
import com.antazri.climbingclub.model.beans.*;
import com.antazri.climbingclub.webapp.services.contract.IMoteurRechercheService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class MoteurRechercheAction extends ActionSupport {

    @Autowired
    private IMoteurRechercheService moteurRechercheService;

    @Autowired
    private IRegionBo regionBo;

    @Autowired
    private ICotationBo cotationBo;

    // =======================================================================
    // Attributs de l'action
    // =======================================================================
    private ResultatRecherche resultatRecherche;
    private String type;
    private List<String> types;
    private String request;
    private String nomRegion;
    private List<Region> regions;
    private String nomCotation;
    private List<Cotation> cotations;
    private int hauteurMin;
    private int hauteurMax;
    private List<Topo> topos;
    private List<Spot> spots;
    private List<Secteur> secteurs;
    private List<Voie> voies;

    // =======================================================================
    // Getters et Setters des attributs de l'action
    // =======================================================================
    public ResultatRecherche getResultatRecherche() {
        return resultatRecherche;
    }

    public void setResultatRecherche(ResultatRecherche resultatRecherche) {
        this.resultatRecherche = resultatRecherche;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String nomRegion) {
        this.nomRegion = nomRegion;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public String getNomCotation() {
        return nomCotation;
    }

    public void setNomCotation(String nomCotation) {
        this.nomCotation = nomCotation;
    }

    public List<Cotation> getCotations() {
        return cotations;
    }

    public void setCotations(List<Cotation> cotations) {
        this.cotations = cotations;
    }

    public int getHauteurMin() {
        return hauteurMin;
    }

    public void setHauteurMin(int hauteurMin) {
        this.hauteurMin = hauteurMin;
    }

    public int getHauteurMax() {
        return hauteurMax;
    }

    public void setHauteurMax(int hauteurMax) {
        this.hauteurMax = hauteurMax;
    }

    public List<Topo> getTopos() {
        return topos;
    }

    public void setTopos(List<Topo> topos) {
        this.topos = topos;
    }

    public List<Spot> getSpots() {
        return spots;
    }

    public void setSpots(List<Spot> spots) {
        this.spots = spots;
    }

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public List<Voie> getVoies() {
        return voies;
    }

    public void setVoies(List<Voie> voies) {
        this.voies = voies;
    }

    // =======================================================================
    // Actions / Méthodes
    // =======================================================================
    public String doSearch() {
        cotations = initCotations();
        regions = initRegions();
        types = initTypes();

        return ActionSupport.SUCCESS;
    }

    public String doSearchRequest() {
        String vResult = ActionSupport.INPUT;

        cotations = initCotations();
        regions = initRegions();
        types = initTypes();

        try {
            if (request.replace(" ", "").length() > 3 && !StringUtils.isAnyEmpty(type, request, nomRegion, nomCotation) && hauteurMin >= 0 && hauteurMax >= 0) {
                resultatRecherche = moteurRechercheService.find(type, request, nomRegion, nomCotation, hauteurMin, hauteurMax);

                topos = resultatRecherche.getResultsTopo();
                spots = resultatRecherche.getResultsSpot();
                secteurs = resultatRecherche.getResultsSecteur();
                voies = resultatRecherche.getResultsVoie();

                vResult = ActionSupport.SUCCESS;
            } else {
                addActionError("Erreur dans la requête : il manque des éléments ou la recherche est trop courte !");
                vResult = ActionSupport.INPUT;
            }
        } catch (Exception pE) {
            addActionError("Il y a eu un problème lors de la requête !");
            pE.printStackTrace();
            vResult =  ActionSupport.ERROR;
        }

        return vResult;
    }

    private List<Region> initRegions() {
        List<Region> regions = new ArrayList<>();
        Region toutes = new Region();
        toutes.setRegionId(99);
        toutes.setRegionNom("Toutes");

        regions.add(toutes);
        regions.addAll(regionBo.findAll());

        return regions;
    }

    private List<Cotation> initCotations() {
        List<Cotation> cotations = new ArrayList<>();
        Cotation toutes = new Cotation();
        toutes.setCotationId(99);
        toutes.setCotationNom("Toutes");

        cotations.add(toutes);
        cotations.addAll(cotationBo.findAll());

        return cotations;
    }

    public List<String> initTypes() {
        List<String> types = new ArrayList<>();
        types.add("Tous");
        types.add("Topo");
        types.add("Spot");
        types.add("Secteur");
        types.add("Voie");

        return types;
    }
}
