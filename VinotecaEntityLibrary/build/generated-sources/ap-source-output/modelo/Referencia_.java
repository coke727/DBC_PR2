package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Lineapedido;
import modelo.Vino;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T18:01:36")
@StaticMetamodel(Referencia.class)
public class Referencia_ { 

    public static volatile SingularAttribute<Referencia, Character> esporcajas;
    public static volatile SingularAttribute<Referencia, Integer> codigo;
    public static volatile SingularAttribute<Referencia, Float> precio;
    public static volatile SingularAttribute<Referencia, Short> contenidoencl;
    public static volatile SingularAttribute<Referencia, Vino> vinoid;
    public static volatile ListAttribute<Referencia, Lineapedido> lineapedidoList;
    public static volatile SingularAttribute<Referencia, Character> disponible;

}