<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Moteur de recherche</h1>

            <div class="columns">
                <s:if test="hasActionErrors()">
                    <span class="notification is-danger is-small"><s:actionerror /></span>
                </s:if>
                <br />
                <s:if test="hasActionMessages()">
                    <span class="notification is-info is-small"><s:actionmessage /></span>
                </s:if>
            </div>

            <div class="columns">

                <div class="column">

                    <s:form action="doSearchRequest" method="POST">
                        <div class="field">
                            <div class="control">
                                <s:textfield name="request" value="%{request}" requiredLabel="true" cssClass="input is-medium is-fullwidth" label="Que recherchez-vous ?" />
                            </div>
                        </div>

                        <div class="field">
                            <div class="control">
                                <s:select name="type" label="Type" list="types" emptyOption="false" requiredLabel="true" cssClass="select" />
                            </div>
                        </div>

                        <div class="field">
                            <div class="control">
                                <s:select name="nomRegion" label="Région"
                                          list="regions" listKey="regionNom" listValue="regionNom"
                                          emptyOption="false"
                                          requiredLabel="true"
                                          cssClass="select"
                                />
                            </div>
                        </div>

                        <div class="field">
                            <div class="control">
                                <s:select name="nomCotation" label="Cotation"
                                          list="cotations" listKey="cotationNom" listValue="cotationNom"
                                          emptyOption="false"
                                          requiredLabel="true"
                                          cssClass="select"
                                />
                            </div>
                        </div>

                        <div class="field">
                            <p class="control">
                                <s:textfield name="hauteurMin" label="Hauteur minimale du Spot" requiredLabel="true" cssClass="input" />
                            </p>
                        </div>

                        <div class="field">
                            <p class="control">
                                <s:textfield name="hauteurMax" label="Hauteur maximale du Spot" requiredLabel="true" cssClass="input" />
                            </p>
                        </div>


                        <div class="field">
                            <div class="control">
                                <s:submit value="Relancer la recherche"  cssClass="button is-primary" />
                            </div>
                        </div>

                    </s:form>

                </div>

            </div>

        </section>

        <section class="section">

            <div class="columns">

                <div class="column">
                    <h2 class="subtitle"><i class="fas fa-list"></i> &nbsp;  Résultats de la recherche</h2>
                </div>

            </div>

            <div class="columns">

                <div class="column">

                    <table class="table is-striped is-hoverable is-fullwidth topo-results">

                        <thead>
                        <tr>
                            <i class="fas fa-ellipsis-h"></i> &nbsp; Les Topos
                        </tr>
                        </thead>

                        <s:if test="%{!topos.isEmpty()}">
                            <tbody>
                            <s:iterator value="topos">
                                <tr>
                                    <td>
                                        <s:a action="doTopoDetails" namespace="/topos">
                                            <s:param name="topoId" value="topoId"/>
                                            <s:property value="topoNom"/>
                                        </s:a>
                                    </td>
                                </tr>
                            </s:iterator>
                            </tbody>
                        </s:if>
                        <s:else>
                            <tbody>
                            <tr>
                                <td><em class="is-danger">Aucun résultat</em></td>
                            </tr>
                            </tbody>
                        </s:else>

                    </table>

                    <table class="table is-striped is-hoverable is-fullwidth spot-results">

                        <thead>
                        <tr>
                            <i class="fas fa-ellipsis-h"></i> &nbsp; Les Spots
                        </tr>
                        </thead>

                        <s:if test="%{!spots.isEmpty()}">
                            <tbody>
                            <s:iterator value="spots">
                                <tr>
                                    <td>
                                        <s:a action="doSpotDetails" namespace="/spots">
                                            <s:param name="spotId" value="spotId"/>
                                            <s:property value="spotNom"/>
                                        </s:a>
                                    </td>
                                </tr>
                            </s:iterator>
                            </tbody>
                        </s:if>
                        <s:else>
                            <tbody>
                            <tr>
                                <td><em class="is-danger">Aucun résultat</em></td>
                            </tr>
                            </tbody>
                        </s:else>

                    </table>

                    <table class="table is-striped is-hoverable is-fullwidth secteur-results">

                        <thead>
                        <tr>
                            <i class="fas fa-ellipsis-h"></i> &nbsp; Les Secteurs
                        </tr>
                        </thead>

                        <s:if test="%{!secteurs.isEmpty()}">
                            <tbody>
                            <s:iterator value="secteurs">
                                <tr>
                                    <td>
                                        <s:a action="doSecteurDetails" namespace="/secteurs">
                                            <s:param name="secteur.secteurId" value="secteurId"/>
                                            <s:property value="secteurNom"/>
                                        </s:a>
                                    </td>
                                </tr>
                            </s:iterator>
                            </tbody>
                        </s:if>
                        <s:else>
                            <tbody>
                            <tr>
                                <td><em class="is-danger">Aucun résultat</em></td>
                            </tr>
                            </tbody>
                        </s:else>


                    </table>

                    <table class="table is-striped is-hoverable is-fullwidth voie-results">

                        <thead>
                        <tr>
                            <i class="fas fa-ellipsis-h"></i> &nbsp; Les Voies
                        </tr>
                        </thead>

                        <s:if test="%{!voies.isEmpty()}">
                            <tbody>
                            <s:iterator value="voies">
                                <tr>
                                    <td>
                                        <s:a action="doVoieDetails" namespace="/voies">
                                            <s:param name="voieId" value="voieId"/>
                                            <s:property value="voieNom"/>
                                        </s:a>
                                    </td>
                                </tr>
                            </s:iterator>
                            </tbody>
                        </s:if>
                        <s:else>
                            <tbody>
                            <tr>
                                <td><em class="is-danger">Aucun résultat</em></td>
                            </tr>
                            </tbody>
                        </s:else>

                    </table>


                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../_include/footer.jsp" %>