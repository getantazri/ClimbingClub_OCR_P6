package com.antazri.climbingclub.webapp.services.impl;

import com.antazri.climbingclub.business.contract.IStatutBo;
import com.antazri.climbingclub.business.contract.IUtilisateurBo;
import com.antazri.climbingclub.model.beans.Utilisateur;
import com.antazri.climbingclub.webapp.services.contract.ICompteUtilisateurService;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Implémentation de l'interface ICompteUtilisateurService. CompteUtilisateurService permet à la WebApp d'utiliser les Business Objects pour récupérer ou envoyer des objets/données,
 * liés à la fonctionnalité permettant de gérer les utilisateurs de l'application, à la base de données.
 *
 * @author Anthony T
 * @version 1.0
 */
public class CompteUtilisateurService implements ICompteUtilisateurService {

    @Autowired
    private IUtilisateurBo utilisateurBo;

    @Autowired
    private IStatutBo statutBo;

    /**
     * La méthode findUtilisateurById permet de récupérer un objet Utilisateur selon son identifiant unique via l'objet UtilisateurBo. Cette objet est automatiquement
     * instancié par Spring avec @Autowired
     * @param pId est l'identifiant unique (Integer) de l'objet Utilisateur
     * @return un objet Utilisateur retourné depuis la couche Business
     */
    public Utilisateur findUtilisateurById(int pId) {
        return utilisateurBo.findById(pId);
    }

    /**
     * La méthode findUtilisateurByStatut permet de récupérer des objets Utilisateur selon le Nom de leur attribut Statut via l'objet UtilisateurBo. Cette objet est automatiquement
     * instancié par Spring avec @Autowired
     * @param pName est un String spécifiant le nom de l'attribut Statut de l'objet Utilisateur
     * @return Une List d'objets Utilisateur retournée depuis la couche Business
     */
    public List<Utilisateur> findUtilisateurByStatut(String pName) {
        return utilisateurBo.findByStatut(statutBo.findByName(pName));
    }

    /**
     * La méthode findUtilisateurByName permet de récupérer un objet Utilisateur selon son attribut Nom via l'objet UtilisateurBo. Cette objet est automatiquement
     * instancié par Spring avec @Autowired
     * @param pName est un String spécifiant l'attribut Nom de l'objet Utilisateur
     * @return un objet Utilisateur retourné depuis la couche Business
     */
    public Utilisateur findUtilisateurByName(String pName) {
        return utilisateurBo.findByName(pName);
    }

    /**
     * La méthode findUtilisateurByPseudo permet de récupérer un objet Utilisateur selon son attribut Pseudo via l'objet UtilisateurBo. Cette objet est automatiquement
     * instancié par Spring avec @Autowired
     * @param pPseudo est un String spécifiant l'attribut Pseudo de l'objet Utilisateur
     * @return un objet Utilisateur retourné depuis la couche Business
     */
    public Utilisateur findUtilisateurByPseudo(String pPseudo) {
        return utilisateurBo.findByPseudo(pPseudo);
    }

    /**
     * La méthode findAllUtilisateur permet de récupérer l'ensemble des instances de Utilisateur enregistrées via l'objet UtilisateurBo. Cette objet est automatiquement
     * instancié par Spring avec @Autowired
     * @return Une List d'objets Utilisateur retournée depuis la couche Business
     */
    public List<Utilisateur> findAllUtilisateur() {
        return utilisateurBo.findAll();
    }

    /**
     * La méthode addUtilisateur permet de créer une instance de Utilisateur via l'objet UtilisateurBo dans la base de données. Cette objet est automatiquement
     * instancié par Spring avec @Autowired
     * @param pNom est le String spécifiant l'attribut Nom de Utilisateur
     * @param pPrenom est le String spécifiant l'attribut Prenom de Utilisateur
     * @param pPseudo est le String spécifiant l'attribut Pseudo de Utilisateur
     * @param pPassword est le String spécifiant l'attribut Password de Utilisateur
     * @param pEmail est le String spécifiant l'attribut Email de Utilisateur
     * @param pTelephone est le String spécifiant l'attribut Telephone de Utilisateur
     * @param statutId est un Integer définissant l'identifiant unique de l'attribut Statut de Utilisateur
     * @return un entier (1 ou 0) qui définira si une ligne a été ajoutée ou non
     */
    public int addUtilisateur(String pNom, String pPrenom, String pPseudo, String pPassword, String pEmail, String pTelephone, int statutId) {
        Utilisateur utilisateur = new Utilisateur();

        if (StringUtils.isNoneBlank(pNom, pPrenom, pPseudo, pPassword, pEmail, pTelephone)) {
            if (pPseudo.replace(" ", "").length() < 3) {
                return -1;
            } else {
                utilisateur.setNom(pNom);
                utilisateur.setPrenom(pPrenom);
                utilisateur.setPseudo(pPseudo);
                utilisateur.setPassword(hashPassword(pPassword));
                utilisateur.setEmail(pEmail);
                utilisateur.setTelephone(pTelephone);
                utilisateur.setStatut(statutBo.findById(statutId));

                return utilisateurBo.create(utilisateur);
            }
        } else {
            return -1;
        }
    }

