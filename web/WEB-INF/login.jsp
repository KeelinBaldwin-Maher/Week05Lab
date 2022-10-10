
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>

        <form method="post" action="login">
            Username: <input type="text" name="username" value="${username}">
            <br>
            Password: <input type="password" name="password" value="${password}">
            <br>
            <input type="submit" value="Login">
        </form>
            <br>
         <c:if test="${invalid == true}">
             Invalid login details
         </c:if>
        <c:if test="${logout != null}">
             Logout successful
         </c:if>   

    </body>
</html>
