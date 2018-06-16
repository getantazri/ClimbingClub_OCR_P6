package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.consumer.contract.ICotationDao;
import com.antazri.climbingclub.model.beans.Voie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Voie lors de la récupération des éléments depuis la base de données
 *
 * @return une instance de Voie paramétrée avec les informations issues de la base de données
 */
public class VoieRM implements RowMapper {

    @Autowired
    private ICotationDao cotationDao;

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Voie voie = new Voie();

        voie.setVoie_id(rs.getInt("voie_id"));
        voie.setNom(rs.getString("nom"));
        voie.setNombrePoints(rs.getInt("nombre_points"));
        voie.setDescription(rs.getString("description"));

        // Récupération d'un objet Cotation avec la méthode findById de l'attribut cotation qui aura la
        // colonne "cotation_id" du ResultSet en tant que paramètre
        voie.setCotation(cotationDao.findById(rs.getInt("cotation_id")));

        return voie;
    }
}

