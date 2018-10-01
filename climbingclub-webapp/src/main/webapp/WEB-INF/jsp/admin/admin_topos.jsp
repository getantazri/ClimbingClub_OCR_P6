<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Administration</h1>

            <h2 class="subtitle">Gestion des topos
                <s:a action="doAddTopo" cssClass="button is-info is-small" title="Créer un topo"
                     namespace="/topos">
                    <span><b>Créer un topo</b></span>
                </s:a>
            </h2>

            <div class="columns">
                <div class="column"><s:actionerror /></div>
                <div class="column"><s:actionmessage /></div>
            </div>

            <div class="columns">

                <div class="column">

                    <table class="table is-striped is-hoverable is-fullwidth topo-list">

                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Propriétaire</th>
                            <th>Modifier</th>
                            <th>Supprimer</th>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="topos">
                            <tr>
                                <td>
                                    <s:a action="doTopoDetails" namespace="/topos">
                                        <s:param name="topoId" value="topoId"/>
                                        <s:property value="topoNom"/>
                                    </s:a>
                                </td>
                                <td>
                                    <s:property value="proprietaire.pseudo" />
                                </td>
                                <td>
                                    <s:a action="doGetTopoToUpdate" namespace="/topos">
                                        <s:param name="topoId" value="topoId"/>
                                        <i class="far fa-edit has-text-primary has-text-centered"></i>
                                    </s:a>
                                </td>
                                <td>
                                    <s:a action="doDeleteTopo" namespace="/topos">
                                        <s:param name="topoId" value="topoId"/>
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


