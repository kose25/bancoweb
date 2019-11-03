/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

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
@WebServlet(name = "Informe", urlPatterns = {"/informe.do"})
public class Informe extends HttpServlet {

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
            long nro = Long.parseLong(request.getParameter("searchfield"));
            int tipo = Integer.valueOf(request.getParameter("busqueda"));
            if (banco.findCuentaByNroCuenta(nro) != null) {
                if (tipo == 0) {
//POr cuenta

                    request.getSession().setAttribute("banco", banco + "Los datos de la cuenta son \n"
                            + banco.findCuentaByNroCuenta(nro).toString());
                    request.getRequestDispatcher("./jsp/Cuenta/registroexitoso.jsp").forward(request, response);
                }
                if (tipo == 1) {
//por cliente
                    request.getSession().setAttribute("banco", banco + "Los datos de la cuenta son \n"
                            + banco.findCuentaByNroCedula(nro).toString());
                    request.getRequestDispatcher("./jsp/Cuenta/registroexitoso.jsp").forward(request, response);
                } else {
                    request.getSession().setAttribute("error", "El saldo es insuficiente, su saldo es: " + banco.findCuentaByNroCuenta(nro).getSaldo());
                    request.getRequestDispatcher("./jsp/error/errorCta.jsp").forward(request, response);
                }
            } else {
                request.getSession().setAttribute("error", "El numero de cuenta: " + nro + " no existe");
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
