<%--
  Created by IntelliJ IDEA.
  User: Plat
  Date: 15.02.2021
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Phonebook</title>

    <link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
    <center>
        <h1>Телефонная книга</h1>
        <h3>
            <a href="/show">Показать всех</a>
            <a href="/add">Добавить</a>
            <a href="/find">Найти</a>
        </h3>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Список контактов</h2></caption>
            <tr>
                <th>ID</th>
                <th>ФИО</th>
                <th>Возраст</th>
                <th>Пол</th>
                <th>Адресс Проживания</th>
                <th>Номер</th>
                <th>Действие</th>
            </tr>
            <c:forEach var="JDBC" items="JDBC.showUsersToConsole">
                <tr>
                    <td><c:out value="${JDBC.id}"/></td>
                    <td><c:out value="${JDBC.lastname}"/></td>
                    <td><c:out value="${firstname}"/></td>
                    <td><c:out value="${patronymic}"/></td>
                    <td><c:out value="${age}"/></td>
                    <td><c:out value="${pol}"/></td>
                    <td><c:out value="${livingAddress}"/></td>
                    <td><c:out value="${phoneNumber}"/></td>
                    <td>
                        <a href="/update?id=<c:out value="${id}"/>">Изменить</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value="${id}"/>">Удалить</a>
                    </td>
                </tr>

            </c:forEach>
        </table>
    </div>
</body>
</html>
