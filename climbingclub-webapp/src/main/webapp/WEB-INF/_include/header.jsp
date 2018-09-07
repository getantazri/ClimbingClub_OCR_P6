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
                <a class="navbar-item" href="/">
                    <img src="${pageContext.request.contextPath}/img/logo.png"
                         alt="ClimbingClub - Projet 6 @ Openclassrooms" width="170" height="28">
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
                    <s:a action="doRegions" cssClass="navbar-item" namespace="/regions">En région</s:a>
                    <s:a action="doReservations" cssClass="navbar-item" namespace="/reservations">Mes réservations</s:a>
                    <a class="navbar-item" href="#"><i class="fab fa-facebook-square"></i></a>
                    <a class="navbar-item" href="#"><i class="fab fa-twitter"></i></a>
                    <a class="navbar-item" href="#"><i class="fab fa-instagram"></i></a>
                </div>
            </div>

            <div class="navbar-end">
                <div class="navbar-item">
                    <div class="field is-grouped">
                        <p class="control">
                            <s:a action="doSearch" cssClass="button is-primary is-small" namespace="/search">
                  <span class="icon">
                    <i class="fas fa-search" aria-hidden="true"></i>
                  </span>
                            </s:a>
                        </p>
                        <p class="control">
                            <s:if test="%{#session.user != null}">
                                <s:a action="doGetCompte" namespace="/compte" cssClass="button is-light is-small"
                                     title="Mon compte">
                  <span class="icon">
                    <i class="fas fa-user" aria-hidden="true"></i>
                  </span>
                                    <span><b>Mon compte</b></span>
                                </s:a>
                                <s:a action="doLogout" namespace="/login" cssClass="button is-danger is-small"
                                     title="Se déconnecter">
                                    <span><b>Se déconnecter</b></span>
                                </s:a>
                            </s:if>
                            <s:else>
                                <s:a action="doLogin" namespace="/login" cssClass="button is-danger is-small"
                                     title="Se connecter">
                  <span class="icon">
                    <i class="fas fa-user" aria-hidden="true"></i>
                  </span>
                                    <span><b>Se connecter</b></span>
                                </s:a>
                                <s:a action="doGetInscription" namespace="/login" cssClass="button is-light is-small"
                                     title="Mon compte">
                                    <span><b>Inscription</b></span>
                                </s:a>
                            </s:else>
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