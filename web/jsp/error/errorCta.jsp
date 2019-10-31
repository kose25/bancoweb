<%-- 
    Document   : error
    Created on : 17/10/2019, 09:18:14 AM
    Author     : docente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/estilo.css">
        <title>Error</title>
    </head>
    <body>
        
        <%
            String error=(String)(request.getSession().getAttribute("error"));
        %>
        <h1 class="register-title">Hubo un error: <%=error%></h1>
        <p>
            <a href="redir.do">Regresar a Registro de Cuentas</a>
        </p>
    </body>
</html>
