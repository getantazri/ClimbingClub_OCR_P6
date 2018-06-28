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
        EmpruntBo empruntBo = (EmpruntBo) vApplicationContext.getBean("empruntBo");
        RegionBo regionBo = (RegionBo) vApplicationContext.getBean("regionBo");
        SecteurBo secteurBo = (SecteurBo) vApplicationContext.getBean("secteurBo");
        SpotBo spotBo = (SpotBo) vApplicationContext.getBean("spotBo");
        StatutBo statutBo = (StatutBo) vApplicationContext.getBean("statutBo");
        TopoBo topoBo = (TopoBo) vApplicationContext.getBean("topoBo");
        UtilisateurBo utilisateurBo = (UtilisateurBo) vApplicationContext.getBean("utilisateurBo");
        VoieBo voieBo = (VoieBo) vApplicationContext.getBean("voieBo");

        System.out.println("======================================================================");
        System.out.println("======================================================================");


        System.out.println("===================================");


        System.out.println("======================================================================");
        System.out.println("======================================================================");

    }
}
