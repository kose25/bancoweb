<%-- 
    Document   : vercuentas
    Created on : 30/10/2019, 10:05:48 PM
    Author     : Carlos Jose
--%>

<%@page import="Dto.Cuenta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Negocio.Banco"%>
<!DOCTYPE html>
<html>

    <%
        Banco banco = (Banco) (request.getSession().getAttribute("banco"));
        request.getSession().setAttribute("banco", banco);

    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ver cuentas</title>
    </head>
    <body>
        <h1>Todas las cuentas</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>Cuenta</th>
                    <th>Cliente</th>
                    <th>Saldo</th>
                </tr>
            </thead>
            <tbody>
                <% for (Cuenta dato : banco.getCuentas()) { %>
                <tr>
                    <td><%=dato.getNroCuenta()%></td>
                    <td><%=dato.getCliente().getCedula()%></td>
                    <td><%=dato.getSaldo()%></td>
                </tr>
                <% }%>
                
            </tbody>
        </table>

    </body>
</html>
