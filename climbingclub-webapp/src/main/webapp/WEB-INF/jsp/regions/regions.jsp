<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>

<html lang="fr">
<head>
    <meta charset="utf-8">

    <title>ClimbingClub Web Application</title>
    <meta name="description" content="Projet 6 du parcours Développeur Java @ Openclassrooms">
    <meta name="author" content="Climbingclub Web Application">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
          integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bulma.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css?v=1.0">

    <link href="https://fonts.googleapis.com/css?family=Nunito:300,400,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500" rel="stylesheet">


    <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
    <![endif]-->

</head>
<body>
<header>
    <nav class="navbar is-fixed-top has-shadow is-spaced" role="navigation">
        <div class="container">
            <div class="navbar-brand">
                <a class="navbar-item" href="#">
                    <img src="${pageContext.request.contextPath}/img/logo.png" alt="ClimbingClub - Projet 6 @ Openclassrooms" width="170" height="28">
                </a>
                <!--<div class="navbar-burger burger" data-target="navbarExampleTransparentExample">
                  <span></span>
                  <span></span>
                  <span></span>
                </div>-->
            </div>

            <div class="navbar-menu">
                <div class="navbar-start">
                    <s:a action="doToposList" cssClass="navbar-item" namespace="/topos">Topos</s:a>
                    <s:a action="allRegions"  cssClass="navbar-item" namespace="/regions">En région</s:a>
                    <a class="navbar-item" href="#">Mes réservations</a>
                    <a class="navbar-item" href="#"><i class="fab fa-facebook-square"></i></a>
                    <a class="navbar-item" href="#"><i class="fab fa-twitter"></i></a>
                    <a class="navbar-item" href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>

            <div class="navbar-end">
                <div class="navbar-item">
                    <div class="field is-grouped">
                        <p class="control">
                            <a class="button is-primary is-small" title="Rechercher">
                      <span class="icon">
                        <i class="fas fa-search" aria-hidden="true"></i>
                      </span>
                            </a>
                        </p>
                        <p class="control">
                            <a class="button is-danger is-small" title="Mon compte">
                      <span class="icon">
                        <i class="fas fa-user" aria-hidden="true"></i>
                      </span>
                                <span><b>Mon compte</b></span>
                            </a>
                        </p>
                        <!-- <p class="control">
                          <a class="button is-dark" title="Retrouvez le projet sur Github">
                            <span class="icon">
                              <i class="fab fa-github" aria-hidden="true"></i>
                            </span>
                          </a>
                        </p> -->
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>

<div class="container">

    <div class="containerContent">

        <section id="en-region" class="section">

            <div class="columns">

                <div class="column has-text-left">

                    <h1 class="title is-uppercase">En région</h1>

                    <h2 class="subtitle">Parcourez l'ensemble des régions de France métropolitiaine et
                        d'outre-mer pour trouver votre prochaine destination de grimpe</h2>

                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                    <a href="#">Auvergne-Rhône-Alpes
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/01-auvergne-rhone-alpes.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Bourgogne-Franche-Comté
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/02-bourgogne-franche-comte.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Bretagne
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/03-bretagne.jpg">
                        </figure>
                    </a>
                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                    <a href="#">Centre-Val de Loire
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/04-centre-val-de-loire.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Corse
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/05-corse.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Grand Est
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/06-grand-est.jpg">
                        </figure>
                    </a>
                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                    <a href="#">Guadeloupe
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/07-guadeloupe.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Guyane
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/08-guyane.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Hauts-de-France
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/09-hauts-de-france.jpg">
                        </figure>
                    </a>
                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                    <a href="#">Île-de-France
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/10-ile-de-france.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Martinique
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/11-martinique.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Mayotte
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/12-mayotte.jpg">
                        </figure>
                    </a>
                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                    <a href="#">Normandie
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/13-normandie.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Nouvelle Aquitaine
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/14-nouvelle-aquitaine.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Occitanie
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/15-occitanie.jpg">
                        </figure>
                    </a>
                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                    <a href="#">Pays de la Loire
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/16-pays-de-la-loire.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Provence-Alpes-Côte d'Azur
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/17-provence-alpes-cote-azur.jpg">
                        </figure>
                    </a>
                </div>

                <div class="column has-text-left">
                    <a href="#">Réunion
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/18-reunion.jpg">
                        </figure>
                    </a>
                </div>

            </div>

        </section>

    </div>

</div>

<footer class="footer">
    <div class="content has-text-centered is-small">
        <p class="navbar-menu menu-footer">
            <s:a action="doToposList" cssClass="navbar-item" namespace="/topos">Topos</s:a>
            <s:a action="allRegions"  cssClass="navbar-item" namespace="/regions">En région</s:a>
            <a class="navbar-item" href="#">Mes réservations</a>
            <a class="navbar-item" href="#"><i class="fab fa-facebook-square"></i></a>
            <a class="navbar-item" href="#"><i class="fab fa-twitter"></i></a>
            <a class="navbar-item" href="#"><i class="fab fa-instagram"></i></a>
        </p>
        <p>
            <strong>ClimbingClub</strong> by <a href="https://www.antazri.xyz">Anthony Tazzari</a><br/>
            <strong>Projet 6</strong> Parcours <strong>Développeur d'Application Java</strong> @ <a
                href="http://www.openclassrooms.com" target="_blank">Openclassrooms</a> - 2018
        </p>
    </div>
</footer>

<!-- Load JavaScript file -->
<script src="js/scripts.js"></script>
</body>
</html>
