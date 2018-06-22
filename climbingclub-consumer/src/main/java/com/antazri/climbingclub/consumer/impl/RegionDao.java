package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IRegionDao;
import com.antazri.climbingclub.consumer.rowmapper.RegionRM;
import com.antazri.climbingclub.model.beans.Region;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implémentation de l'interface IRegionDao. RegionDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
@Repository
public class RegionDao extends AbstractDao implements IRegionDao {

    /**
     * La méthode findById permet de rechercher un objet Region dans la base de données via son identifiant unique
     *
     * @param pId est un Integer permettant l'identification unique d'une instance de Region dans la base de données
     * @return un objet Region configuré via le RowMapper "RegionRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.RegionRM
     */
    public Region findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.region WHERE region.region_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Region) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new RegionRM());
    }

    /**
     * La méthode findByName permet de rechercher un objet Region dans la base de données via son nom
     *
     * @param pName est un String permettant l'identification d'une instance de Region dans la base de données via la colonne "region_nom"
     * @return un objet Region configuré via le RowMapper "RegionRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.RegionRM
     */
    public Region findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.region WHERE region.region_nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return (Region) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new RegionRM());
    }

    /**
     * La méthode findAll permet de retourner l'ensemble des instances de Region enregistrées dans la base de données
     *
     * @return une List de tous les objets Region configurés via le RowMapper "RegionRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.RegionRM
     */
    public List<Region> findAll() {
        //Requête SQL
        String vSql = "SELECT * FROM public.region";

        // Retourne une List<Region> contenant toutes les régions
        return getJdbcTemplate().query(vSql, new RegionRM());
    }

    /**
     * La méthode create permet de créer une nouvelle instance de Region dans la base de données
     *
     * @param pRegion est un objet Region passé et configuré depuis la couche Business
     * @return l'objet Region passé en paramètre de la méthode
     * @see com.antazri.climbingclub.consumer.rowmapper.RegionRM
     */
    public Region create(Region pRegion) {
        //Requête SQL
        String vSql = "INSERT INTO public.region(region_nom) VALUES (?)";

        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("region_nom", pRegion.getRegionNom());

        // Mise à jour de l'objet dans la base de données
        SimpleJdbcInsert vSimpleJdbcInsert = new SimpleJdbcInsert(getJdbcTemplate()).withTableName("region").usingGeneratedKeyColumns("region_id");
        vSimpleJdbcInsert.execute(vSqlParameters);

        return pRegion;
    }

    /**
     * La méthode update permet de mettre à jour une instance de Region dans la base de données
     *
     * @param pRegion est un objet Region passé et configuré depuis la couche Business
     * @return l'objet Region passé en paramètre de la méthode
     * @see com.antazri.climbingclub.consumer.rowmapper.RegionRM
     */
    public Region update(Region pRegion) {
        //Requête SQL
        String vSql = "UPDATE public.region SET nom = :nom WHERE region.region_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pRegion.getRegionId());
        vSqlParameters.addValue("nom", pRegion.getRegionNom());

        // Mise à jour de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);

        return pRegion;

    }

    /**
     * La méthode delete permet de supprimer une instance de Region dans la base de données
     *
     * @param pRegion est un objet Region passé et configuré depuis la couche Business
     */
    public void delete(Region pRegion) {
        //Requête SQL
        String vSql = "DELETE FROM public.region WHERE region.region_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pRegion.getRegionId());

        // Suppression de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
