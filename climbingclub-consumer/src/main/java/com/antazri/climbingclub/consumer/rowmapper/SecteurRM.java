package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SecteurRM implements RowMapper {

    public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Secteur secteur = new Secteur();

        secteur.setSecteurId(rs.getInt("secteur_id"));

        Spot spot = new Spot();


        secteur.setNom(rs.getString("secteur_nom"));

        return secteur;
    }
}

