<%-- 
    Document   : resultado
    Created on : 4/11/2019, 04:17:01 PM
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
        ArrayList<Cuenta> resultado = (ArrayList) request.getSession().getAttribute("cuentas");        
        
    %>
    </head>
    <body>
        
        
        <h1>resultado busqueda por cliente </h1>
        
        
            
                
                
                
                <p>
                    <%=resultado.toString()%>
                </p>

            
    </body>
</html>
