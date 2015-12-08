package dominio;

import dominio.Abonado;
import dominio.Estadopedido;
import dominio.Factura;
import dominio.Lineapedido;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-30T23:44:09")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Float> importe;
    public static volatile SingularAttribute<Pedido, Date> fecharecepcion;
    public static volatile SingularAttribute<Pedido, Date> fechaentrega;
    public static volatile SingularAttribute<Pedido, Estadopedido> estado;
    public static volatile CollectionAttribute<Pedido, Lineapedido> lineapedidoCollection;
    public static volatile SingularAttribute<Pedido, Factura> numerofactura;
    public static volatile SingularAttribute<Pedido, String> notaentrega;
    public static volatile SingularAttribute<Pedido, Abonado> abonado;
    public static volatile SingularAttribute<Pedido, Date> fecharealizacion;
    public static volatile SingularAttribute<Pedido, Integer> numero;

}