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

                    <div class="notification is-danger"><s:actionerror /></div>

                    <div class="notification is-light"><s:actionmessage /></div>

                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../_include/footer.jsp" %>


