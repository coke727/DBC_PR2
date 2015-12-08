/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controlador.controladorAbonadoRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import javax.ejb.EJB;
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

    @EJB
    private controladorAbonadoRemote controladorAbonado;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/VinotecaWS-war/PedidoWS.wsdl")
    private services.PedidoWS_Service service;
    
    private String nifActual = "";

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
            out.println("<title>Consultar Pedidos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Administración de pedidos:</h1>");
            out.println("Aquí puede cambiar el estado de los pedidos.");
            out.println("<h4>Pedidos Pendientes:</h4>");
            out.println("<div>");
            out.println("<form method=\"post\" action=\"consultarPedidos\">");
            out.println("<ul>");
            //Obtenemos pedidos pendientes.
            List<services.Pedido> pendientes = getPedidosPendientes();
            if(pendientes.size()>0) {
                for(services.Pedido item : pendientes) { //Mostramos los pedidos
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
            out.println("<h4>Buscar pedidos de un usuario:</h4>");
            out.println("<form method=\"post\" action=\"consultarPedidos\"><input type=\"text\" name=\"nif\"><input name=\"usrBuscar\" value=\"Buscar\" type=\"submit\"></form>");
            out.println("<form method=\"post\" action=\"consultarPedidos\">");
            if(!nifActual.equals("")) out.println("<p>Pedidos del Abonado con NIF: "+ nifActual+"</p>");
            out.println("<ul>");
            //Obtenemos los pedidos del usuario, en caso de no existir se mostrará como que no hay pedidos.
            List<services.Pedido> pedidosUsuario = getPedidosAbonado(nifActual);
            if(pedidosUsuario.size()>0) { //si existen se muestran
                for(services.Pedido item : pedidosUsuario) {
                   out.println("<li>");
                   String estado = item.getEstado().getClave();
                   String selectorP = ""; String selectorC = ""; String selectorT = ""; String selectorF = ""; String selectorA = ""; String selectorS = "";
                   if(estado.equals("P")){selectorP = "selected";} else if(estado.equals("T")){selectorT = "selected";}else if(estado.equals("C")){selectorC = "selected";}else if(estado.equals("F")){selectorF = "selected";}else if(estado.equals("A")){selectorA = "selected";}else if(estado.equals("S")){selectorS = "selected";}
                   out.println("Pedido " + item.getNumero()
                      +" <select name=\"estado\">"
                      +"<option value=\"P,"+item.getNumero()+"\" "+selectorP+">Pendiente</option>" 
                      +"<option value=\"C,"+item.getNumero()+"\" "+selectorC+">Completado</option>" 
                      +"<option value=\"T,"+item.getNumero()+"\" "+selectorT+">Tramitado</option>"
                      +"<option value=\"F,"+item.getNumero()+"\" "+selectorF+">Facturado</option>"
                      +"<option value=\"A,"+item.getNumero()+"\" "+selectorA+">Pagado</option>"
                      +"<option value=\"S,"+item.getNumero()+"\" "+selectorS+">Servido</option>"
                      +"</select>"
                      +"</li>"); 
                }
                out.println("</ul>");
                out.println("<p><input name=\"usrCommit\" value=\"Save\" type=\"submit\"></p>");
                out.println("</form>");
            } else {
                if(nifActual.equals("")){
                    out.println("<p>Seleccione un usuario.</p>");
                } else {
                    out.println("<p>No hay pedidos de este usuario.</p>");
                }
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
        String buscar = request.getParameter("usrBuscar");
        String[] estados = request.getParameterValues("estado");
        
        if(buscar == null){ //No se esta realizando la accion de buscar
            if(estados != null) { //Hay items en la lista de pedidos
                for(String i : estados) { //Actualizamos el estado de los pedidos se hayan cambiado o no
                    List<String> tupla = Arrays.asList(i.split(","));
                    editPedido(Integer.parseInt(tupla.get(1)), tupla.get(0));
                }
            }
        } else { //Se ha pulsado el botón de buscar usuario
            //Obtenemos el nif introducido por el usuario y actualizamos la variable con el.
            String nif = request.getParameter("nif");
            if(nif != null) nifActual = nif;
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

    private java.util.List<services.Pedido> getPedidosAbonado(java.lang.String nif) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        services.PedidoWS port = service.getPedidoWSPort();
        return port.getPedidosAbonado(nif);
    }

}
