<%--
  Created by IntelliJ IDEA.
  User: Plat
  Date: 15.02.2021
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import ="JDBC" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert in here</title>
</head>
<body>
    <jsp:useBean id="add"
    class="JDBC" />

    <jsp:setProperty name="add" property="*" />

    <%
        JDBC jdbc = new JDBC();
    %>

</body>
</html>