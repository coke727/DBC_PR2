/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ejb.Remote;
import modelo.Pedido;

/**
 *
 * @author coke
 */
@Remote
public interface controladorPedidoRemote {

    void newPedido(Pedido pedido);

    List<Pedido> getPedidosPendientes();

    List<Pedido> getPedidosAbonado(String nif);

    void editPedido(int numeroAbonado, String estado);
    
}
