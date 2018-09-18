package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.CommentaireTopo;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentaireTopoRM implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        CommentaireTopo commentaireTopo = new CommentaireTopo();

        // Création et affectation d'un Commentaire
        Commentaire commentaire = new Commentaire();
        commentaire.setCommentaireId(rs.getInt("commentaire_id"));
        commentaireTopo.setCommentaire(commentaire);

        // Création et affectation d'un Topo
        Topo topo = new Topo();
        topo.setTopoId(rs.getInt("topo_id"));
        commentaireTopo.setTopo(topo);

        return commentaireTopo;
    }
}
