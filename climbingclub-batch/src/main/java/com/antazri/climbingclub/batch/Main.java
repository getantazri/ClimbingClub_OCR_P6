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

        List<Topo> topos = rechercheDao.rechercherTopo("", "Toutes");

        if (!topos.isEmpty()) {
            for (Topo topo : topos) {
                System.out.println(topo.getTopoNom());
            }
        } else {
            System.out.println("C'est vide ici");
        }

        System.out.println("===================================");

        List<Spot> spots = rechercheDao.rechercherSpot("");

        if (!spots.isEmpty()) {
            for (Spot spot : spots) {
                System.out.println(spot.getSpotNom());
            }
        } else {
            System.out.println("C'est vide ici");
        }

        System.out.println("===================================");

        List<Secteur> secteurs = rechercheDao.rechercherSecteur("");

        if (!secteurs.isEmpty()) {
            for (Secteur secteur : secteurs) {
                System.out.println(secteur.getSecteurNom());
            }
        } else {
            System.out.println("C'est vide ici");
        }

        System.out.println("===================================");

        List<Voie> voies = rechercheDao.rechercherVoie("", "Toutes");

        if (!voies.isEmpty()) {
            for (Voie voie : voies) {
                System.out.println(voie.getVoieNom());
            }
        } else {
            System.out.println("C'est vide ici");
        }

        System.out.println("===================================");

        List<Object> objects = search.find("All", "", "Toutes", "Toutes").getResults();
        if (!objects.isEmpty()) {
                for (Object object : objects) {
                    System.out.println(object.getClass().getSimpleName());
                }
        } else {
            System.out.println("C'est vide ici");
        }


        System.out.println("======================================================================");
        System.out.println("======================================================================");

    }

}
