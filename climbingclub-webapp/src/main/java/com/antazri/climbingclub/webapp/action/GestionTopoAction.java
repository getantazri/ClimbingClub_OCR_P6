package com.antazri.climbingclub.webapp.action;

import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.webapp.service.contract.IGestionTopoService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GestionTopoAction extends ActionSupport {

    @Autowired
    private IGestionTopoService gestionTopoService;

    // Attributs de l'Action
    private Integer id;
    private String name;
    private Topo topo;
    private List<Topo> topoList;

    // Getters et Setters des attributs de l'Action
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public List<Topo> getTopoList() {
        return topoList;
    }

    public void setTopoList(List<Topo> topoList) {
        this.topoList = topoList;
    }

    // Méthodes
    public String doList() {
        topoList = gestionTopoService.findAllTopo();
        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doDetails() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un ID de topo");
        } else {
            try {
                topo = gestionTopoService.findTopoById(id);
            } catch (NullPointerException pE) {
                this.addActionError("Aucun Topo trouvé avec l'ID :" + id);
                pE.printStackTrace();
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doAddTopo() {
        if (topo == null) {
            this.addActionError("Vous devez indiquer un ID de topo");
        } else {
           try {
               gestionTopoService.addTopo(topo.getProprietaire().getUtilisateurId(), topo.getTopoNom(), topo.isDisponible(), topo.getRegion().getRegionId());
           } catch(Exception pE) {
               this.addActionError("Il manque des informations dans le topo");
           }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doUpdateTopo() {
        if (topo == null) {
            this.addActionError("Vous devez indiquer un ID de topo");
        } else {
            try {
                gestionTopoService.updateTopo(topo.getTopoId(), topo.getTopoNom(), topo.isDisponible(), topo.getRegion().getRegionId());
            } catch(Exception pE) {
                this.addActionError("Il manque des informations dans le topo");
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

    public String doDeleteTopo() {
        if (topo == null) {
            this.addActionError("Vous devez indiquer un ID de topo");
        } else {
            try {
                gestionTopoService.deleteTopo(topo.getTopoId());
            } catch(Exception pE) {
                this.addActionError("Votre topo ne peut pas être supprimé");
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }


}
