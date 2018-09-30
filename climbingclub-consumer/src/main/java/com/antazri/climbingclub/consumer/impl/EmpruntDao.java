package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IEmpruntDao;
import com.antazri.climbingclub.consumer.rowmapper.EmpruntRM;
import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

/**
 * Implémentation de l'interface IEmpruntDao. EmpruntDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
public class EmpruntDao extends AbstractDao implements IEmpruntDao {

    /**
     * La méthode findById permet de rechercher un objet Emprunt dans la base de données via son identifiant unique
     *
     * @param pId est un Integer permettant l'identification unique d'une instance de Emprunt dans la base de données
     * @return un objet Emprunt configuré via le RowMapper "EmpruntRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.EmpruntRM
     */
    public Emprunt findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.emprunt WHERE emprunt.emprunt_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Emprunt) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new EmpruntRM());
    }

    /**
     * La méthode findByUtilisateur permet de rechercher un objet Emprunt dans la base de données via l'identifiant unique de
     * l'Utilisateur lié
     *
     * @param pUtilisateur est un objet Utilisateur permettant l'identification unique d'une instance de Utilisateur dans la base de données
     * @return une List d'objets Emprunt configurés via le RowMapper "EmpruntRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.EmpruntRM
     */
    public List<Emprunt> findByUtilisateur(Utilisateur pUtilisateur) {
        // Requête SQL
        String vSql = "SELECT * FROM public.emprunt WHERE emprunt.utilisateur_id = :id ORDER BY emprunt.date_debut DESC";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pUtilisateur.getUtilisateurId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new EmpruntRM());
    }

    /**
     * La méthode findByTopo permet de rechercher un objet Emprunt dans la base de données via l'identifiant unique de
     * l'objet Topo lié
     *
     * @param pTopo est un objet Topo permettant l'identification unique d'une instance de Topo dans la base de données
     * @return une List d'objets Emprunt configurés via le RowMapper "EmpruntRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.EmpruntRM
     */
    public List<Emprunt> findByTopo(Topo pTopo) {
        // Requête SQL
        String vSql = "SELECT * FROM public.emprunt WHERE emprunt.topo_id = :id ORDER BY emprunt.date_debut DESC";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pTopo.getTopoId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new EmpruntRM());
    }

    /**
     * La méthode findAll permet de retourner l'ensemble des instances de Emprunt enregistrées dans la base de données
     *
     * @return une List d'objets Emprunt configurés via le RowMapper "EmpruntRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.EmpruntRM
     */
    public List<Emprunt> findAll() {
        //Requête SQL
        String vSql = "SELECT * FROM public.emprunt ORDER BY emprunt.date_debut DESC";

        // Retourne une List<Emprunt> contenant toutes les réservations effectuées
        return getJdbcTemplate().query(vSql, new EmpruntRM());
    }

    /**
     * La méthode create permet d'enregistrer une instance de Emprunt dans la base de données
     *
     * @param pEmprunt est un objet Emprunt configuré et envoyé par la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     */
    public int create(Emprunt pEmprunt) {
        // Requête SQL
        String vSql = "INSERT INTO public.emprunt (date_debut, date_fin, utilisateur_id, topo_id) VALUES (?, ?, ?, ?)";

        return getJdbcTemplate().update(vSql, pEmprunt.getDateDebut(), pEmprunt.getDateFin(), pEmprunt.getUtilisateur().getUtilisateurId(), pEmprunt.getTopo().getTopoId());
    }

    /**
     * La méthode update permet de mettre à jour une instance de Emprunt dans la base de données
     *
     * @param pEmprunt est un objet Emprunt configuré et envoyé par la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     */
    public int update(Emprunt pEmprunt) {
        //Requête SQL
        String vSql = "UPDATE public.emprunt "
                + "SET date_debut = :dateDebut, "
                + "date_fin = :dateFin, "
                + "utilisateur_id = :utilisateurId, "
                + "topo_id = :topoId "
                + "WHERE emprunt.emprunt_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("dateDebut", pEmprunt.getDateDebut());
        vSqlParameters.addValue("dateFin", pEmprunt.getDateFin());
        vSqlParameters.addValue("utilisateurId", pEmprunt.getUtilisateur().getUtilisateurId());
        vSqlParameters.addValue("topoId", pEmprunt.getTopo().getTopoId());
        vSqlParameters.addValue("id", pEmprunt.getEmpruntId());

        // Mise à jour de l'objet dans la base de données
        return getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

    /**
     * La méthode delete permet de supprimer une instance de Emprunt dans la base de données
     *
     * @param pEmprunt est un objet Emprunt configuré et envoyé par la couche Business
     */
    public void delete(Emprunt pEmprunt) {
        //Requête SQL
        String vSql = "DELETE FROM public.emprunt WHERE emprunt.emprunt_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pEmprunt.getEmpruntId());

        // Suppression de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
