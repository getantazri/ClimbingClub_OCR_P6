<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Ajouter une Voie</h1>

            <h2 class="subtitle">pour le secteur "<s:property value="secteur.secteurNom" />"</h2>

            <div class="columns">

                <div class="column">

                    <span class="has-text-danger"><b><s:actionerror /></b></span>

                    <s:form action="doAddVoie" method="POST" namespace="/gestion/voies">
                        <s:hidden name="secteurId" value="%{secteur.secteurId}" />
                        <div class="field">
                            <div class="control">
                                <s:textfield name="voie.voieNom" label="Nom" requiredLabel="true" cssClass="input" type="text" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:textarea name="voie.voieDescription" label="Description" requiredLabel="true" cssClass="textarea" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:textfield name="voie.nombrePoints" label="Nombre de points" requiredLabel="true" cssClass="input" type="number" />
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
                            <s:submit value="Ajouter"  cssClass="button is-primary" />
                        </div>
                    </s:form>
                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>