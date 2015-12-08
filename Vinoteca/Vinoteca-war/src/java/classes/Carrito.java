/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.List;
import modelo.Referencia;
import modelo.Vino;


/**
 * Carrito de la compra.
 * @author coke
 */
public class Carrito {
    private ArrayList<Referencia> referencias;
    private ArrayList<Vino> vinos;
    private ArrayList<Integer> cantidades;
    
    public Carrito(){
        referencias = new ArrayList();
        vinos = new ArrayList();
        cantidades = new ArrayList();
    }
    
    /**
     * Añade un elemento al carrito
     * @param referencia
     * @param vino 
     */
    public void addItem(Referencia referencia, Vino vino) {
        boolean existe = false;
        for(int i = 0; i < referencias.size() ; i++) { //Si existe se acutaliza la cantidad de esa referencia
            if(referencias.get(i).getCodigo().equals(referencia.getCodigo())) {
                int cantidad = cantidades.get(i);
                System.out.println("ADD: " + referencia.getCodigo() +" Cantidad: "+ cantidad++);
                cantidades.set(i, cantidad++);
                existe = true;
            }
        }
        if(!existe) { //si no existe lo introduce al array
            referencias.add(referencia);
            vinos.add(vino);
            cantidades.add(1);
        }
    }
    
    /**
     * Elimina un elemento del carrito
     * @param referencia 
     */
    public void removeItem(Referencia referencia) {
        System.out.println("REMOVE: SIZE REFS " + referencias.size());

        for(int i = 0; i < referencias.size() ; i++) {
            System.out.println("REMOVE: Codigo Array: "+ referencias.get(i).getCodigo() + "Codigo Ref: " + referencia.getCodigo());
            if(referencias.get(i).getCodigo().equals(referencia.getCodigo())) {
                int cantidad = cantidades.get(i);
                if(cantidad > 1) { //Si hay más de una referencia reduce su cantidad
                    System.out.println("REMOVE: " + referencia.getCodigo() +" Cantidad: "+ cantidad--);
                    cantidades.set(i, cantidad--);
                } else { //Si sólo queda una la elimina de los arrays
                    System.out.println("REMOVE: " + referencia.getCodigo() +" Cantidad: "+ 0);
                    referencias.remove(i);
                    vinos.remove(i);
                    cantidades.remove(i);
                }
            }
        }
    }

    public List<Referencia> getReferencias() {
        return referencias;
    }

    public List<Vino> getVinos() {
        return vinos;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }
    
    /**
     * Devuelve la suma de los precios de los elementos del carrito
     * @return 
     */
    public float getImporte(){
        float precio = 0;
        for(int i = 0; i < referencias.size(); i++){
            precio = precio + referencias.get(i).getPrecio() * cantidades.get(i);
        }
        return precio;
    }
    
    
}
