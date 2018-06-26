package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IStatutDao;
import com.antazri.climbingclub.consumer.rowmapper.StatutRM;
import com.antazri.climbingclub.model.beans.Statut;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implémentation de l'interface IStatutDao. StatutDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
@Repository
public class StatutDao extends AbstractDao implements IStatutDao {

    /**
     * La méthode findById permet de rechercher un objet Statut dans la base de données via son identifiant unique
     *
     * @param pId est un Integer permettant l'identification unique d'une instance de Statut dans la base de données
     * @return un objet Statut configuré via le RowMapper "StatutRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.StatutRM
     */
    public Statut findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.statut WHERE statut.statut_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Statut) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new StatutRM());
    }

    /**
     * La méthode findByName permet de rechercher un objet Statut dans la base de données via son nom
     *
     * @param pName est un String permettant l'identification d'une instance de Statut dans la base de données
     * @return un objet Statut configuré via le RowMapper "StatutRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.StatutRM
     */
    public Statut findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.statut WHERE statut.statut_nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return (Statut) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new StatutRM());
    }

    /**
     * La méthode findAll permet de retourner l'ensemble des instances de Statut enregistrées dans la base de données
     *
     * @return une List d'objets Statut configurés via le RowMapper "StatutRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.StatutRM
     */
    public List<Statut> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.statut";

        return getJdbcTemplate().query(vSql, new StatutRM());
    }

    /**
     * La méthode create permet de créer une nouvelle instance de Statut dans la base de données
     *
     * @param pStatut est un objet Statut passé et configuré depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.StatutRM
     */
    public int create(Statut pStatut) {
        // Requête SQL
        String vSql = "INSERT INTO public.statut (statut_nom) VALUES (?)";

        return getJdbcTemplate().update(vSql, pStatut.getStatutNom());
    }

    /**
     * La méthode update permet de mettre à jour une instance de Statut dans la base de données
     *
     * @param pStatut est un objet Statut passé et configuré depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.StatutRM
     */
    public int update(Statut pStatut) {
        // Requête SQL
        String vSql = "UPDATE public.statut "
                + "SET statut_nom = :nom "
                + "WHERE statut.statut_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pStatut.getStatutNom());
        vSqlParameters.addValue("id", pStatut.getStatutId());

        return getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

    /**
     * La méthode create permet de supprimer une instance de Statut dans la base de données
     *
     * @param pStatut est un objet Statut passé et configuré depuis la couche Business
     * @see com.antazri.climbingclub.consumer.rowmapper.StatutRM
     */
    public void delete(Statut pStatut) {
        //Requête SQL
        String vSql = "DELETE FROM public.statut WHERE statut.statut_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pStatut.getStatutId());

        // Suppression de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
