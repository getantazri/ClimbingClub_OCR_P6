package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ISpotDao;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpotDao extends AbstractDao implements ISpotDao {

    public Spot findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.spot WHERE spot.spot_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, Spot.class);
    }

    public List<Spot> findByTopo(Topo pTopo) {
        // Requête SQL
        String vSql = "SELECT * FROM public.spot WHERE spot.topo_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pTopo.getTopo_id());

        return getNamedParameterJdbcTemplate().queryForList(vSql, vSqlParameters, Spot.class);
    }

    public List<Spot> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.spot";

        return getJdbcTemplate().queryForList(vSql, Spot.class);
    }

    public Spot create(Spot pSpot) {
        // Requête SQL
        String vSql = "INSERT INTO public.spot (nom, description, hauteur, topo_id, region_id) "
                + "VALUES (?, ?, ?, ?, ?)";

        getJdbcTemplate().update(vSql, pSpot.getNom(), pSpot.getDescription(), pSpot.getHauteur(), pSpot.getTopo().getTopo_id(), pSpot.getRegion().getRegion_id());

        return pSpot;
    }

    public Spot update(Spot pSpot) {
        //Requête SQL
        String vSql = "UPDATE public.spot "
                + "SET spot.nom =  = :nom, "
                + "spot.description =  = :description, "
                + "spot.hauteur =  = :hauteur, "
                + "spot.topo_id =  = :topoId, "
                + "spot.region_id =  = :regionId "
                + "WHERE spot.spot_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pSpot.getNom());
        vSqlParameters.addValue("description", pSpot.getDescription());
        vSqlParameters.addValue("hauteur", pSpot.getHauteur());
        vSqlParameters.addValue("topoId", pSpot.getTopo().getTopo_id());
        vSqlParameters.addValue("regionId", pSpot.getRegion().getRegion_id());
        vSqlParameters.addValue("id", pSpot.getSpot_id());

        // Mise à jour de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);

        return pSpot;
    }

    public void delete(Spot pSpot) {
        //Requête SQL
        String vSql = "DELETE FROM public.spot WHERE spot.spot_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSpot.getSpot_id());

        // Suppression de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
