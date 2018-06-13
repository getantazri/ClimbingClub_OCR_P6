package com.antazri.climbingclub.batch;

import com.antazri.climbingclub.consumer.impl.RegionDao;
import com.antazri.climbingclub.model.beans.Region;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/**/batch/spring/applicationContext-bootstrap.xml");

        RegionDao regionDao = new RegionDao();
        Region region = regionDao.findById(1);

        System.out.println(region.getNom());
    }
}
