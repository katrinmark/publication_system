<%--
  Created by IntelliJ IDEA.
  User: Ekaterina
  Date: 20.12.2016
  Time: 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp" %>
<div class="top-content">
    <div class="row">
        <div class="col-xs-6 col-xs-offset-3">
            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    <strong>Ошибка:</strong>
                        ${error}
                </div>
            </c:if>
        </div>
    </div>
    <div class="row">
        <div class="text-center">
            <c:if test="${not empty backLink}">
                <a href="${backLink}" class="btn btn-default" role="button">Назад</a>
            </c:if>
        </div>
    </div>
</div>