<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  Profile: Ekaterina
  Date: 21.11.2016
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp"%>

<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-bottom">
                        <form role="form" action="/logout" method="get" class="login-form">
                            <div class="form-group">
                                <label class="sr-only">Имя:</label>
                                <input type="text" name="firstName" readonly value="${user.firstName}">
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Фамилия:</label>
                                <input type="text" name="secondName" readonly value="${user.secondName}">
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Email:</label>
                                <input type="text" name="secondName" readonly value="${user.username}">
                            </div>
                            <button type="submit" class="btn btn-default">Выйти</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>