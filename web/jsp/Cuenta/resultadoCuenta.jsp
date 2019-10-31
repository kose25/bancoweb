<%-- 
    Document   : resultadoCuenta
    Created on : 31/10/2019, 07:34:19 AM
    Author     : Carlos Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>
            <%
            String banco=(String)(request.getSession().getAttribute("banco"));
        %>
        </p>
    </body>
</html>
