/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.controladorAbonadoRemote;
import controlador.controladorVinoRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Preferencia;
import modelo.Referencia;
import modelo.Vino;

/**
 *
 * @author coke
 */
public class AbonadoSeleccion extends HttpServlet {

    @EJB
    private controladorVinoRemote controladorVino;

    @EJB
    private controladorAbonadoRemote controladorAbonado;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AbonadoSeleccion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Creación de un pedido:</h1>");
            out.println("<h3>Añada las preferencias que desee pedir.</h3>");
            out.println("<div>");
            out.println("<ul>");
            List<Preferencia> preferencias = controladorAbonado.getPreferencias("xxx");
            List<Vino> vinos = new ArrayList();
            for(Preferencia item : preferencias) {
                vinos.addAll(controladorVino.getVinos(item.getDenominacion(), item.getCategoria()));
            }
            for(Vino item : vinos) {
                Referencia ref = controladorVino.getReferencia(item.getId());
                out.println("<li>"+ref.toString()+" "+ ref.getPrecio()+"<input type=\"hidden\" name=\"referencia\" values=\""+ref.getCodigo()+"\"/><input name=\"commit\" value=\"+\" type=\"submit\"></li>");
            }
            out.println("</ul>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
