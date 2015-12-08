<%-- 
    Document   : login
    Created on : 01-dic-2015, 1:42:06
    Author     : coke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Vinoteca</h1>
        <form method="post" action="Login">
        <p><input name="login" value="" placeholder="Username" type="text"></p>
        <p><input name="password" value="" placeholder="Password" type="password"></p>
        <p class="remember_me">
          <label>
            <input name="is_empleado" id="is_empleado" type="checkbox">
            Soy Empleado
          </label>
        </p>
        <p class="submit"><input name="commit" value="Login" type="submit"></p>
      </form>
    </body>
</html>
