/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dto.Cuenta;
import Negocio.Banco;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Carlos Jose
 */
@WebServlet(name = "Operacion", urlPatterns = {"/operacion.do"})
public class Operacion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Banco banco = (Banco) (request.getSession().getAttribute("banco"));
        try (PrintWriter out = response.getWriter()) {
            long nroCuenta = Long.parseLong(request.getParameter("cuentaOrigen"));
            double saldo = Double.parseDouble(request.getParameter("saldo"));
            int tipo = Integer.valueOf(request.getParameter("tipo"));
            int busqueda = Integer.valueOf(request.getParameter("tipo"));

            if (banco.findCuentaByNroCuenta(nroCuenta) != null) {
                if (tipo == 1) {

                    boolean dataResponse = banco.realizarConsignacion(saldo, nroCuenta);

//                    if (dataResponse) {
//                        request.getSession().setAttribute("banco", banco);
//                        request.getRequestDispatcher("./jsp/Cuenta/registroexitoso.jsp").forward(request, response);
//                    } else {
//                        request.getSession().setAttribute("error", "El numero de cuenta pailas, " + nroCuenta);
//                        request.getRequestDispatcher("./jsp/error/errorCta.jsp").forward(request, response);
//                    }
                    request.getSession().setAttribute("banco", banco);
                    request.getRequestDispatcher("./jsp/Cuenta/registroexitoso.jsp").forward(request, response);
                }
                if (tipo == 2) {
                    boolean dataResponse = banco.realizarRetiro(saldo, nroCuenta);
                    if (dataResponse) {
                        request.getSession().setAttribute("banco", banco);
                        request.getRequestDispatcher("./jsp/Cuenta/registroexitoso.jsp").forward(request, response);
                    } else {
                        request.getSession().setAttribute("error", "El saldo es insuficiente, su saldo es: " + banco.findCuentaByNroCuenta(nroCuenta).getSaldo());
                        request.getRequestDispatcher("./jsp/error/errorCta.jsp").forward(request, response);
                    }
                }
                if(tipo == 3){
                   long nroCuentaR = Long.parseLong(request.getParameter("cuentaDestino"));
                   boolean dataResponse = banco.realizarTransferencia(saldo, nroCuenta, nroCuentaR);
                   if(dataResponse){
                       request.getSession().setAttribute("banco", banco);
                       request.getRequestDispatcher("./jsp/Operacion/transferenciaExitosa.jsp").forward(request, response);
                   }else {
                        request.getSession().setAttribute("error", "El saldo es insuficiente, su saldo es: " + banco.findCuentaByNroCuenta(nroCuenta).getSaldo());
                        request.getRequestDispatcher("./jsp/error/errorCta.jsp").forward(request, response);
                    }
                }
            } else {
                request.getSession().setAttribute("error", "El numero de cuenta: " + nroCuenta + " no existe");
                request.getRequestDispatcher("./jsp/error/errorCta.jsp").forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
