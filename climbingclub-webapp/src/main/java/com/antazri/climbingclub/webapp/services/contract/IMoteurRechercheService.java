package com.antazri.climbingclub.webapp.services.contract;

import com.antazri.climbingclub.model.beans.ResultatRecherche;

public interface IMoteurRechercheService {

    public ResultatRecherche find(String pType, String pNom, String pNomRegion, String pNomCotation, int pHauteurMin, int pHauteurMax);

}
