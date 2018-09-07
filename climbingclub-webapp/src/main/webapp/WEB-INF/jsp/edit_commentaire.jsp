<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Modifier le commentaire</h1>

            <s:if test="%{commentaire.topo.topoId > 0}">
                <h2 class="subtitle">pour le topo "<s:property value="commentaire.topo.topoNom"/>"</h2>
            </s:if>
            <s:else>
                <h2 class="subtitle">pour le spot "<s:property value="commentaire.spot.spotNom"/>"</h2>
            </s:else>

            <div class="columns">

                <div class="column">

                    <s:if test="%{commentaire.topo.topoId > 0}">
                        <s:form action="doEditTopoCommentaire" method="POST">
                            <s:hidden name="commentaire.commentaireId" value="%{commentaire.commentaireId}"/>
                            <s:hidden name="topoId" value="%{commentaire.topo.topoId}"/>
                            <s:hidden name="spotId" value="%{commentaire.spot.spotId}"/>
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
                            <s:hidden name="topoId" value="%{commentaire.topo.topoId}"/>
                            <s:hidden name="spotId" value="%{commentaire.spot.spotId}"/>
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