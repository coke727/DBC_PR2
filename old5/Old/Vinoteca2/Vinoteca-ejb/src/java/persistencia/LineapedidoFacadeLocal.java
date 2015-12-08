/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Lineapedido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author coke
 */
@Local
public interface LineapedidoFacadeLocal {

    void create(Lineapedido lineapedido);

    void edit(Lineapedido lineapedido);

    void remove(Lineapedido lineapedido);

    Lineapedido find(Object id);

    List<Lineapedido> findAll();

    List<Lineapedido> findRange(int[] range);

    int count();
    
}
