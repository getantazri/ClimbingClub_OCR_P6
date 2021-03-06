<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title"><s:property value="topo.topoNom"/> &nbsp;
                <s:if test="%{#session.user.utilisateurId == topo.proprietaire.utilisateurId || #session.user.utilisateurId == 1}">
                    <s:a action="doAddSpot" namespace="/gestion/spots" cssClass="button is-primary is-small">
                        <s:param name="topoId" value="topo.topoId"/>
                        <span><b>Ajouter un spot</b></span>
                    </s:a>
                    <s:a action="doGetTopoToUpdate" namespace="/gestion/topos" cssClass="button is-info is-small">
                        <s:param name="topoId" value="topo.topoId"/>
                        <span><b>Modifier le topo</b></span>
                    </s:a>
                    <s:a action="doDeleteTopo" namespace="/gestion/topos" cssClass="button is-danger is-small">
                        <s:param name="topoId" value="topo.topoId"/>
                        <span><b>Supprimer le topo</b></span>
                    </s:a>
                </s:if>
            </h1>

            <div class="columns">
                <div class="column"></div>
            </div>

            <div class="columns">
                <s:if test="hasActionErrors()">
                    <span class="notification is-danger is-small"><s:actionerror /></span>
                </s:if>
            </div>

            <div class="columns">

                <div class="column">

                    <nav class="level is-mobile">
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Région</p>
                                <p class="title">
                                    <s:a action="doRegionDetails" namespace="/regions" cssClass="no-color-change">
                                        <s:param name="region.regionId" value="topo.region.regionId"/>
                                        <s:property value="topo.region.regionNom"/>
                                    </s:a>
                                </p>
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

            <div class="columns">
                <div class="column"></div>
            </div>

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
                                            <s:param name="spotId" value="spotId"/>
                                            <s:property value="spotNom"/>
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

            <div class="columns">
                <div class="column"></div>
            </div>

            <s:if test="%{topo.disponible == true}">
                <div class="columns">
                    <div class="column">
                        <nav class="level is-mobile">
                            <div class="level-item has-text-centered">
                                <div>
                                    <p class="heading">Ce topo est disponible à la réservation !</p>
                                    <p class="title">
                                        <s:if test="%{#session.user != null}">
                                            <s:a action="doAddReservation" namespace="/reservations" cssClass="button is-primary is-medium">
                                                <s:param name="topoId" value="topo.topoId"/>
                                                <span><b>Je le réserve !</b></span>
                                            </s:a>
                                        </s:if>
                                        <s:else>
                                            <s:a action="doGetCompte" namespace="/compte" cssClass="button is-light is-medium">
                                                <span><b>Connectez-vous pour le réserver</b></span>
                                            </s:a>
                                        </s:else>
                                    </p>
                                </div>
                            </div>
                        </nav>
                    </div>
                </div>

                <div class="columns">
                    <div class="column"></div>
                </div>
            </s:if>

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
                                            <s:a action="doGetTopoCommentaireToEdit">
                                                <s:param name="commentaireId" value="commentaireId"/>
                                                <i class="far fa-edit has-text-primary has-text-centered"></i>
                                                Modifier
                                            </s:a> &nbsp; - &nbsp;
                                            <s:a action="doDeleteTopoCommentaire">
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
                    <s:form action="doPostTopoCommentaire" method="post">
                        <s:hidden name="utilisateur.utilisateurId" value="%{#session.user.utilisateurId}"/>
                        <s:hidden name="topoId" value="%{topo.topoId}"/>
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


