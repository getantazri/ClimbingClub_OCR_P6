<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title"><s:property value="topo.topoNom"/></h1>
            <s:a action="doGetTopoToUpdate" namespace="/topos">
                <s:param name="topoId" value="topo.topoId" />
                Modifier le topo
            </s:a> -
            <s:a action="doDeleteTopo" namespace="/topos">
                <s:param name="topoId" value="topo.topoId" />
                Supprimer le topo
            </s:a>

            <div class="columns">

                <div class="column">

                    <nav class="level is-mobile">
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Région</p>
                                <p class="title"><s:property value="topo.region.regionNom"/></p>
                            </div>
                        </div>
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Propriétaire</p>
                                <p class="title"><s:property value="topo.proprietaire.pseudo"/></p>
                            </div>
                        </div>
                        <div class="level-item has-text-centered">
                            <div>
                                <p class="heading">Disponible</p>
                                <p class="title">

                                    <s:if test="%{topo.disponible == true}">
                                        <i class="fas fa-check has-text-success"></i>
                                    </s:if>
                                    <s:else>
                                        <i class="fas fa-times has-text-danger"></i>
                                    </s:else>

                                </p>
                            </div>
                        </div>
                    </nav>

                    <h2 class="subtitle">Liste des spots</h2>

                    <s:if test="%{spots == null}">
                        <div class="notification is-danger"><s:actionmessage/></div>
                    </s:if>
                    <s:else>
                        <table class="table is-striped is-hoverable is-fullwidth topo-list">

                            <thead>
                            <tr>
                                <td>Nom</td>
                                <td>Hauteur</td>
                                <td>Description</td>
                            </tr>
                            </thead>

                            <tbody>
                            <s:iterator value="spots">
                                <tr>
                                    <td>
                                        <s:property value="spotNom"/>
                                    </td>
                                    <td>
                                        <s:property value="hauteur"/>
                                    </td>
                                    <td>
                                        <s:property value="spotDescription"/>
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


