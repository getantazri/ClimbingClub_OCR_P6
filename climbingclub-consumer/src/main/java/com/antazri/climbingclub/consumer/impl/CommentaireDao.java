package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ICommentaireDao;
import com.antazri.climbingclub.consumer.rowmapper.CommentaireRM;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.Date;
import java.util.List;

/**
 * Implémentation de l'interface ICommentaireDao. CommentaireDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
public class CommentaireDao extends AbstractDao implements ICommentaireDao {

    /**
     * La méthode findById permet de rechercher un objet Commentaire dans la base de données via son identifiant unique
     *
     * @param pId est un Integer permettant l'identification unique d'une instance de Commentaire dans la base de données
     * @return un objet Commentaire configuré via le RowMapper "CommentaireRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public Commentaire findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.commentaire_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Commentaire) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new CommentaireRM());
    }

    /**
     * La méthode findByUtilisateur permet de rechercher un (ou plusieurs) objet Commentaire dans la base de données selon l'Utilisateur
     * auquel il est rattaché
     *
     * @param pUtilisateur est un objet Utilisateur permettant l'identification de Commentaire dans la base de données via "utilisateur_id"
     * @return une List d'objets Commentaire configurés via le RowMapper "CommentaireRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public List<Commentaire> findByUtilisateur(Utilisateur pUtilisateur) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.utilisateur_id = :id ORDER BY commentaire.date_publication DESC";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pUtilisateur.getUtilisateurId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireRM());
    }

    /**
     * La méthode findAll permet de retourner l'ensemble des instances de Commentaire de la base de données
     *
     * @return une List d'objets Commentaire configurés via le RowMapper "CommentaireRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public List<Commentaire> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire ORDER BY commentaire.date_publication DESC";

        return getJdbcTemplate().query(vSql, new CommentaireRM());
    }

    /**
     * La méthode create permet de créer une nouvelle instance de Commentaire dans la base de données
     *
     * @param pCommentaire est un objet Commentaire passé et configuré depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public int create(Commentaire pCommentaire) {
        KeyHolder vKeyHolder = new GeneratedKeyHolder();

        // Requête SQL
        String vSql = "INSERT INTO public.commentaire (contenu, utilisateur_id, date_publication) VALUES (?, ?, ?)";

        getJdbcTemplate().update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement vPreparedStatement = con.prepareStatement(vSql, Statement.RETURN_GENERATED_KEYS);
                vPreparedStatement.setString(1, pCommentaire.getContenu());
                vPreparedStatement.setInt(2, pCommentaire.getUtilisateur().getUtilisateurId());
                vPreparedStatement.setTimestamp(3, Timestamp.valueOf(pCommentaire.getDatePublication()));
                return vPreparedStatement;
            }
        }, vKeyHolder);

        pCommentaire.setCommentaireId((int) vKeyHolder.getKeys().get("commentaire_id"));

        return pCommentaire.getCommentaireId();
    }

    /**
     * La méthode create permet de mettre à jour une instance de Commentaire dans la base de données
     *
     * @param pCommentaire est un objet Commentaire passé et configuré depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public int update(Commentaire pCommentaire) {
        //Requête SQL
        String vSql = "UPDATE public.commentaire "
                + "SET contenu = :contenu, "
                + "utilisateur_id = :utilisateurId, "
                + "date_publication = :date "
                + "WHERE commentaire.commentaire_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("contenu", pCommentaire.getContenu());
        vSqlParameters.addValue("utilisateurId", pCommentaire.getUtilisateur().getUtilisateurId());
        vSqlParameters.addValue("date", Timestamp.valueOf(pCommentaire.getDatePublication()));
        vSqlParameters.addValue("id", pCommentaire.getCommentaireId());

        return getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

    /**
     * La méthode delete permet de supprimer une instance de Commentaire dans la base de données
     *
     * @param pCommentaire est un objet Commentaire passé et configuré depuis la couche Business
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public void delete(Commentaire pCommentaire) {
        // Requête SQL
        String vSql = "DELETE FROM public.commentaire WHERE commentaire.commentaire_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pCommentaire.getCommentaireId());

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

}
