<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Administration</h1>

            <h2 class="subtitle">Gestion des secteurs</h2>

            <div class="columns">

                <div class="column">

                    <table class="table is-striped is-hoverable is-fullwidth topo-list">

                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Spot</th>
                            <th>Modifier</th>
                            <th>Supprimer</th>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="secteurs">
                            <tr>
                                <td>
                                    <s:a action="doSecteurDetails" namespace="/secteurs">
                                        <s:param name="secteur.secteurId" value="secteurId" />
                                        <s:property value="secteurNom" />
                                    </s:a>
                                </td>
                                <td>
                                    <s:property value="spot.spotNom" />
                                </td>
                                <td>
                                    <s:a action="doGetSecteurToUpdate" namespace="/secteurs">
                                        <s:param name="secteur.secteurId" value="secteurId"/>
                                        <i class="far fa-edit has-text-primary has-text-centered"></i>
                                    </s:a>
                                </td>
                                <td>
                                    <s:a action="doDeleteSecteur" namespace="/secteurs">
                                        <s:param name="secteur.secteurId" value="secteurId"/>
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


