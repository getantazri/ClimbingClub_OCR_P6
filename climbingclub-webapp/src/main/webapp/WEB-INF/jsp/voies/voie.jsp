<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title"><s:property value="voie.voieNom"/> &nbsp;
                <s:if test="%{#session.user.utilisateurId == voie.secteur.spot.topo.proprietaire.utilisateurId}">
                    <s:a action="doGetVoieToUpdate" namespace="/voies" cssClass="button is-info is-small">
                        <s:param name="voieId" value="voieId"/>
                        <span><b>Modifier la voie</b></span>
                    </s:a>
                    <s:a action="doDeleteVoie" namespace="/voies" cssClass="button is-danger is-small">
                        <s:param name="voieId" value="voieId"/>
                        <span><b>Supprimer la voie</b></span>
                    </s:a>
                </s:if>
            </h1>

            <div class="columns">
                <div class="column"></div>
            </div>

            <div class="columns">

                <div class="column">

                    <nav class="level is-mobile">
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Secteur</p>
                                <p class="title">
                                    <s:a action="doSecteurDetails" namespace="/secteurs" cssClass="no-color-change">
                                        <s:param name="secteur.secteurId" value="voie.secteur.secteurId"/>
                                        <s:property value="voie.secteur.secteurNom"/>
                                    </s:a>
                                </p>
                            </div>
                        </div>
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Nombre de points</p>
                                <p class="title">
                                    <s:property value="voie.nombrePoints" />
                                </p>
                            </div>
                        </div>
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Cotation</p>
                                <p class="title">
                                    <s:property value="voie.cotation.cotationNom" />
                                </p>
                            </div>
                        </div>
                    </nav>

                </div>

            </div>

            <div class="columns">
                <div class="column"></div>
            </div>

            <div class="columns">

                <div class="column">

                    <h2 class="subtitle">Description</h2>

                    <p><s:property value="voie.voieDescription" /></p>

                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>


