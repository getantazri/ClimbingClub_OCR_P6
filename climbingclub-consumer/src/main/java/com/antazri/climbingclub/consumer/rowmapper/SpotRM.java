package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Spot lors de la récupération des éléments depuis la base de données
 */
public class SpotRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Spot
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Spot construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Spot mapRow(ResultSet rs, int rowNum) throws SQLException {
        Spot spot = new Spot();

        spot.setSpotId(rs.getInt("spot_id"));
        spot.setSpotNom(rs.getString("spot_nom"));
        spot.setSpotDescription(rs.getString("spot_description"));
        spot.setHauteur(rs.getString("hauteur"));

        // Création d'un objet Topo
        Topo topo = new Topo();
        topo.setTopoId(rs.getInt("topo_id"));

        // Affection de Topo à Spot
        spot.setTopo(topo);

        return spot;
    }
}

