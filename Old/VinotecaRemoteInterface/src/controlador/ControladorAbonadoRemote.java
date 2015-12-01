/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author coke
 */
@Remote
public interface ControladorAbonadoRemote {

    String getNif(String login);

    Boolean isPasswdOK(String login, String passwd);

    List<dominio.Preferencia> getPreferencias(String login);
    
    List<dominio.Preferencia> getPreferencias(dominio.Persona nif);

    Boolean isAbonado(String login);
    
}
