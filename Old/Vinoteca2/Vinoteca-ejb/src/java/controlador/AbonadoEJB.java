/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dominio.Preferencia;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import persistencia.AbonadoFacadeLocal;
import persistencia.PersonaFacadeLocal;
import persistencia.PreferenciaFacadeLocal;

/**
 *
 * @author coke
 */
@Stateless
public class AbonadoEJB implements ControladorAbonadoRemote {
    
    @EJB
    private AbonadoFacadeLocal abonadoFacade;
    @EJB
    private PreferenciaFacadeLocal preferenciaFacade;
    @EJB
    private PersonaFacadeLocal personaFacade;

    @Override
    public String getNif(String login) {
        dominio.Abonado abonado = getAbonado(login);
        if(abonado != null) return abonado.getNif().getNif();
        return null;
    }

    @Override
    public Boolean isPasswdOK(String login, String passwd) {
        dominio.Abonado abonado = getAbonado(login);
        return abonado != null && abonado.getPassword().equals(passwd);
    }

    @Override 
    public List<dominio.Preferencia> getPreferencias(String login) {
        dominio.Abonado abonado = getAbonado(login);
        Collection<Preferencia> collection = abonado.getPreferenciaCollection();
        List<Preferencia> preferencias = new ArrayList<>();
        for(Preferencia pref : collection){
            preferencias.add(pref);
        }
        return preferencias;
    }
    
    @Override //TODO nuestro abonado no tiene preferencias
    public List<dominio.Preferencia> getPreferencias(dominio.Persona nif) {
        dominio.Abonado abonado = getAbonado(nif);
        Collection<Preferencia> collection = abonado.getPreferenciaCollection();
        List<Preferencia> preferencias = new ArrayList<>();
        for(Preferencia pref : collection){
            preferencias.add(pref);
        }
        return preferencias;
    }

    @Override
    public Boolean isAbonado(String login) {
        return getAbonado(login) != null;
    }
    
    private dominio.Abonado getAbonado(String login){
        List<dominio.Abonado> abonados = abonadoFacade.findAll();
        for(dominio.Abonado item : abonados) {
            if(item.getLogin().equals(login)) return item;
        }
        return null;
    }
    
    private dominio.Abonado getAbonado(dominio.Persona persona){
        List<dominio.Abonado> abonados = abonadoFacade.findAll();
        for(dominio.Abonado item : abonados) {
            if(item.getNif().equals(persona)) {
                return item;
            }
        }
        return null;
    }
    
    
}
