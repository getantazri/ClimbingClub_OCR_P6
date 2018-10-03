
CREATE SEQUENCE public.cotation_cotation_id_seq;

CREATE TABLE public.cotation (
                cotation_id INTEGER NOT NULL DEFAULT nextval('public.cotation_cotation_id_seq'),
                cotation_nom VARCHAR(10) NOT NULL,
                CONSTRAINT cotation_pk PRIMARY KEY (cotation_id)
);


ALTER SEQUENCE public.cotation_cotation_id_seq OWNED BY public.cotation.cotation_id;

CREATE SEQUENCE public.statut_statut_id_seq;

CREATE TABLE public.statut (
                statut_id INTEGER NOT NULL DEFAULT nextval('public.statut_statut_id_seq'),
                statut_nom VARCHAR(100) NOT NULL,
                CONSTRAINT statut_pk PRIMARY KEY (statut_id)
);


ALTER SEQUENCE public.statut_statut_id_seq OWNED BY public.statut.statut_id;

CREATE SEQUENCE public.utilisateur_utilisateur_id_seq;

CREATE TABLE public.utilisateur (
                utilisateur_id INTEGER NOT NULL DEFAULT nextval('public.utilisateur_utilisateur_id_seq'),
                nom VARCHAR(100) NOT NULL,
                prenom VARCHAR(100) NOT NULL,
                pseudo VARCHAR(100) NOT NULL,
                password VARCHAR NOT NULL,
                email VARCHAR(100) NOT NULL,
                telephone VARCHAR NOT NULL,
                statut_id INTEGER NOT NULL,
                CONSTRAINT utilisateur_pk PRIMARY KEY (utilisateur_id)
);


ALTER SEQUENCE public.utilisateur_utilisateur_id_seq OWNED BY public.utilisateur.utilisateur_id;

CREATE SEQUENCE public.commentaire_commentaire_id_seq;

CREATE TABLE public.commentaire (
                commentaire_id INTEGER NOT NULL DEFAULT nextval('public.commentaire_commentaire_id_seq'),
                contenu VARCHAR NOT NULL,
                date_publication TIMESTAMP NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                CONSTRAINT commentaire_pk PRIMARY KEY (commentaire_id)
);


ALTER SEQUENCE public.commentaire_commentaire_id_seq OWNED BY public.commentaire.commentaire_id;

CREATE SEQUENCE public.region_region_id_seq;

CREATE TABLE public.region (
                region_id INTEGER NOT NULL DEFAULT nextval('public.region_region_id_seq'),
                region_nom VARCHAR(100) NOT NULL,
                CONSTRAINT region_pk PRIMARY KEY (region_id)
);


ALTER SEQUENCE public.region_region_id_seq OWNED BY public.region.region_id;

CREATE SEQUENCE public.topo_topo_id_seq;

CREATE TABLE public.topo (
                topo_id INTEGER NOT NULL DEFAULT nextval('public.topo_topo_id_seq'),
                utilisateur_id INTEGER NOT NULL,
                topo_nom VARCHAR(100) NOT NULL,
                disponible BOOLEAN NOT NULL,
                region_id INTEGER NOT NULL,
                CONSTRAINT topo_pk PRIMARY KEY (topo_id)
);


ALTER SEQUENCE public.topo_topo_id_seq OWNED BY public.topo.topo_id;

CREATE TABLE public.commentaire_topo (
                commentaire_id INTEGER NOT NULL,
                topo_id INTEGER NOT NULL,
                CONSTRAINT commentaire_topo_pk PRIMARY KEY (commentaire_id, topo_id)
);


CREATE SEQUENCE public.spot_spot_id_seq;

CREATE TABLE public.spot (
                spot_id INTEGER NOT NULL DEFAULT nextval('public.spot_spot_id_seq'),
                spot_nom VARCHAR(100) NOT NULL,
                spot_description VARCHAR NOT NULL,
                hauteur INTEGER NOT NULL,
                topo_id INTEGER NOT NULL,
                CONSTRAINT spot_pk PRIMARY KEY (spot_id)
);


