package com.antazri.climbingclub.batch;

import com.antazri.climbingclub.consumer.impl.RegionDao;
import com.antazri.climbingclub.model.beans.Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/**/batch/spring/applicationContext-bootstrap.xml");

        RegionDao regionDao = (RegionDao) vApplicationContext.getBean("regionDao");

        System.out.println("====================");

        Region findById = regionDao.findById(21);
        System.out.println("Région trouvée par le ID : " + findById.getNom() + "(" + findById.getRegion_id() + ")");

        System.out.println("====================");

        Region findByName = regionDao.findByName("Occitanie");
        System.out.println("Région trouvée par le nom : " + findByName.getNom() + "(" + findByName.getRegion_id() + ")");


        System.out.println("====================");

        Region hautDeFrance = new Region();
        hautDeFrance.setRegion_id(0);
        hautDeFrance.setNom("Haut-de-France");

        Region regionAdd = regionDao.create(hautDeFrance);
        System.out.println("Région ajoutée : " + regionAdd.getNom());

        System.out.println("====================");


        Region paca = new Region();
        hautDeFrance.setRegion_id(3);
        hautDeFrance.setNom("PACA");

        //Region addPaca = regionDao.update(paca);
        System.out.println("Région modifié : " + paca.getNom());

        System.out.println("====================");

        List<Region> regions = regionDao.findAll();

        System.out.println("Toutes les régions :");

        for(Region region : regions) {
            System.out.println(region.getNom() + " (" + region.getRegion_id() + ")");
        }
        System.out.println("====================");
    }
}
