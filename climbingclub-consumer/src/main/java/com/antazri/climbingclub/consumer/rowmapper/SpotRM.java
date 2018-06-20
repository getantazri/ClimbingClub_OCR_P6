package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Spot lors de la récupération des éléments depuis la base de données
 */
public class SpotRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Spot
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Spot construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Spot mapRow(ResultSet rs, int rowNum) throws SQLException {
        Spot spot = new Spot();

        spot.setSpotId(rs.getInt("spot_id"));
        spot.setNom(rs.getString("spot_nom"));
        spot.setDescription(rs.getString("spot_description"));
        spot.setHauteur(rs.getString("hauteur"));

        // Création d'un objet Region et affection à l'objet Spot
        Region region = new Region();
        region.setRegionId(rs.getInt("region_id"));
        region.setNom(rs.getString("region_nom"));
        spot.setRegion(region);

        // Création d'un objet Topo
        Topo topo = new Topo();
        topo.setTopoId(rs.getInt("topo_id"));
        topo.setNom(rs.getString("topo_nom"));
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
        statut.setNom(rs.getString("statut_nom"));

        // Affectation du Statut à l'Utilisateur
        utilisateur.setStatut(statut);

        // Affectation de l'Utilisateur (Propriétaire) au Topo
        topo.setProprietaire(utilisateur);

        // Affection de Topo à Spot
        spot.setTopo(topo);

        return spot;
    }
}

