package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.consumer.contract.ISpotDao;
import com.antazri.climbingclub.model.beans.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SecteurRM implements RowMapper {

    @Autowired
    ISpotDao spotDao;

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Secteur secteur = new Secteur();

        secteur.setSecteur_id(rs.getInt("secteur_id"));

        // Affectation d'un Spot avec la méthode findById de l'attribut spotDao qui retourne une
        // instance de l'objet Spot avec son id, récupéré dans le ResultSet, en paramètre
        secteur.setSpot(spotDao.findById(rs.getInt("spot_id")));

        secteur.setNom(rs.getString("nom"));

        return secteur;
    }
}

