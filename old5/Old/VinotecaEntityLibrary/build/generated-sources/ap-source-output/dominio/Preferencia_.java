package dominio;

import dominio.Abonado;
import dominio.Persona;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-30T23:44:09")
@StaticMetamodel(Preferencia.class)
public class Preferencia_ { 

    public static volatile SingularAttribute<Preferencia, Integer> id;
    public static volatile SingularAttribute<Preferencia, Character> categoria;
    public static volatile SingularAttribute<Preferencia, String> denominacion;
    public static volatile SingularAttribute<Preferencia, Persona> nif;
    public static volatile SingularAttribute<Preferencia, Abonado> numeroabonado;

}