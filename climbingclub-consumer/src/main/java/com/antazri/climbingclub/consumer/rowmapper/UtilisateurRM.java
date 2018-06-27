package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation du RowMapper pour la création d'un objet Utilisateur lors de la récupération des éléments depuis la base de données
 */
public class UtilisateurRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Utilisateur
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Utilisateur construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setUtilisateurId(rs.getInt("utilisateur_id"));
        utilisateur.setNom(rs.getString("nom"));
        utilisateur.setPrenom(rs.getString("prenom"));
        utilisateur.setPseudo(rs.getString("pseudo"));
        utilisateur.setPassword(rs.getString("password"));
        utilisateur.setEmail(rs.getString("email"));
        utilisateur.setTelephone(rs.getString("telephone"));

        Statut statut = new Statut();
        statut.setStatutId(rs.getInt("statut_id"));

        utilisateur.setStatut(statut);


        return utilisateur;
    }
}

