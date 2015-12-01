package dominio;

import dominio.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-30T23:44:09")
@StaticMetamodel(Estadopedido.class)
public class Estadopedido_ { 

    public static volatile SingularAttribute<Estadopedido, String> nombre;
    public static volatile SingularAttribute<Estadopedido, String> clave;
    public static volatile CollectionAttribute<Estadopedido, Pedido> pedidoCollection;

}