<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Réservations</h1>

            <div class="columns">

                <div class="column">



                </div>

            </div>

            <div class="columns">

                <div class="column">

                    <div class="control add-space-top-bottom-10">
                        <a href="">
                            <s:a action="doAddReservation">
                                <button class="button is-primary">Créer une réservation</button>
                            </s:a>
                        </a>
                    </div>

                </div>

            </div>

            <div class="columns">

                <div class="column">

                    <h2 class="subtitle">Mes réservations</h2>

                    <s:if test="%{emprunts == null}">
                        <div class="notification is-info">Vous n'avez aucune réservation de topo en cours</div>
                    </s:if>
                    <s:else>
                        <table class="table is-striped is-hoverable is-fullwidth topo-list">

                            <thead>
                            <tr>
                                <th>Topo</th>
                                <th>Date de début</th>
                                <th>Date de fin</th>
                                <th>Modifier</th>
                                <th>Supprimer</th>
                            </tr>
                            </thead>

                            <tbody>
                            <s:iterator value="topos">
                                <tr>
                                    <td>
                                        <s:a action="doReservationDetails" namespace="/reservations">
                                            <s:param name="empruntId" value="empruntId"/>
                                            <s:property value="topo.topoNom"/>
                                        </s:a>

                                    </td>
                                    <td>
                                        <s:property value="emprunt.dateDebut" />
                                    </td>
                                    <td>
                                        <s:property value="emprunt.dateFin" />
                                    </td>
                                    <td>
                                        <s:a action="doGetReservationToUpdate" namespace="/reservations">
                                            <s:param name="empruntId" value="empruntId"/>
                                            <i class="far fa-edit has-text-primary has-text-centered"></i>
                                        </s:a>
                                    </td>
                                    <td>
                                        <s:a action="doDeleteReservations" namespace="/reservations">
                                            <s:param name="empruntId" value="empruntId"/>
                                            <i class="fas fa-times has-text-danger has-text-centered"></i>
                                        </s:a>
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


