package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ICommentaireDao;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Cotation;
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

        return namedParameterJdbcTemplate.queryForObject(vSql, vSqlParameters, Commentaire.class);
    }

    public List<Commentaire> findByParentId(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.parent_commentaire_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return namedParameterJdbcTemplate.queryForList(vSql, vSqlParameters, Commentaire.class);
    }

    public List<Commentaire> findBySpot(Spot pSpot) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.spot_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSpot.getSpot_id());

        return namedParameterJdbcTemplate.queryForList(vSql, vSqlParameters, Commentaire.class);
    }

    public List<Commentaire> findByTopo(Topo pTopo) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.topo_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pTopo.getTopo_id());

        return namedParameterJdbcTemplate.queryForList(vSql, vSqlParameters, Commentaire.class);
    }

    public List<Commentaire> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire";

        return jdbcTemplate.queryForList(vSql, Commentaire.class);
    }

    public Commentaire create(Commentaire pCommentaire) {
        // Requête SQL
        String vSql = "INSERT INTO public.commentaire (contenu, parent_commentaire_id, utilisateur_id, spot_id, topo_id) "
                + "VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(vSql, pCommentaire.getContenu(), pCommentaire.getCommentaireParent().getCommentaire_id(), pCommentaire.getUtilisateur().getUtilisateur_id(), pCommentaire.getSpot().getSpot_id(), pCommentaire.getTopo().getTopo_id());

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
        vSqlParameters.addValue("parentCommentId", pCommentaire.getCommentaireParent().getCommentaire_id());
        vSqlParameters.addValue("utilisateurId", pCommentaire.getUtilisateur().getUtilisateur_id());
        vSqlParameters.addValue("spotId", pCommentaire.getSpot().getSpot_id());
        vSqlParameters.addValue("topoId", pCommentaire.getTopo().getTopo_id());
        vSqlParameters.addValue("id", pCommentaire.getCommentaire_id());

        return pCommentaire;
    }

    public void delete(Commentaire pCommentaire) {
        // Requête SQL
        String vSql = "DELETE FROM public.commentaire WHERE commentaire.commentaire_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pCommentaire.getCommentaire_id());

        namedParameterJdbcTemplate.update(vSql, vSqlParameters);
    }
}
