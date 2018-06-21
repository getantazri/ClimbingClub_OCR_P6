package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ITopoDao;
import com.antazri.climbingclub.consumer.rowmapper.TopoRM;
import com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implémentation de l'interface ITopoDao. TopoDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
@Repository
public class TopoDao extends AbstractDao implements ITopoDao {

    /**
     * La méthode findById permet de rechercher un objet Topo dans la base de données via son identifiant unique
     *
     * @param pId est un Integer permettant l'identification unique d'une instance de Topo dans la base de données
     * @return un objet Topo configuré via le RowMapper "TopoRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.TopoRM
     */
    public Topo findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo " +
                "FULL JOIN public.utilisateur ON topo.utilisateur_id = utilisateur.utilisateur_id " +
                "FULL JOIN public.statut ON utilisateur.statut_id = statut.statut_id " +
                "WHERE topo.topo_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Topo) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new TopoRM());
    }

    /**
     *  La méthode findByUser permet de rechercher une List d'objets Topo selon l'identifiant unique du Propriétaire (un Utilisateur) auquel les Topo sont rattachés.
     *  La requête SQL permet de faire une jointure avec les tables liées aux attributs de l'objet et puis l'ensemble est construit via le RowMapper "TopoRM"
     *
     * @param pUtilisateur est un objet Utilisateur à partir duquel on extrait l'identifiant unique qui servira à effectuer la recherche dans la colonne "utilisateur_id" de la table "topo"
     * @return une List d'objets Topo configurés via le RowMapper "TopoRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.TopoRM
     */
    public List<Topo> findByUser(Utilisateur pUtilisateur) {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo " +
                "FULL JOIN public.utilisateur ON topo.utilisateur_id = utilisateur.utilisateur_id " +
                "FULL JOIN public.statut ON utilisateur.statut_id = statut.statut_id " +
                "WHERE topo.utilisateur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pUtilisateur.getUtilisateurId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new TopoRM());
    }

    /**
     *  La méthode findByName permet de rechercher un objet Topo selon le nom spécifié dans la base de données.
     *  La requête SQL permet de faire une jointure avec les tables liées aux attributs de l'objet et puis l'ensemble est construit via le RowMapper "TopoRM"
     *
     * @param pName est un String  qui servira à effectuer la recherche dans la colonne "topo_nom" de la table "topo"
     * @return un objet Topo configuré via le RowMapper "TopoRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.TopoRM
     */
    public List<Topo> findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo " +
                "FULL JOIN public.utilisateur ON topo.utilisateur_id = utilisateur.utilisateur_id " +
                "FULL JOIN public.statut ON utilisateur.statut_id = statut.statut_id " +
                "WHERE topo.nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new TopoRM());
    }

    /**
     *  La méthode findAll permet de retrouver l'ensemble des instances de Topo enregistrées dans la base de données.
     *  La requête SQL permet de faire une jointure avec les tables liées aux attributs de l'objet et puis l'ensemble est construit via le RowMapper "TopoRM"
     *
     * @return un objet Topo configuré via le RowMapper "TopoRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.TopoRM
     */
    public List<Topo> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo " +
                "FULL JOIN public.utilisateur ON topo.utilisateur_id = utilisateur.utilisateur_id " +
                "FULL JOIN public.statut ON utilisateur.statut_id = statut.statut_id ";

        return getJdbcTemplate().query(vSql, new TopoRM());
    }

    /**
     * La méthode create permet de persister un objet Topo dans la base de données
     *
     * @param pTopo est un objet Topo configuré et envoyé depuis la couche Business
     * @return l'objet Topo spécifié en paramètre
     */
    public Topo create(Topo pTopo) {
        // Requête SQL
        String vSql = "INSERT INTO public.topo (utilisateur_id, nom, disponible) VALUES(?, ?, ?)";

        getJdbcTemplate().update(vSql, pTopo.getNom(), pTopo.getProprietaire().getUtilisateurId(), pTopo.isDisponible());

        return pTopo;
    }

    /**
     * La méthode update permet de mettre à jour une instance de Topo enregistrée dans la base de données
     *
     * @param pTopo est un objet Topo configuré et envoyé depuis la couche Business
     * @return l'objet Topo spécifié en paramètre
     */
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

    /**
     * La méthode delete permet de supprimer une instance de Topo enregistrée dans la base de données
     *
     * @param pTopo est un objet Topo configuré et envoyé depuis la couche Business
     */
    public void delete(Topo pTopo) {
        // Requête SQL
        String vSql = "DELETE FROM public.topo WHERE topo.topo_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pTopo.getTopoId());

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

    /**
     * La méthode getProprietaire permet de créer un objet Utilisateur que l'on affectera à l'attribut Propriétaire de l'objet
     * Topo afin de clarifier les différentes requêtes en dehors de multiples jointures
     * @param pId est l'identifiant unique retourné depuis la colonne "utilisateur_id" de la table Topo
     * @return un objet Utilisateur à affecter à l'objet Topo
     */
    public Utilisateur getProprietaire(Integer pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur " +
                "FULL JOIN public.statut ON utilisateur.statut_id = statut.statut_id " +
                "WHERE utilisateur.utilisateur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Utilisateur) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new UtilisateurRM());
    }
}
