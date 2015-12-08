package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Pedido;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-07T01:38:53")
@StaticMetamodel(Estadopedido.class)
public class Estadopedido_ { 

    public static volatile SingularAttribute<Estadopedido, String> clave;
    public static volatile ListAttribute<Estadopedido, Pedido> pedidoList;
    public static volatile SingularAttribute<Estadopedido, String> nombre;

}