ALTER SEQUENCE public.spot_spot_id_seq OWNED BY public.spot.spot_id;

CREATE TABLE public.commentaire_spot (
                commentaire_id INTEGER NOT NULL,
                spot_id INTEGER NOT NULL,
                CONSTRAINT commentaire_spot_pk PRIMARY KEY (commentaire_id, spot_id)
);


CREATE SEQUENCE public.secteur_secteur_id_seq;

CREATE TABLE public.secteur (
                secteur_id INTEGER NOT NULL DEFAULT nextval('public.secteur_secteur_id_seq'),
                secteur_nom VARCHAR(100) NOT NULL,
                spot_id INTEGER NOT NULL,
                CONSTRAINT secteur_pk PRIMARY KEY (secteur_id)
);


ALTER SEQUENCE public.secteur_secteur_id_seq OWNED BY public.secteur.secteur_id;

CREATE SEQUENCE public.voie_voie_id_seq;

CREATE TABLE public.voie (
                voie_id INTEGER NOT NULL DEFAULT nextval('public.voie_voie_id_seq'),
                voie_nom VARCHAR(100) NOT NULL,
                nombre_points INTEGER NOT NULL,
                voie_description VARCHAR NOT NULL,
                secteur_id INTEGER NOT NULL,
                cotation_id INTEGER NOT NULL,
                CONSTRAINT voie_pk PRIMARY KEY (voie_id)
);


ALTER SEQUENCE public.voie_voie_id_seq OWNED BY public.voie.voie_id;

CREATE SEQUENCE public.emprunt_emprunt_id_seq;

CREATE TABLE public.emprunt (
                emprunt_id INTEGER NOT NULL DEFAULT nextval('public.emprunt_emprunt_id_seq'),
                date_debut DATE NOT NULL,
                date_fin DATE NOT NULL,
                utilisateur_id INTEGER NOT NULL,
                topo_id INTEGER NOT NULL,
                CONSTRAINT emprunt_pk PRIMARY KEY (emprunt_id)
);


ALTER SEQUENCE public.emprunt_emprunt_id_seq OWNED BY public.emprunt.emprunt_id;

ALTER TABLE public.voie ADD CONSTRAINT cotation_voie_fk
FOREIGN KEY (cotation_id)
REFERENCES public.cotation (cotation_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.utilisateur ADD CONSTRAINT statut_utilisateur_fk
FOREIGN KEY (statut_id)
REFERENCES public.statut (statut_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.emprunt ADD CONSTRAINT utilisateur_emprunt_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo ADD CONSTRAINT utilisateur_topo_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire ADD CONSTRAINT utilisateur_commentaire_fk
FOREIGN KEY (utilisateur_id)
REFERENCES public.utilisateur (utilisateur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_spot ADD CONSTRAINT commentaire_commentaire_spot_fk
FOREIGN KEY (commentaire_id)
REFERENCES public.commentaire (commentaire_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_topo ADD CONSTRAINT commentaire_commentaire_topo_fk
FOREIGN KEY (commentaire_id)
REFERENCES public.commentaire (commentaire_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.topo ADD CONSTRAINT region_topo_fk
FOREIGN KEY (region_id)
REFERENCES public.region (region_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.emprunt ADD CONSTRAINT topo_emprunt_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (topo_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.spot ADD CONSTRAINT topo_spot_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (topo_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_topo ADD CONSTRAINT topo_commentaire_topo_fk
FOREIGN KEY (topo_id)
REFERENCES public.topo (topo_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.secteur ADD CONSTRAINT spot_secteur_fk
FOREIGN KEY (spot_id)
REFERENCES public.spot (spot_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.commentaire_spot ADD CONSTRAINT spot_commentaire_spot_fk
FOREIGN KEY (spot_id)
REFERENCES public.spot (spot_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.voie ADD CONSTRAINT secteur_voie_fk
FOREIGN KEY (secteur_id)
REFERENCES public.secteur (secteur_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;