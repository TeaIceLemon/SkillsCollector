<%--
  Created by IntelliJ IDEA.
  User: Piotrek
  Date: 10/17/2019
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<jsp:include page="fragmented/header.jsp"/>
<head>
    <title>Sign in</title>
</head>
<body>
<h1> Sign in </h1>
<div>
    <form method="post" action="/login">
        <fieldset>
            <span>
                <div>
                    <label for = "username"> Username</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div>
                    <label for= "password"> Password</label>
                    <input type="password" id = "password" name="password" required>
                </div>
            </span>
        </fieldset>
        <p>
            <input type="submit" value="SAVE"/> <input type="reset" value="RESET"/>
        </p>
        <c:if test="${error != null}">
            <p>
                ${error}
            </p>
        </c:if>
    </form>
</div>
</body>
<jsp:include page="fragmented/footer.jsp"/>
</html>
