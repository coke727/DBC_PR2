package dominio;

import dominio.Estadofactura;
import dominio.Pedido;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-30T23:44:09")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Float> importe;
    public static volatile SingularAttribute<Factura, String> idextractobancario;
    public static volatile SingularAttribute<Factura, Estadofactura> estado;
    public static volatile SingularAttribute<Factura, Integer> numerofactura;
    public static volatile SingularAttribute<Factura, Date> fechaemision;
    public static volatile SingularAttribute<Factura, Date> fechapago;
    public static volatile CollectionAttribute<Factura, Pedido> pedidoCollection;

}