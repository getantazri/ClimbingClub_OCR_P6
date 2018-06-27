package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Voie lors de la récupération des éléments depuis la base de données
 */
public class VoieRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Voie
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Voie construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Voie voie = new Voie();

        voie.setVoieId(rs.getInt("voie_id"));
        voie.setVoieNom(rs.getString("voie_nom"));
        voie.setNombrePoints(rs.getInt("nombre_points"));
        voie.setVoieDescription(rs.getString("voie_description"));

        // Création et affectation de l'objet Cotation pour l'objet Voie
        Cotation cotation = new Cotation();
        cotation.setCotationId(rs.getInt("cotation_id"));
        voie.setCotation(cotation);

        // Création de l'objet Secteur
        Secteur secteur = new Secteur();
        secteur.setSecteurId(rs.getInt("secteur_id"));

        // Affectation de Secteur à Voie
        voie.setSecteur(secteur);

        return voie;
    }
}

