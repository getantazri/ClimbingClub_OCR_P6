<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Administration</h1>

            <h2 class="subtitle">Gestion des utilisateurs
                <s:a action="doAddUtilisateur" cssClass="button is-info is-small" title="Créer un utilisateur"
                     namespace="/admin">
                    <span><b>Créer un utilisateur</b></span>
                </s:a>
            </h2>

            <div class="columns">

                <div class="column">

                    <table class="table is-striped is-hoverable is-fullwidth topo-list">

                        <thead>
                        <tr>
                            <th>Pseudo</th>
                            <th>Modifier</th>
                            <th>Supprimer</th>
                        </tr>
                        </thead>

                        <tbody>
                        <s:iterator value="utilisateurs">
                            <tr>
                                <td>
                                    <s:property value="utilisateur.pseudo"/>
                                </td>
                                <td>
                                    <s:a action="doGetUtilisateurToUpdate" namespace="/admin">
                                        <s:param name="utilisateurId" value="utilisateurId"/>
                                        <i class="far fa-edit has-text-primary has-text-centered"></i>
                                    </s:a>
                                </td>
                                <td>
                                    <s:a action="doDeleteUtilisateur" namespace="/admin">
                                        <s:param name="utilisateurId" value="utilisateurId"/>
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


