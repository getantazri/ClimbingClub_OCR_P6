<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ClimbingClub Web Application - Homepage</title>
</head>

<body>
<h1>Bienvenue sur l'application CClub</h1>
<h2>qui implémente Struts2</h2>
<s:a action="doToposList" namespace="/topos">Liste des topos</s:a>

</body>
</html>