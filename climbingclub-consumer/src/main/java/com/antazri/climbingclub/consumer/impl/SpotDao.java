package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ISpotDao;
import com.antazri.climbingclub.consumer.rowmapper.SpotRM;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implémentation de l'interface ISpotDao. SpotDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
@Repository
public class SpotDao extends AbstractDao implements ISpotDao {

    /**
     * La méthode findById permet de rechercher un objet Spot dans la base de données via son identifiant unique
     *
     * @param pId est un Integer permettant l'identification unique d'une instance de Spot dans la base de données
     * @return un objet Spot configuré via le RowMapper "SpotRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.SpotRM
     */
    public Spot findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.spot " +
                "FULL JOIN public.region ON spot.region_id = region.region_id " +
                "FULL JOIN public.topo ON spot.topo_id = topo.topo_id " +
                "FULL JOIN public.utilisateur ON topo.utilisateur_id = utilisateur.utilisateur_id " +
                "FULL JOIN public.statut ON utilisateur.statut_id = statut.statut_id " +
                "WHERE spot.spot_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Spot) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new SpotRM());
    }

    /**
     *  La méthode findByTopo permet de rechercher une List d'objets Spot selon l'identifiant unique du Topo auquel les Spot sont rattachés.
     *  La requête SQL permet de faire une jointure avec les tables liées aux attributs de l'objet et puis l'ensemble est construit via le RowMapper
     *
     * @param pTopo est un objet Topo à partir duquel on extrait l'identifiant unique qui servira à effectuer la recherche dans la colonne "topo_id" de la table "spot"
     * @return une List d'objets Spot configurés via le RowMapper "SpotRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.SpotRM
     */
    public List<Spot> findByTopo(Topo pTopo) {
        // Requête SQL
        String vSql = "SELECT * FROM public.spot " +
                "FULL JOIN public.region ON spot.region_id = region.region_id " +
                "FULL JOIN public.topo ON spot.topo_id = topo.topo_id " +
                "FULL JOIN public.utilisateur ON topo.utilisateur_id = utilisateur.utilisateur_id " +
                "FULL JOIN public.statut ON utilisateur.statut_id = statut.statut_id " +
                "WHERE spot.topo_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pTopo.getTopoId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new SpotRM());
    }

    /**
     *  La méthode findAll permet de retrouver l'ensemble des instances de Spot enregistrées dans la base de données.
     *  La requête SQL permet de faire une jointure avec les tables liées aux attributs de l'objet et puis l'ensemble est construit via le RowMapper
     *
     * @return une List d'objets Spot configurés via le RowMapper "SpotRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.SpotRM
     */
    public List<Spot> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.spot " +
                "FULL JOIN public.region ON spot.region_id = region.region_id " +
                "FULL JOIN public.topo ON spot.topo_id = topo.topo_id " +
                "FULL JOIN public.utilisateur ON topo.utilisateur_id = utilisateur.utilisateur_id " +
                "FULL JOIN public.statut ON utilisateur.statut_id = statut.statut_id ";

        return getJdbcTemplate().query(vSql, new SpotRM());
    }

    /**
     * La méthode create permet de persister un objet Spot dans la base de données
     *
     * @param pSpot est un objet Spot configuré et envoyé depuis la couche Business
     * @return l'objet Spot spécifié en paramètre
     */
    public Spot create(Spot pSpot) {
        // Requête SQL
        String vSql = "INSERT INTO public.spot (nom, description, hauteur, topo_id, region_id) "
                + "VALUES (?, ?, ?, ?, ?)";

        getJdbcTemplate().update(vSql, pSpot.getNom(), pSpot.getDescription(), pSpot.getHauteur(), pSpot.getTopo().getTopoId(), pSpot.getRegion().getRegionId());

        return pSpot;
    }

    /**
     * La méthode update permet de mettre à jour une instance de Spot enregistrée dans la base de données
     *
     * @param pSpot est un objet Spot configuré et envoyé depuis la couche Business
     * @return l'objet Spot spécifié en paramètre
     */
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
        vSqlParameters.addValue("topoId", pSpot.getTopo().getTopoId());
        vSqlParameters.addValue("regionId", pSpot.getRegion().getRegionId());
        vSqlParameters.addValue("id", pSpot.getSpotId());

        // Mise à jour de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);

        return pSpot;
    }

    /**
     * La méthode delete permet de supprimer une instance de Spot enregistrée dans la base de données
     *
     * @param pSpot est un objet Spot configuré et envoyé depuis la couche Business
     */
    public void delete(Spot pSpot) {
        //Requête SQL
        String vSql = "DELETE FROM public.spot WHERE spot.spot_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSpot.getSpotId());

        // Suppression de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
