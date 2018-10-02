<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Moteur de recherche</h1>

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

                    <s:form action="doSearchRequest" method="POST">
                        <div class="field">
                            <div class="control">
                                <s:textfield name="request" value="" requiredLabel="true" cssClass="input is-medium is-fullwidth" label="Que recherchez-vous ?" />
                            </div>
                        </div>

                        <div class="field">
                            <div class="control">
                                <s:select name="type" label="Type" list="types" emptyOption="false" requiredLabel="true" cssClass="select" />
                            </div>
                        </div>

                        <div class="field">
                            <div class="control">
                                <s:select name="nomRegion" label="Région"
                                          list="regions" listKey="regionNom" listValue="regionNom"
                                          emptyOption="false"
                                          requiredLabel="true"
                                          cssClass="select"
                                />
                            </div>
                        </div>

                        <div class="field">
                            <div class="control">
                                <s:select name="nomCotation" label="Cotation"
                                          list="cotations" listKey="cotationNom" listValue="cotationNom"
                                          emptyOption="false"
                                          requiredLabel="true"
                                          cssClass="select"
                                />
                            </div>
                        </div>

                        <div class="field">
                            <p class="control">
                                <s:textfield name="hauteurMin" label="Hauteur minimale du Spot" requiredLabel="true" cssClass="input" />
                            </p>
                        </div>

                        <div class="field">
                            <p class="control">
                                <s:textfield name="hauteurMax" label="Hauteur maximale du Spot" requiredLabel="true" cssClass="input" />
                            </p>
                        </div>


                        <div class="field">
                            <div class="control">
                                <s:submit value="Rechercher"  cssClass="button is-primary" />
                            </div>
                        </div>

                    </s:form>

                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../_include/footer.jsp" %>