package dominio;

import dominio.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-30T23:44:09")
@StaticMetamodel(Estadofactura.class)
public class Estadofactura_ { 

    public static volatile SingularAttribute<Estadofactura, String> nombre;
    public static volatile CollectionAttribute<Estadofactura, Factura> facturaCollection;
    public static volatile SingularAttribute<Estadofactura, String> clave;

}