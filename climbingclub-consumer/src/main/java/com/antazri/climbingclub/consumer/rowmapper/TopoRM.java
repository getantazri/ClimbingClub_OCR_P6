package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * La classe TopoRM implémente l'interface RowMapper pour construire des objets Topo à partir des informations récupérées depuis la base de données (ResultSet rs)
 */
public class TopoRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Topo
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Topo construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {
        Topo topo = new Topo();

        topo.setTopoId(rs.getInt("topo_id"));

        topo.setTopoNom(rs.getString("topo_nom"));
        topo.setDisponible(rs.getBoolean("disponible"));

        // Création d'un objet Utilisateur (Propriétaire)
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtilisateurId(rs.getInt("utilisateur_id"));
        utilisateur.setNom(rs.getString("nom"));
        utilisateur.setPrenom(rs.getString("prenom"));
        utilisateur.setPseudo(rs.getString("pseudo"));
        utilisateur.setEmail(rs.getString("email"));
        utilisateur.setTelephone(rs.getString("telephone"));


        // Création d'un objet Statut
        Statut statut = new Statut();
        statut.setStatutId(rs.getInt("statut_id"));
        statut.setStatutNom(rs.getString("statut_nom"));

        // Affectation du Statut à l'Utilisateur
        utilisateur.setStatut(statut);

        // Affectation de l'Utilisateur (Propriétaire) au Topo
        topo.setProprietaire(utilisateur);

        return topo;
    }
}

