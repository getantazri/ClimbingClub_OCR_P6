package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ITopoDao;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopoDao extends AbstractDao implements ITopoDao {

    public Topo findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo WHERE topo.topo_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return namedParameterJdbcTemplate.queryForObject(vSql, vSqlParameters, Topo.class);
    }

    public List<Topo> findByUser(Utilisateur pUtilisateur) {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo WHERE topo.utilisateur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pUtilisateur.getUtilisateur_id());

        return namedParameterJdbcTemplate.queryForList(vSql, vSqlParameters, Topo.class);
    }

    public List<Topo> findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo WHERE topo.nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return namedParameterJdbcTemplate.queryForList(vSql, vSqlParameters, Topo.class);
    }

    public List<Topo> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo";

        return jdbcTemplate.queryForList(vSql, Topo.class);
    }

    public Topo create(Topo pTopo) {
        // Requête SQL
        String vSql = "INSERT INTO public.topo (utilisateur_id, nom, disponible) VALUES(?, ?, ?)";

        jdbcTemplate.update(vSql, pTopo.getNom(), pTopo.getProprietaire().getUtilisateur_id(), pTopo.isDisponible());

        return pTopo;
    }

    public Topo update(Topo pTopo) {
        // Requête SQL
        String vSql = "UPDATE public.topo "
                + "SET topo.utilisateur_id = :utilisateurId, "
                + "topo.nom = :nom, "
                + "topo.disponible = :disponible "
                + "WHERE topo.topo_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("utilisateurId", pTopo.getTopo_id());
        vSqlParameters.addValue("nom", pTopo.getTopo_id());
        vSqlParameters.addValue("disponible", pTopo.getTopo_id());
        vSqlParameters.addValue("id", pTopo.getTopo_id());

        namedParameterJdbcTemplate.update(vSql, vSqlParameters);

        return pTopo;
    }

    public void delete(Topo pTopo) {
        // Requête SQL
        String vSql = "DELETE FROM public.topo WHERE topo.topo_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pTopo.getTopo_id());

        namedParameterJdbcTemplate.update(vSql, vSqlParameters);
    }
}
