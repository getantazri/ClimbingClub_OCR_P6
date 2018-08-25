<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title is-uppercase">Mon compte</h1>

            <div class="columns">

                <div class="column">

                    <h2 class="subtitle">Se connecter</h2>
                    <span class="has-text-danger is-bold"><s:actionerror /></span>

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


