<%@ page import="ru.innopolis.dao.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ekaterina
  Date: 21.11.2016
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Личный кабинет</title>
</head>
<body>
<h1>Личный кабинет</h1>
<form action="/profile" class="input_table" method="POST">
    <table>
        <tr>
            <th>
                Имя:
            </th>
            <th><input type="text" name="firstName" readonly value="<%=request.getAttribute("userFirstName")%>"></th>
        </tr>
        <tr>
            <th>
                Фамилия:
            </th>
            <th><input type="text" name="secondName" readonly value="<%=request.getAttribute("userSecondName")%>"></th>
        </tr>
        <tr>
            <th>
                Email:
            </th>
            <th><input type="text" name="email" readonly value="<%=request.getAttribute("userEmail")%>"></th>
        </tr>
    </table>
    <tr>
        <th><input type="submit" class="button" value="Выйти"/></th>
    </tr>
</form>


</body>
</html>
