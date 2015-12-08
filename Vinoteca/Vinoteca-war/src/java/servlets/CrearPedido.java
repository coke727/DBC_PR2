/* ABONADOSELECCION
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes.Carrito;
import controlador.controladorAbonadoRemote;
import controlador.controladorVinoRemote;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import modelo.Abonado;
import modelo.Preferencia;
import modelo.Referencia;
import modelo.Vino;
import services.Pedido;
import services.PedidoWS_Service;

/**
 *
 * @author coke
 */
public class CrearPedido extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/VinotecaWS-war/PedidoWS.wsdl")
    private PedidoWS_Service service;

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
            HttpSession session = request.getSession();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Crear Pedido</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Creación de un pedido:</h1>");
            out.println("<h3>Añada las preferencias que desee pedir.</h3>");
            out.println("<div>");
            //Obtenemos el login con el que se logeo el usuario en la página de login
            String login = (String) session.getAttribute("user");
            //Obtenemos las preferencias del abonado
            List<Preferencia> preferencias = controladorAbonado.getPreferencias(login);
            List<Vino> vinos = new ArrayList();
            for(Preferencia item : preferencias) { 
                //Obtenemos los vinos que corresponden a las preferencias del abonado
                List<Vino> vinosTmp = controladorVino.getVinos(item.getIddenominacion()+"", ""+item.getCategoria());
                if(vinosTmp != null) {
                    vinos.addAll(vinosTmp);
                    out.println("<h3>Denominacion: "+item.getDenominacion()+" Categoria: "+ item.getCategoria()+"</h3>");
                    out.println("<ul>");
                    for(Vino itemVino : vinos) { //Obtenemos las referencias de ese vino y las mostramos
                        List<Referencia> referencias = controladorVino.getReferencias(itemVino.getId());
                        for(Referencia ref : referencias) {
                            out.println("<li><form method='post' action='CrearPedido'>");
                            out.println(" <b>Nombre:</b> " + itemVino.getNombrecomercial()
                                        + " <b>Contenido (Cl):</b> " + ref.getContenidoencl()
                                        + " <b>Precio:</b> "+ ref.getPrecio()
                                        +" <input type=\"hidden\" name=\"referencia\" value='"+itemVino.getId()+","+ref.getCodigo()+"'/>"
                                        + "<input name=\"add\" value=\"+\" type=\"submit\">");
                            out.println("</form></li>");
                        }
                    }
                    out.println("</ul>");
                    vinos = new ArrayList();
                }
                
            }
            out.println("</div>");
            out.println("<div><h1>Carrito:</h1></div>");
            //Obtenemos el carrito y los datos que almacena.
            Carrito carrito = (Carrito) session.getAttribute("carrito");
            List<Vino> vinosCarrito = carrito.getVinos();
            List<Referencia> referenciasCarrito = carrito.getReferencias();
            List<Integer> cantidadesCarrito = carrito.getCantidades();
            
            out.println("<div>");
            if(referenciasCarrito.size() > 0) {
                out.println("<ul>");
                for(int i = 0 ; i < referenciasCarrito.size() ; i++) { //Mostramos las referencias del carrito
                    out.println("<li><form method='post' action='CrearPedido'>");
                    out.println(" <b>Nombre:</b> "+ vinosCarrito.get(i).getNombrecomercial()
                               +" <b>Precio:</b> "+ referenciasCarrito.get(i).getPrecio()
                               +" <b>Cantidad:</b> "+ cantidadesCarrito.get(i)
                               +" <input type=\"hidden\" name=\"referencia\" value='"+vinosCarrito.get(i).getId()+","+referenciasCarrito.get(i).getCodigo()+"'/>"
                               + "<input name=\"add\" value=\"-\" type=\"submit\">");
                    out.println("</form></li>");
                }
                out.println("<h3> Precio Total: " + carrito.getImporte() + "</h3>");
                out.println("</ul>");
                out.println("<form method='post' action='CrearPedido'><input name=\"create\" value=\"Crear Pedido\" type=\"submit\"></form>");
            } else {
                out.println("<p>En estos momentos el carrito no tiene elementos.</p>");
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
        
        HttpSession session = request.getSession();
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if(carrito == null) carrito = new Carrito();
        
        String crearPedido = request.getParameter("create");
        System.out.println("---- CREAR ---" + crearPedido);
        if(crearPedido != null) { //Se ha pulsado el boton de crear pedido.
            //Creamos el pedido.
            String login = (String) session.getAttribute("user");
            Abonado abonado = controladorAbonado.getAbonado(login);
            Pedido pedido = new Pedido();
            pedido.setAbonado(abonado.getNumeroabonado());
            int numeroPedido = (int) (Math.random() * 1000000); //Id aleatoreo
            pedido.setNumero(numeroPedido);
            pedido.setNif(abonado.getNif().getNif());
            pedido.setImporte(carrito.getImporte());
            newPedido(pedido);
            editPedido(numeroPedido, "P");
            //Pasamos a la página de pedido realizado correctamente.
            RequestDispatcher rd = request.getRequestDispatcher("PedidoHecho");
            rd.forward(request,response);
        } else { // Se ha añadido o eliminado una referencia del carrito.
            String addition = request.getParameter("add");
            System.out.println("FORMULARIO " + addition);
            String formValue = request.getParameter("referencia");
            if(formValue != null && addition != null) {
                if(addition.equals("+")) { //Añadimos referencia
                    //El valor del formulario se compone de el id del vino y del id de la referencia separados por una coma.
                    List<String> tupla = Arrays.asList(formValue.split(","));
                    //Obtenemos el vino y las referencias que corresponden a ese vino.
                    Vino vino = controladorVino.getVino(Integer.parseInt(tupla.get(0)));
                    List<Referencia> refs = controladorVino.getReferencias(Integer.parseInt(tupla.get(0)));

                    for(Referencia item : refs) { //Obtenemos la referencias concreta que se ha seleccionado y la añadimos
                        if(item.getCodigo().equals(Integer.parseInt(tupla.get(1)))) {
                            carrito.addItem(item, vino);
                        }
                    }
                } else if(addition.equals("-")) { //Eliminamos referencia
                    List<String> tupla = Arrays.asList(formValue.split(","));
                    List<Referencia> refs = controladorVino.getReferencias(Integer.parseInt(tupla.get(0)));

                    for(Referencia item : refs) { //Obtenemos la referencias concreta que se ha seleccionado y la eliminamos
                        if(item.getCodigo().equals(Integer.parseInt(tupla.get(1)))) {
                            carrito.removeItem(item);
                        }
                    }  
                }
            }
        }
        session.setAttribute("carrito", carrito);
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
    
    private void newPedido(services.Pedido pedido) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        services.PedidoWS port = service.getPedidoWSPort();
        port.newPedido(pedido);
    }

    private void editPedido(int numeroPedido, java.lang.String estado) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        services.PedidoWS port = service.getPedidoWSPort();
        port.editPedido(numeroPedido, estado);
    }
}
