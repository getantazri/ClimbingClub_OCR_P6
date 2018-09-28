<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Nouvelle réservation</h1>

            <div class="columns">

                <div class="column">

                    <s:form action="doAddReservation" method="POST">
                        <s:hidden name="utilisateurId" value="%{#session.user.utilisateurId}" />
                        <div class="field">
                            <div class="control">
                                <s:select name="emprunt.topo.topoId" label="Topo"
                                          list="topos" listKey="topoId" listValue="topoNom"
                                          emptyOption="false"
                                          requiredLabel="true"
                                          cssClass="select" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:textfield label="Date de début" type="date" name="emprunt.dateDebut" format="dd-MM-yyyy" requiredLabel="true" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:textfield label="Date de fin" type="date" name="emprunt.dateFin" format="dd-MM-yyyy" requiredLabel="true" />
                            </div>
                        </div>

                        <div class="control add-space-top-bottom-10">
                            <s:submit value="Réserver"  cssClass="button is-primary" />
                        </div>
                    </s:form>

                </div>

                <div class="column">
                    <s:actionerror cssClass="is-bold has-text-danger"/>
                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>


