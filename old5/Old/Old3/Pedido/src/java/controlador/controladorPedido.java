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
    private PedidoFacadeLocal pedidoFacade;

    @EJB
    private EstadopedidoFacadeLocal estadopedidoFacade;

    @Override
    public void newPedido(Pedido pedido) {
        pedidoFacade.create(pedido);
    }

    @Override
    public List<Pedido> getPedidosPendientes() {
        Estadopedido pendientes = estadopedidoFacade.find("P");
        return pendientes.getPedidoList();
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
    public void editPedido(int numeroAbonado, String estado) {
        /*Pedido pedido = pedidoFacade.find(numeroPedido);
        Estadopedido estadoPedido = estadopedidoFacade.find("Estado");
        pedido.setEstado(estadoPedido);
        pedidoFacade.edit(pedido);*/
    }

    
}
