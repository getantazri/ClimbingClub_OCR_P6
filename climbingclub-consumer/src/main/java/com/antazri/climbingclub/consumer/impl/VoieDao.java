package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IVoieDao;
import com.antazri.climbingclub.consumer.rowmapper.VoieRM;
import com.antazri.climbingclub.model.beans.Cotation;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Voie;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implémentation de l'interface IVoieDao. VoieDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
@Repository
public class VoieDao extends AbstractDao implements IVoieDao {

    /**
     * La méthode findById permet de rechercher un objet Voie dans la base de données via son identifiant unique
     *
     * @param pId est un Integer permettant l'identification unique d'une instance de Voie dans la base de données
     * @return un objet Voie configuré via le RowMapper "VoieRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.VoieRM
     */
    public Voie findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie WHERE voie.voie_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Voie) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new VoieRM());
    }

    /**
     * La méthode findByName permet de rechercher un objet Voie dans la base de données via son nom
     *
     * @param pName est un String permettant l'identification unique d'une instance de Voie dans la base de données
     * @return un objet Voie configuré via le RowMapper "VoieRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.VoieRM
     */
    public Voie findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie WHERE voie.voie_nom LIKE :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return (Voie) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new VoieRM());
    }

    /**
     *  La méthode findBySecteur permet de rechercher une List d'objets Voie selon l'identifiant unique du Secteur auquel les Voies sont rattachées.
     *
     * @param pSecteur est un objet Secteur à partir duquel on extrait l'identifiant unique qui servira à effectuer la recherche dans la colonne "secteur_id" de la table "voie"
     * @return une List d'objets Voie configurés via le RowMapper "VoieRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.VoieRM
     */
    public List<Voie> findBySecteur(Secteur pSecteur) {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie WHERE voie.secteur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSecteur.getSecteurId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new VoieRM());
    }

    /**
     *  La méthode findByCotation permet de rechercher une List d'objets Voie selon l'identifiant unique de Cotation auquel les Voies sont rattachées.
     *
     * @param pCotation est un objet Cotation à partir duquel on extrait l'identifiant unique qui servira à effectuer la recherche dans la colonne "cotation_id" de la table "voie"
     * @return une List d'objets Voie configurés via le RowMapper "VoieRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.VoieRM
     */
    public List<Voie> findByCotation(Cotation pCotation) {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie WHERE voie.cotation_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pCotation.getCotationId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new VoieRM());
    }

    /**
     * La méthode findAll permet de retourner l'ensemble des lignes enregistrées dans la table "voie" de la base de données.
     *
     * @return une List d'objets Voie configurés via le RowMapper "VoieRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.VoieRM
     */
    public List<Voie> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie";

        return getJdbcTemplate().query(vSql, new VoieRM());
    }

    /**
     * La méthode create permet d'enregistrer une instance de Voie dans la base de données
     *
     * @param pVoie est un objet Voie configuré et envoyé par la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     */
    public int create(Voie pVoie) {
        // Requête SQL
        String vSql = "INSERT INTO public.voie (voie_nom, nombre_points, voie_description, secteur_id, cotation_id) "
                + "VALUES (?, ?, ?, ?, ?)";

        return getJdbcTemplate().update(vSql, pVoie.getVoieNom(), pVoie.getNombrePoints(), pVoie.getVoieDescription(), pVoie.getSecteur().getSecteurId(), pVoie.getCotation().getCotationId());
    }

    /**
     * La méthode update permet de mettre à jour une instance de Voie dans la base de données
     *
     * @param pVoie est un objet Voie configuré et envoyé par la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     */
    public int update(Voie pVoie) {
        //Requête SQL
        String vSql = "UPDATE public.voie "
                + "SET voie_nom = :nom, "
                + "nombre_points = :nbrPoints, "
                + "voie_description = :description, "
                + "secteur_id = :secteurId, "
                + "cotation_id = :cotationId "
                + "WHERE voie.voie_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pVoie.getVoieNom());
        vSqlParameters.addValue("nbrPoints", pVoie.getNombrePoints());
        vSqlParameters.addValue("description", pVoie.getVoieDescription());
        vSqlParameters.addValue("secteurId", pVoie.getSecteur().getSecteurId());
        vSqlParameters.addValue("cotationId", pVoie.getCotation().getCotationId());
        vSqlParameters.addValue("id", pVoie.getVoieId());

        // Mise à jour de l'objet dans la base de données
        return getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

    /**
     * La méthode create permet de supprimer une instance de Voie dans la base de données
     *
     * @param pVoie est un objet Voie configuré et envoyé par la couche Business
     */
    public void delete(Voie pVoie) {
        //Requête SQL
        String vSql = "DELETE FROM public.voie WHERE voie.voie_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pVoie.getVoieId());

        // Suppression de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
