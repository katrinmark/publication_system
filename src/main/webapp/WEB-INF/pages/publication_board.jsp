<%--
  Created by IntelliJ IDEA.
  User: Ekaterina
  Date: 30.11.2016
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="index.jsp" %>

<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <form role="form">
                        <c:forEach items="${publications}" var="publication">
                            <div class="form-group">
                                <label class="sr-only">"${publication.title}"</label>
                            </div>

                            <div class="form-group">
                                <textarea class="form-control" rows="5" readonly
                                          name="content">"${publication.content}"</textarea>
                            </div>
                        </c:forEach>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
