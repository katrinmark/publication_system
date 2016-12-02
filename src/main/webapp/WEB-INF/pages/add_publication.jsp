<%--
  Created by IntelliJ IDEA.
  User: Ekaterina
  Date: 30.11.2016
  Time: 20:45
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
                            <p>Новая публикация</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-lock"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/publication/add" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only">Заголовок:</label>
                                <input type="text" placeholder="Заголовок..." name="title" required>
                            </div>

                            <div class="form-group">
                                <label for="comment">Введети текст публикации:</label>
                                <textarea class="form-control" rows="5" id="comment" name="content"></textarea>
                            </div>
                            <button type="submit" class="btn btn-default">Сохранить</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>