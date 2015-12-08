/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ejb.Remote;
import modelo.Abonado;
import modelo.Preferencia;

/**
 *
 * @author coke
 */
@Remote
public interface controladorAbonadoRemote {

    String getNif(String login);

    boolean isPasswdOK(String login, String passwd);

    List<Preferencia> getPreferencias(String login);

    boolean isAbonado(String login);

    Abonado getAbonado(String login);
    
}
