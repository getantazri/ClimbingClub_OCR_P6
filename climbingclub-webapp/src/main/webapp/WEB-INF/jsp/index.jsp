<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
                <a class="navbar-item" href="/">
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
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>

<section class="hero bg-hp-fullwidth is-fullheight">
    <div class="hero-head">
    </div>

    <div class="hero-body">
        <div class="container has-text-centered">
            <h1 class="title"><span class="hp-title">Où grimperez-vous</span><br/><span class="hp-title">demain ?</span>
            </h1>
            <s:select list="regions"
            <div class="field is-grouped is-grouped-centered has-addons">
                <div class="hp-form control has-icons-left has-icons-right">
                    <input class="input is-large" type="email" placeholder="Les Alpes ? La Réunion ?">
                    <span class="icon is-left">
            <i class="fas fa-search fa-sm"></i>
            </span>
                </div>
                <div class="control">
                    <a class="button is-black is-large">
                        <span class="btn-hp-form">En route !</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <div class="columns">


                <div class="column is-one-quarter is-offset-1">

                    <figure class="image is-3by4">
                        <img class="hp-img-bg" src="${pageContext.request.contextPath}/img/hp-001.jpg" title="Inscrivez-vous et partagez"
                             alt="Inscrivez-vous et partagez"/>
                    </figure>

                </div>

                <div class="column is-two-quarter is-offset-1">

                    <h2 class="title">Inscrivez-vous et partagez</h2>
                    <h3 class="subtitle">C'est gratuit !</h3>

                    <div class="columns">
                        <div class="column">
                            <span class="hp-icons-centered is-size-6"><i class="fas fa-book"></i> &nbsp; Des topos complets pour toute la France</span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel tristique orci, a
                                gravida odio. Etiam et lacinia odio.</p>
                        </div>

                        <div class="column">
                            <span class="hp-icons-centered is-size-6"><i class="fas fa-hands-helping"></i> &nbsp; Entre-aide dans la communauté</span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel tristique orci, a
                                gravida odio. Etiam et lacinia odio.</p>
                        </div>

                        <div class="column">
                            <span class="hp-icons-centered is-size-6"><i class="far fa-comment"></i> &nbsp; Donnez vos avis sur les topos et spots partagés </span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel tristique orci, a
                                gravida odio. Etiam et lacinia odio.</p>
                        </div>
                    </div>

                </div>

            </div>

        </section>

        <section class="section">

            <div class="columns">

                <div class="column is-one-quarter is-offset-2 has-text-right">

                    <h2 class="title">Trouvez vos destinations et vos défis de demain</h2>

                    <p>Phasellus in ipsum erat. Duis id vehicula urna. Donec lacinia ullamcorper rhoncus. Donec rhoncus
                        leo sit amet leo auctor
                        rutrum. Morbi in felis accumsan, tempus erat quis, vulputate nisl. In bibendum sed quam eu
                        sollicitudin.</p>
                </div>

                <div class="column is-one-third is-offset-1">

                    <figure class="image is-16by9 is-fullwidth">
                        <img class="hp-img-bg" src="${pageContext.request.contextPath}/img/hp-002.jpg"
                             title="Trouvez vos destinations et vos défis de demain"
                             alt="Trouvez vos destinations et vos défis de demain"/>
                    </figure>

                </div>

            </div>

            <div class="columns">
                <div class="column"></div>
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
