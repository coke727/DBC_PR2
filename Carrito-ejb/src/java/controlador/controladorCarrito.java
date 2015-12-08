/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;
import modelo.Referencia;
import modelo.Vino;

/**
 *
 * @author coke
 */
@Stateful
public class controladorCarrito implements controladorCarritoRemote {
    private ArrayList<Referencia> referencias;
    private ArrayList<Vino> vinos;
    private ArrayList<Integer> cantidades;
    
    @Override
    public void addItem(Referencia referencia, Vino vino) {
        boolean existe = false;
        for(int i = 0; i < referencias.size() ; i++) {
            if(referencias.get(i).getCodigo() == referencia.getCodigo()) {
                int cantidad = cantidades.get(i);
                cantidades.set(i, cantidad++);
                existe = true;
            }
        }
        if(!existe) {
            referencias.add(referencia);
            vinos.add(vino);
            cantidades.add(1);
        }
    }

    @Override
    public void removeItem(Referencia referencia) {
        for(int i = 0; i < referencias.size() ; i++) {
            if(referencias.get(i).getCodigo() == referencia.getCodigo()) {
                int cantidad = cantidades.get(i);
                if(cantidad > 1) {cantidades.set(i, cantidad--);}
                else {
                    referencias.remove(i);
                    vinos.remove(i);
                    cantidades.remove(i);
                }
            }
        }
    }

    @Override
    public List<Referencia> getReferencias() {
        return referencias;
    }

    @Override
    public List<Vino> getVinos() {
        return vinos;
    }

    @Override
    public List<Integer> getCantidades() {
        return cantidades;
    }
    
    

    
}
