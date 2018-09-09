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

                    <span class="has-text-danger is-bold"><s:actionerror /></span>

                    <span class="has-text-info is-bold"><s:actionmessage /></span>

                    <s:form action="doUpdatePassword" namespace="/compte" method="POST">
                        <s:hidden name="utilisateurId" value="%{#session.user.utilisateurId}" />

                        <div class="field">
                            <p class="control">
                                <s:textfield name="oldPassword" label="Ancien mot de passe" requiredLabel="true" cssClass="input"
                                             type="password"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="password" label="Nouveau mot de passe" requiredLabel="true" cssClass="input"
                                             type="password"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="passwordConfirmed" label="Confirmation du nouveau mot de passe" requiredLabel="true" cssClass="input"
                                             type="password"/>
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


