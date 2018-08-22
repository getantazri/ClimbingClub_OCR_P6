<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<footer class="footer">
    <div class="content has-text-centered is-small">
        <p class="navbar-menu menu-footer">
            <s:a action="doToposList" cssClass="navbar-item" namespace="/topos">Topos</s:a>
            <s:a action="doRegions" cssClass="navbar-item" namespace="/regions">En région</s:a>
            <a class="navbar-item" href="#">Mes réservations</a>
            <a class="navbar-item" href="#"><i class="fab fa-facebook-square"></i></a>
            <a class="navbar-item" href="#"><i class="fab fa-twitter"></i></a>
            <a class="navbar-item" href="#"><i class="fab fa-instagram"></i></a>
        </p>
        <p>
            <strong>ClimbingClub</strong> by <a href="https://www.antazri.xyz">Anthony Tazzari</a><br />
            <strong>Projet 6</strong> Parcours <strong>Développeur d'Application Java</strong> @ <a href="http://www.openclassrooms.com" target="_blank">Openclassrooms</a> - 2018
        </p>
    </div>
</footer>

<!-- Load JavaScript file -->
<script src="js/scripts.js"></script>
</body>
</html>