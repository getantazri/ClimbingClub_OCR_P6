<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Oops, erreur !</h1>

            <h2 class="subtitle">Il semble y avoir un problème !</h2>

            <div class="columns">

                <div class="column">

                    <s:if test="%{this.hasActionErrors()}">
                        <div class="notification is-danger"><s:actionerror /></div>
                    </s:if>

                    <s:if test="%{this.hasActionMessages()}">
                        <div class="notification is-danger"><s:actionmessage /></div>
                    </s:if>

                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../_include/footer.jsp" %>


