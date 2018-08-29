<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title"><s:property value="topo.topoNom"/> &nbsp;
            <s:if test="%{#session.user.utilisateurId == topo.proprietaire.utilisateurId}">
                <s:a action="doAddSpot" namespace="/spots" cssClass="button is-primary is-small">
                    <s:param name="topoId" value="topo.topoId" />
                    <span><b>Ajouter un spot</b></span>
                </s:a>
                <s:a action="doGetTopoToUpdate" namespace="/topos" cssClass="button is-info is-small">
                    <s:param name="topoId" value="topo.topoId" />
                    <span><b>Modifier le topo</b></span>
                </s:a>
                <s:a action="doDeleteTopo" namespace="/topos" cssClass="button is-danger is-small">
                    <s:param name="topoId" value="topo.topoId" />
                    <span><b>Supprimer le topo</b></span>
                </s:a>
            </s:if>
            </h1>

            <div class="columns"><div class="column"></div></div>

            <div class="columns">

                <div class="column">

                    <nav class="level is-mobile">
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Région</p>
                                <p class="title"><s:property value="topo.region.regionNom"/></p>
                            </div>
                        </div>
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Propriétaire</p>
                                <p class="title"><s:property value="topo.proprietaire.pseudo"/></p>
                            </div>
                        </div>
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Disponible</p>
                                <p class="title">

                                    <s:if test="%{topo.disponible == true}">
                                        <i class="fas fa-check has-text-success"></i>
                                    </s:if>
                                    <s:else>
                                        <i class="fas fa-times has-text-danger"></i>
                                    </s:else>

                                </p>
                            </div>
                        </div>
                    </nav>

                </div>

            </div>

            <div class="columns"><div class="column"></div></div>

            <div class="columns">

                <div class="column">

                    <h2 class="subtitle">Liste des spots</h2>

                    <s:if test="%{spots == null}">
                        <div class="notification is-info"><s:actionmessage/></div>
                    </s:if>
                    <s:else>
                        <table class="table is-striped is-hoverable is-fullwidth topo-list">

                            <thead>
                            <tr>
                                <td>Nom</td>
                                <td>Hauteur</td>
                                <td>Description</td>
                            </tr>
                            </thead>

                            <tbody>
                            <s:iterator value="spots">
                                <tr>
                                    <td>
                                        <s:a action="doSpotDetails" namespace="/spots">
                                            <s:param name="spotId" value="spotId" />
                                            <s:property value="spotNom" />
                                        </s:a>
                                    </td>
                                    <td>
                                        <s:property value="hauteur"/>
                                    </td>
                                    <td>
                                        <s:property value="spotDescription"/>
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


