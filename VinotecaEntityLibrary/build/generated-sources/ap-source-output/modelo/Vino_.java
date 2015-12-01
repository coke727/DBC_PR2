package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Bodega;
import modelo.Referencia;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-01T01:06:03")
@StaticMetamodel(Vino.class)
public class Vino_ { 

    public static volatile SingularAttribute<Vino, Short> ano;
    public static volatile SingularAttribute<Vino, Bodega> idbodega;
    public static volatile SingularAttribute<Vino, Character> categoria;
    public static volatile SingularAttribute<Vino, Integer> iddenominacion;
    public static volatile SingularAttribute<Vino, Integer> id;
    public static volatile SingularAttribute<Vino, String> nombrecomercial;
    public static volatile SingularAttribute<Vino, String> comentario;
    public static volatile ListAttribute<Vino, Referencia> referenciaList;

}