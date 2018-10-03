/* INSERT PART 1 */

INSERT INTO public.region 
    (region_nom)
VALUES
    ('Auvergne-Rhône-Alpes'),
    ('Bourgogne-Franche-Comté'),
    ('Bretagne'),
    ('Centre-Val de Loire'),
    ('Corse'),
    ('Grand Est'), 
    ('Guadeloupe'),
    ('Guyane'),
    ('Hauts-de-France'),
    ('Île-de-France'),
    ('Martinique '), 
    ('Mayotte'),
    ('Normandie'),
    ('Nouvelle Aquitaine '),
    ('Occitanie'),
    ('Pays de la Loire'), 
    ('Provence-Alpes-Côte Azur'),
    ('Réunion');

INSERT INTO public.statut
    (statut_nom)
VALUES
    ('administrateur'),
    ('membre');

INSERT INTO public.cotation
    (cotation_nom)
VALUES
    ('3'), ('3a'), ('3b'), ('3c'), 
    ('4'), ('4a'), ('4b'), ('4c'), 
    ('5'), ('5a'), ('5b'), ('5c'), 
    ('6'), ('6a'), ('6b'), ('6c'), 
    ('7'), ('7a'), ('7b'), ('7c'), 

    ('8'), ('8a'), ('8b'), ('8c'), 
    ('9'), ('9a'), ('9b'), ('9c');

/* INSERT PART 2 */

INSERT INTO public.utilisateur
    (nom, prenom, pseudo, password, email, telephone, statut_id)
VALUES
    ('Doe', 'John', 'JohnDoe', '$2a$04$Gel3MlOLv7B4INOpnngAyOv5hEVrjXE72Y3KgPrf7M.ATEADU4.aC', 'john.doe@google.com','+33123456789', 1),
    ('Parker', 'Peter', 'SpiderMan', '$2a$04$UqduTUTZ5uaKEIYiJqJgOeqaG/lnIUU8d0c8ZXMFQsnw4h493VJ4.', 'peter.parker@dailybugle.com','0123456789', 2),
    ('Drew', 'Jessica', 'SpiderWoman', '$2a$04$lzGObyUggc2Sd07yh37EeeUrSb9icvGwTKgL2/WFvh3g4TcyFIDXO', 'jessica.drew@shield.gov', '0123456789', 2),
    ('Danvers', 'Carol', 'CaptainM', '$2a$04$S3Q7DuWUebxZT5A/KrTkkOkpLsO.pdjpNLu1MaOXxlqVCBq3Am/a.', 'carol.danvers@airforce.gov', '0123456789', 2),
    ('Chan', 'Jackie', 'BruceLee', '$2a$04$TE076jnSuqXbO9aP18UdXeUCUU7o6u43RFUt5REZg5m1O63hiIXWa', 'jchan@adventures.net', '0123456789', 2),
    ('Chan', 'Jade', 'Mononoke', '$2a$04$zdaMUTXjrJbT3MWdX0CvMOyNl/MMpPMU9eKUsC/NiWUIoYv17EK1e', 'mononoke@adventures.net', '0123456789', 2);

INSERT INTO public.topo
    (utilisateur_id, topo_nom, disponible, region_id)
VALUES
    (1, 'Dans les Pyrénées Orientales', true, 1),
    (2, 'Escalades à Annecy', true, 2),
    (2, 'Massif des Bornes T1', false, 3),
    (2, 'Massif des Bornes T2', false, 3),
    (4, 'Krappenfels', true, 4),
    (4, 'Bassin plat', true, 4);

INSERT INTO public.spot
    (spot_nom, spot_description, hauteur, topo_id)
VALUES
    ('Vingrau', '...des soubresauts tectoniques lors de la formation des Pyrénées...', 120, 1),
    ('Mont Verrier', '...aux environs du lac d’Annecy...', 90, 2),
    ('Mont Verrier 2', '...aux environs du lac d’Annecy...', 90, 2),
    ('Col des Glières', '...aux environs du lac d’Annecy...', 30, 3),
    ('Pont de la Caille', '...aux environs du lac d’Annecy...', 50, 4),
    ('Pont de la Caille 2', '...aux environs du lac d’Annecy...', 50, 4),
    ('Pont de la Caille 3', '...aux environs du lac d’Annecy...', 50, 4),
    ('Haberhacker', '...Lorem ipsum dolor sit amet...', 30, 3),
    ('Heidenkopf', '...Lorem ipsum dolor sit amet...', 30, 4);

INSERT INTO public.secteur
    (secteur_nom, spot_id)
