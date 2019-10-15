<%--
  Created by IntelliJ IDEA.
  User: Piotrek
  Date: 10/15/2019
  Time: 9:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<jsp:include page="WEB-INF/views/fragmented/header.jsp"/>
<head>
    <title>User registration</title>
</head>
<body>
    <h1> New user registration</h1>
    <div>
<%--        <form method="post" action="/register">--%>
            <div>
                <label for="login">Login</label>
                <input type ="text", id="login" name="login" required/>
            </div>
            <div>
                <label for="password"> password </label>
                <input type ="text", id="password" name="password" required/>
            </div>
        </form>
    </div>
</body>
<jsp:include page="WEB-INF/views/fragmented/footer.jsp"/>
</html>
