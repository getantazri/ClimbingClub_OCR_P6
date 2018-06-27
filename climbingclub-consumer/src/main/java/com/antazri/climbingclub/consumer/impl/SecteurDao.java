package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ISecteurDao;
import com.antazri.climbingclub.consumer.rowmapper.SecteurRM;
import com.antazri.climbingclub.model.beans.Secteur;
import com.antazri.climbingclub.model.beans.Spot;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implémentation de l'interface ISecteurDao. SecteurDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
@Repository
public class SecteurDao extends AbstractDao implements ISecteurDao {

    /**
     * La méthode findById permet de rechercher un objet Secteur dans la base de données via son identifiant unique
     *
     * @param pId est un Integer permettant l'identification unique d'une instance de Secteur dans la base de données
     * @return un objet Secteur configuré via le RowMapper "SecteurRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.SecteurRM
     */
    public Secteur findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.secteur WHERE secteur.secteur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Secteur) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new SecteurRM());
    }

    /**
     * La méthode findByName permet de rechercher un objet Secteur dans la base de données via son nom
     *
     * @param pName est un String permettant l'identification d'une instance de Secteur dans la base de données
     * @return un objet Secteur configuré via le RowMapper "SecteurRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.SecteurRM
     */
    public Secteur findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.secteur WHERE secteur.secteur_nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return (Secteur) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new SecteurRM());
    }

    /**
     *  La méthode findBySpot permet de rechercher une List d'objets Secteur selon l'identifiant unique du Spot auquel les Secteur sont rattachés.
     *  La requête SQL permet de faire une jointure avec les tables liées aux attributs de l'objet et puis l'ensemble est construit via le RowMapper
     *
     * @param pSpot est un objet Spot à partir duquel on extrait l'identifiant unique qui servira à effectuer la recherche dans la colonne "spot_id" de la table "secteur"
     * @return une List d'objets Secteur configurés via le RowMapper "SpotRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.SpotRM
     */
    public List<Secteur> findBySpot(Spot pSpot) {
        // Requête SQL
        String vSql = "SELECT * FROM public.secteur WHERE secteur.spot_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSpot.getSpotId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new SecteurRM());
    }

    /**
     *  La méthode findAll permet de retrouver l'ensemble des instances de Secteur enregistrées dans la base de données.
     *  La requête SQL permet de faire une jointure avec les tables liées aux attributs de l'objet et puis l'ensemble est construit via le RowMapper
     *
     * @return une List d'objets Secteur configurés via le RowMapper "SecteurRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.SecteurRM
     */
    public List<Secteur> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.secteur";

        return getJdbcTemplate().query(vSql, new SecteurRM());
    }

    /**
     * La méthode create permet de persister un objet Secteur dans la base de données
     *
     * @param pSecteur est un objet Secteur configuré et envoyé depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     */
    public int create(Secteur pSecteur) {
        // Requête SQL
        String vSql = "INSERT INTO public.secteur (secteur_nom, spot_id) VALUES (?, ?)";

        return getJdbcTemplate().update(vSql, pSecteur.getSecteurNom(), pSecteur.getSpot().getSpotId());
    }

    /**
     * La méthode update permet de mettre à jour une instance de Secteur enregistrée dans la base de données
     *
     * @param pSecteur est un objet Secteur configuré et envoyé depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     */
    public int update(Secteur pSecteur) {
        //Requête SQL
        String vSql = "UPDATE public.secteur "
                + "SET secteur_nom = :nom, "
                + "spot_id = :spotId "
                + "WHERE secteur.secteur_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pSecteur.getSecteurNom());
        vSqlParameters.addValue("spotId", pSecteur.getSpot().getSpotId());
        vSqlParameters.addValue("id", pSecteur.getSecteurId());

        // Mise à jour de l'objet dans la base de données
        return getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

    /**
     * La méthode delete permet de supprimer une instance de Secteur enregistrée dans la base de données
     *
     * @param pSecteur est un objet Secteur configuré et envoyé depuis la couche Business
     */
    public void delete(Secteur pSecteur) {
        //Requête SQL
        String vSql = "DELETE FROM public.secteur WHERE secteur.secteur_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSecteur.getSecteurId());

        // Mise à jour de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
