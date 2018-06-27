package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Secteur lors de la récupération des éléments depuis la base de données
 */
public class SecteurRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Secteur
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Secteur construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Secteur secteur = new Secteur();

        secteur.setSecteurId(rs.getInt("secteur_id"));
        secteur.setSecteurNom(rs.getString("secteur_nom"));

        // Création d'un objet Spot
        Spot spot = new Spot();
        spot.setSpotId(rs.getInt("spot_id"));

        // Affectation du Spot au Secteur
        secteur.setSpot(spot);

        return secteur;
    }
}

