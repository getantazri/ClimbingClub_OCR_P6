<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>CCLUB - TOPOS</title>
</head>
<body>
<h1>Topos</h1>
<ul>
    <s:iterator value="topos">
        <li>
            <s:a action="doTopoDetails" namespace="/topos/topo">
                <s:param name="topoId" value="topoId" />
                <s:property value="topoNom" />
            </s:a>
        </li>
    </s:iterator>
</ul>
</body>
</html>
