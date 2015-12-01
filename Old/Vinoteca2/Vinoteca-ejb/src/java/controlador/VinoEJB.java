/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Referencia;
import dominio.Vino;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import persistencia.AbonadoFacadeLocal;
import persistencia.BodegaFacadeLocal;
import persistencia.PersonaFacadeLocal;
import persistencia.ReferenciaFacadeLocal;
import persistencia.VinoFacadeLocal;


/**
 * Session bean remota y sin estado que se encargará de la comunicación con 
 * el cliente para las operaciones sobre la tabla Vino
 * @author Lucas
 */
@Stateless
public class VinoEJB implements ControladorVinoRemote {
    @EJB
    private ReferenciaFacadeLocal referenciaFacade;
    @EJB
    private VinoFacadeLocal vinoFacade;
    @EJB
    private PersonaFacadeLocal personaFacade;
    @EJB
    private BodegaFacadeLocal bodegaFacade;
    @EJB
    private AbonadoFacadeLocal abonadoFacade;

    /**
     * Método de prueba de la comunicación entre capas
     */
    @Override
    public void test() {
        System.out.println("=======> Aquí estoy");
    }

    
    /**
     * Crea una nueva entrada en la tabla de vinos
     * @param parameter vino a añadir a la tabla de Vinos
     */
    @Override
    public void create(Vino parameter) {
        vinoFacade.create(parameter);
    }

    /**
     * Devuelve un vino por el identificador dado
     * @param id
     * @return el vino correspondiente
     */
    @Override
    public Vino retrieveVino(String id) {
        List<Vino> vinos = vinoFacade.findAll();
        for(Vino item: vinos){
            if(item.getId().equals(id)) return item;
        }
        return null;
    }

    /**
     * Devuelve la lista de vinos que tengan la categoría y el origen dados
     * @param origen
     * @param categoria
     * @return lista de vinos
     */
    @Override
    public List<Vino> getVinos(String origen, String categoria) {
        List<Vino> vinos = vinoFacade.findAll();
        List<Vino> vinosBuscados = null;
        for(Vino item: vinos){
            if(item.getIddenominacion()==Integer.parseInt(origen) &
                    item.getCategoria().equals(categoria)){
                vinosBuscados.add(item);
            }
        }
        return vinosBuscados;
    }

    /**
     * devuelve la referencia que tenga el id del vino dado
     * @param vinoID
     * @return una referencia
     */
    @Override
    public Referencia getReferencia(int vinoID) {
        List<Referencia> referencias = referenciaFacade.findAll();
        for(Referencia item: referencias){
            if(item.getVinoid().getId() == vinoID) return item;
        }
        return null;
    }

    /**
     * Añade a la base de datos una nueva referencia
     * Si se necesita crea la entrada de la tabla de vinos necesarea
     * @param referencia 
     */
    @Override
    public void addReferencia(Referencia referencia) {
        List<Vino> vinos = vinoFacade.findAll();
        boolean hayVino = false;
        for(Vino item: vinos){
            if(item.getId() == (referencia.getVinoid().getId())) hayVino=true ;
        }
        if(hayVino == false) vinoFacade.create(referencia.getVinoid());
        referenciaFacade.create(referencia);
        //crear vino, puede hacerse en cascada
    }
    

    
}