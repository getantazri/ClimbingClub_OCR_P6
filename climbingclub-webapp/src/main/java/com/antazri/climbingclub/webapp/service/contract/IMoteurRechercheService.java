package com.antazri.climbingclub.webapp.service.contract;

import com.antazri.climbingclub.model.beans.ResultatRecherche;

import java.util.List;

public interface IMoteurRechercheService {

    public ResultatRecherche find(String pType, String pNom, String pNomRegion, String pNomCotation);
    public Object doTransformObject(Object object);
    public String fromObjectToUrl(Object object);

}
