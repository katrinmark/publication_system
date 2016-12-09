<%@ page import="ru.innopolis.entity.Profile" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  Profile: Ekaterina
  Date: 22.11.2016
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp" %>

<div class="container">
    <form method="get" action="/logout">
        <table id="users" class="display" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th><b>Имя</b></th>
                <b/>
                <th><b>Фамилия</b></th>
                <b/>
                <th><b>email</b></th>
            </tr>

            </thead>

            <tfoot>
            <tr>
                <th><b>Имя</b></th>
                <b/>
                <th><b>Фамилия</b></th>
                <b/>
                <th><b>email</b></th>
            </tr>
            </tfoot>

            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <th><c:out value="${user.firstName}"></c:out></th>
                    <th><c:out value="${user.secondName}"></c:out></th>
                    <th><c:out value="${user.email}"></c:out></th>
                </tr>
            </c:forEach>
            </tbody>

        </table>
        <tr>
            <th><input type="submit" class="button" value="Выйти"/></th>
        </tr>
    </form>
</div>

