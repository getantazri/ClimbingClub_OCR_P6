package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Statut;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Statut lors de la récupération des éléments depuis la base de données
 */
public class StatutRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Statut
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Statut construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Statut mapRow(ResultSet rs, int rowNum) throws SQLException {
        Statut statut = new Statut();

        statut.setStatutId(rs.getInt("statut_id"));
        statut.setStatutNom(rs.getString("nom"));

        return statut;
    }
}

