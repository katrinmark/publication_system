<%--
  Created by IntelliJ IDEA.
  User: Ekaterina
  Date: 30.11.2016
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>

<div class="container">
    <form method="get" action="/logout">
        <table id="users" class="display" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th><b>Заголовок</b></th>
                <b/>
                <th><b>Текст</b></th>
            </tr>

            </thead>

            <tfoot>
            <tr>
                <th><b>Заголовок</b></th>
                <b/>
                <th><b>Текст</b></th>
            </tr>
            </tfoot>

            <tbody>
            <c:forEach items="${publications}" var="publication">
                <tr>
                    <th><c:out value="${publication.title}"></c:out></th>
                    <th><c:out value="${publication.content}"></c:out></th>
                </tr>
            </c:forEach>
            </tbody>

        </table>
        <tr>
            <th><input type="submit" class="button" value="Выйти"/></th>
        </tr>
    </form>
</div>