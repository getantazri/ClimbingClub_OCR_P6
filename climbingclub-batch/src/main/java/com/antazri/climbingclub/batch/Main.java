package com.antazri.climbingclub.batch;

import com.antazri.climbingclub.business.bo.impl.*;
import com.antazri.climbingclub.consumer.impl.*;
import com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM;
import com.antazri.climbingclub.model.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath*:/**/batch/spring/applicationContext-bootstrap.xml");

        CommentaireBo commentaireBo = (CommentaireBo) vApplicationContext.getBean("commentaireBo");
        CotationBo cotationBo = (CotationBo) vApplicationContext.getBean("cotationBo");
        RegionBo regionBo = (RegionBo) vApplicationContext.getBean("regionBo");
        SecteurBo secteurBo = (SecteurBo) vApplicationContext.getBean("secteurBo");
        SpotBo spotBo = (SpotBo) vApplicationContext.getBean("spotBo");
        StatutBo statutBo = (StatutBo) vApplicationContext.getBean("statutBo");
        TopoBo topoBo = (TopoBo) vApplicationContext.getBean("topoBo");
        UtilisateurBo utilisateurBo = (UtilisateurBo) vApplicationContext.getBean("utilisateurBo");
        VoieBo voieBo = (VoieBo) vApplicationContext.getBean("voieBo");

        System.out.println("======================================================================");
        System.out.println("======================================================================");

        List<Topo> topos = topoBo.containsName("Massif");

        for (Topo topo : topos) {
            System.out.println(topo.getTopoNom());
        }

        Topo topo = topoBo.findById(1);
        System.out.println("+ " + topo.getTopoNom());

        System.out.println("===================================");

        List<Spot> spots = spotBo.containsName("Mont");

        for (Spot spot : spots) {
            System.out.println(spot.getSpotNom());
        }

        Spot spot = spotBo.findById(1);
        System.out.println("+ " + spot.getSpotNom());

        System.out.println("===================================");

        List<Secteur> secteurs = secteurBo.containsName("Lorem");

        for (Secteur secteur : secteurs) {
            System.out.println(secteur.getSecteurNom());
        }

        Secteur secteur = secteurBo.findById(1);
        System.out.println("+ " + secteur.getSecteurNom());

        System.out.println("===================================");

        List<Utilisateur> users = utilisateurBo.containsName("Dr");

        for (Utilisateur user : users) {
            System.out.println(user.getNom());
        }

        Utilisateur user = utilisateurBo.findById(1);
        System.out.println("+ " + user.getNom());

        System.out.println("===================================");

        List<Utilisateur> usersPseudo = utilisateurBo.containsName("man");

        for (Utilisateur userPseudo : usersPseudo) {
            System.out.println(userPseudo.getPseudo());
        }

        System.out.println("======================================================================");
        System.out.println("======================================================================");

    }
}
