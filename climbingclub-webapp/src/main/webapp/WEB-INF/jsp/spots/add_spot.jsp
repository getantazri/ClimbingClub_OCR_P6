<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Ajouter un Spot</h1>

            <h2 class="subtitle">pour le topo "<s:property value="topo.topoNom" />"</h2>

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

                    <s:form action="doAddSpot" method="POST" namespace="/gestion/spots">
                        <s:hidden name="topoId" value="%{topo.topoId}" />
                        <div class="field">
                            <div class="control">
                                <s:textfield name="spot.spotNom" label="Nom" requiredLabel="true" cssClass="input" type="text" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:textarea name="spot.spotDescription" label="Description" requiredLabel="true" cssClass="textarea" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:textfield name="spot.hauteur" label="Hauteur" requiredLabel="true" cssClass="input" type="number" />
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