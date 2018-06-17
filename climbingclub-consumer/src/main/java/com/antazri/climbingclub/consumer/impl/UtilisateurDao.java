package com.antazri.climbingclub.consumer.impl;

import com.antazri.climbingclub.consumer.contract.IUtilisateurDao;
import com.antazri.climbingclub.consumer.rowmapper.UtilisateurRM;
import com.antazri.climbingclub.model.beans.Statut;
import com.antazri.climbingclub.model.beans.Utilisateur;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UtilisateurDao extends AbstractDao implements IUtilisateurDao {

    public Utilisateur findById(int pId) {
        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur WHERE utilisateur.utilisateur_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pId);

        return (Utilisateur) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new UtilisateurRM());
    }

    public List<Utilisateur> findByStatut(Statut pStatut) {
        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur WHERE utilisateur.statut_id = :id";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pStatut.getStatut_id());

        return getNamedParameterJdbcTemplate().query(vSql, vSqlParameters, new UtilisateurRM());
    }

    public Utilisateur findByName(String pName) {
        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur WHERE utilisateur.nom = :nom";

        // Définition des paramètres de la requêtes
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pName);

        return (Utilisateur) getNamedParameterJdbcTemplate().queryForObject(vSql, vSqlParameters, new UtilisateurRM());
    }

    public List<Utilisateur> findAll() {
        // Requête SQL
        String vSql = "SELECT * FROM public.utilisateur";

        return getJdbcTemplate().query(vSql, new UtilisateurRM());
    }

    public Utilisateur create(Utilisateur pUtilisateur) {
        // Requête SQL
        String vSql = "INSERT INTO public.utilisateur (nom, prenom, pseudo, email, telephone, statut_id) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        getJdbcTemplate().update(vSql, pUtilisateur.getNom(), pUtilisateur.getPrenom(), pUtilisateur.getPseudo(), pUtilisateur.getEmail(), pUtilisateur.getTelephone(), pUtilisateur.getStatut().getStatut_id());
        return pUtilisateur;
    }

    public Utilisateur update(Utilisateur pUtilisateur) {
        //Requête SQL
        String vSql = "UPDATE public.utilisateur "
                + "SET utilisateur.nom =  = :nom, "
                + "utilisateur.prenom = :prenom, "
                + "utilisateur.pseudo = :pseudo, "
                + "utilisateur.email = :email, "
                + "utilisateur.telephone = :telephone, "
                + "utilisateur.statut_id = :statutId "
                + "WHERE utilisateur.utilisateur_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("nom", pUtilisateur.getNom());
        vSqlParameters.addValue("prenom", pUtilisateur.getPrenom());
        vSqlParameters.addValue("pseudo", pUtilisateur.getPseudo());
        vSqlParameters.addValue("email", pUtilisateur.getEmail());
        vSqlParameters.addValue("telephone", pUtilisateur.getTelephone());
        vSqlParameters.addValue("statutId", pUtilisateur.getStatut().getStatut_id());
        vSqlParameters.addValue("id", pUtilisateur.getUtilisateur_id());

        // Mise à jour de l'objet dans la base de données
        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);

        return pUtilisateur;
    }

    public void delete(Utilisateur pUtilisateur) {
        // Requête SQL
        String vSql = "DELETE FROM public.utilisateur WHERE utilisateur.utilisateur_id = :id";

        // Définition des paramètres de la requête
        MapSqlParameterSource vSqlParameters = new MapSqlParameterSource();
        vSqlParameters.addValue("id", pUtilisateur.getUtilisateur_id());

        getNamedParameterJdbcTemplate().update(vSql, vSqlParameters);
    }
}
