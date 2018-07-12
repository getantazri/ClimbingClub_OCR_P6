package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Topo;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class GestionTopoAction extends ActionSupport {

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

    public String doList() {
        return "";
    }
}
