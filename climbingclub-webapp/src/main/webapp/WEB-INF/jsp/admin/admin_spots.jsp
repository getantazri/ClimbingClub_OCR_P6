<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Administration</h1>

            <h2 class="subtitle">Gestion des spots</h2>

            <div class="columns">

                <div class="column">

                    <table class="table is-striped is-hoverable is-fullwidth topo-list">

                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Topo</th>
                            <th>Modifier</th>
                            <th>Supprimer</th>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="spots">
                            <tr>
                                <td>
                                    <s:a action="doSpotDetails" namespace="/spots">
                                        <s:param name="spotId" value="spotId" />
                                        <s:property value="spotNom" />
                                    </s:a>
                                </td>
                                <td>
                                    <s:property value="topo.topoNom"/>
                                </td>
                                <td>
                                    <s:a action="doGetSpotToUpdate" namespace="/spots">
                                        <s:param name="spotId" value="spotId"/>
                                        <i class="far fa-edit has-text-primary has-text-centered"></i>
                                    </s:a>
                                </td>
                                <td>
                                    <s:a action="doDeleteSpot" namespace="/spots">
                                        <s:param name="spotId" value="spotId"/>
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


