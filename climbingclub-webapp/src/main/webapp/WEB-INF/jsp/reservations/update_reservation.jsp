<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Modifier votre réservation</h1>
            <h2 class="subtitle">pour le topo "<s:property value="%{topo.topoNom}" />"</h2>

            <div class="columns">

                <div class="column">

                    <h2 class="subtitle">Dates actuelles :</h2>

                    <p>Début : <b><s:property value="%{emprunt.dateDebut}" /></b> <br />
                        Fin : <b><s:property value="%{emprunt.dateFin}" /></b></p>
                    <br />

                    <h2 class="subtitle">Nouvelles dates :</h2>

                    <s:form action="doUpdateReservation" method="POST">
                        <s:hidden name="utilisateurId" value="%{#session.user.utilisateurId}" />
                        <s:hidden name="topoId" value="%{topo.topoId}" />
                        <s:hidden name="empruntId" value="%{emprunt.empruntId}" />

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

                    <div class="columns">
                        <s:if test="hasActionErrors()">
                            <span class="notification is-danger is-small"><s:actionerror /></span>
                        </s:if>
                        <br />
                        <s:if test="hasActionMessages()">
                            <span class="notification is-info is-small"><s:actionmessage /></span>
                        </s:if>
                    </div>

                    <br />

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


