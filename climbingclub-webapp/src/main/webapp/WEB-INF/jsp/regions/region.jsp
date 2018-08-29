<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title"><s:property value="region.regionNom"/></h1>

            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec mollis lectus dictum, sodales lacus at,
                consequat justo. Pellentesque at finibus nisi. Phasellus consectetur sem vel sem viverra, a fringilla
                risus lacinia. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.
                Interdum et malesuada fames ac ante ipsum primis in faucibus. In et congue quam, non egestas eros.
                Aenean dapibus eget est vel malesuada.
            </p>


            <div class="columns"><div class="column"></div></div>


            <div class="columns">

                <div class="column">

                    <h2 class="subtitle">Liste des topos de la région</h2>

                    <s:if test="%{topos == null}">
                        <div class="notification is-info"><s:actionmessage/></div>
                    </s:if>
                    <s:else>
                        <table class="table is-striped is-hoverable is-fullwidth topo-list">

                            <thead>
                            <tr>
                                <td>Nom</td>
                                <td>Propriétaire</td>
                                <td>Disponible</td>
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
                                        <s:property value="proprietaire.pseudo"/>
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
                    </s:else>

                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>


