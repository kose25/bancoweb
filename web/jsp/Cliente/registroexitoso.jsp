<%-- 
    Document   : registroexistoso
    Created on : 17/10/2019, 09:19:07 AM
    Author     : docente
--%>

<%@page import="Dto.Cliente"%>
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
        
        <h1 class="register-title">Registro exitoso</h1>
        <br>
        <hr>
        <% for (Cliente dato:banco.getClientes())
        {
        %>
            <p><%=dato.toString()%></p>
        <%
            }
        %>
        
        <hr>
        
        <a href="./jsp/Cliente/registrar.jsp">Ingresar otro cliente</a>
        </br>
        <a href="./index.html">Ir a Inicio</a>
    </body>
</html>
