/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Vino;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author coke
 */
@Stateless
public class VinoFacade extends AbstractFacade<Vino> implements VinoFacadeLocal {
    @PersistenceContext(unitName = "Vinoteca-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VinoFacade() {
        super(Vino.class);
    }
    
}
