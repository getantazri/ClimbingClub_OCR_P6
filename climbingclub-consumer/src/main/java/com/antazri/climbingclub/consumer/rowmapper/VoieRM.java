package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Voie lors de la récupération des éléments depuis la base de données
 */
public class VoieRM implements RowMapper {

    /**
     * La méthode mapRow va parcourir le ResultSet ligne par ligne et construire un objet Voie
     * @param rs ResultSet récupéré à partir de la requête SQL envoyée par le DAO
     * @param rowNum
     * @return Un objet Voie construit et utilisable par le reste de l'application
     * @throws SQLException
     */
    public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
        Voie voie = new Voie();

        voie.setVoieId(rs.getInt("voie_id"));
        voie.setVoieNom(rs.getString("voie_nom"));
        voie.setNombrePoints(rs.getInt("nombre_points"));
        voie.setVoieDescription(rs.getString("voie_description"));

        // Création et affectation de l'objet Cotation pour l'objet Voie
        Cotation cotation = new Cotation();
        cotation.setCotationId(rs.getInt("cotation_id"));
        cotation.setCotationNom(rs.getString("cotation_nom"));
        voie.setCotation(cotation);

        // Création de l'objet Secteur
        Secteur secteur = new Secteur();
        secteur.setSecteurId(rs.getInt("secteur_id"));
        secteur.setSecteurNom(rs.getString("secteur_nom"));

        // Création d'un objet Spot
        Spot spot = new Spot();
        spot.setSpotId(rs.getInt("spot_id"));
        spot.setSpotNom(rs.getString("spot_nom"));
        spot.setSpotDescription(rs.getString("spot_description"));
        spot.setHauteur(rs.getString("hauteur"));

        // Création d'un objet Topo
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

        // Affectation du Topo au Spot
        spot.setTopo(topo);

        // Affectation du Spot au Secteur
        secteur.setSpot(spot);

        // Affectation de Secteur à Voie
        voie.setSecteur(secteur);

        return voie;
    }
}

