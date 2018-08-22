<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Les topos</h1>

            <h2 class="subtitle">Retrouvez l'ensemble des topos partagés par ordre alphabétique</h2>

            <div class="columns">

                <div class="column">

                    <table class="table is-striped is-hoverable is-fullwidth topo-list">

                        <thead>
                        <tr>
                            <td>Nom</td>
                            <td>Région</td>
                            <td>Propriétaire</td>
                            <td>Disponible</td>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="topos">
                            <tr>
                                <td>
                                    <s:a action="doTopoDetails" namespace="/topos">
                                        <s:param name="topoId" value="topoId" />
                                        <s:property value="topoNom" />
                                    </s:a>
                                </td>
                                <td>
                                    <s:property value="region.regionNom" />
                                </td>
                                <td>
                                    <s:property value="proprietaire.pseudo" />
                                </td>
                                <td>
                                    <s:if test="%{disponible == true}">
                                        Disponible &nbsp; <i class="fas fa-check has-text-success">
                                    </s:if>
                                    <s:else>
                                        Indisponible &nbsp; <i class="fas fa-times has-text-danger"></i>
                                    </s:else>
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


