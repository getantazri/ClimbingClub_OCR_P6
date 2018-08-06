package com.antazri.climbingclub.batch;

import com.antazri.climbingclub.business.contract.ITopoBo;
import com.antazri.climbingclub.business.impl.TopoBo;
import com.antazri.climbingclub.consumer.contract.ITopoDao;
import com.antazri.climbingclub.consumer.impl.TopoDao;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ApplicationContext vApplicationContext = new ClassPathXmlApplicationContext("classpath:/com/antazri/climbingclub/batch/spring/applicationContext-bootstrap.xml");

        System.out.println("======================================================================");
        System.out.println("======================================================================");


        System.out.println("===================================");


        System.out.println("======================================================================");
        System.out.println("======================================================================");

    }

}
