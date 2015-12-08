/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Lineacompra;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author coke
 */
@Local
public interface LineacompraFacadeLocal {

    void create(Lineacompra lineacompra);

    void edit(Lineacompra lineacompra);

    void remove(Lineacompra lineacompra);

    Lineacompra find(Object id);

    List<Lineacompra> findAll();

    List<Lineacompra> findRange(int[] range);

    int count();
    
}
