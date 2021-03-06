package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Implémentation de RowMapper pour la création d'un objet Commentaire lors de la récupération des éléments depuis la base de données
 */
public class CommentaireRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Commentaire
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Commentaire construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Commentaire mapRow(ResultSet rs, int rowNum) throws SQLException {
        Commentaire commentaire = new Commentaire();

        commentaire.setCommentaireId(rs.getInt("commentaire_id"));
        commentaire.setContenu(rs.getString("contenu"));
        commentaire.setDatePublication(rs.getTimestamp("date_publication").toLocalDateTime());


        // Création et affectation d'un Auteur (Utilisateur)
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtilisateurId(rs.getInt("utilisateur_id"));
        commentaire.setUtilisateur(utilisateur);

        return commentaire;
    }
}
