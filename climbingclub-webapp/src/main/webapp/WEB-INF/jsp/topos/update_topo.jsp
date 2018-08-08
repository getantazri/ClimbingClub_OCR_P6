<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
    <title>UPDATE TOPO</title>
</head>
<body>

<s:form action="doUpdateTopo">
    <s:textfield name="topo.topoNom" value="${topo.topoNom}" label="Nom" requiredLabel="true" />
    <s:select name="topo.region.regionId" label="Région" value="${topo.region.regionNom}"
              list="regions" listKey="regionId" listValue="regionNom"
              emptyOption="false"
              requiredLabel="true" />
    <s:checkbox name="topo.disponible" value="${topo.disponible}" label="Disponible" requiredLabel="true" />
    <s:submit value="Modifier" />
</s:form>

</body>
</html>
