<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Ekaterina
  Date: 22.12.2016
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp" %>

<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <form role="form" method="post" action="/publication/update">
                        <div class="form-group">
                            <label class="sr-only">"${publication.title}"</label>
                        </div>

                        <div class="form-group">
                                <textarea class="form-control" rows="10"
                                          name="content">${publication.content}</textarea>
                        </div>
                        <div hidden>
                            <input name="id" value="${publication.id}">
                            <input name="version" value="${publication.version}">
                            <input name="title" value="${publication.title}">
                            <input name="profileModel.id" value="${publication.profileModel.id}">
                            <input name="profileModel.firstName" value="${publication.profileModel.firstName}">
                            <input name="profileModel.secondName" value="${publication.profileModel.secondName}">
                            <input name="profileModel.username" value="${publication.profileModel.username}">
                        </div>
                        <input type="submit" class="button" value="Сохранить">

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
