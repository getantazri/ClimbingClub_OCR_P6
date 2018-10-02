<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Administration</h1>

            <h2 class="subtitle">Modification d'un d'un utilisateur</h2>

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

                    <s:form action="doUpdateUtilisateur" namespace="/admin" method="POST">
                        <s:hidden name="utilisateurId" value="%{utilisateur.utilisateurId}" />

                        <div class="field">
                            <p class="control">
                                <s:textfield name="utilisateur.nom" value="%{utilisateur.nom}" label="Nom" requiredLabel="true" cssClass="input" type="text"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="utilisateur.prenom" value="%{utilisateur.prenom}" label="Prénom" requiredLabel="true" cssClass="input"
                                             type="text"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="utilisateur.pseudo" value="%{utilisateur.pseudo}" label="Pseudo" requiredLabel="true" cssClass="input"
                                             type="text"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="utilisateur.email" value="%{utilisateur.email}" label="Email" requiredLabel="true" cssClass="input"
                                             type="email"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="utilisateur.telephone" value="%{utilisateur.telephone}" label="Téléphone" requiredLabel="true" cssClass="input"
                                             type="text"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:select name="utilisateur.statut.statutId" list="statuts" listKey="statutId" listValue="statutNom" requiredLabel="true"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control add-space-top-bottom-10">
                                <s:submit value="Enregistrer les modifications" cssClass="button is-primary"/>
                            </p>
                        </div>

                    </s:form>

                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>


