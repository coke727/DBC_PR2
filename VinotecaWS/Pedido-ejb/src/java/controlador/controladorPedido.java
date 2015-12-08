/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Estadopedido;
import modelo.Pedido;
import persistencia.EstadopedidoFacadeLocal;
import persistencia.PedidoFacadeLocal;

/**
 *
 * @author coke
 */
@Stateless
public class controladorPedido implements controladorPedidoRemote {

    @EJB
    private EstadopedidoFacadeLocal estadopedidoFacade;

    @EJB
    private PedidoFacadeLocal pedidoFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public void newPedido(Pedido pedido) {
        pedidoFacade.create(pedido);
    }

    @Override
    public List<Pedido> getPedidosPendientes() {
        List<Pedido> pedidos = pedidoFacade.findAll();
        List<Pedido> pedidosPendientes = new ArrayList<>();
        for(Pedido item : pedidos){
            if(item.getEstado().getClave().equals("P")){
                pedidosPendientes.add(item);
            }
        }
        return pedidosPendientes;
    }

    @Override
    public List<Pedido> getPedidosAbonado(String nif) {
        List<Pedido> pedidos = pedidoFacade.findAll();
        List<Pedido> pedidosAbonado = new ArrayList<>();
        for(Pedido item : pedidos){
            if(item.getNif().equals(nif)){
                pedidosAbonado.add(item);
            }
        }
        return pedidosAbonado;
    }

    @Override
    public void editPedido(int numeroPedido, String estado) {
        Pedido pedido = pedidoFacade.find(numeroPedido);
        Estadopedido estadoPedido = estadopedidoFacade.find(estado);
        pedido.setEstado(estadoPedido);
        pedidoFacade.edit(pedido);
    }
}
