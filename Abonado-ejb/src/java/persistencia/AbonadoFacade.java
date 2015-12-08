/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Abonado;

/**
 *
 * @author coke
 */
@Stateless
public class AbonadoFacade extends AbstractFacade<Abonado> implements AbonadoFacadeLocal {

    @PersistenceContext(unitName = "Abonado-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AbonadoFacade() {
        super(Abonado.class);
    }
    
}
