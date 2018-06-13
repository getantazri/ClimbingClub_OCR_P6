package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ISecteurDao;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Voie;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SecteurDao extends AbstractDao implements ISecteurDao {

    public Secteur findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.secteur WHERE secteur.secteur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return namedParameterJdbcTemplate.queryForObject(vSql, vSqlParameters, Secteur.class);
    }

    public List<Secteur> findBySpot(Spot pSpot) {
        // Requête SQL
        String vSql = "SELECT * FROM public.secteur WHERE secteur.spot_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSpot.getSpot_id());

        return namedParameterJdbcTemplate.queryForList(vSql, vSqlParameters, Secteur.class);
    }

    public List<Secteur> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.secteur";

        return jdbcTemplate.queryForList(vSql, Secteur.class);
    }

    public Secteur create(Secteur pSecteur) {
        // Requête SQL
        String vSql = "INSERT INTO public.secteur (nom, spot_id) "
                + "VALUES (?, ?)";

        jdbcTemplate.update(vSql, pSecteur.getNom(), pSecteur.getSpot().getSpot_id());

        return pSecteur;
    }

    public Secteur update(Secteur pSecteur) {
        //Requête SQL
        String vSql = "UPDATE public.secteur "
                + "SET secteur.nom =  = :nom, "
                + "secteur.spot_id =  = :spotId "
                + "WHERE secteur.secteur_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pSecteur.getNom());
        vSqlParameters.addValue("spotId", pSecteur.getSpot().getSpot_id());
        vSqlParameters.addValue("id", pSecteur.getSecteur_id());

        // Mise à jour de l'objet dans la base de données
        namedParameterJdbcTemplate.update(vSql, vSqlParameters);

        return pSecteur;
    }

    public void delete(Secteur pSecteur) {
        //Requête SQL
        String vSql = "DELETE FROM public.secteur WHERE secteur.secteur_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSecteur.getSecteur_id());

        // Mise à jour de l'objet dans la base de données
        namedParameterJdbcTemplate.update(vSql, vSqlParameters);
    }
}
