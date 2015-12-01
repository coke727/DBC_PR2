/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import controlador.controladorPedidoRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import modelo.Pedido;

/**
 *
 * @author coke
 */
@WebService(serviceName = "VinotecaWebService")
public class VinotecaWebService {

    @EJB
    private controladorPedidoRemote ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "newPedido")
    @Oneway
    public void newPedido(@WebParam(name = "pedido") Pedido pedido) {
        ejbRef.newPedido(pedido);
    }

    @WebMethod(operationName = "getPedidosPendientes")
    public List<Pedido> getPedidosPendientes() {
        return ejbRef.getPedidosPendientes();
    }

    @WebMethod(operationName = "getPedidosAbonado")
    public List<Pedido> getPedidosAbonado(@WebParam(name = "nif") String nif) {
        return ejbRef.getPedidosAbonado(nif);
    }

    @WebMethod(operationName = "editPedido")
    @Oneway
    public void editPedido(@WebParam(name = "numeroAbonado") int numeroAbonado, @WebParam(name = "estado") String estado) {
        ejbRef.editPedido(numeroAbonado, estado);
    }
    
}
