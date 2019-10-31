
package Controlador;

import Negocio.Banco;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "redir", urlPatterns = {"/redir.do"})
public class redir extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Banco banco = new Banco();
            
            String url = request.getParameter("url");
            
            if (request.getSession().getAttribute("banco") != null) {
                banco = (Banco) (request.getSession().getAttribute("banco"));
                request.getSession().setAttribute("banco", banco);
                request.getRequestDispatcher(url).forward(request, response);
            }
            else {
                System.err.println("falso");
                request.getSession().setAttribute("error", "No existe banco creado");
                request.getRequestDispatcher("./jsp/error/errorbanco.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            request.getSession().setAttribute("error", e.getMessage());
            request.getRequestDispatcher("./jsp/error/errorbanco.jsp").forward(request, response);
        }
 {
            
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
