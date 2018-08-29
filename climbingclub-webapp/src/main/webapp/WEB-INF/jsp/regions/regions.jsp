<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%@include file="../../_include/header.jsp" %>

<div class="container">

    <div class="containerContent">

        <section id="en-region" class="section">

            <div class="columns">

                <div class="column has-text-left">

                    <h1 class="title is-uppercase">En région</h1>

                    <h2 class="subtitle">Parcourez l'ensemble des régions de France métropolitiaine et
                        d'outre-mer pour trouver votre prochaine destination de grimpe</h2>

                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Auvergne-Rhône-Alpes
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-01.jpg">
                        </figure>
                        <s:param name="region.regionId" value="1" />
                    </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Bourgogne-Franche-Comté
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-02.jpg">
                        </figure>
                        <s:param name="region.regionId" value="2" />
                    </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Bretagne
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-03.jpg">
                        </figure>
                        <s:param name="region.regionId" value="3" />
                    </s:a>
                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                        <s:a action="doRegionDetails">Centre-Val de Loire
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-04.jpg">
                        </figure>
                            <s:param name="region.regionId" value="4" />
                        </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Corse
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-05.jpg">
                        </figure>
                        <s:param name="region.regionId" value="5" />
                    </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Grand Est
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-06.jpg">
                        </figure>
                        <s:param name="region.regionId" value="6" />
                    </s:a>
                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Guadeloupe
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-07.jpg">
                        </figure>
                        <s:param name="region.regionId" value="7" />
                    </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Guyane
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-08.jpg">
                        </figure>
                        <s:param name="region.regionId" value="8" />
                    </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Hauts-de-France
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-09.jpg">
                        </figure>
                        <s:param name="region.regionId" value="9" />
                    </s:a>
                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Île-de-France
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-010.jpg">
                        </figure>
                        <s:param name="region.regionId" value="10" />
                    </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Martinique
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-011.jpg">
                        </figure>
                        <s:param name="region.regionId" value="11" />
                    </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Mayotte
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-012.jpg">
                        </figure>
                        <s:param name="region.regionId" value="12" />
                    </s:a>
                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Normandie
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-013.jpg">
                        </figure>
                        <s:param name="region.regionId" value="13" />
                    </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Nouvelle Aquitaine
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-014.jpg">
                        </figure>
                        <s:param name="region.regionId" value="14" />
                    </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Occitanie
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-015.jpg">
                        </figure>
                        <s:param name="region.regionId" value="15" />
                    </s:a>
                </div>

            </div>

            <div class="columns">

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Pays de la Loire
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-016.jpg">
                        </figure>
                        <s:param name="region.regionId" value="16" />
                    </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Provence-Alpes-Côte d'Azur
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-017.jpg">
                        </figure>
                        <s:param name="region.regionId" value="17" />
                    </s:a>
                </div>

                <div class="column has-text-left">
                    <s:a action="doRegionDetails">Réunion
                        <figure class="image is-2by1">
                            <img src="${pageContext.request.contextPath}/img/regions/region-018.jpg">
                        </figure>
                        <s:param name="region.regionId" value="18" />
                    </s:a>
                </div>

            </div>

        </section>

    </div>

</div>

<%@include file="../../_include/footer.jsp" %>

