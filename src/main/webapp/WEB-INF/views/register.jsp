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
<jsp:include page="fragmented/header.jsp"/>
<head>
    <title>User registration</title>
</head>
<body>
<h1> New user registration</h1>
<div>
    <form method="post" action="/register">
        <fieldset>
            <div>
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required/>
            </div>
            <div>
                <label for="password"> Password </label>
                <input type="text" id="password" name="password" required/>
            </div>
            <div>
                <label for="firstname"> First Name </label>
                <input type="text" id="firstname" name="firstname"/>
            </div>
            <div>
                <label for="lastname"> Last name </label>
                <input type="text" id="lastname" name="lastname"/>
            </div>
        </fieldset>
        <fieldset>
            <input type="submit" value="SAVE"/> <input type="reset" value="RESET"/>
        </fieldset>
    </form>
</div>
</body>
<jsp:include page="fragmented/footer.jsp"/>
</html>
