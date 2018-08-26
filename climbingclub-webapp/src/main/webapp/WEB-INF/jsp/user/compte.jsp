<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title"><s:property value="#session.user.pseudo"/></h1>

            <div class="columns">

                <div class="column">

                    <h2 class="subtitle">Gérer mon compte</h2>

                    <div class="control add-space-top-bottom-10">
                        <a href="">
                            <button class="button is-primary">Mettre à jour mes informations</button>
                        </a>
                    </div>

                </div>

            </div>

            <div class="columns">
                <div class="column"></div>
            </div>

            <div class="columns">

                <div class="column">

                    <div class="column">

                        <s:actionerror/>

                        <hr/>

                        <h2 class="subtitle">Mes topos
                            <s:a action="doAddTopo" cssClass="button is-info is-small" title="Créer un topo"
                                 namespace="/topos">
                                <span><b>Créer un topo</b></span>
                            </s:a>
                        </h2>

                        <table class="table is-striped is-hoverable is-fullwidth topo-list">

                            <thead>
                            <tr>
                                <th>Nom</th>
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

                        <hr/>

                        <h2 class="subtitle">Mes Spots</h2>

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
                                        <s:property value="spotNom"/>
                                    </td>
                                    <td>
                                        <s:property value="topo.topoNom"/>
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

                        <hr/>

                        <h2 class="subtitle">Mes Secteurs</h2>

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
                                        <s:property value="secteurNom"/>
                                    </td>
                                    <td>
                                        <s:property value="spot.spotNom"/>
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

                        <hr/>

                        <h2 class="subtitle">Mes Voies</h2>

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
                                        <s:property value="voieNom"/>
                                    </td>
                                    <td>
                                        <s:property value="secteur.secteurNom"/>
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

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>


