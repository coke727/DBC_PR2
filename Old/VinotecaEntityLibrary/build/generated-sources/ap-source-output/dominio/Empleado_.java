package dominio;

import dominio.Persona;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-30T23:44:09")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, Character> tipoempleado;
    public static volatile SingularAttribute<Empleado, Persona> nif;
    public static volatile SingularAttribute<Empleado, String> login;
    public static volatile SingularAttribute<Empleado, String> password;
    public static volatile SingularAttribute<Empleado, Date> fechainicio;

}