    /**
     * La méthode updateUtilisateur permet de mettre à jour une instance de Utilisateur via l'objet UtilisateurBo dans la base de données. Cette objet est automatiquement
     * instancié par Spring avec @Autowired
     * @param pId est un Integer définissant l'identifiant unique de l'instance de Utilisateur à modifier
     * @param pNom est le String spécifiant l'attribut Nom de Utilisateur
     * @param pPrenom est le String spécifiant l'attribut Prenom de Utilisateur
     * @param pPseudo est le String spécifiant l'attribut Pseudo de Utilisateur
     * @param pEmail est le String spécifiant l'attribut Email de Utilisateur
     * @param pTelephone est le String spécifiant l'attribut Telephone de Utilisateur
     * @param statutId est un Integer définissant l'identifiant unique de l'attribut Statut de Utilisateur
     * @return un entier (1 ou 0) qui définira si une ligne a été modifié ou non
     */
    public int updateUtilisateur(int pId, String pNom, String pPrenom, String pPseudo, String pEmail, String pTelephone, int statutId) {
        Utilisateur utilisateur = utilisateurBo.findById(pId);

        utilisateur.setNom(pNom);
        utilisateur.setPrenom(pPrenom);
        utilisateur.setPseudo(pPseudo);
        utilisateur.setEmail(pEmail);
        utilisateur.setTelephone(pTelephone);
        utilisateur.setStatut(statutBo.findById(statutId));

        return utilisateurBo.update(utilisateur);
    }

    /**
     * La méthode deleteUtilisateur permet de supprimer une instance de Utilisateur via l'objet UtilisateurBo dans la base de données. Cette objet est automatiquement
     * instancié par Spring avec @Autowired
     * @param pId est un Integer définissant l'identifiant unique de l'instance de Utilisateur à supprimer
     */
    public void deleteUtilisateur(int pId) {
        utilisateurBo.delete(utilisateurBo.findById(pId));
    }

    /**
     * La méthode login permet de comparer la combinaison des attributs Pseudo et Password de l'objet Utilisateur afin de permettre à un utilisateur de se connecter.
     * @param pPseudo est un String définissant l'attribut Pseudo de l'objet Utilisateur
     * @param pPassword est un String définissant l'attribut Password de l'objet Utilisateur
     * @return un objet Utilisateur configuré selon l'attribut Pseudo spécifié
     */
    @Override
    public Utilisateur login(String pPseudo, String pPassword) {
        Utilisateur vUtilisateur = new Utilisateur();

        if (!StringUtils.isAllEmpty(pPseudo, pPassword)) {
            vUtilisateur = utilisateurBo.findByPseudo(pPseudo);

            if (verifyPassword(pPassword, vUtilisateur.getPassword())) {
                return vUtilisateur;
            }
        }

        vUtilisateur.setUtilisateurId(-1);
        return vUtilisateur;

    }

    @Override
    public boolean updateStatut(int pUtilisateurId, int pStatutId) {
        Utilisateur vUtilisateur = findUtilisateurById(pUtilisateurId);

        if (vUtilisateur != null) {
            vUtilisateur.setStatut(statutBo.findById(pStatutId));
            return true;
        } else {
            return false;
        }
    }

    /**
     * La méthode hashPassword utilise la dépendance BCrypt afin de haché le mot de passe renseigné par l'utilisateur. Le service va envoyé un String de 60 caractères dans
     * la base de données pour ne pas stocker ces données sensibles en clair.
     * @param pPlainPassword est un String définissant le mot de passe renseigné par l'utilisateur
     * @return un String de 60 caractères
     */
    @Override
    public String hashPassword(String pPlainPassword) {
        return BCrypt.hashpw(pPlainPassword, BCrypt.gensalt());
    }

    /**
     * La méthode verifyPassword utilise la dépendance BCrypt afin de comparer le mot de passe en clair, renseigné par l'utilisateur, et le mot de passe haché enregistré dans la
     * base de données.
     * @param pPlainPassword est un String définissant le mot de passe renseigné par l'utilisateur
     * @param pHashedPassword est un String String définissant le mot de passe haché par la méthode hashPassword()
     * @return True ou False selon si la combinaison est similaire ou non
     */
    @Override
    public boolean verifyPassword(String pPlainPassword, String pHashedPassword) {
        try {
            if (BCrypt.checkpw(pPlainPassword, pHashedPassword)) {
                return true;
            } else
                return false;
        } catch (NullPointerException pE) {
            return false;
        }

    }

    /**
     * La méthode updatePassword permet à l'utilisateur connecté de changer son mot de passe. La méthode vérifie la concordance de l'ancien mot de passe en utilisant la méthode
     * verifyPassword puis le remplace dans la base de données après avoir vérifier le nouveau mot de passe puis de le hacher l'enregistrer.
     * @param pNewPassword est un String correspondant au nouveau mot de passe spécifié
     * @param pConfirmedNewPassword est un String correspondant à la confirmation renseignée dans le formulaire
     * @param pOldPassword est un String correspondant à l'ancien mot de passe renseigné dans le formulaire
     * @param pHashedPassword est un String récupéré dans la base de données correspondant à la version hachée du mot de passe par BCrypt
     * @return un Integer pour renseigné le nombre de lignes modifiées dans la base de données
     */
    @Override
    public int updatePassword(int pUtilisateurId, String pNewPassword, String pConfirmedNewPassword, String pOldPassword, String pHashedPassword) {
        Utilisateur vUtilisateur = utilisateurBo.findById(pUtilisateurId);

        if (!StringUtils.isAnyBlank(pNewPassword, pConfirmedNewPassword, pOldPassword, pHashedPassword)) {
            if (verifyPassword(pOldPassword, pHashedPassword)) {
                if (pNewPassword.equals(pConfirmedNewPassword)) {
                    return utilisateurBo.updatePassword(vUtilisateur, hashPassword(pNewPassword));
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }
}
