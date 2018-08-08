<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>CCLUB - ADD TOPO</title>
</head>
<body>
    <h1>CCLUB - ADD TOPO</h1>
    <p><s:actionmessage /></p>
    <p><s:actionerror /></p>

    <h2>Ajouter un topo</h2>
    <s:form action="doAddTopo">
        <s:textfield name="topo.topoNom" label="Nom" requiredLabel="true" />
        <s:select name="topo.region.regionId" label="Région"
                  list="regions" listKey="regionId" listValue="regionNom"
                  emptyOption="false"
                  requiredLabel="true" />
        <s:checkbox name="topo.disponible" label="Disponible" requiredLabel="true" />
        <s:submit value="Ajouter" />
    </s:form>

</body>
</html>
