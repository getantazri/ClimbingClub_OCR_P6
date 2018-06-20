package com.antazri.climbingclub.batch;

import com.antazri.climbingclub.consumer.impl.*;
import com.antazri.climbingclub.model.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath*:/**/batch/spring/applicationContext-bootstrap.xml");

        VoieDao voieDao = (VoieDao) vApplicationContext.getBean("voieDao");
        CotationDao cotationDao = (CotationDao) vApplicationContext.getBean("cotationDao");

        Cotation cotation = cotationDao.findById(2);


        List<Voie> voies = voieDao.findByCotation(cotation);

        for (Voie voie : voies) {
            System.out.println(voie.getNom());
        }
    }
}
