<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Mon compte</h1>

            <div class="columns">

                <div class="column">

                    <h2 class="subtitle">Editer les informations de mon profil : <span class="is-bold"><s:property value="utilisateur.pseudo" /></span></h2>

                </div>

            </div>

            <div class="columns">

                <div class="column">

                    <span class="has-text-danger is-bold"><s:actionerror/></span>

                    <s:form action="doUpdateProfile" namespace="/compte" method="POST">
                        <s:hidden name="utilisateurId" value="%{#session.user.utilisateurId}" />
                        <s:hidden name="utilisateur.pseudo" value="%{#session.user.pseudo}" />
                        <s:hidden name="utilisateur.statut.statutId" value="%{#session.user.statut.statutId}" />

                        <div class="field">
                            <p class="control">
                                <s:textfield name="utilisateur.nom" fieldValue="%{utilisateur.nom}" label="Nom" requiredLabel="true" cssClass="input" type="text"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="utilisateur.prenom" fieldValue="%{utilisateur.prenom}" label="Prénom" requiredLabel="true" cssClass="input"
                                             type="text"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="utilisateur.email" fieldValue="%{utilisateur.email}" label="Email" requiredLabel="true" cssClass="input"
                                             type="email"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="utilisateur.telephone" fieldValue="%{utilisateur.telephone}" label="Téléphone" requiredLabel="true" cssClass="input"
                                             type="text"/>
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


