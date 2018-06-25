package com.antazri.climbingclub.batch;

import com.antazri.climbingclub.business.bo.impl.RegionBo;
import com.antazri.climbingclub.consumer.impl.*;
import com.antazri.climbingclub.model.beans.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath*:/**/batch/spring/applicationContext-bootstrap.xml");

        RegionBo regionBo = (RegionBo) vApplicationContext.getBean("regionBo");

        Region region = regionBo.findById(1);
        System.out.println(region.getRegionNom());

        System.out.println("=========================");

        Region normandie = new Region();
        normandie.setRegionId(16);
        normandie.setRegionNom("Normandie");

        regionBo.update(normandie);

        Region vosges = new Region();
        vosges.setRegionId(17);
        vosges.setRegionNom("Vosges");

        regionBo.delete(vosges);

        System.out.println("=========================");

        List<Region> regions = regionBo.findAll();

        for (Region reg : regions) {
            System.out.println(reg.getRegionNom());
        }

        System.out.println("=========================");

    }
}
