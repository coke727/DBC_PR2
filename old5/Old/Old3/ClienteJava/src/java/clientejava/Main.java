/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientejava;

import controlador.controladorAbonadoRemote;
import controlador.controladorPedidoRemote;
import controlador.controladorVinoRemote;
import javax.ejb.EJB;

/**
 *
 * @author coke
 */
public class Main {

    @EJB
    private static controladorVinoRemote controladorVino;

    @EJB
    private static controladorPedidoRemote controladorPedido;

    @EJB
    private static controladorAbonadoRemote controladorAbonado;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
