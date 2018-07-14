package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IRechercheDao;
import com.antazri.climbingclub.consumer.rowmapper.*;
import com.antazri.climbingclub.model.beans.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

/**
 * Implémentation de l'interface IRechercheDao. RechercheDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
public class RechercheDao extends AbstractDao implements IRechercheDao {

    private final String allAnswers = "Toutes";

    /**
     * La méthode rechercherTopo permet de retourner les instances de Topo ayant le paramètre pNom dans leur nom et/ou selon une certaine région puis sont
     *  construits à l'aide du RowMapper.
     *
     * @param pNom est le nom indiqué dans la zone de recherche du moteur de recherche
     * @param pNomRegion est le nom de la région spécifié dans l'un des champs du moteur de recherche
     * @return une List d'objets Topo configurés via le RowMapper "TopoRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.TopoRM
     */
    public List<Topo> rechercherTopo(String pNom, String pNomRegion) {
        // Requête SQL
        String vSql;

        if (!allAnswers.equals(pNomRegion)) {
            vSql = "SELECT * FROM public.topo " +
                    "JOIN public.region ON topo.region_id = region.region_id " +
                    "WHERE topo.topo_nom LIKE :nom " +
                    "AND region.region_nom = :region";
        } else {
            vSql = "SELECT * FROM public.topo WHERE topo.topo_nom LIKE :nom";
        }

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", "%" + pNom + "%");
        vSqlParameters.addValue("region", pNomRegion);

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new TopoRM());
    }

    /**
     * La méthode rechercherSpot permet de retourner les instances de Spot ayant le paramètre pNom dans leur nom et sont
     *  construits à l'aide du RowMapper.
     *
     * @param pNom est le nom indiqué dans la zone de recherche du moteur de recherche
     * @return une List d'objets Spot configurés via le RowMapper "SpotRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.SpotRM
     */
    public List<Spot> rechercherSpot(String pNom) {
        // Requête SQL
        String vSql = "SELECT * FROM public.spot WHERE spot.spot_nom LIKE :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", "%" + pNom + "%");

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new SpotRM());
    }

    /**
     * La méthode rechercherSecteur permet de retourner les instances de Secteur ayant le paramètre pNom dans leur nom et sont
     *  construits à l'aide du RowMapper.
     *
     * @param pNom est le nom indiqué dans la zone de recherche du moteur de recherche
     * @return une List d'objets Secteur configurés via le RowMapper "SecteurRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.SecteurRM
     */
    public List<Secteur> rechercherSecteur(String pNom) {
        // Requête SQL
        String vSql = "SELECT * FROM public.secteur WHERE secteur.secteur_nom LIKE :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", "%" + pNom + "%");

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new SecteurRM());
    }

    /**
     * La méthode rechercherVoie permet de retourner les instances de Voie ayant le paramètre pNom dans leur nom et/ou selon une certaine cotation puis sont
     *  construits à l'aide du RowMapper.
     *
     * @param pNom est le nom indiqué dans la zone de recherche du moteur de recherche
     * @param pNomCotation est le nom de la cotation spécifié dans un des champs du moteur de recherche
     * @return une List d'objets Voie configurés via le RowMapper "VoieRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.VoieRM
     */
    public List<Voie> rechercherVoie(String pNom, String pNomCotation) {
        // Requête SQL
        String vSql;

        if (!allAnswers.equals(pNomCotation)) {
            vSql = "SELECT * FROM public.voie " +
                    "JOIN public.cotation ON voie.cotation_id = cotation.cotation_id " +
                    "WHERE voie.voie_nom LIKE :nom " +
                    "AND cotation.cotation_nom LIKE :cotation";
        } else {
            vSql = "SELECT * FROM public.voie WHERE voie.voie_nom LIKE :nom";
        }

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", "%" + pNom + "%");
        vSqlParameters.addValue("cotation", pNomCotation);

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new VoieRM());
    }

    /**
     * La méthode containsPseudo permet de retourner les instances de Utilisateur ayant le paramètre pPseudo dans leur nom et sont
     *  construits à l'aide du RowMapper.
     *
     * @return une List d'objets Voie configurés via le RowMapper "UtilisateurRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM
     */
    public List<Utilisateur> rechercherUtilisateur(String pPseudo) {
        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur WHERE utilisateur.pseudo LIKE :pseudo";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("pseudo", "%" + pPseudo + "%");

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new UtilisateurRM());
    }
}
