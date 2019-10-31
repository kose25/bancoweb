
<%@page import="java.util.Iterator"%>
<%@page import="Dto.Cliente"%>
<%@page import="Negocio.Banco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro Cuenta</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/estilo.css">
    </head>
    <body>

        <p class="register-title">Por favor digitar los datos de la cuenta nueva:</p>
        <a class="btnStyle" href="./index.html"> HOME </a>
        <form name="registrarCta" action="RegistrarCuenta.do" class="register">

            <p>Nro. Cuenta (10 dígitos):<input class="register-input" maxlength="10" type="text" name="nrocuenta" value="" /></p>    
            <h3>Tipo de Cuenta</h3>
            <select name="tipocuenta">
                <option> Elegir tipo </option>
                <option value="0"> Cuenta Ahorros</option>
                <option value="1"> Cuenta Corriente </option>           
            </select>
            <hr>
            <br>
            <h3>Cliente</h3>            
            <select name="cedula">
                <option> Seleccionar Cliente </option>
                <%
                    Banco banco = (Banco) (request.getSession().getAttribute("banco"));
                    request.getSession().setAttribute("banco", banco);
                    
                    if (banco != null) {
                        Iterator<Cliente> it = banco.getClientes().iterator();
                        while (it.hasNext()) {
                            Cliente cl = it.next();
                            long cedula = cl.getCedula();
                            String nombre = cl.getNombre();
                %>                
                <option value="<%=cedula%>"> <%= cedula + " | " + nombre%> </option>
                <%
                        }
                    }
                %>  
            </select>
            <hr>           

            <input type="submit" value="Registrar" class="register-button" />

        </form>

    </body>
</html>
