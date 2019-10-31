<%-- 
    Document   : registroexistoso
    Created on : 17/10/2019, 09:19:07 AM
    Author     : docente
--%>

<%@page import="Dto.Cuenta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Negocio.Banco"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/estilo.css">
        <title>Registro exitoso</title>
    </head>
    <body>
        
        <%
        Banco banco=(Banco)(request.getSession().getAttribute("banco"));
        request.getSession().setAttribute("banco", banco);
            
        %>
        
        <h1 class="register-title">Registro de Cuenta Exitoso</h1>
        <br>
        <hr>
        <% for (Cuenta dato:banco.getCuentas())
        {
        %>
            <p><%=dato.toString()%></p>
        <%
            }
        %>
        
        <hr>
        
        <a href="redir.do?url=./jsp/Cuenta/registroCta.jsp">Ingresar otra cuenta</a><br>        
        <a href="./index.html">Ir a Inicio</a>
        
    </body>
</html>
