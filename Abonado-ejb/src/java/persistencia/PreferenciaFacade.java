/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Preferencia;

/**
 *
 * @author coke
 */
@Stateless
public class PreferenciaFacade extends AbstractFacade<Preferencia> implements PreferenciaFacadeLocal {

    @PersistenceContext(unitName = "Abonado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PreferenciaFacade() {
        super(Preferencia.class);
    }
    
}
