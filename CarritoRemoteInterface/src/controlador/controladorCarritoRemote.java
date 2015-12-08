/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ejb.Remote;
import modelo.Referencia;
import modelo.Vino;

/**
 *
 * @author coke
 */
@Remote
public interface controladorCarritoRemote {

    void addItem(Referencia referencia, Vino vino);

    void removeItem(Referencia referencia);

    List<Referencia> getReferencias();

    List<Vino> getVinos();

    List<Integer> getCantidades();
    
}
