<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Modifier la voie</h1>

            <h2 class="subtitle">"<s:property value="voie.voieNom" />"</h2>

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

                    <s:if test="%{#session.user.utilisateurId != voie.secteur.spot.topo.proprietaire.utilisateurId}">
                        <span class="notification is-danger is-small">Vous n'êtes pas le propriétaire</span>
                    </s:if>
                    <s:else>
                    <s:form action="doUpdateVoie" method="POST" namespace="/gestion/voies">
                        <s:hidden name="voie.voieId" value="%{voie.voieId}" />
                        <s:hidden name="voie.secteur.secteurId" value="%{voie.secteur.secteurId}" />
                        <div class="field">
                            <div class="control">
                                <s:textfield name="voie.voieNom" fieldValue="%{voie.voieNom}" label="Nom" requiredLabel="true" cssClass="input" type="text" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:textarea name="voie.voieDescription" fieldValue="%{voie.voieDescription}" label="Description" requiredLabel="true" cssClass="textarea" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:textfield name="voie.nombrePoints" fieldValue="%{voie.nombrePoints}" label="Nombre de points" requiredLabel="true" cssClass="input" type="number" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:select name="voie.cotation.cotationId" label="Cotation"
                                          list="cotations" listKey="cotationId" listValue="cotationNom"
                                          emptyOption="false"
                                          requiredLabel="true"
                                          cssClass="select" />
                            </div>
                        </div>

                        <div class="control add-space-top-bottom-10">
                            <s:submit value="Enregistrer les modifications"  cssClass="button is-primary" />
                        </div>
                    </s:form>
                    </s:else>
                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>