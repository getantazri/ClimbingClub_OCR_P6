<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title"><s:property value="spot.spotNom"/> &nbsp;
                <s:if test="%{#session.user.utilisateurId == spot.topo.proprietaire.utilisateurId || #session.user.utilisateurId == 1}">
                    <s:a action="doAddSecteur" namespace="/gestion/secteurs" cssClass="button is-primary is-small">
                        <s:param name="spot.spotId" value="spot.spotId"/>
                        <span><b>Ajouter un secteur</b></span>
                    </s:a>
                    <s:a action="doGetSpotToUpdate" namespace="/gestion/spots" cssClass="button is-info is-small">
                        <s:param name="spotId" value="spot.spotId"/>
                        <span><b>Modifier le spot</b></span>
                    </s:a>
                    <s:a action="doDeleteSpot" namespace="/gestion/spots" cssClass="button is-danger is-small">
                        <s:param name="spotId" value="spot.spotId"/>
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

                    <p><s:property value="spot.spotDescription"/></p>

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
                                            <s:param name="secteur.secteurId" value="secteurId"/>
                                            <s:property value="secteurNom"/>
                                        </s:a>
                                    </td>
                                </tr>
                            </s:iterator>
                            </tbody>

                        </table>
                    </s:else>

                </div>

            </div>

            <div class="columns">
                <div class="column"></div>
            </div>

            <div class="columns">

                <em class="column">

                    <h2 class="subtitle">Commentaires</h2>

                    <s:if test="%{commentaires == null}">
                    <p><em>Aucun commentaire</em></p>
                    </s:if>
                    <s:else>
                    <table class="table is-striped is-hoverable is-fullwidth topo-list">

                        <thead>
                        <tr>
                            <td>Utilisateur</td>
                            <td>Commentaire</td>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="commentaires">
                            <tr>
                                <td>
                                    <span class="is-bold"><s:property value="utilisateur.pseudo"/></span>
                                </td>
                                <td>
                                    <span class="is-small is-italic">Publié le : <s:property
                                            value="datePublication"/></span>
                                    <p><s:property value="contenu"/></p>
                                    <p>
                                        <s:if test="%{#session.user.statut.statutId == 1 || #session.user.utilisateurId == utilisateur.utilisateurId}">
                                            <s:a action="doGetSpotCommentaireToEdit">
                                                <s:param name="commentaireId" value="commentaireId"/>
                                                <s:param name="spotId" value="spotId" />
                                                <i class="far fa-edit has-text-primary has-text-centered"></i>
                                                Modifier
                                            </s:a> &nbsp; - &nbsp;
                                            <s:a action="doDeleteSpotCommentaire">
                                                <s:param name="commentaireId" value="commentaireId"/>
                                                <i class="fas fa-times has-text-danger has-text-centered"></i>
                                                Supprimer
                                            </s:a>
                                        </s:if>
                                    </p>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>

                    </table>
                    </s:else>

                    <hr/>

                    <s:if test="%{#session.user != null}">
                    <s:form action="doPostSpotCommentaire" method="post">
                        <s:hidden name="utilisateur.utilisateurId" value="%{#session.user.utilisateurId}"/>
                        <s:hidden name="spotId" value="%{spot.spotId}"/>
                    <div class="field">
                        <div class="control">
                            <s:textarea name="commentaire.contenu" label="Commentaire" requiredLabel="true"
                                        cssClass="textarea"/>
                        </div>
                    </div>

                    <div class="control add-space-top-bottom-10">
                        <s:submit value="Poster" cssClass="button is-primary"/>
                    </div>
                    </s:form>
                    </s:if>
                    <s:else>
                    <p><span class="is-bold has-text-black">Vous devez être connecté pour poster un commentaire</span>
                    </p>
                    </s:else>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>


