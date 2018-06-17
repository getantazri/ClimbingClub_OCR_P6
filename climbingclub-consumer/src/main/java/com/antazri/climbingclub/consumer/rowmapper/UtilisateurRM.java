package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.consumer.contract.IStatutDao;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation du RowMapper pour la création d'un objet Utilisateur lors de la récupération des éléments depuis la base de données
 *
 * @return une instance de Utilisateur paramétrée avec les informations issues de la base de données
 */
public class UtilisateurRM implements RowMapper {

    @Autowired
    private IStatutDao statutDao;

    public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setUtilisateur_id(rs.getInt("utilisateur_id"));
        utilisateur.setNom(rs.getString("nom"));
        utilisateur.setPrenom(rs.getString("prenom"));
        utilisateur.setPseudo(rs.getString("pseudo"));
        utilisateur.setPassword(rs.getString("password"));
        utilisateur.setEmail(rs.getString("email"));
        utilisateur.setTelephone(rs.getString("telephone"));

        // Récupération d'un objet Statut avec la méthode findById() de l'attribut StatutDao qui prendra la colonne
        // "statut_id" du ResultSet
        utilisateur.setStatut(statutDao.findById(rs.getInt("statut_id")));

        return utilisateur;
    }
}

