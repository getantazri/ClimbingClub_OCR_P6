<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title is-uppercase">Mon compte</h1>
            <h2 class="subtitle">Se connecter</h2>

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

                    <s:form action="doLogin" namespace="/login" method="POST">
                        <div class="field">
                            <p class="control">
                                <s:textfield name="pseudo" label="Pseudo" requiredLabel="true" cssClass="input" type="text" />
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <s:textfield name="password" label="Password" requiredLabel="true" cssClass="input" type="password" />
                            </p>
                        </div>
                        <div class="field">
                            <p class="control add-space-top-bottom-10">
                                <s:submit value="Se connecter"  cssClass="button is-primary" />
                            </p>
                        </div>
                    </s:form>

                </div>

            </div>

        </section>

    </div>

</div>


<%@include file="../_include/footer.jsp" %>


