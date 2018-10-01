<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Administration</h1>

            <h2 class="subtitle">Gestion des réservations</h2>

            <div class="columns">

                <div class="column">

                    <table class="table is-striped is-hoverable is-fullwidth topo-list">

                        <thead>
                        <tr>
                            <th>Utilisateur</th>
                            <th>Topo</th>
                            <th>Modifier</th>
                            <th>Supprimer</th>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="emprunts">
                            <tr>
                                <td>
                                    <s:property value="utilisateur.pseudo" />
                                </td>
                                <td>
                                    <s:a action="doTopoDetails" namespace="/topos">
                                        <s:param name="topoId" value="topoId"/>
                                        <s:property value="topo.topoNom"/>
                                    </s:a>
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

                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>


