<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <h1 class="title">Administration</h1>

            <div class="columns">
                <div class="column"><s:actionerror /></div>
                <div class="column"><s:actionmessage /></div>
            </div>

            <h2 class="subtitle">Gestion du contenu</h2>

            <div class="columns">

                <div class="column">

                    <s:a action="doListTopos" namespace="/admin" cssClass="button is-light is-small">
                        <span><b>Afficher tous les Topos</b></span>
                    </s:a>

                </div>

            </div>

            <div class="columns">

                <div class="column">

                    <s:a action="doListSpots" namespace="/admin" cssClass="button is-light is-small">
                        <span><b>Afficher tous les Spots</b></span>
                    </s:a>

                </div>

            </div>

            <div class="columns">

                <div class="column">

                    <s:a action="doListSecteurs" namespace="/admin" cssClass="button is-light is-small">
                        <span><b>Afficher tous les Secteurs</b></span>
                    </s:a>

                </div>

            </div>

            <div class="columns">

                <div class="column">

                    <s:a action="doListVoies" namespace="/admin" cssClass="button is-light is-small">
                        <span><b>Afficher toutes les Voies</b></span>
                    </s:a>

                </div>

            </div>

            <div class="columns">

                <div class="column">

                    <s:a action="doListCommentaires" namespace="/admin" cssClass="button is-light is-small">
                        <span><b>Afficher tous les Commentaires</b></span>
                    </s:a>

                </div>

            </div>

            <div class="columns">

                <div class="column">

                    <s:a action="doListReservations" namespace="/admin" cssClass="button is-light is-small">
                        <span><b>Afficher tous les Réservations</b></span>
                    </s:a>

                </div>

            </div>

            <h2 class="subtitle">Gestion des utilisateurs</h2>

            <div class="columns">

                <div class="column">

                    <s:a action="doListUtilisateurs" namespace="/admin" cssClass="button is-light is-small">
                        <span><b>Afficher tous les utilisateur</b></span>
                    </s:a>

                </div>

            </div>

            <div class="columns">

                <div class="column">

                    <s:a action="doAddUtilisateur" namespace="/admin" cssClass="button is-primary is-small">
                        <span><b>Ajouter un utilisateur</b></span>
                    </s:a>

                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>


