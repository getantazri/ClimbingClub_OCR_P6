<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Modifier le commentaire</h1>

            <s:if test="%{topo.topoId > 0}">
                <h2 class="subtitle">pour le topo "<s:property value="topo.topoNom"/>"</h2>
            </s:if>
            <s:else>
                <h2 class="subtitle">pour le spot "<s:property value="spot.spotNom"/>"</h2>
            </s:else>

            <div class="columns">
                <s:if test="hasActionErrors()">
                    <span class="notification is-danger is-small"><s:actionerror /></span>
                </s:if>
                <br />
                <s:if test="hasActionMessages()">
                    <span class="notification is-info is-small"><s:actionmessage /></span>
                </s:if>
            </div>

            <div class="columns">

                <div class="column">

                    <s:if test="%{topo.topoId > 0}">
                        <s:form action="doEditTopoCommentaire" method="POST">
                            <s:hidden name="commentaire.commentaireId" value="%{commentaire.commentaireId}"/>
                            <s:hidden name="topoId" value="%{topo.topoId}"/>
                            <s:hidden name="commentaire.utilisateur.utilisateurId" value="%{commentaire.utilisateur.utilisateurId}"/>

                            <div class="field">
                                <div class="control">
                                    <s:textarea name="commentaire.contenu" label="Commentaire" requiredLabel="true"
                                                cssClass="textarea"/>
                                </div>
                            </div>
                            <div class="control add-space-top-bottom-10">
                                <s:submit value="Enregistrer les modifications" cssClass="button is-primary"/>
                            </div>

                        </s:form>
                    </s:if>
                    <s:else>
                        <s:form action="doEditSpotCommentaire" method="POST">
                            <s:hidden name="commentaire.commentaireId" value="%{commentaire.commentaireId}"/>
                            <s:hidden name="spotId" value="%{spot.spotId}"/>
                            <s:hidden name="commentaire.utilisateur.utilisateurId" value="%{commentaire.utilisateur.utilisateurId}"/>

                            <div class="field">
                                <div class="control">
                                    <s:textarea name="commentaire.contenu" label="Commentaire" requiredLabel="true"
                                                cssClass="textarea"/>
                                </div>
                            </div>
                            <div class="control add-space-top-bottom-10">
                                <s:submit value="Enregistrer les modifications" cssClass="button is-primary"/>
                            </div>

                        </s:form>
                    </s:else>
                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../_include/footer.jsp" %>