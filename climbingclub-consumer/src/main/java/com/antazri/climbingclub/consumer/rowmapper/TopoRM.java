package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.consumer.contract.IUtilisateurDao;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TopoRM implements RowMapper {

    @Autowired
    private IUtilisateurDao utilisateurDao;

    public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Topo topo = new Topo();

        topo.setTopo_id(rs.getInt("topo_id"));
        topo.setNom(rs.getString("nom"));

        // Affectation d'un Utilisateur avec la méthode findById de l'attribut utilisateurDao qui retourne une
        // instance de l'objet Utilisateur avec son id, récupéré dans le ResultSet, en paramètre
        topo.setProprietaire(utilisateurDao.findById(rs.getInt("utilisateur_id")));

        topo.setDisponible(rs.getBoolean("disponible"));

        return topo;
    }
}

