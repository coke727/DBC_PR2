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
    private VinoFacadeLocal vinoFacade;

    @EJB
    private ReferenciaFacadeLocal referenciaFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Vino> getVinos(String origen, String categoria) {
        List<modelo.Vino> vinos = vinoFacade.findAll();
        List<modelo.Vino> vinosBuscados = new ArrayList<>();
        for(modelo.Vino item: vinos){
            if(categoria.equals(item.getCategoria()+"")){
                vinosBuscados.add(item);
            }
        }
        if(vinosBuscados.isEmpty()) vinosBuscados = null;
        return vinosBuscados;
    }

    @Override
    public List<Referencia> getReferencias(int vinoID) {
        List<Referencia> referencias = referenciaFacade.findAll();
        List<Referencia> referenciasVino = new ArrayList();
        for(Referencia item: referencias){
            if(item.getVinoid().getId() == vinoID) referenciasVino.add(item);
        }
        return referenciasVino;
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
    }

    @Override
    public Vino getVino(int vinoID) {
        return vinoFacade.find(vinoID);
    }
}
