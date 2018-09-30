<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Nouvelle réservation</h1>
            <h2 class="subtitle">pour le topo "<s:property value="topo.topoNom" />"</h2>

            <div class="columns">

                <div class="column">

                    <s:if test="%{this.hasActionMessages()}">
                        <div class="control add-space-top-bottom-10">
                            <span class="notification is-info is-medium"><b><s:actionmessage /></b></span>
                        </div>
                    </s:if>

                    <s:if test="%{this.hasActionErrors()}">
                        <div class="control add-space-top-bottom-10">
                            <span class="notification is-danger is-medium"><b><s:actionmessage /></b></span>
                        </div>
                    </s:if>

                    <br />

                    <s:form action="doAddReservation" method="POST">
                        <s:hidden name="utilisateurId" value="%{#session.user.utilisateurId}" />
                        <s:hidden name="topoId" value="%{topo.topoId}" />

                        <div class="field">
                            <div class="control">
                                <s:textfield label="Date de début" type="date" name="dateDebut" requiredLabel="true" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:textfield label="Date de fin" type="date" name="dateFin" requiredLabel="true" />
                            </div>
                        </div>

                        <div class="control add-space-top-bottom-10">
                            <s:submit value="Réserver" cssClass="button is-primary" />
                        </div>
                    </s:form>

                </div>

                <div class="column">
                    <s:if test="%{emprunts == null}">
                        <div class="notification is-info">Aucune réservation à venir ou en cours pour ce topo</div>
                    </s:if>
                    <s:else>
                        <h2 class="subtitle">Périodes réservées en cours ou à venir :</h2>
                        <table class="table is-striped is-hoverable is-fullwidth topo-list">

                            <thead>
                                <tr>
                                    <th>Date de début</th>
                                    <th>Date de fin</th>
                                </tr>
                            </thead>

                            <tbody>
                                <s:iterator value="emprunts">
                                    <tr>
                                        <td>
                                            <s:property value="dateDebut" />
                                        </td>
                                        <td>
                                            <s:property value="dateFin" />
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>
                        </table>
                    </s:else>
                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>


