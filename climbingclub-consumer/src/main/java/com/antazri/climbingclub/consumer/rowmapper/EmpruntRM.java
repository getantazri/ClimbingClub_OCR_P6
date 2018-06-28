package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Emprunt;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Emprunt lors de la récupération des éléments depuis la base de données
 */
public class EmpruntRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Emprunt
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Emprunt construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Emprunt mapRow(ResultSet rs, int rowNum) throws SQLException {
        Emprunt emprunt = new Emprunt();

        emprunt.setEmpruntId(rs.getInt("emprunt_id"));
        emprunt.setDateDebut(rs.getDate("date_debut"));
        emprunt.setDateFin(rs.getDate("date_fin"));

        // Création et affectation d'un objet Utilisateur
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtilisateurId(rs.getInt("utilisateur_id"));
        emprunt.setUtilisateur(utilisateur);

        // Création et affectation d'un objet Topo
        Topo topo = new Topo();
        topo.setTopoId(rs.getInt("topo_id"));
        emprunt.setTopo(topo);

        return emprunt;
    }
}
