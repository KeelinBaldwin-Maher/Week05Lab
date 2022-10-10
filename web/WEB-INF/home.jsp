
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    
    <body>
        <h1>Home Page</h1>
        
        <h2>Hello ${username}</h2>
        
        <form action="home" method="post">
            <input type="submit" value="Logout">
            <input type="hidden" name="logout">
        </form>
        
    </body>
</html>
