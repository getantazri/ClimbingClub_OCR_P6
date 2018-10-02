<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Ajouter un Topo</h1>

            <h2 class="subtitle">Partagez-le avec la communauté !</h2>

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

                    <s:form action="doAddTopo" method="POST" namespace="/gestion/topos">
                        <s:hidden name="topo.proprietaire.utilisateurId" value="%{#session.user.utilisateurId}" />
                        <div class="field">
                            <div class="control">
                                <s:textfield name="topo.topoNom" label="Nom" requiredLabel="true" cssClass="input" type="text" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:select name="topo.region.regionId" label="Région"
                                          list="regions" listKey="regionId" listValue="regionNom"
                                          emptyOption="false"
                                          requiredLabel="true"
                                          cssClass="select" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <label class="checkbox">
                                    <s:checkbox name="topo.disponible" label="Disponible" requiredLabel="true" />
                                </label>
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