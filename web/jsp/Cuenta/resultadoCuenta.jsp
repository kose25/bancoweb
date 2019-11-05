<%-- 
    Document   : resultadoCuenta
    Created on : 31/10/2019, 07:34:19 AM
    Author     : Carlos Jose
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Dto.Cliente"%>
<%@page import="Dto.Cuenta"%>
<%@page import="Negocio.Banco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <%
        Banco banco = (Banco) (request.getSession().getAttribute("banco"));
        request.getSession().setAttribute("banco", banco);
        Cuenta cuentas = (Cuenta) request.getSession().getAttribute("dato");
        
        
    %>
    </head>
    <body>
        
        <a class="btnStyle" href="./index.html"> HOME </a>
        
        
        <h1>resultado busqueda por cuenta </h1> 
                        
                
                <p>
                    <%=cuentas.toString()%>
                </p>

            
    </body>
</html>

