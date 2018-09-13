package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.ICommentaireByObjectDao;
import com.antazri.climbingclub.consumer.rowmapper.CommentaireTopoRM;
import com.antazri.climbingclub.model.beans.Commentaire;
import com.antazri.climbingclub.model.beans.CommentaireTopo;
import com.antazri.climbingclub.model.beans.Topo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

public class CommentaireByTopoDao extends AbstractDao implements ICommentaireByObjectDao<Topo, CommentaireTopo> {

    /**
     * La méthode findByObject permet de rechercher un (ou plusieurs) objet Commentaire dans la base de données selon le Topo
     * auquel il est rattaché
     *
     * @param pTopo est un objet Topo permettant l'identification de Commentaire dans la base de données via "topo_id"
     * @return une List d'objets Commentaire configurés via le RowMapper "CommentaireRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireTopoRM
     */
    @Override
    public List<CommentaireTopo> findByObject(Topo pTopo) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire_topo "
                        + "JOIN public.commentaire ON commentaire_topo.commentaire_id = commentaire.commentaire_id "
                        + "WHERE commentaire_topo.topo_id = :id ORDER BY commentaire.date_publication DESC";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pTopo.getTopoId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireTopoRM());
    }

    /**
     * La méthode addCommentaire permet de créer une nouvelle relation entre un Commentaire et un Topo dans la base de données
     *
     * @param pTopoId est l'identifiant d'un objet Topo
     * @param pCommentaireId est l'identifiant d'un objet Commentaire
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireTopoRM
     */
    @Override
    public int addCommentaire(int pTopoId, int pCommentaireId) {
        // Requête SQL
        String vSql = "INSERT INTO public.commentaire_topo (commentaire_id, topo_id) "
                + "VALUES (?, ?)";

        return getJdbcTemplate().update(vSql, pCommentaireId, pTopoId);
    }

    /**
     * La méthode deleteCommentaire permet de supprimer une relation entre un Topo et un Commentaire dans la base de données
     *
     * @param pTopoId est l'identifiant d'un objet Topo
     * @param pCommentaireId est l'identifiant d'un objet Commentaire
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    @Override
    public void deleteCommentaire(int pTopoId, int pCommentaireId) {
        // Requête SQL
        String vSql = "DELETE FROM public.commentaire_topo WHERE commentaire_id = :commentaireId AND topo_id = :topoId";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("commentaireId", pCommentaireId);
        vSqlParameters.addValue("topoId", pTopoId);

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
