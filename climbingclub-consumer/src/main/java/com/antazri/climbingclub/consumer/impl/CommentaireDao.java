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

        //Récupération du résultat et affectation des attributs
        List<Commentaire> commentaires = getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireRM());

        for (Commentaire commentaire : commentaires) {
            commentaire.setUtilisateur(getAuthor(commentaire.getUtilisateur().getUtilisateurId()));
            commentaire.setSpot(getSpot(commentaire.getSpot().getSpotId()));
            commentaire.setTopo(getTopo(commentaire.getTopo().getTopoId()));
        }

        return commentaires;
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

        //Récupération du résultat et affectation des attributs
        List<Commentaire> commentaires = getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new CommentaireRM());

        for (Commentaire commentaire : commentaires) {
            commentaire.setUtilisateur(getAuthor(commentaire.getUtilisateur().getUtilisateurId()));
            commentaire.setSpot(getSpot(commentaire.getSpot().getSpotId()));
            commentaire.setTopo(getTopo(commentaire.getTopo().getTopoId()));
        }

        return commentaires;
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

        //Récupération du résultat et affectation des attributs
        List<Commentaire> commentaires = getJdbcTemplate().query(vSql, new CommentaireRM());

        for (Commentaire commentaire : commentaires) {
            commentaire.setUtilisateur(getAuthor(commentaire.getUtilisateur().getUtilisateurId()));
            commentaire.setSpot(getSpot(commentaire.getSpot().getSpotId()));
            commentaire.setTopo(getTopo(commentaire.getTopo().getTopoId()));
        }

        return commentaires;
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

    /**
     * La méthode getTopo permet de rechercher et retourner un objet Topo qui servira à la création d'un objet
     * Commentaire dans le RowMapper "CommentaireRM". La requête récupère une instance de Topo selon l'identifiant
     * "topo_id" renseigné dans l'objet Commentaire à configurer
     *
     * @param pId est un Integer récupéré dans l'objet Commentaire à configurer
     * @return un objet Topo récupéré dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
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

    /**
     * La méthode getSpot permet de rechercher et retourner un objet Spot qui servira à la création d'un objet
     * Commentaire dans le RowMapper "CommentaireRM". La requête récupère une instance de Spot selon l'identifiant
     * "spot_id" renseigné dans l'objet Commentaire à configurer
     *
     * @param pId est un Integer récupéré dans l'objet Commentaire à configurer
     * @return un objet Topo récupéré dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
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

    /**
     * La méthode getAuthor permet de rechercher et retourner un objet Utilisateur qui servira à la création d'un objet
     * Commentaire dans le RowMapper "CommentaireRM". La requête récupère une instance de Utilisateur selon l'identifiant
     * "utilisateur_id" renseigné dans l'objet Commentaire à configurer
     *
     * @param pId est un Integer récupéré dans l'objet Commentaire à configurer
     * @return un objet Utilisateur récupéré dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.CommentaireRM
     */
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
