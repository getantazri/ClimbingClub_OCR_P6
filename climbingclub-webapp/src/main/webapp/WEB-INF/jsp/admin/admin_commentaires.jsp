<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Administration</h1>

            <h2 class="subtitle">Gestion des commentaires (par Topo)</h2>

            <div class="columns">

                <div class="column">

                    <table class="table is-striped is-hoverable is-fullwidth topo-list">

                        <thead>
                        <tr>
                            <th>Auteur</th>
                            <th>Contenu</th>
                            <th>Modifier</th>
                            <th>Supprimer</th>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="commentairesByTopo">
                            <tr>
                                <td>
                                    <s:property value="utilisateur.pseudo"/>
                                </td>
                                <td>
                                    <s:property value="contenu"/>
                                </td>
                                <td>
                                    <s:a action="doGetTopoCommentaireToEdit" namespace="/">
                                        <s:param name="commentaireId" value="commentaireId"/>
                                        <i class="far fa-edit has-text-primary has-text-centered"></i>
                                    </s:a>
                                </td>
                                <td>
                                    <s:a action="doDeleteTopoCommentaire" namespace="/">
                                        <s:param name="commentaireId" value="commentaireId"/>
                                        <i class="fas fa-times has-text-danger has-text-centered"></i>
                                    </s:a>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>

                    </table>

                </div>

            </div>

            <h2 class="subtitle">Gestion des commentaires (par Spot)</h2>

            <div class="columns">

                <div class="column">

                    <table class="table is-striped is-hoverable is-fullwidth topo-list">

                        <thead>
                        <tr>
                            <th>Auteur</th>
                            <th>Contenu</th>
                            <th>Modifier</th>
                            <th>Supprimer</th>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="commentairesBySpot">
                            <tr>
                                <td>
                                    <s:property value="utilisateur.pseudo"/>
                                </td>
                                <td>
                                    <s:property value="contenu"/>
                                </td>
                                <td>
                                    <s:a action="doGetSpotCommentaireToEdit" namespace="/">
                                        <s:param name="commentaireId" value="commentaireId"/>
                                        <i class="far fa-edit has-text-primary has-text-centered"></i>
                                    </s:a>
                                </td>
                                <td>
                                    <s:a action="doDeleteSpotCommentaire" namespace="/">
                                        <s:param name="commentaireId" value="commentaireId"/>
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


