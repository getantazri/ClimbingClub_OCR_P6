package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Cotation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Cotation lors de la récupération des éléments depuis la base de données
 */
public class CotationRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Cotation
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Cotation construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Cotation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cotation cotation = new Cotation();

        cotation.setCotationId(rs.getInt("cotation_id"));
        cotation.setNom(rs.getString("cotation_nom"));

        return cotation;
    }
}

