package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IRegionDao;
import com.antazri.climbingclub.model.beans.Region;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionDao extends AbstractDao implements IRegionDao {

    public Region findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.region WHERE region.region_id = :id";

        // Initialisation du template avec la DataSource en paramètre
        NamedParameterJdbcTemplate vJdbcTemplate;
        vJdbcTemplate = new NamedParameterJdbcTemplate(this.getDataSource());

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
        vJdbcTemplate = new NamedParameterJdbcTemplate(this.getDataSource());

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return vJdbcTemplate.queryForObject(vSql, vSqlParameters, Region.class);
    }

    public List<Region> findAll() {
        //Requête SQL
        String vSql = "SELECT * FROM public.region";

        // Initialisation du template avec la DataSource en paramètre
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(this.getDataSource());

        // Retourne une List<Region> contenant toutes régions
        return vJdbcTemplate.queryForList(vSql, Region.class);
    }

    public Region create(Region pRegion) {
        //Requête SQL
        String vSql = "INSERT INTO public.region (nom) VALUES (?)";

        // Initialisation du template avec la DataSource en paramètre
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(this.getDataSource());

        // Création de l'objet dans la base de données
        vJdbcTemplate.update(vSql, pRegion.getNom());

        return pRegion;
    }

    public Region update(Region pRegion) {
        //Requête SQL
        String vSql = "UPDATE public.region SET nom = :nom WHERE region.region_id = :id";

        // Initialisation du template avec la DataSource en paramètre
        NamedParameterJdbcTemplate vJdbcTemplate;
        vJdbcTemplate = new NamedParameterJdbcTemplate(this.getDataSource());

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pRegion.getRegion_id());
        vSqlParameters.addValue("nom", pRegion.getNom());

        // Création de l'objet dans la base de données
        vJdbcTemplate.update(vSql, vSqlParameters);

        return pRegion;

    }

    public void delete(Region pRegion) {
        //Requête SQL
        String vSql = "DELETE * FROM public.region WHERE region.region_id = :id";

        // Initialisation du template avec la DataSource en paramètre
        NamedParameterJdbcTemplate vJdbcTemplate;
        vJdbcTemplate = new NamedParameterJdbcTemplate(this.getDataSource());

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pRegion.getRegion_id());

        // Création de l'objet dans la base de données
        vJdbcTemplate.update(vSql, vSqlParameters);
    }
}
