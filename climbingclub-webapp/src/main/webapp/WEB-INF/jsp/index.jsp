<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../_include/header.jsp" %>

<section class="hero bg-hp-fullwidth is-fullheight">
    <div class="hero-head">
    </div>

    <div class="hero-body">
        <div class="container has-text-centered">
            <h1 class="title"><span class="hp-title">Où grimperez-vous</span><br/><span class="hp-title">demain ?</span>
            </h1>
            <!--<div class="field is-grouped is-grouped-centered has-addons">
                <div class="hp-form control">
                    <select class="input is-large">
                        <s:iterator value="regions">
                            <option value="region.regionId"><s:property value="region.regionNom"/></option>
                        </s:iterator>
                    </select>
                </div>
                <div class="control">
                    <a class="button is-black is-large">
                        <span class="btn-hp-form">En route !</span>
                    </a>
                </div>-->
            </div>
        </div>
    </div>
</section>

<div class="container">

    <div class="containerContent">

        <section class="section">

            <div class="columns">


                <div class="column is-one-quarter is-offset-1">

                    <figure class="image is-3by4">
                        <img class="hp-img-bg" src="${pageContext.request.contextPath}/img/hp-001.jpg"
                             title="Inscrivez-vous et partagez"
                             alt="Inscrivez-vous et partagez"/>
                    </figure>

                </div>

                <div class="column is-two-quarter is-offset-1">

                    <h2 class="title">Inscrivez-vous et partagez</h2>
                    <h3 class="subtitle">C'est gratuit !</h3>

                    <div class="columns">
                        <div class="column">
                            <span class="hp-icons-centered is-size-6"><i class="fas fa-book"></i> &nbsp; Des topos complets pour toute la France</span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel tristique orci, a
                                gravida odio. Etiam et lacinia odio.</p>
                        </div>

                        <div class="column">
                            <span class="hp-icons-centered is-size-6"><i class="fas fa-hands-helping"></i> &nbsp; Entre-aide dans la communauté</span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel tristique orci, a
                                gravida odio. Etiam et lacinia odio.</p>
                        </div>

                        <div class="column">
                            <span class="hp-icons-centered is-size-6"><i class="far fa-comment"></i> &nbsp; Donnez vos avis sur les topos et spots partagés </span>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel tristique orci, a
                                gravida odio. Etiam et lacinia odio.</p>
                        </div>
                    </div>

                </div>

            </div>

        </section>

        <section class="section">

            <div class="columns">

                <div class="column is-one-quarter is-offset-2 has-text-right">

                    <h2 class="title">Trouvez vos destinations et vos défis de demain</h2>

                    <p>Phasellus in ipsum erat. Duis id vehicula urna. Donec lacinia ullamcorper rhoncus. Donec rhoncus
                        leo sit amet leo auctor
                        rutrum. Morbi in felis accumsan, tempus erat quis, vulputate nisl. In bibendum sed quam eu
                        sollicitudin.</p>
                </div>

                <div class="column is-one-third is-offset-1">

                    <figure class="image is-16by9 is-fullwidth">
                        <img class="hp-img-bg" src="${pageContext.request.contextPath}/img/hp-002.jpg"
                             title="Trouvez vos destinations et vos défis de demain"
                             alt="Trouvez vos destinations et vos défis de demain"/>
                    </figure>

                </div>

            </div>

            <div class="columns">
                <div class="column"></div>
            </div>

        </section>

    </div>

</div>

<%@include file="../_include/footer.jsp" %>

