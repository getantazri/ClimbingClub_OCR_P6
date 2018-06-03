package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IRegionDao;
import com.antazri.climbingclub.model.beans.Region;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RegionDao extends AbstractDao implements IRegionDao {

    public Region findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.region WHERE region.region_id = :id";

        // Initialisation du template avec la DataSource en paramètre
        NamedParameterJdbcTemplate vJdbcTemplate;
        vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return vJdbcTemplate.queryForObject(vSql, vSqlParameters, Region.class);
    }

    public Region findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.region WHERE region.nom = :nom";

        // Initialisation du template avec la DataSource en paramètre
        NamedParameterJdbcTemplate vJdbcTemplate;
        vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return vJdbcTemplate.queryForObject(vSql, vSqlParameters, Region.class);
    }

    public List<Region> findAll() {
        //Requête SQL
        String vSql = "SELECT * FROM public.region";

        // Initialisation du template avec la DataSource en paramètre
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        // Retourne une List<Region> contenant toutes régions
        return vJdbcTemplate.queryForList(vSql, Region.class);
    }

    public Region create(Region pRegion) {
        //Requête SQL
        String vSql = "INSERT INTO public.region (?) VALUES (:nom)";

        // Récupération des données à persister dans la base de données


        return pRegion;
    }

    public Region update(Region pRegion) {
        return null;
    }

    public void delete(Region pRegion) {

    }
}
