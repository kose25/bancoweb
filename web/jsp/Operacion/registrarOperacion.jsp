<%-- 
    Document   : registrarOperacion
    Created on : 30/10/2019, 03:17:11 PM
    Author     : Carlos Jose
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Operacion</title>
    </head>

    <body>
        <form name="operadcion" method="post" action="operacion.do">
            <p>Seleccionar Operacion<p>
                <select name="tipo" required id="dropdown">
                    <option value="1">Consignacion</option>
                    <option value="2">Retiro</option>
                    <option value="3">Transferencia</option>
                </select>
            <p> ingresar cuenta origen <p>
                <input type="number" name="cuentaOrigen" value="" min="1" required placeholder="ingrese numero de cuenta" />

            <p> ingrese cuenta destino <p>
                <input type="number" name="cuentaOrigen" value="" id="destino" placeholder="ingrese cuenta destino" disabled />

            <p> ingresar monto<p>
                <input type="number" name="saldo" value="0" min="1" required />

                <input type="submit" value="Registrar" name="registrar" />
        </form>



        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <script type="text/javascript">
            $(document).ready(function () {

                $('#dropdown').change(function () {
                    if ($(this).val() == 3) {
                        $('#destino').prop("disabled", false);
                    } else {
                        $('#destino').prop("disabled", true);
                    }
                });

            });

        </script>
    </body>

</html>

