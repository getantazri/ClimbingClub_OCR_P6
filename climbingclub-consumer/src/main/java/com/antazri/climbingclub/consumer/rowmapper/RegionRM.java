package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Region;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Region lors de la récupération des éléments depuis la base de données
 */
public class RegionRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Region
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Region construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Region mapRow(ResultSet rs, int rowNum) throws SQLException {
        Region region = new Region();

        region.setRegionId(rs.getInt("region_id"));
        region.setNom(rs.getString("nom"));

        return region;
    }
}
