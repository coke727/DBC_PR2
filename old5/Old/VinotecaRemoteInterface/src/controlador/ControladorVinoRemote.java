/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Referencia;
import dominio.Vino;
import java.util.List;
import javax.ejb.Remote;

/**
 * Interfaz remota del controladorVino
 * @author Lucas
 */
@Remote
public interface ControladorVinoRemote {

    void test();

    void create(Vino parameter);

    Vino retrieveVino(String parameter);

    List<Vino> getVinos(String origen, String categoria);

    Referencia getReferencia(int vinoID);

    void addReferencia(Referencia referencia);
    
}
