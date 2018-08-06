package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ICotationDao;
import com.antazri.climbingclub.consumer.rowmapper.CotationRM;
import com.antazri.climbingclub.model.beans.Cotation;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

/**
 * Implémentation de l'interface ICotationDao. CotationDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
public class CotationDao extends AbstractDao implements ICotationDao {

    /**
     * La méthode findById permet de rechercher un objet Cotation dans la base de données via son identifiant unique
     *
     * @param pId est un Integer permettant l'identification unique d'une instance de Cotation dans la base de données
     * @return un objet Cotation configuré via le RowMapper "CotationRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CotationRM
     */
    public Cotation findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.cotation WHERE cotation.cotation_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Cotation) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new CotationRM());
    }

    /**
     * La méthode findByName permet de rechercher un objet Cotation dans la base de données via son nom
     *
     * @param pName est un String permettant l'identification d'une instance de Cotation dans la base de données
     * @return un objet Cotation configuré via le RowMapper "CotationRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CotationRM
     */
    public Cotation findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.cotation WHERE cotation.cotation_nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return (Cotation) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new CotationRM());
    }

    /**
     * La méthode findAll permet de retourner l'ensemble des instances de Cotation enregistrées dans la base de données
     *
     * @return une List d'objets Cotation configurés via le RowMapper "CotationRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CotationRM
     */
    public List<Cotation> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.cotation";

        return getJdbcTemplate().query(vSql, new CotationRM());
    }

    /**
     * La méthode create permet de créer une nouvelle instance de Cotation dans la base de données
     *
     * @param pCotation est un objet Cotation passé et configuré depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CotationRM
     */
    public int create(Cotation pCotation) {
        // Requête SQL
        String vSql = "INSERT INTO public.cotation (cotation_nom) VALUES (?)";

        return getJdbcTemplate().update(vSql, pCotation.getCotationNom());
    }

    /**
     * La méthode update permet de mettre à jour une instance de Cotation dans la base de données
     *
     * @param pCotation est un objet Cotation passé et configuré depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CotationRM
     */
    public int update(Cotation pCotation) {
        //Requête SQL
        String vSql = "UPDATE public.cotation SET cotation_nom = :nom WHERE cotation.cotation_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pCotation.getCotationNom());
        vSqlParameters.addValue("id", pCotation.getCotationId());

        return getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

    /**
     * La méthode delete permet de supprimer une instance de Cotation dans la base de données
     *
     * @param pCotation est un objet Cotation passé et configuré depuis la couche Business
     * @see com.antazri.climbingclub.consumer.rowmapper.CotationRM
     */
    public void delete(Cotation pCotation) {
        //Requête SQL
        String vSql = "DELETE FROM public.cotation WHERE cotation.cotation_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pCotation.getCotationId());

        // Mise à jour de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
