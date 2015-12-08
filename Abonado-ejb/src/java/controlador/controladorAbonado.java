/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Abonado;
import modelo.Preferencia;
import persistencia.AbonadoFacadeLocal;
import persistencia.PreferenciaFacadeLocal;

/**
 *
 * @author coke
 */
@Stateless
public class controladorAbonado implements controladorAbonadoRemote {

    @EJB
    private PreferenciaFacadeLocal preferenciaFacade;

    @EJB
    private AbonadoFacadeLocal abonadoFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String getNif(String login) {
        modelo.Abonado abonado = getAbonado(login);
        
        if(abonado != null) return abonado.getNif().getNif();
        return null;
    }

    @Override
    public boolean isPasswdOK(String login, String passwd) {
        modelo.Abonado abonado = getAbonado(login);
        return abonado != null && abonado.getPassword().equals(passwd);
    }

    @Override
    public List<Preferencia> getPreferencias(String login) {
        Abonado abonado = getAbonado(login);
        List<Preferencia> preferencias = preferenciaFacade.findAll();
        List<Preferencia> prefList = new ArrayList<>();
        
        for(Preferencia pref : preferencias) {
            if(pref.getNumeroabonado() == abonado.getNumeroabonado()) prefList.add(pref);
        }
        
        return prefList;
    }

    @Override
    public boolean isAbonado(String login) {
        return getAbonado(login) != null;
    }

    @Override
    public Abonado getAbonado(String login) {
        List<modelo.Abonado> abonados = abonadoFacade.findAll();
        for(modelo.Abonado item : abonados) {
            if(item.getLogin().equals(login)) return item;
        }
        return null;
    }
}
