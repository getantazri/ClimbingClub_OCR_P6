package com.antazri.climbingclub.batch;

import com.antazri.climbingclub.business.bo.impl.*;
import com.antazri.climbingclub.consumer.impl.*;
import com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM;
import com.antazri.climbingclub.model.beans.*;
import com.antazri.climbingclub.webapp.service.impl.MoteurRechercheService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath*:/**/batch/spring/applicationContext-bootstrap.xml");

        CommentaireBo commentaireBo = (CommentaireBo) vApplicationContext.getBean("commentaireBo");
        CotationBo cotationBo = (CotationBo) vApplicationContext.getBean("cotationBo");
        EmpruntBo empruntBo = (EmpruntBo) vApplicationContext.getBean("empruntBo");
        RegionBo regionBo = (RegionBo) vApplicationContext.getBean("regionBo");
        SecteurBo secteurBo = (SecteurBo) vApplicationContext.getBean("secteurBo");
        SpotBo spotBo = (SpotBo) vApplicationContext.getBean("spotBo");
        StatutBo statutBo = (StatutBo) vApplicationContext.getBean("statutBo");
        TopoBo topoBo = (TopoBo) vApplicationContext.getBean("topoBo");
        UtilisateurBo utilisateurBo = (UtilisateurBo) vApplicationContext.getBean("utilisateurBo");
        VoieBo voieBo = (VoieBo) vApplicationContext.getBean("voieBo");

        MoteurRechercheService search = (MoteurRechercheService) vApplicationContext.getBean("moteurRechercheService");
        RechercheDao rechercheDao = (RechercheDao) vApplicationContext.getBean("rechercheDao");

        System.out.println("======================================================================");
        System.out.println("======================================================================");

        ResultatRecherche result = search.find("Spot", "", "Alsace", "Toutes", 0, 0);

        for (Topo topo : result.getResultsTopo()) {
            System.out.println("+ " + topo.getTopoId() + " : " + topo.getTopoNom());
        }

        System.out.println("===================================");

        for (Spot spot : result.getResultsSpot()) {
            System.out.println("+ " + spot.getSpotId() + " : " + spot.getSpotNom());
        }

        System.out.println("===================================");

        for (Secteur secteur : result.getResultsSecteur()) {
            System.out.println("+ " + secteur.getSecteurId() + " : " + secteur.getSecteurNom());
        }

        System.out.println("===================================");

        for (Voie voie : result.getResultsVoie()) {
            System.out.println("+ " + voie.getVoieId() + " : " + voie.getVoieNom());
        }


        System.out.println("======================================================================");
        System.out.println("======================================================================");

    }

}
