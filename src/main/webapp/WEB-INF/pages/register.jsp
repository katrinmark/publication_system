<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ekaterina
  Date: 18.11.2016
  Time: 17:48
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
                            <p>Регистрация</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/register" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only">Имя:</label>
                                <input type="text" name="firstName" placeholder="Имя..." required>
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Фамилия:</label>
                                <input type="text" name="secondName" placeholder="Фамилия..." required>
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Email:</label>
                                <input type="email" name="email" placeholder="Email..." required>
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Пароль:</label>
                                <input type="password" name="password" placeholder="Пароль..." required>
                            </div>
                            <div class="form-group">
                                <label class="sr-only">Повторите пароль:</label>
                                <input type="password" name="passwordConfirm" placeholder="Повторите пароль..." required>
                            </div>
                            <button type="submit" class="btn btn-default">Сохранить</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>