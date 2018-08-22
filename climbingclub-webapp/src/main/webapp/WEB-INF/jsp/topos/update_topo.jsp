<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Ajouter un topo</h1>

            <h2 class="subtitle">Partagez-le avec la communauté !</h2>

            <div class="columns">

                <div class="column">

                    <s:form action="doAddTopo">
                        <div class="field">
                            <div class="control">
                                <span class="has-text-danger"><s:actionerror /></span>
                                <s:textfield name="topo.topoNom" value="%{topo.topoNom}" label="Nom" requiredLabel="true" />
                            </div>
                        </div>
                        <div class="field">
                            <div class="control">
                                <s:select name="region.regionId" label="Région" value="%{topo.region.regionNom}"
                                          list="regions" listKey="regionId" listValue="regionNom"
                                          emptyOption="false"
                                          requiredLabel="true" />
                            </div>
                        </div>
                        <label class="checkbox">
                            <s:checkbox name="topo.disponible" value="%{topo.disponible}" label="Disponible" requiredLabel="true" />
                        </label>
                        <div class="control add-space-top-bottom-10">
                            <s:submit value="Enregistrer les modifications"  cssClass="button is-primary" />
                        </div>

                    </s:form>
                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>