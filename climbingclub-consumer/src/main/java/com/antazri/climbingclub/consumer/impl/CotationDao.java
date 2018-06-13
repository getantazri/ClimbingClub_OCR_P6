package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ICotationDao;
import com.antazri.climbingclub.model.beans.Cotation;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CotationDao extends AbstractDao implements ICotationDao {

    public Cotation findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.cotation WHERE cotation.cotation_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, Cotation.class);
    }

    public Cotation findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.cotation WHERE cotation.nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, Cotation.class);
    }

    public List<Cotation> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.cotation";

        return getJdbcTemplate().queryForList(vSql, Cotation.class);
    }

    public Cotation create(Cotation pCotation) {
        // Requête SQL
        String vSql = "INSERT INTO public.cotation (nom) VALUES (?)";

        getJdbcTemplate().update(vSql, pCotation.getNom());

        return pCotation;
    }

    public Cotation update(Cotation pCotation) {
        //Requête SQL
        String vSql = "UPDATE public.cotation SET cotation.nom = :nom WHERE cotation.cotation_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pCotation.getNom());
        vSqlParameters.addValue("id", pCotation.getCotation_id());

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);

        return pCotation;
    }

    public void delete(Cotation pCotation) {
        //Requête SQL
        String vSql = "DELETE FROM public.cotation WHERE cotation.cotation_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pCotation.getCotation_id());

        // Mise à jour de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
