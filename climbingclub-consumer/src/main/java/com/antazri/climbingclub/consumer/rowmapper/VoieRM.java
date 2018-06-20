package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Voie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Voie lors de la récupération des éléments depuis la base de données
 *
 * @return une instance de Voie paramétrée avec les informations issues de la base de données
 */
public class VoieRM implements RowMapper {

    public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Voie voie = new Voie();

        voie.setVoieId(rs.getInt("voie_id"));
        voie.setNom(rs.getString("voie_nom"));
        voie.setNombrePoints(rs.getInt("nombre_points"));
        voie.setDescription(rs.getString("voie_description"));

        // Création de l'objet Cotation pour l'objet Voie
        Cotation cotation = new Cotation();
        cotation.setCotationId(rs.getInt("cotation_id"));
        cotation.setNom(rs.getString("cotation_nom"));

        voie.setCotation(cotation);

        return voie;
    }
}

