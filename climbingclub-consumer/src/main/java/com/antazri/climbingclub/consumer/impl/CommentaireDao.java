package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ICommentaireDao;
import com.antazri.climbingclub.consumer.rowmapper.CommentaireRM;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentaireDao extends AbstractDao implements ICommentaireDao {

    public Commentaire findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.commentaire_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Commentaire) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new CommentaireRM());
    }

    public List<Commentaire> findByParentId(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.parent_commentaire_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireRM());
    }

    public List<Commentaire> findBySpot(Spot pSpot) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.spot_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSpot.getSpotId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireRM());
    }

    public List<Commentaire> findByTopo(Topo pTopo) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.topo_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pTopo.getTopoId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireRM());
    }

    public List<Commentaire> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire";

        return getJdbcTemplate().query(vSql, new CommentaireRM());
    }

    public Commentaire create(Commentaire pCommentaire) {
        // Requête SQL
        String vSql = "INSERT INTO public.commentaire (contenu, parent_commentaire_id, utilisateur_id, spot_id, topo_id) "
                + "VALUES (?, ?, ?, ?, ?)";

        getJdbcTemplate().update(vSql, pCommentaire.getContenu(),
                                        pCommentaire.getCommentaireParent().getCommentaireId(),
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
        vSqlParameters.addValue("parentCommentId", pCommentaire.getCommentaireParent().getCommentaireId());
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
}
