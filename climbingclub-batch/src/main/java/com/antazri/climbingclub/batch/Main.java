package com.antazri.climbingclub.batch;

import com.antazri.climbingclub.consumer.impl.*;
import com.antazri.climbingclub.model.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath*:/**/batch/spring/applicationContext-bootstrap.xml");

        RegionDao regionDao = (RegionDao) vApplicationContext.getBean("regionDao");

        Region region = regionDao.findById(1);
        System.out.println(region.getRegionNom());

        System.out.println("=========================");

        Region jura = new Region();
        jura.setRegionId(0);
        jura.setRegionNom("Jura");

        regionDao.create(jura);
        System.out.println("Région créée : " + jura.getRegionNom());

        System.out.println("=========================");

        List<Region> regions = regionDao.findAll();

        for (Region reg : regions) {
            System.out.println(reg.getRegionNom());
        }

        System.out.println("=========================");

    }
}
