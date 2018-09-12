package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ICommentaireByObjectDao;
import com.antazri.climbingclub.consumer.rowmapper.CommentaireSpotRM;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.Spot;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public class CommentaireBySpotDao extends AbstractDao implements ICommentaireByObjectDao<Spot> {

    /**
     * La méthode findByObject permet de rechercher un (ou plusieurs) objet Commentaire dans la base de données selon le Spot
     * auquel il est rattaché
     *
     * @param pSpot est un objet Spot permettant l'identification de Commentaire dans la base de données via "spot_id"
     * @return une List d'objets Commentaire configurés via le RowMapper "CommentaireRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireSpotRM
     */
    @Override
    public List<Commentaire> findByObject(Spot pSpot) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire_spot "
                + "JOIN public.commentaire WHERE commentaire_spot.commentaire_id = commentaire.commentaire_id "
                + "WHERE spot_id = :id ORDER BY commentaire.date_publication DESC";

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
        String vSql = "INSERT INTO public.commentaire_topo (spot_id, commentaire_id) "
                + "VALUES (?, ?)";

        return getJdbcTemplate().update(vSql, pSpotId, pCommentaireId);
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
