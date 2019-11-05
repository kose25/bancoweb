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
        <link rel="stylesheet" href="./css/estilo.css">
        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>

        <title>ver cuentas</title>
    </head>
    <body>
        <!-- <h1>Todas las cuentas</h1>
        <table border="1" id="myTable" class="display">
            <thead>
                <tr>
                    <th>Cuenta</th>
                    <th>Cliente</th>
                    <th>Saldo</th>
                </tr>
            </thead>
            <tbody>
        <% for (Cuenta dato : banco.getCuentas()) {%>
        <tr>
            <td><%=dato.getNroCuenta()%></td>
            <td><%=dato.getCliente().getCedula()%></td>
            <td><%=dato.getSaldo()%></td>
        </tr>
        <% }%>

    </tbody>
</table> -->
        <p class="register-title">Seleccione su metodo de busqueda</p>
        <a class="btnStyle" href="./index.html"> HOME </a>
        <form name="operacion" method="post" action="informe.do" class="register">
            <p>seleccione el tipo de busqueda</p>
            <select name="busqueda">
                <option> Elegir tipo de busqueda </option>
                <option value="0">por cuenta</option>
                <option value="1">por cliente</option>
            </select>
            <input type="number" class="register-input" name="searchfield" value=""  placeholder="ingrese la busqueda" required/>
            <input type="submit" value="buscar" class="register-button"/>
        </form>


        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
            $('#myTable').DataTable();
            });
        </script>
    </body>
</html>
