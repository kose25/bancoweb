<%-- 
    Document   : registrar
    Created on : 21/10/2019, 06:31:14 PM
    Author     : madar
--%>

<%@page import="Negocio.Banco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
        Banco banco=(Banco)(request.getSession().getAttribute("banco"));
        request.getSession().setAttribute("banco", banco);            
%>
<jsp:include page="../../html/Cliente/registro.html" />


