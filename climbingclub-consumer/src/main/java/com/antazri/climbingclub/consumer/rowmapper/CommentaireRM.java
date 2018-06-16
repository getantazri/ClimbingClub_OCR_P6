package com.antazri.climbingclub.consumer.rowmapper;

import com.antazri.climbingclub.consumer.contract.ICommentaireDao;
import com.antazri.climbingclub.consumer.contract.ISpotDao;
import com.antazri.climbingclub.consumer.contract.ITopoDao;
import com.antazri.climbingclub.consumer.contract.IUtilisateurDao;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentaireRM implements RowMapper {

    @Autowired
    ITopoDao topoDao;

    @Autowired
    ISpotDao spotDao;

    @Autowired
    IUtilisateurDao utilisateurDao;

    @Autowired
    ICommentaireDao commentaireDao;

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Commentaire commentaire = new Commentaire();

        commentaire.setCommentaire_id(rs.getInt("commentaire_id"));

        // On vérifie si le commentaire est présent sur une page d'un topo
        if(rs.getInt("topo_id") != 0) {
            commentaire.setTopo(topoDao.findById(rs.getInt("topo_id")));
        } else {
            Topo topo = new Topo();
            topo.setTopo_id(0);

            commentaire.setTopo(topo);
        }

        // On vérifie si le commentaire est présent sur une page d'un spot
        if(rs.getInt("spot_id") != 0) {
            commentaire.setSpot(spotDao.findById(rs.getInt("spot_id")));
        } else {
            Spot spot = new Spot();
            spot.setSpot_id(0);

            commentaire.setSpot(spot);
        }

        // Affectation d'un Utilisateur avec la méthode findById de l'attribut topoDao qui retourne une
        // instance de l'objet Utilisateur avec son id, récupéré dans le ResultSet, en paramètre
        commentaire.setUtilisateur(utilisateurDao.findById(rs.getInt("utilisateur_id")));

        commentaire.setContenu(rs.getString("contenu"));

        // On vérifie si le commentaire a un parent
        if(rs.getInt("spot_id") != 0) {
            commentaire.setSpot(spotDao.findById(rs.getInt("spot_id")));
        } else {
            Commentaire commentaireParent = new Commentaire();
            commentaireParent.setCommentaire_id(0);

            commentaire.setCommentaireParent(commentaireParent);
        }

        return commentaire;
    }
}
