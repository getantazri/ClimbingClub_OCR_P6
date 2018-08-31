<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title"><s:property value="secteur.secteurNom"/> &nbsp;
                <s:if test="%{#session.user.utilisateurId == secteur.spot.topo.proprietaire.utilisateurId}">
                    <s:a action="doAddVoie" namespace="/voies" cssClass="button is-primary is-small">
                        <s:param name="secteurId" value="secteur.secteurId"/>
                        <span><b>Ajouter une voie</b></span>
                    </s:a>
                    <s:a action="doGetSecteurToUpdate" namespace="/secteurs" cssClass="button is-info is-small">
                        <s:param name="secteur.secteurId" value="secteur.secteurId"/>
                        <span><b>Modifier le secteur</b></span>
                    </s:a>
                    <s:a action="doDeleteSecteur" namespace="/secteurs" cssClass="button is-danger is-small">
                        <s:param name="secteur.secteurId" value="secteur.secteurId"/>
                        <span><b>Supprimer le secteur</b></span>
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
                                <p class="heading">Spot</p>
                                <p class="title">
                                    <s:a action="doSpotDetails" namespace="/spots" cssClass="no-color-change">
                                        <s:param name="spotId" value="secteur.spot.spotId"/>
                                        <s:property value="secteur.spot.spotNom"/>
                                    </s:a>
                                </p>
                            </div>
                        </div>
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Région</p>
                                <p class="title">
                                    <s:a action="doRegionDetails" namespace="/regions" cssClass="no-color-change">
                                        <s:param name="region.regionId" value="secteur.spot.topo.region.regionId"/>
                                        <s:property value="secteur.spot.topo.region.regionNom"/>
                                    </s:a>
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

                    <h2 class="subtitle">Liste des voies</h2>

                    <s:if test="%{voies == null}">
                        <div class="notification is-danger"><s:actionmessage/></div>
                    </s:if>
                    <s:else>
                        <table class="table is-striped is-hoverable is-fullwidth topo-list">

                            <thead>
                            <tr>
                                <td>Nom</td>
                                <td>Description</td>
                                <td>Nombre de points</td>
                                <td>Cotation</td>
                            </tr>
                            </thead>

                            <tbody>
                            <s:iterator value="voies">
                                <tr>
                                    <td>
                                        <s:property value="voieNom"/>
                                    </td>
                                    <td>
                                        <s:property value="voieDescription"/>
                                    </td>
                                    <td>
                                        <s:property value="nombrePoints"/>
                                    </td>
                                    <td>
                                        <s:property value="cotation.cotationNom"/>
                                    </td>
                                </tr>
                            </s:iterator>
                            </tbody>

                        </table>
                    </s:else>

                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>


