package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.webapp.services.contract.IGestionTopoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionTopoAction extends ActionSupport {

    @Autowired
    private IGestionTopoService gestionTopoService;

    // Attributs et paramètres de l'action
    private int topoId;
    private Topo topo;
    private List<Topo> topos;

    public IGestionTopoService getGestionTopoService() {
        return gestionTopoService;
    }

    public void setGestionTopoService(IGestionTopoService gestionTopoService) {
        this.gestionTopoService = gestionTopoService;
    }

    public int getTopoId() {
        return topoId;
    }

    public void setTopoId(int topoId) {
        this.topoId = topoId;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public List<Topo> getTopos() {
        return topos;
    }

    public void setTopos(List<Topo> topos) {
        this.topos = topos;
    }

    // Méthodes de l'action
    public String doList() {
        setTopos(gestionTopoService.findAllTopo());
        return ActionSupport.SUCCESS;
    }

    public String doDetails() {

        if (topoId > 0) {
            setTopo(gestionTopoService.findTopoById(topoId));
            return ActionSupport.SUCCESS;
        } else {
            addActionError("Vous devez spécifié un ID existant");
            return ActionSupport.ERROR;
        }
    }
}
