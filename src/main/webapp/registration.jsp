<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ekaterina
  Date: 18.11.2016
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
    <title>Регистрация нового пользователя</title>
</head>
<body>
<h1>Регистрация</h1>
<form action="/registration" class="input_table" method="POST">
    <table>
        <tr>
            <th>
                Имя:
            </th>
            <th><input type="text" name="firstName" required></th>
        </tr>
        <tr>
            <th>
                Фамилия:
            </th>
            <th><input type="text" name="secondName" required></th>
        </tr>
        <tr>
            <th>
                Email:
            </th>
            <th><input type="text" name="email" required></th>
        </tr>
        <tr>
            <th>Пароль:</th>
            <th><input type="password" name="password" required></th>
        </tr>
        <tr>
            <th>Подтвердите пароль:</th>
            <th><input type="password" name="passwordConfirm" required></th>
        </tr>
    </table>
    <input type="submit" class="button" value="Сохранить"/>
</form>
</body>
</html>
