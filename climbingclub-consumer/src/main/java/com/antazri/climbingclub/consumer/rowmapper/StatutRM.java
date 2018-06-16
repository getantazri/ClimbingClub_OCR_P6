package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Statut;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Statut lors de la récupération des éléments depuis la base de données
 *
 * @return une instance de Statut paramétrée avec les informations issues de la base de données
 */
public class StatutRM implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Statut statut = new Statut();

        statut.setStatut_id(rs.getInt("statut_id"));
        statut.setNom(rs.getString("nom"));

        return statut;
    }
}

