/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Preferencia;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import modelo.Abonado;
import persistencia.AbonadoFacadeLocal;

/**
 *
 * @author coke
 */
@Stateless
public class controladorAbonado implements controladorAbonadoRemote {

    @EJB
    private AbonadoFacadeLocal abonadoFacade;

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
        modelo.Abonado abonado = getAbonado(login);
        //Collection<modelo.Preferencia> prefCollection = abonado.getPreferenciaList();
        List<modelo.Preferencia> prefList = new ArrayList<>();
        
        //for(modelo.Preferencia pref : prefCollection) prefList.add(pref);
        
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
