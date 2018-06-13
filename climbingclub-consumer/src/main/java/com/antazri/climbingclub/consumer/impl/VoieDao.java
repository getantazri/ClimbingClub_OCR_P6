package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IVoieDao;
import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VoieDao extends AbstractDao implements IVoieDao {

    public Voie findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie WHERE voie.voie_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, Voie.class);
    }

    public List<Voie> findBySecteur(Secteur pSecteur) {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie WHERE voie.secteur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSecteur.getSecteur_id());

        return getNamedParameterJdbcTemplate().queryForList(vSql, vSqlParameters, Voie.class);
    }

    public List<Voie> findByCotation(Cotation pCotation) {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie WHERE voie.cotation_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pCotation.getCotation_id());

        return getNamedParameterJdbcTemplate().queryForList(vSql, vSqlParameters, Voie.class);
    }

    public List<Voie> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie";

        return getJdbcTemplate().queryForList(vSql, Voie.class);
    }

    public Voie create(Voie pVoie) {
        // Requête SQL
        String vSql = "INSERT INTO public.voie (nom, nombre_points, description, secteur_id, cotation_id) "
                + "VALUES (?, ?, ?, ?, ?)";

        getJdbcTemplate().update(vSql, pVoie.getNom(), pVoie.getNombrePoints(), pVoie.getDescription(), pVoie.getSecteur().getSecteur_id(), pVoie.getCotation().getCotation_id());

        return pVoie;
    }

    public Voie update(Voie pVoie) {
        //Requête SQL
        String vSql = "UPDATE public.voie "
                + "SET voie.nom =  = :nom, "
                + "voie.nom_points =  = :nbrPoints, "
                + "voie.description =  = :description, "
                + "voie.secteur_id =  = :secteurId, "
                + "voie.cotation_id =  = :cotationId "
                + "WHERE voie.voie_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pVoie.getNom());
        vSqlParameters.addValue("nbrPoints", pVoie.getNombrePoints());
        vSqlParameters.addValue("description", pVoie.getDescription());
        vSqlParameters.addValue("secteurId", pVoie.getSecteur().getSecteur_id());
        vSqlParameters.addValue("cotationId", pVoie.getCotation().getCotation_id());
        vSqlParameters.addValue("id", pVoie.getVoie_id());

        // Mise à jour de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);

        return pVoie;
    }

    public void delete(Voie pVoie) {
        //Requête SQL
        String vSql = "DELETE FROM public.voie WHERE voie.voie_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pVoie.getVoie_id());

        // Suppression de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
