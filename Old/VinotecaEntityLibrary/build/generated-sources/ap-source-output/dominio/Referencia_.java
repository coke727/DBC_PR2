package dominio;

import dominio.Lineapedido;
import dominio.Vino;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-30T23:44:09")
@StaticMetamodel(Referencia.class)
public class Referencia_ { 

    public static volatile SingularAttribute<Referencia, Integer> codigo;
    public static volatile CollectionAttribute<Referencia, Lineapedido> lineapedidoCollection;
    public static volatile SingularAttribute<Referencia, Float> precio;
    public static volatile SingularAttribute<Referencia, Character> esporcajas;
    public static volatile SingularAttribute<Referencia, Vino> vinoid;
    public static volatile SingularAttribute<Referencia, Short> contenidoencl;
    public static volatile SingularAttribute<Referencia, Character> disponible;

}