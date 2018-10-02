<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Modifier le Secteur</h1>

            <h2 class="subtitle">"<s:property value="secteur.secteurNom" />"</h2>

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

                    <s:form action="doUpdateSecteur" method="POST" namespace="/gestion/secteurs">
                        <s:hidden name="secteur.secteurId" value="%{secteur.secteurId}" />
                        <s:hidden name="secteur.spot.spotId" value="%{secteur.spot.spotId}" />
                        <div class="field">
                            <div class="control">
                                <s:textfield name="secteur.secteurNom" fieldValue="%{secteur.secteurNom}" label="Nom" requiredLabel="true" cssClass="input" type="text" />
                            </div>
                        </div>

                        <div class="control add-space-top-bottom-10">
                            <s:submit value="Enregistrer les modifications"  cssClass="button is-primary" />
                        </div>
                    </s:form>
                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>