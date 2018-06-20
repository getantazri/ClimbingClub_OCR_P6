package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ITopoDao;
import com.antazri.climbingclub.consumer.rowmapper.TopoRM;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopoDao extends AbstractDao implements ITopoDao {

    public Topo findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo " +
                "FULL JOIN public.utilisateur ON topo.utilisateur_id = utilisateur.utilisateur_id " +
                "FULL JOIN public.spot ON topo." +
                "WHERE topo.topo_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Topo) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new TopoRM());
    }

    public List<Topo> findByUser(Utilisateur pUtilisateur) {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo WHERE topo.utilisateur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pUtilisateur.getUtilisateurId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new TopoRM());
    }

    public List<Topo> findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo WHERE topo.nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new TopoRM());
    }

    public List<Topo> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo";

        return getJdbcTemplate().query(vSql, new TopoRM());
    }

    public Topo create(Topo pTopo) {
        // Requête SQL
        String vSql = "INSERT INTO public.topo (utilisateur_id, nom, disponible) VALUES(?, ?, ?)";

        getJdbcTemplate().update(vSql, pTopo.getNom(), pTopo.getProprietaire().getUtilisateurId(), pTopo.isDisponible());

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
        vSqlParameters.addValue("utilisateurId", pTopo.getProprietaire().getUtilisateurId());
        vSqlParameters.addValue("nom", pTopo.getNom());
        vSqlParameters.addValue("disponible", pTopo.isDisponible());
        vSqlParameters.addValue("id", pTopo.getTopoId());

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);

        return pTopo;
    }

    public void delete(Topo pTopo) {
        // Requête SQL
        String vSql = "DELETE FROM public.topo WHERE topo.topo_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pTopo.getTopoId());

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
