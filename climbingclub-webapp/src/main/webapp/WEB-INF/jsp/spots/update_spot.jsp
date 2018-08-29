<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Modifier le Spot</h1>

            <h2 class="subtitle">"<s:property value="spot.spotNom" />"</h2>

            <div class="columns">

                <div class="column">

                    <span class="has-text-danger"><b><s:actionerror /></b></span>
                    <span class="has-text-info"><b><s:actionmessage /></b></span>

                    <s:form action="doUpdateSpot" method="POST">
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
                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>