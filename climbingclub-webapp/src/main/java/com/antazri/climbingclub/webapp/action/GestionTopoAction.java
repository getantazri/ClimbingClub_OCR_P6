package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.webapp.service.contract.IGestionTopoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionTopoAction extends ActionSupport {

    @Autowired
    private IGestionTopoService gestionTopoService;

    // ========== Attributs de la classe Action ==========
    private int id;
    private List<Topo> listTopos;
    private Topo topo;

    // ========== Getters / Setters ==========
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Topo> getListTopos() {
        return listTopos;
    }

    public Topo getTopo() {
        return topo;
    }

    // ========== Méthodes ==========

    public List<Topo> doList() {
        listTopos = gestionTopoService.findAllTopo();
        return getListTopos();
    }
}
