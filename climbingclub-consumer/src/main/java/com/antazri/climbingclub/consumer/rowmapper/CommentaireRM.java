package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implémentation de RowMapper pour la création d'un objet Commentaire lors de la récupération des éléments depuis la base de données
 */
public class CommentaireRM extends AbstractMapper implements RowMapper {

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


        // Création et affectation d'un Auteur (Utilisateur)
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUtilisateurId(rs.getInt("utilisateur_id"));
        commentaire.setUtilisateur(utilisateur);

        // Création et affectation d'un Topo
        Topo topo = new Topo();
        topo.setTopoId(rs.getInt("topo_id"));
        commentaire.setTopo(topo);

        // Création et affectation d'un Topo
        Spot spot = new Spot();
        spot.setSpotId(rs.getInt("spot_id"));
        commentaire.setSpot(spot);

        return commentaire;
    }
}
