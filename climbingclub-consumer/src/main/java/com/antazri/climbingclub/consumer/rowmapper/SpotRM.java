package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.consumer.contract.IRegionDao;
import com.antazri.climbingclub.consumer.contract.ITopoDao;
import com.antazri.climbingclub.model.beans.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Spot lors de la récupération des éléments depuis la base de données
 *
 * @return une instance de Spot paramétrée avec les informations issues de la base de données
 */
public class SpotRM implements RowMapper {

    @Autowired
    ITopoDao topoDao;

    @Autowired
    IRegionDao regionDao;

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Spot spot = new Spot();

        spot.setSpot_id(rs.getInt("spot_id"));

        // Affectation d'un Topo avec la méthode findById de l'attribut topoDao qui retourne une
        // instance de l'objet Topo avec son id, récupéré dans le ResultSet, en paramètre
        spot.setTopo(topoDao.findById(rs.getInt("topo_id")));

        // Affectation d'un Region avec la méthode findById de l'attribut regionDao qui retourne une
        // instance de l'objet Region avec son id, récupéré dans le ResultSet, en paramètre
        spot.setRegion(regionDao.findById(rs.getInt("region_id")));

        spot.setNom(rs.getString("nom"));
        spot.setDescription(rs.getString("description"));
        spot.setHauteur(rs.getString("hauteur"));

        return spot;
    }
}

