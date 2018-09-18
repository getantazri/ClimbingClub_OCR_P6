package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.CommentaireSpot;
import com.antazri.climbingclub.model.beans.Spot;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentaireSpotRM implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        CommentaireSpot commentaireSpot = new CommentaireSpot();


        // Création et affectation d'un Commentaire
        Commentaire commentaire = new Commentaire();
        commentaire.setCommentaireId(rs.getInt("commentaire_id"));
        commentaireSpot.setCommentaire(commentaire);

        // Création et affectation d'un Topo
        Spot spot = new Spot();
        spot.setSpotId(rs.getInt("spot_id"));
        commentaireSpot.setSpot(spot);

        return commentaireSpot;
    }
}
