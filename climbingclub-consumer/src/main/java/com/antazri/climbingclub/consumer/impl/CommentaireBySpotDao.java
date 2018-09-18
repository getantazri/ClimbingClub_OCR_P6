package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ICommentaireByObjectDao;
import com.antazri.climbingclub.consumer.rowmapper.CommentaireSpotRM;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.CommentaireSpot;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public class CommentaireBySpotDao extends AbstractDao implements ICommentaireByObjectDao<Spot, CommentaireSpot> {

    /**
     * La méthode findByCommentaire permet de rechercher un objet CommentaireSpot dans la base de données selon le Commentaire
     * auquel il est rattaché
     *
     * @param pCommentaire est un objet Commentaire permettant l'identification de CommentaireSpot dans la base de données via "commentaire_id"
     * @return un objet CommentaireSpot
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireSpotRM
     */
    @Override
    public CommentaireSpot findByCommentaire(Commentaire pCommentaire) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire_spot JOIN public.commentaire ON commentaire_spot.commentaire_id = commentaire.commentaire_id WHERE commentaire_spot.commentaire_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pCommentaire.getCommentaireId());

        return (CommentaireSpot) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new CommentaireSpotRM());
    }

    /**
     * La méthode findByObject permet de rechercher un (ou plusieurs) objet CommentaireSpot dans la base de données selon le Spot
     * auquel il est rattaché
     *
     * @param pSpot est un objet Spot permettant l'identification de Commentaire dans la base de données via "spot_id"
     * @return une List d'objets CommentaireSpot configurés via le RowMapper "CommentaireSpotRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireSpotRM
     */
    @Override
    public List<CommentaireSpot> findByObject(Spot pSpot) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire_spot "
                        + "JOIN public.commentaire ON commentaire_spot.commentaire_id = commentaire.commentaire_id "
                        + "WHERE commentaire_spot.spot_id = :id ORDER BY commentaire.date_publication DESC";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSpot.getSpotId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireSpotRM());
    }

    /**
     * La méthode addCommentaire permet de créer une nouvelle relation entre un Commentaire et un Spot dans la base de données
     *
     * @param pSpotId est l'identifiant unique d'un objet Spot
     * @param pCommentaireId est l'identifiant unique d'un objet Commentaire
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireTopoRM
     */
    @Override
    public int addCommentaire(int pSpotId, int pCommentaireId) {
        // Requête SQL
        String vSql = "INSERT INTO public.commentaire_spot (commentaire_id, spot_id) "
                + "VALUES (?, ?)";

        return getJdbcTemplate().update(vSql, pCommentaireId, pSpotId);
    }

    /**
     * La méthode deleteCommentaire permet de supprimer une relation entre un Spot et un Commentaire dans la base de données
     *
     * @param pSpotId est l'identifiant unique d'un objet Spot
     * @param pCommentaireId est l'identifiant unique d'un objet Commentaire
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    @Override
    public void deleteCommentaire(int pSpotId, int pCommentaireId) {
        // Requête SQL
        String vSql = "DELETE FROM public.commentaire_spot WHERE commentaire_id = :commentaireId AND spot_id = :spotId";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("commentaireId", pCommentaireId);
        vSqlParameters.addValue("spotId", pSpotId);

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
