<%--
  Created by IntelliJ IDEA.
  User: Ekaterina
  Date: 21.11.2016
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title></title>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="/portal/main">Publication System</a>
            </div>

            <c:choose>
                <c:when test="${empty pageContext.request.userPrincipal.name}">
                </c:when>
                <c:otherwise>
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/user/profile">Личный кабинет</a></li>
                        <li><a href="/publication/user_publications">Мои публикации</a></li>
                        <li><a href="/publication/add">Новая публикация</a></li>
                    </ul>
                </c:otherwise>
            </c:choose>

        </div>
    </nav>

    <div class="row">
        <div class="col-xs-6 col-xs-offset-3">
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                <strong>Ошибка</strong>
                ${error}
            </div>
        </c:if>
        </div>
    </div>

    <spring:url value="/resources/css/index.css" var="mainCss"/>
    <spring:url value="/resources/css/jquery.dataTables.min.css" var="dataTablesCss"/>
    <spring:url value="/bootstrap/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/bootstrap/css/bootstrap-theme.min.css" var="bootstrapThemeCss"/>

    <spring:url value="/resources/js/jquery.min.js" var="jqueryJs"/>
    <spring:url value="/resources/js/jquery.dataTables.min.js" var="dataTablesJs"/>
    <spring:url value="/bootstrap/js/bootstrap.min.js" var="bootstrapJs"/>
    <spring:url value="/resources/js/index.js" var="mainJs"/>

    <link href="${mainCss}" rel="stylesheet"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${bootstrapThemeCss}" rel="stylesheet"/>
    <link href="${dataTablesCss}" rel="stylesheet"/>
    <script src="${jqueryJs}"></script>
    <script src="${dataTablesJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="${mainJs}"></script>

</head>

<body>
</body>
</html>
