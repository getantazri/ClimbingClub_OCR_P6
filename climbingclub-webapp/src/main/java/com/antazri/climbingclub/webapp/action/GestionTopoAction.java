package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionTopoAction extends ActionSupport {

    // Attributs et paramètres de l'action
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // Méthodes de l'action
    public String doList() {

        return ActionSupport.SUCCESS;
    }

    public String doDetails() {
        return ActionSupport.SUCCESS;
    }
}
