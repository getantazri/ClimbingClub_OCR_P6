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

/**
 * Implémentation de l'interface ICommentaireDao. CommentaireDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
@Repository
public class CommentaireDao extends AbstractDao implements ICommentaireDao {

    /**
     * La méthode findById permet de rechercher un objet Commentaire dans la base de données via son identifiant unique
     *
     * @param pId est un Integer permettant l'identification unique d'une instance de Commentaire dans la base de données
     * @return un objet Commentaire configuré via le RowMapper "CommentaireRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public Commentaire findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.commentaire_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Commentaire) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new CommentaireRM());
    }

    /**
     * La méthode findBySpot permet de rechercher un (ou plusieurs) objet Commentaire dans la base de données selon le Spot
     * auquel il est rattaché
     *
     * @param pSpot est un objet Spot permettant l'identification de Commentaire dans la base de données via "spot_id"
     * @return une List d'objets Commentaire configurés via le RowMapper "CommentaireRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public List<Commentaire> findBySpot(Spot pSpot) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.spot_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pSpot.getSpotId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireRM());
    }

    /**
     * La méthode findByTopo permet de rechercher un (ou plusieurs) objet Commentaire dans la base de données selon le Topo
     * auquel il est rattaché
     *
     * @param pTopo est un objet Topo permettant l'identification de Commentaire dans la base de données via "topo_id"
     * @return une List d'objets Commentaire configurés via le RowMapper "CommentaireRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public List<Commentaire> findByTopo(Topo pTopo) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.topo_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pTopo.getTopoId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireRM());
    }

    /**
     * La méthode findByUtilisateur permet de rechercher un (ou plusieurs) objet Commentaire dans la base de données selon l'Utilisateur
     * auquel il est rattaché
     *
     * @param pUtilisateur est un objet Utilisateur permettant l'identification de Commentaire dans la base de données via "utilisateur_id"
     * @return une List d'objets Commentaire configurés via le RowMapper "CommentaireRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public List<Commentaire> findByUtilisateur(Utilisateur pUtilisateur) {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire WHERE commentaire.utilisateur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pUtilisateur.getUtilisateurId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireRM());
    }

    /**
     * La méthode findAll permet de retourner l'ensemble des instances de Commentaire de la base de données
     *
     * @return une List d'objets Commentaire configurés via le RowMapper "CommentaireRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public List<Commentaire> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.commentaire";

        return getJdbcTemplate().query(vSql, new CommentaireRM());
    }

    /**
     * La méthode create permet de créer une nouvelle instance de Commentaire dans la base de données
     *
     * @param pCommentaire est un objet Commentaire passé et configuré depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public int create(Commentaire pCommentaire) {
        // Requête SQL
        String vSql = "INSERT INTO public.commentaire (contenu, utilisateur_id, spot_id, topo_id) "
                + "VALUES (?, ?, ?, ?)";

        return getJdbcTemplate().update(vSql, pCommentaire.getContenu(),
                                        pCommentaire.getUtilisateur().getUtilisateurId(),
                                        pCommentaire.getSpot().getSpotId(),
                                        pCommentaire.getTopo().getTopoId());
    }

    /**
     * La méthode create permet de mettre à jour une instance de Commentaire dans la base de données
     *
     * @param pCommentaire est un objet Commentaire passé et configuré depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public int update(Commentaire pCommentaire) {
        //Requête SQL
        String vSql = "UPDATE public.commentaire "
                + "SET contenu = :contenu, "
                + "utilisateur_id = :utilisateurId, "
                + "spot_id = :spotId, "
                + "topo_id = :topoId "
                + "WHERE commentaire.commentaire_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("contenu", pCommentaire.getContenu());
        vSqlParameters.addValue("utilisateurId", pCommentaire.getUtilisateur().getUtilisateurId());
        vSqlParameters.addValue("spotId", pCommentaire.getSpot().getSpotId());
        vSqlParameters.addValue("topoId", pCommentaire.getTopo().getTopoId());
        vSqlParameters.addValue("id", pCommentaire.getCommentaireId());

        return getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

    /**
     * La méthode create permet de supprimer une instance de Commentaire dans la base de données
     *
     * @param pCommentaire est un objet Commentaire passé et configuré depuis la couche Business
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
    public void delete(Commentaire pCommentaire) {
        // Requête SQL
        String vSql = "DELETE FROM public.commentaire WHERE commentaire.commentaire_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pCommentaire.getCommentaireId());

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

}
