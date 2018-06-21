package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ICommentaireDao;
import com.antazri.climbingclub.consumer.rowmapper.CommentaireRM;
import com.antazri.climbingclub.consumer.rowmapper.SpotRM;
import com.antazri.climbingclub.consumer.rowmapper.TopoRM;
import com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentaireDao extends AbstractDao implements ICommentaireDao {

    public Commentaire findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire " +
                "WHERE commentaire.commentaire_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        // Récupération du résultat et affectation des attributs
        Commentaire commentaire = (Commentaire) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new CommentaireRM());
        commentaire.setUtilisateur(getAuthor(commentaire.getUtilisateur().getUtilisateurId()));
        commentaire.setSpot(getSpot(commentaire.getSpot().getSpotId()));
        commentaire.setTopo(getTopo(commentaire.getTopo().getTopoId()));

        return commentaire;
    }

    public List<Commentaire> findBySpot(Spot pSpot) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.spot_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSpot.getSpotId());

        //Récupération du résultat et affectation des attributs
        List<Commentaire> commentaires = getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireRM());

        for (Commentaire commentaire : commentaires) {
            commentaire.setUtilisateur(getAuthor(commentaire.getUtilisateur().getUtilisateurId()));
            commentaire.setSpot(getSpot(commentaire.getSpot().getSpotId()));
            commentaire.setTopo(getTopo(commentaire.getTopo().getTopoId()));
        }

        return commentaires;
    }

    public List<Commentaire> findByTopo(Topo pTopo) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.topo_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pTopo.getTopoId());

        //Récupération du résultat et affectation des attributs
        List<Commentaire> commentaires = getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireRM());

        for (Commentaire commentaire : commentaires) {
            commentaire.setUtilisateur(getAuthor(commentaire.getUtilisateur().getUtilisateurId()));
            commentaire.setSpot(getSpot(commentaire.getSpot().getSpotId()));
            commentaire.setTopo(getTopo(commentaire.getTopo().getTopoId()));
        }

        return commentaires;
    }

    public List<Commentaire> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire";

        //Récupération du résultat et affectation des attributs
        List<Commentaire> commentaires = getJdbcTemplate().query(vSql, new CommentaireRM());

        for (Commentaire commentaire : commentaires) {
            commentaire.setUtilisateur(getAuthor(commentaire.getUtilisateur().getUtilisateurId()));
            commentaire.setSpot(getSpot(commentaire.getSpot().getSpotId()));
            commentaire.setTopo(getTopo(commentaire.getTopo().getTopoId()));
        }

        return commentaires;
    }

    public Commentaire create(Commentaire pCommentaire) {
        // Requête SQL
        String vSql = "INSERT INTO public.commentaire (contenu, utilisateur_id, spot_id, topo_id) "
                + "VALUES (?, ?, ?, ?)";

        getJdbcTemplate().update(vSql, pCommentaire.getContenu(),
                                        pCommentaire.getUtilisateur().getUtilisateurId(),
                                        pCommentaire.getSpot().getSpotId(),
                                        pCommentaire.getTopo().getTopoId());

        return pCommentaire;
    }

    public Commentaire update(Commentaire pCommentaire) {
        //Requête SQL
        String vSql = "UPDATE public.commentaire "
                + "SET commentaire.nom = :nom, "
                + "commentaire.parent_commentaire_id = :parentCommentId, "
                + "commentaire.utilisateur_id = :utilisateurId, "
                + "commentaire.spot_id = :spotId, "
                + "commentaire.topo_id = :topoId "
                + "WHERE commentaire.commentaire_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("contenu", pCommentaire.getContenu());
        vSqlParameters.addValue("utilisateurId", pCommentaire.getUtilisateur().getUtilisateurId());
        vSqlParameters.addValue("spotId", pCommentaire.getSpot().getSpotId());
        vSqlParameters.addValue("topoId", pCommentaire.getTopo().getTopoId());
        vSqlParameters.addValue("id", pCommentaire.getCommentaireId());

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);

        return pCommentaire;
    }

    public void delete(Commentaire pCommentaire) {
        // Requête SQL
        String vSql = "DELETE FROM public.commentaire WHERE commentaire.commentaire_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pCommentaire.getCommentaireId());

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

    public Topo getTopo(Integer pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.topo " +
                "FULL JOIN public.utilisateur ON topo.utilisateur_id = utilisateur.utilisateur_id " +
                "FULL JOIN public.statut ON utilisateur.statut_id = statut.statut_id " +
                "WHERE topo.topo_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Topo) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new TopoRM());
    }

    public Spot getSpot(Integer pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.spot " +
                "FULL JOIN public.region ON spot.region_id = region.region_id " +
                "FULL JOIN public.topo ON spot.topo_id = topo.topo_id " +
                "FULL JOIN public.utilisateur ON topo.utilisateur_id = utilisateur.utilisateur_id " +
                "FULL JOIN public.statut ON utilisateur.statut_id = statut.statut_id " +
                "WHERE spot.spot_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Spot) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new SpotRM());
    }

    public Utilisateur getAuthor(Integer pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur JOIN public.statut ON utilisateur.statut_id = statut.statut_id " +
                "WHERE utilisateur.utilisateur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Utilisateur) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new UtilisateurRM());
    }
}
