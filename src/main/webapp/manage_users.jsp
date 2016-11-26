<%@ page import="ru.innopolis.dao.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ekaterina
  Date: 22.11.2016
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Сотрудники</title>
</head>
<body>
<form>
<table>
    <tr>
        <td><b>Id</b></td>
        <b/>
        <td><b>Имя</b></td>
        <b/>
        <td><b>Фамилия</b></td>
    </tr>

    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.firstName}"></c:out></td>
            <td><c:out value="${user.secondName}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
        </tr>
    </c:forEach>
</table>
    <tr>
        <th><input type="submit" class="button" value="Выйти"/></th>
    </tr>
</form>
</body>
</html>
