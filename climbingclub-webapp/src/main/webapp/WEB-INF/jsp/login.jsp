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

                    <form id="login-form" action="" method="POST"/>
                    <div class="field">
                        <p class="control has-icons-left">
                            <input class="input" type="email" placeholder="Email" required>
                            <span class="icon is-small is-left">
                    <i class="fas fa-envelope"></i>
                  </span>
                        </p>
                    </div>
                    <div class="field">
                        <p class="control has-icons-left">
                            <input class="input" type="password" placeholder="Password" required>
                            <span class="icon is-small is-left">
                    <i class="fas fa-lock"></i>
                  </span>
                        </p>
                    </div>
                    <div class="field">
                        <p class="control">
                            <button class="button is-success">
                                Se connecter
                            </button>
                        </p>
                    </div>
                    </form>

                </div>

                <div class="column">

                    <h2 class="subtitle">S'inscrire</h2>

                    <p>Vous n'êtes pas inscrit ? Rejoignez la communauté ClimbingClub pour partager
                        votre passion pour l'escalade. Vous pourrez partager vos topos et réserver
                        ceux des autres membres !</p>

                    <form id="inscription-form" action="" method="POST">

                        <div class="field">
                            <label class="label is-small">Nom :</label>
                            <p class="control">
                                <input class="input" type="text" placeholder="Nom" required>
                            </p>
                        </div>
                        <div class="field">
                            <label class="label is-small">Prénom :</label>
                            <p class="control">
                                <input class="input" type="text" placeholder="Prénom" required>
                            </p>
                        </div>
                        <div class="field">
                            <label class="label is-small">Pseudonyme :</label>
                            <p class="control">
                                <input class="input" type="text" placeholder="Pseudonyme" required>
                            </p>
                        </div>
                        <div class="field">
                            <label class="label is-small">E-mail :</label>
                            <p class="control">
                                <input class="input" type="email" placeholder="E-mail" required>
                            </p>
                        </div>
                        <div class="field">
                            <label class="label is-small">Téléphone :</label>
                            <p class="control">
                                <input class="input" type="text" placeholder="Téléphone" required>
                            </p>
                        </div>
                        <div class="field">
                            <label class="label is-small">Mot de passe :</label>
                            <p class="control">
                                <input class="input" type="password" placeholder="Mot de passe" required>
                            </p>
                        </div>
                        <div class="field">
                            <label class="label is-small">Confirmer le mot de passe :</label>
                            <p class="control">
                                <input class="input" type="password" placeholder="Mot de passe" required>
                            </p>
                        </div>
                        <div class="field">
                            <p class="control">
                                <button class="button is-success">
                                    S'inscrire
                                </button>
                            </p>
                        </div>

                    </form>
                </div>

            </div>

        </section>

    </div>

</div>


<%@include file="../_include/footer.jsp" %>


