/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author coke
 */
public class consultarPedidos extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/VinotecaWS-war/PedidoWS.wsdl")
    private services.PedidoWS_Service service;

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
            out.println("<title>Servlet consultarPedidos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Administración de pedidos:</h1>");
            out.println("<h3>Aquí puede cambiar el estado de los pedidos.</h3>");
            out.println("<div>");
            out.println("<form method=\"post\" action=\"consultarPedidos\">");
            out.println("<ul>");
            List<services.Pedido> pendientes = getPedidosPendientes();
            if(pendientes.size()>0) {
                for(services.Pedido item : pendientes) {
                   out.println("<li>");
                   out.println("Pedido " + item.getNumero()
                      +" <select name=\"estado\">"
                      +"<option value=\"P,"+item.getNumero()+"\">Pendiente</option>" 
                      +"<option value=\"C,"+item.getNumero()+"\">Completado</option>" 
                      +"<option value=\"T,"+item.getNumero()+"\">Tramitado</option>"
                      +"<option value=\"F,"+item.getNumero()+"\">Facturado</option>"
                      +"<option value=\"A,"+item.getNumero()+"\">Pagado</option>"
                      +"<option value=\"S,"+item.getNumero()+"\">Servido</option>"
                      +"</select>"
                      +"</li>"); 
                }
                out.println("</ul>");
                out.println("<p><input name=\"commit\" value=\"Save\" type=\"submit\"></p>");
                out.println("</form>");
            } else {
                out.println("<p>No hay pedidos pendientes</p>");
            }
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
        doPost(request, response);
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
        String[] estados = request.getParameterValues("estado");
        if(estados != null) {
            for(String i : estados) {
                List<String> tupla = Arrays.asList(i.split(","));
                editPedido(Integer.parseInt(tupla.get(1)), tupla.get(0));
            }
        }
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

    private java.util.List<services.Pedido> getPedidosPendientes() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        services.PedidoWS port = service.getPedidoWSPort();
        return port.getPedidosPendientes();
    }

    private void editPedido(int numeroPedido, java.lang.String estado) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        services.PedidoWS port = service.getPedidoWSPort();
        port.editPedido(numeroPedido, estado);
    }

}
