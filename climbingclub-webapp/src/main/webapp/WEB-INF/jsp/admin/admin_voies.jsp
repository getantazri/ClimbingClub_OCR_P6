<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Administration</h1>

            <h2 class="subtitle">Gestion des voies</h2>

            <div class="columns">

                <div class="column">

                    <table class="table is-striped is-hoverable is-fullwidth topo-list">

                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Secteur</th>
                            <th>Modifier</th>
                            <th>Supprimer</th>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="voies">
                            <tr>
                                <td>
                                    <s:a action="doVoieDetails" namespace="/voies">
                                        <s:param name="voieId" value="voieId" />
                                        <s:property value="voieNom" />
                                    </s:a>
                                </td>
                                <td>
                                    <s:property value="secteur.secteurNom"/>
                                </td>
                                <td>
                                    <s:a action="doGetVoieToUpdate" namespace="/voies">
                                        <s:param name="voieId" value="voieId"/>
                                        <i class="far fa-edit has-text-primary has-text-centered"></i>
                                    </s:a>
                                </td>
                                <td>
                                    <s:a action="doDeleteVoie" namespace="/voies">
                                        <s:param name="voieId" value="voieId"/>
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


