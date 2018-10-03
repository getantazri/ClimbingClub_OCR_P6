# ClimbingClub_OCR_P6
Projet 6 du Parcours Développeur d'Application Java @ Openclassrooms.com


## Présentation
Cette application web est un site communautaire de partage de Topo d'escalade. Les utilisateurs sont invités à 
s'inscrire pour partager leurs topos ou en réserver d'autres. 
Un système d'administration permet aux administrateurs de gérer l'ensemble des contenus et des 
utilisateurs en dehors de la partie privée destinée aux membres (et propriétaires de topos).


## Structure du projet
Le projet se compose de plusieurs modules :
- Batch : permet de contenir et lancer les scripts (actuellement aucun n'est présent) de
l'application
- Business : contient la couche Business de l'application avec les Business Objects
- Consumer : contient la Couche Data de l'application avec les Data Access Objects
- Model : contient l'ensemble des beans / class modèles 
- Technical : permet de gérer toute la partie technique, notamment les logs de l'application
- Webapp : contient l'ensemble de la webapp dont les éléments Struts (fichier de configuration,
Actions, Services, JSP)


## Technique
Le projet utilise le JDK 8 de Java (version 1.8.171) avec :
- Spring Framework (5.0.8.RELEASE)
- Maven 3 (version incluse dans IntelliJ IDEA)
- Struts 2 (2.5.14)

La partie front est construite avec le framework Bulma.io basé sur Flexbox (nécessite des navigateurs 
récents).

La base de données utilisée est PostgreSQL 9.6 (un jeu de données de test est présent dans le
dossier DOCS/DATA).

Les mots de passe sont enregistré et hashé à l'aide BCrypt.

L'application est à déployée avec Tomcat 9.0.12.


## Fonctionnalités
- Créer un compte utilisateur
Les visiteurs ont la possibilité de s'inscrire sur le site pour accéder à d'autres 
fonctionnalités présentes sur le site. 

- Gérer des Topos/Spots/Secteurs/Voies 
Un utilisateur (ou administrateur) a la possibilité d'affichier, de créer, de modifier et de 
supprimer leurs topos/spots/secteurs/voies depuis leur compte ou en se rendant sur les pages 
des éléments (les visiteurs ne peuvent qu'afficher les informations).

- Commenter les Topos/Spots
Les membres ont la possibilité de commenter un Topo ou un Spot. 

- Réserver les Topos
Les membres peuvent réserver des topos pour une durée libre. Le propriétaire de chaque 
topo peut définir si son Topo est disponible (à la location) ou non.

- Effectuer des recherches sur le site
Un moteur de recherche permet d'effectuer une recherche selon un ou plusieurs critères 
pour retrouver un topo, un spot, un secteur ou une voie.


## Installation / Déploiement
1 - Installation de la base de données
Une fois PostgreSQL 9.6 installé, il est possible de garder la configuration actuelle :
créer une base de données appelée "climbingclub_db" sur le port 5432 avec comme propriétaire
"postgres" (mot de passe : "admin"). Pour utiliser une configuration personnalisées, 
il faut changer la configuration de la ressource JNDI dans le fichier 
"climbingclub-webapp/META-INF/context.xml"

2 - Créer la base de données
Plusieurs scripts sont disponibles dans le dossier DOCS/DATA pour créer la base de données. Le 
script 01 permet de créer l'ensemble des tables et leurs relations. La génération de clé 
primaire étant automatiqué, le script 01B permet de redémarrer les séquences PostgreSQL
(fortement conseillé pour notamment inclure le jeu de données proposé dans le script 02).

3 - Package
2 Artifacts peuvent être construits pour son déploiement : WAR et WAR Exploded. Pour 
une utilisation depuis l'IDE, préférer le WAR Exploded.


## Administration / Gestion des sources
Un Administrateur est déjà enregistré dans la base de données avec le jeu de données 
d'exemple. Un autre peut être créé en se connectant avec le premier, un lien vers 
l'interface d'administration est présent en bas de page. Un lien vers un formulaire de 
création d'utilisateur permettra d'en ajouter d'autres.

Cette même interface permet aux administrateurs de retrouver l'ensemble des contenus et de 
les gérer (ajouter, modifier, supprimer). 