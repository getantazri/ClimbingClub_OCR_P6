package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IUtilisateurDao;
import com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM;
import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;

/**
 * Implémentation de l'interface IUtilisateurDao. UtilisateurDao permet de récupérer les données grâce à la connexion à la DataSource obtenue via la classe AbstractDao. Les JdbcTemplate et
 * NamedParameterJdbcTemplate sont également déclarés via l'AbstractDao.
 *
 * @author Anthony T
 * @version 1.0
 */
public class UtilisateurDao extends AbstractDao implements IUtilisateurDao {

    /**
     * La méthode findById permet de rechercher un objet Utilisateur dans la base de données via son identifiant unique
     *
     * @param pId est un Integer permettant l'identification unique d'une instance de Utilisateur dans la base de données
     * @return un objet Utilisateur configuré via le RowMapper "UtilisateurRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM
     */
    public Utilisateur findById(int pId) {
        Utilisateur vUtilisateur;

        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur WHERE utilisateur.utilisateur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return getResultUtilisateur(vSql, vSqlParameters);
    }

    /**
     * La méthode findByStatut permet de rechercher un objet Utilisateur dans la base de données via l'identifiant de son statut "statut_id"
     *
     * @param pStatut est un objet Statut permettant l'identification des Utilisateur grâce à son attribut "statut_id"
     * @return une List d'objets Utilisateur configurés via le RowMapper "UtilisateurRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM
     */
    public List<Utilisateur> findByStatut(Statut pStatut) {
        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur WHERE utilisateur.statut_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pStatut.getStatutId());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new UtilisateurRM());
    }

    /**
     * La méthode findByName permet de rechercher un objet Utilisateur dans la base de données via son nom
     *
     * @param pName est un String permettant l'identification d'une instance de Utilisateur dans la base de données
     * @return un objet Utilisateur configuré via le RowMapper "UtilisateurRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM
     */
    public Utilisateur findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur WHERE utilisateur.nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return getResultUtilisateur(vSql, vSqlParameters);
    }

    /**
     * La méthode findByPseudo permet de rechercher un objet Utilisateur dans la base de données via son pseudonyme
     *
     * @param pPseudo est un String permettant l'identification d'une instance de Utilisateur dans la base de données
     * @return un objet Utilisateur configuré via le RowMapper "UtilisateurRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM
     */
    public Utilisateur findByPseudo(String pPseudo) {
        Utilisateur vUtilisateur;

        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur WHERE utilisateur.pseudo = :pseudo";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("pseudo", pPseudo);

        return getResultUtilisateur(vSql, vSqlParameters);
    }

    /**
     * La méthode findAll permet de retourner l'ensemble des instances de Utilisateur enregistrées dans la base de données
     *
     * @return une List d'objets Utilisateur configurés via le RowMapper "UtilisateurRM"
     * @see com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM
     */
    public List<Utilisateur> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur";

        return getJdbcTemplate().query(vSql, new UtilisateurRM());
    }

    /**
     * La méthode create permet de créer une nouvelle instance de Utilisateur dans la base de données
     *
     * @param pUtilisateur est un objet Utilisateur passé et configuré depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM
     */
    public int create(Utilisateur pUtilisateur) {
        // Requête SQL
        String vSql = "INSERT INTO public.utilisateur (nom, prenom, pseudo, password, email, telephone, statut_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        return getJdbcTemplate().update(vSql, pUtilisateur.getNom(),
                                        pUtilisateur.getPrenom(),
                                        pUtilisateur.getPseudo(),
                                        pUtilisateur.getPassword(),
                                        pUtilisateur.getEmail(),
                                        pUtilisateur.getTelephone(),
                                        pUtilisateur.getStatut().getStatutId());
    }

    /**
     * La méthode create permet de mettre à jour une instance de Utilisateur dans la base de données
     *
     * @param pUtilisateur est un objet Utilisateur passé et configuré depuis la couche Business
     * @return un Integer indiquant le nombre de lignes modifiées dans la base de données
     * @see com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM
     */
    public int update(Utilisateur pUtilisateur) {
        //Requête SQL
        String vSql = "UPDATE public.utilisateur "
                + "SET nom = :nom, "
                + "prenom = :prenom, "
                + "pseudo = :pseudo, "
                + "password = :password, "
                + "email = :email, "
                + "telephone = :telephone, "
                + "statut_id = :statutId "
                + "WHERE utilisateur.utilisateur_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pUtilisateur.getNom());
        vSqlParameters.addValue("prenom", pUtilisateur.getPrenom());
        vSqlParameters.addValue("pseudo", pUtilisateur.getPseudo());
        vSqlParameters.addValue("password", pUtilisateur.getPassword());
        vSqlParameters.addValue("email", pUtilisateur.getEmail());
        vSqlParameters.addValue("telephone", pUtilisateur.getTelephone());
        vSqlParameters.addValue("statutId", pUtilisateur.getStatut().getStatutId());
        vSqlParameters.addValue("id", pUtilisateur.getUtilisateurId());

        // Mise à jour de l'objet dans la base de données
        return getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

    /**
     * La méthode create permet de supprimer une instance de Utilisateur dans la base de données
     *
     * @param pUtilisateur est un objet Utilisateur passé et configuré depuis la couche Business
     * @see com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM
     */
    public void delete(Utilisateur pUtilisateur) {
        // Requête SQL
        String vSql = "DELETE FROM public.utilisateur WHERE utilisateur.utilisateur_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pUtilisateur.getUtilisateurId());

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }

    public Utilisateur getResultUtilisateur(String vSql, MapSqlParameterSource vSqlParameters) {
        Utilisateur vUtilisateur;

        try {
            vUtilisateur = (Utilisateur) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new UtilisateurRM());
        } catch (EmptyResultDataAccessException pE) {
            //pE.printStackTrace();
            vUtilisateur = new Utilisateur();
            vUtilisateur.setUtilisateurId(-1);
        }

        return vUtilisateur;
    }
}