VALUES
    ('Le petit secteur du Vingrau 1', 1),
    ('Le grand secteur du Vingrau 2', 1),
    ('Lorem Secteur 1 du Mont Verrier', 2),
    ('Le secteur 1 du Mont Verrier 2', 3),
    ('Le sommet du Col des Glières', 4),
    ('Le très long secteur du spot du Col des Glières', 4),
    ('Le secteur #25', 4),
    ('La base du Pont de la Caille', 5),
    ('Le milieu du Pont de la Caille', 5),
    ('Le haut du Pont de la Caille', 5),
    ('Les 2/3 du Pont de la Caille 2', 6),
    ('Secteur sans nom du Pont de la Caille 3', 7),
    ('Le tour du au milieu de la moitié du quart de du PONT DE LA CAILLE', 7),
    ('Une partie du Haberhacker', 8),
    ('Une partie du Haberhacker 2', 8),
    ('Une partie du Haberhacker 3', 8),
    ('La face cachée du Heidenkopf', 9),
    ('La moitié du Heidenkopf', 9);

INSERT INTO public.voie
    (voie_nom, nombre_points, voie_description, secteur_id, cotation_id)
VALUES
    ('Voie Vingrau 1a', 20, '...Lorem ipsum description Vingrau...', 1, 2),
    ('Voie Vingrau 2a', 20, '...Lorem ipsum description Vingrau...', 1, 4),
    ('Voie du Mont Verrier 1z', 20, '...Lorem ipsum description Mont Verrier...', 2, 6),
    ('Chemin de quelque secteur 2z', 20, '...Lorem ipsum description Mont Verrier...', 2, 8),
    ('Voie voie voie 1e', 20, '...Lorem ipsum description Col des Glières...', 3, 10),
    ('Voie quelque chose 2e', 20, '...Lorem ipsum description Col des Glières...', 3, 12),
    ('Chemin aller plus haut 1r', 40, '...Lorem ipsum description Pont de la Caille...', 4, 14),
    ('Chemin pas très facile 2r', 120, '...Lorem ipsum description Pont de la Caille...', 4, 16),
    ('Chemin Tur 1t', 90, '...Lorem ipsum description Haberhacker...', 5, 18),
    ('Voie Viager 2t', 45, '...Lorem ipsum description Haberhacker...', 5, 20),
    ('Voie trop longue 1y', 200, '...Lorem ipsum description Heidenkopf...', 6, 22),
    ('Voie as-tu vu la hauteur ? 2y', 220, '...Lorem ipsum description Heidenkopf...', 6, 24), 
    ('Voie aller plus encore plus haut haut 1r', 40, '...Lorem ipsum description Pont de la Caille...', 7, 14),
    ('Voie lactée 2r', 120, '...Lorem ipsum description Pont de la Caille...', 7, 16),
    ('Voie simple 1t', 90, '...Lorem ipsum description Haberhacker...', 7, 18),
    ('Voie très simple 2t', 45, '...Lorem ipsum description Haberhacker...', 8, 20),
    ('Voie réservée aux experts 1y', 200, '...Lorem ipsum description Heidenkopf...', 9, 22),
    ('Voie AVEC UN NOM EN MAJUSCULE', 220, '...Lorem ipsum description Heidenkopf...', 9, 24),
    ('Voie 2t', 45, '...Lorem ipsum description Haberhacker...', 10, 20),
    ('Voie de saint dié 1y', 200, '...Lorem ipsum description Heidenkopf...', 11, 22),
    ('Voie de dié saint ? 2y', 220, '...Lorem ipsum description Heidenkopf...', 12, 24), 
    ('Voie de la forêt 1r', 40, '...Lorem ipsum description Pont de la Caille...', 12, 14),
    ('Voie de la montagne 2r', 120, '...Lorem ipsum description Pont de la Caille...', 13, 16),
    ('Chemin des neiges éternelles', 90, '...Lorem ipsum description Haberhacker...', 14, 18),
    ('Pente hasardeuse 2t', 45, '...Lorem ipsum description Haberhacker...', 15, 20),
    ('Voie trop longue avec un nom encore plus long 1y', 200, '...Lorem ipsum description Heidenkopf...', 16, 22),
    ('La voie est ouverte ? 2y', 220, '...Lorem ipsum description Heidenkopf...', 17, 24);

INSERT INTO public.emprunt
    (date_debut, date_fin, utilisateur_id, topo_id)
VALUES
    ('2018-10-15', '2018-10-17', 1, 1),
    ('2018-10-19', '2018-10-20', 2, 1),
    ('2018-10-17', '2018-10-18', 3, 2),
    ('2018-10-28', '2018-10-29', 4, 3),
    ('2018-11-11', '2018-11-11', 4, 4),
    ('2018-10-23', '2018-10-29', 5, 4),
    ('2018-12-01', '2018-12-03', 5, 5);