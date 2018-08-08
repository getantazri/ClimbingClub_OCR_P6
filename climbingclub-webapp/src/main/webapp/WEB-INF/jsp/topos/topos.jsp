<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!doctype html>

<html lang="fr">
<head>
    <meta charset="utf-8">

    <title>ClimbingClub Web Application</title>
    <meta name="description" content="Projet 6 du parcours Développeur Java @ Openclassrooms">
    <meta name="author" content="Climbingclub Web Application">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.0/css/all.css" integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt" crossorigin="anonymous">
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

        <section class="section">

            <h1 class="title">Les topos</h1>

            <h2 class="subtitle">Retrouvez l'ensemble des topos partagés par ordre alphabétique</h2>

            <div class="columns">

                <div class="column">

                    <!--<div class="tabs nav-alpha">
                        <ul>
                            <li><a href="#0-9">0 - 9</a></li>
                            <li><a href="#A">A</a></li>
                            <li><a href="#B">B</a></li>
                            <li><a href="#C">C</a></li>
                            <li><a href="#D">D</a></li>
                            <li><a href="#E">E</a></li>
                            <li><a href="#F">F</a></li>
                            <li><a href="#G">G</a></li>
                            <li><a href="#H">H</a></li>
                            <li><a href="#I">I</a></li>
                            <li><a href="#J">J</a></li>
                            <li><a href="#K">K</a></li>
                            <li><a href="#L">L</a></li>
                            <li><a href="#M">M</a></li>
                            <li><a href="#N">N</a></li>
                            <li><a href="#O">O</a></li>
                            <li><a href="#P">P</a></li>
                            <li><a href="#Q">Q</a></li>
                            <li><a href="#R">R</a></li>
                            <li><a href="#S">S</a></li>
                            <li><a href="#T">T</a></li>
                            <li><a href="#U">U</a></li>
                            <li><a href="#V">V</a></li>
                            <li><a href="#W">W</a></li>
                            <li><a href="#X">X</a></li>
                            <li><a href="#Y">Y</a></li>
                            <li><a href="#Z">Z</a></li>
                        </ul>
                    </div>-->

                    <table class="table is-striped is-hoverable is-fullwidth topo-list">

                        <thead>
                        <tr>
                            <td>Nom</td>
                            <td>Région</td>
                            <td>Propriétaire</td>
                            <td>Disponible</td>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="topos">
                            <tr>
                                <td>
                                    <s:a action="doTopoDetails" namespace="/topos">
                                        <s:param name="topoId" value="topoId" />
                                        <s:property value="topoNom" />
                                    </s:a>
                                </td>
                                <td>
                                    <s:property value="region.regionNom" />
                                </td>
                                <td>
                                    <s:property value="proprietaire.pseudo" />
                                </td>
                                <td>
                                    <s:if test="%{disponible == true}">
                                        Disponible &nbsp; <i class="fas fa-check has-text-success">
                                    </s:if>
                                    <s:else>
                                        Indisponible &nbsp; <i class="fas fa-times has-text-danger"></i>
                                    </s:else>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>

                    </table>

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
            <strong>ClimbingClub</strong> by <a href="https://www.antazri.xyz">Anthony Tazzari</a><br />
            <strong>Projet 6</strong> Parcours <strong>Développeur d'Application Java</strong> @ <a href="http://www.openclassrooms.com" target="_blank">Openclassrooms</a> - 2018
        </p>
    </div>
</footer>

<!-- Load JavaScript file -->
<script src="js/scripts.js"></script>
</body>
</html>

