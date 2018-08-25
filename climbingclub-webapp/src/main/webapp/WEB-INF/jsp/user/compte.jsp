<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title"><s:property value="#session.user.pseudo" /></h1>

            <h2 class="subtitle">Fiche détaillée</h2>

            <div class="columns">

                <div class="column">

                    <p class="control">
                        <s:a action="doLogout" cssClass="button is-danger is-small" title="Se déconnecter">
                            <span><b>Se déconnecter</b></span>
                        </s:a>
                    </p>

                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>


