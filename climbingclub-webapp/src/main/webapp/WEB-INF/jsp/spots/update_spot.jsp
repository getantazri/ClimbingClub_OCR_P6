<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Modifier le Spot</h1>

            <h2 class="subtitle">"<s:property value="spot.spotNom" />"</h2>

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

                    <s:if test="%{#session.user.utilisateurId != spot.topo.proprietaire.utilisateurId}">
                        <span class="notification is-danger is-small">Vous n'êtes pas le propriétaire</span>
                    </s:if>
                    <s:else>
                    <s:form action="doUpdateSpot" method="POST" namespace="/gestion/spots">
                        <s:hidden name="spot.spotId" value="%{spot.spotId}" />
                        <s:hidden name="spot.topo.topoId" value="%{spot.topo.topoId}" />
                        <div class="field">
                            <div class="control">
                                <s:textfield name="spot.spotNom" fieldValue="%{spot.spotNom}" label="Nom" requiredLabel="true" cssClass="input" type="text" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:textarea name="spot.spotDescription" fieldValue="%{spot.spotDescription}" label="Description" requiredLabel="true" cssClass="textarea" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:textfield name="spot.hauteur" fieldValue="%{spot.hauteur}" label="Hauteur" requiredLabel="true" cssClass="input" type="text" />
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