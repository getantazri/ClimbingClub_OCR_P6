<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Modifier le Topo</h1>

            <h2 class="subtitle">"<s:property value="topo.topoNom" />"</h2>

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

                    <s:if test="%{#session.user.utilisateurId != topo.proprietaire.utilisateurId}">
                        <span class="notification is-danger is-small">Vous n'êtes pas le propriétaire</span>
                    </s:if>
                    <s:else>
                    <s:form action="doUpdateTopo" method="POST" namespace="/gestion/topos">
                        <s:hidden name="topo.topoId" value="%{topo.topoId}" />
                        <s:hidden name="topo.proprietaire.utilisateurId" value="%{#session.user.utilisateurId}" />

                        <div class="field">
                            <div class="control">
                                <span class="has-text-danger"><s:actionerror /></span>
                                <s:textfield name="topo.topoNom" fieldValue="%{topo.topoNom}" label="Nom" requiredLabel="true" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:select name="topo.region.regionId" label="Région"
                                          list="regions" listKey="regionId" listValue="regionNom"
                                          emptyOption="false"
                                          requiredLabel="true"
                                />
                            </div>
                        </div>
                        <label class="checkbox">
                            <s:checkbox name="topo.disponible" fieldValue="%{topo.disponible}" label="Disponible" requiredLabel="true" />
                        </label>
                        <div class="control add-space-top-bottom-10">
                            <s:submit value="Enregistrer les modifications"  cssClass="button is-primary" />
                        </div>

                    </s:form>
                    </s:else>
                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>