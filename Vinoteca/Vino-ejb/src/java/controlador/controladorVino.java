/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Referencia;
import modelo.Vino;
import persistencia.ReferenciaFacadeLocal;
import persistencia.VinoFacadeLocal;

/**
 *
 * @author coke
 */
@Stateless
public class controladorVino implements controladorVinoRemote {

    @EJB
    private ReferenciaFacadeLocal referenciaFacade;

    @EJB
    private VinoFacadeLocal vinoFacade;

    @Override
    public List<Vino> getVinos(String origen, char categoria) {
        List<modelo.Vino> vinos = vinoFacade.findAll();
        List<modelo.Vino> vinosBuscados = new ArrayList<>();
        for(modelo.Vino item: vinos){
            if(item.getIddenominacion() == Integer.parseInt(origen) && item.getCategoria() == categoria){
                vinosBuscados.add(item);
            }
        }
        if(vinosBuscados.isEmpty()) vinosBuscados = null;
        return vinosBuscados;
    }

    @Override
    public Referencia getReferencia(int vinoID) {
        List<Referencia> referencias = referenciaFacade.findAll();
        for(Referencia item: referencias){
            if(item.getVinoid().getId() == vinoID) return item;
        }
        return null;
    }

    @Override
    public void addReferencia(Referencia referencia) {
        List<modelo.Vino> vinos = vinoFacade.findAll();
        boolean hayVino = false;
        for(modelo.Vino item: vinos){
            if(Objects.equals(item.getId(), referencia.getVinoid().getId())) 
            hayVino=true ;
        }
        if(hayVino == false) vinoFacade.create(referencia.getVinoid());
        referenciaFacade.create(referencia);
        //crear vino, puede hacerse en cascada
    }

    
}
