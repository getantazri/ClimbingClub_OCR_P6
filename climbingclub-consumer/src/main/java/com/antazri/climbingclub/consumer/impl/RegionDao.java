package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IRegionDao;
import com.antazri.climbingclub.model.beans.Region;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionDao extends AbstractDao implements IRegionDao {

    public Region findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.region WHERE region.region_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, Region.class);
    }

    public Region findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.region WHERE region.nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, Region.class);
    }

    public List<Region> findAll() {
        //Requête SQL
        String vSql = "SELECT * FROM public.region";

        // Retourne une List<Region> contenant toutes les régions
        return getJdbcTemplate().queryForList(vSql, Region.class);
    }

    public Region create(Region pRegion) {
        //Requête SQL
        String vSql = "INSERT INTO public.region (nom) VALUES (?)";

        // Création de l'objet dans la base de données
        getJdbcTemplate().update(vSql, pRegion.getNom());

        return pRegion;
    }

    public Region update(Region pRegion) {
        //Requête SQL
        String vSql = "UPDATE public.region SET nom = :nom WHERE region.region_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pRegion.getRegion_id());
        vSqlParameters.addValue("nom", pRegion.getNom());

        // Mise à jour de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);

        return pRegion;

    }

    public void delete(Region pRegion) {
        //Requête SQL
        String vSql = "DELETE FROM public.region WHERE region.region_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pRegion.getRegion_id());

        // Suppression de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
