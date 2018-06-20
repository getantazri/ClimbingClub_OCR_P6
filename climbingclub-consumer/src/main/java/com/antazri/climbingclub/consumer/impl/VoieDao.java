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
 * Implémentation de l'interface VoieDao. VoieDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
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
        String vSql = "SELECT * FROM public.voie " +
                "FULL JOIN public.secteur ON secteur.secteur_id = voie.secteur_id " +
                "FULL JOIN public.cotation ON cotation.cotation_id = voie.cotation_id " +
                "WHERE voie.voie_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Voie) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new VoieRM());
    }

    /**
     *  La méthode findBySecteur permet de rechercher une List d'objets Voie selon l'identifiant unique du Secteur auquel les Voies sont rattachées.
     *  La requête SQL permet de faire une jointure avec les tables Cotation et Secteur puis les objets Cotation et RowMapper sont
     *  construit à l'aide du RowMapper.
     *
     * @param pSecteur est un objet Secteur à partir duquel on extrait l'identifiant unique qui servira à effectuer la recherche dans la colonne "secteur_id" de la table "voie"
     * @return une List d'objets Voie configurés via le RowMapper "VoieRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.VoieRM
     */
    public List<Voie> findBySecteur(Secteur pSecteur) {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie " +
                "FULL JOIN public.secteur ON secteur.secteur_id = voie.secteur_id " +
                "FULL JOIN public.cotation ON cotation.cotation_id = voie.cotation_id " +
                "WHERE voie.secteur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSecteur.getSecteurId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new VoieRM());
    }

    /**
     *  La méthode findByCotation permet de rechercher une List d'objets Voie selon l'identifiant unique de Cotation auquel les Voies sont rattachées.
     *  La requête SQL permet de faire une jointure avec les tables Cotation et Secteur puis les objets Cotation et RowMapper sont
     *  construit à l'aide du RowMapper.
     *
     * @param pCotation est un objet Cotation à partir duquel on extrait l'identifiant unique qui servira à effectuer la recherche dans la colonne "cotation_id" de la table "voie"
     * @return une List d'objets Voie configurés via le RowMapper "VoieRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.VoieRM
     */
    public List<Voie> findByCotation(Cotation pCotation) {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie " +
                "FULL JOIN public.secteur ON secteur.secteur_id = voie.secteur_id " +
                "FULL JOIN public.cotation ON cotation.cotation_id = voie.cotation_id " +
                "WHERE voie.cotation_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pCotation.getCotationId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new VoieRM());
    }

    /**
     * La méthode findAll permet de retourner l'ensemble des lignes enregistrées dans la table "voie" de la base de données.
     *  La requête SQL permet de faire une jointure avec les tables Cotation et Secteur puis les objets Cotation et RowMapper sont
     *  construit à l'aide du RowMapper.
     *
     * @return une List d'objets Voie configurés via le RowMapper "VoieRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.VoieRM
     */
    public List<Voie> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.voie " +
                "FULL JOIN public.secteur ON voie.secteur_id = secteur.secteur_id " +
                "FULL JOIN public.cotation ON voie.cotation_id = cotation.cotation_id";

        return getJdbcTemplate().query(vSql, new VoieRM());
    }

    /**
     * La méthode create permet d'enregistrer une instance de Voie dans la base de données
     *
     * @param pVoie est un objet Voie configuré et envoyé par la couche Business
     * @return l'objet pVoie placé en paramètre
     */
    public Voie create(Voie pVoie) {
        // Requête SQL
        String vSql = "INSERT INTO public.voie (nom, nombre_points, description, secteur_id, cotation_id) "
                + "VALUES (?, ?, ?, ?, ?)";

        getJdbcTemplate().update(vSql, pVoie.getNom(), pVoie.getNombrePoints(), pVoie.getDescription(), pVoie.getCotation().getCotationId());

        return pVoie;
    }

    /**
     * La méthode update permet de mettre à jour une instance de Voie dans la base de données
     *
     * @param pVoie est un objet Voie configuré et envoyé par la couche Business
     * @return l'objet pVoie placé en paramètre
     */
    public Voie update(Voie pVoie) {
        //Requête SQL
        String vSql = "UPDATE public.voie "
                + "SET voie.nom =  = :nom, "
                + "voie.nom_points =  = :nbrPoints, "
                + "voie.description =  = :description, "
                + "voie.cotation_id =  = :cotationId "
                + "WHERE voie.voie_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pVoie.getNom());
        vSqlParameters.addValue("nbrPoints", pVoie.getNombrePoints());
        vSqlParameters.addValue("description", pVoie.getDescription());
        vSqlParameters.addValue("cotationId", pVoie.getCotation().getCotationId());
        vSqlParameters.addValue("id", pVoie.getVoieId());

        // Mise à jour de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);

        return pVoie;
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
