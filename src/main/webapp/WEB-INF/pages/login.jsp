<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ekaterina
  Date: 20.11.2016
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp" %>

<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <p>Введите email и пароль</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/login" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">Email</label>
                                <input type="text" name="login" placeholder="Email..."
                                       class="form-username form-control" id="form-username" required>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">Пароль</label>
                                <input type="password" name="password" placeholder="Пароль..."
                                       class="form-password form-control" id="form-password" required>
                            </div>
                            <button type="submit" class="btn btn-default">Войти</button>
                            <a href="/register" class="btn btn-default" role="button">Регистрация</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>