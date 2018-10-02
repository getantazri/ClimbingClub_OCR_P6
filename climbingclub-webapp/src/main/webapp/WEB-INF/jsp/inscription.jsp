<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title is-uppercase">Inscription</h1>
            <h2 class="subtitle">Rejoignez la communauté ClimbingClub pour partager votre passion pour l'escalade.</h2>

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

                    <s:form action="doInscription" namespace="/login" method="POST">

                        <div class="field">
                            <p class="control">
                                <s:textfield name="nom" label="Nom" requiredLabel="true" cssClass="input" type="text"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="prenom" label="Prénom" requiredLabel="true" cssClass="input"
                                             type="text"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="pseudo" label="Pseudo" requiredLabel="true" cssClass="input"
                                             type="text"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="email" label="Email" requiredLabel="true" cssClass="input"
                                             type="email"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="telephone" label="Téléphone" requiredLabel="true" cssClass="input"
                                             type="text"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="password" label="Mot de passe" requiredLabel="true" cssClass="input"
                                             type="password"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="passwordConfirmed" label="Confirmer" requiredLabel="true"
                                             cssClass="input" type="password"/>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control add-space-top-bottom-10">
                                <s:submit value="S'inscrire" cssClass="button is-primary"/>
                            </p>
                        </div>

                    </s:form>

                </div>

            </div>

        </section>

    </div>

</div>


<%@include file="../_include/footer.jsp" %>


