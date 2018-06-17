package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IStatutDao;
import com.antazri.climbingclub.consumer.rowmapper.StatutRM;
import com.antazri.climbingclub.model.beans.Statut;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StatutDao extends AbstractDao implements IStatutDao {

    public Statut findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.statut WHERE statut.statut_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Statut) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new StatutRM());
    }

    public Statut findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.statut WHERE statut.nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return (Statut) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new StatutRM());
    }

    public List<Statut> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.statut";

        return getJdbcTemplate().query(vSql, new StatutRM());
    }

    public Statut create(Statut pStatut) {
        // Requête SQL
        String vSql = "INSERT INTO public.topo (nom) VALUES (?)";

        getJdbcTemplate().update(vSql, pStatut.getNom());

        return pStatut;
    }

    public Statut update(Statut pStatut) {
        // Requête SQL
        String vSql = "UPDATE public.statut "
                + "SET statut.nom = :nom "
                + "WHERE statut.statut_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pStatut.getNom());
        vSqlParameters.addValue("id", pStatut.getStatut_id());

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);

        return pStatut;
    }

    public void delete(Statut pStatut) {
        //Requête SQL
        String vSql = "DELETE FROM public.statut WHERE statut.statut_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pStatut.getStatut_id());

        // Suppression de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
