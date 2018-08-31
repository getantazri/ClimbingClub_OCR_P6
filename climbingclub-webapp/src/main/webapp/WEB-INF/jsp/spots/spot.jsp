<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title"><s:property value="spot.spotNom"/> &nbsp;
                <s:if test="%{#session.user.utilisateurId == spot.topo.proprietaire.utilisateurId}">
                    <s:a action="doAddSecteur" namespace="/secteurs" cssClass="button is-primary is-small">
                        <s:param name="spot.spotId" value="spot.spotId" />
                        <span><b>Ajouter un secteur</b></span>
                    </s:a>
                    <s:a action="doGetSpotToUpdate" namespace="/spots" cssClass="button is-info is-small">
                        <s:param name="spotId" value="spot.spotId" />
                        <span><b>Modifier le spot</b></span>
                    </s:a>
                    <s:a action="doDeleteSpot" namespace="/spots" cssClass="button is-danger is-small">
                        <s:param name="spotId" value="spot.spotId" />
                        <span><b>Supprimer le spot</b></span>
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
                                <p class="heading">Topo</p>
                                <p class="title">
                                    <s:a action="doTopoDetails" namespace="/topos" cssClass="no-color-change">
                                        <s:param name="topoId" value="spot.topo.topoId"/>
                                        <s:property value="spot.topo.topoNom"/>
                                    </s:a>
                                </p>
                            </div>
                        </div>
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Région</p>
                                <p class="title">
                                    <s:a action="doRegionDetails" namespace="/regions" cssClass="no-color-change">
                                        <s:param name="region.regionId" value="spot.topo.region.regionId"/>
                                        <s:property value="spot.topo.region.regionNom"/>
                                    </s:a>
                                </p>
                            </div>
                        </div>
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Hauteur</p>
                                <p class="title"><s:property value="%{spot.hauteur}"/>m</p>
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

                    <p><s:property value="spot.spotDescription" /></p>

                </div>

            </div>

            <div class="columns">
                <div class="column"></div>
            </div>

            <div class="columns">

                <div class="column">

                    <h2 class="subtitle">Liste des secteurs</h2>

                    <s:if test="%{secteurs == null}">
                        <div class="notification is-danger"><s:actionmessage/></div>
                    </s:if>
                    <s:else>
                        <table class="table is-striped is-hoverable is-fullwidth topo-list">

                            <thead>
                            <tr>
                                <td>Nom</td>
                            </tr>
                            </thead>

                            <tbody>
                            <s:iterator value="secteurs">
                                <tr>
                                    <td>
                                        <s:a action="doSecteurDetails" namespace="/secteurs">
                                            <s:param name="secteur.secteurId" value="secteurId" />
                                            <s:property value="secteurNom" />
                                        </s:a>
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


