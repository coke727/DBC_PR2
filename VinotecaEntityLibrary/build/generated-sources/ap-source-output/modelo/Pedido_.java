package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Estadopedido;
import modelo.Lineapedido;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-12-08T22:19:06")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Date> fechaentrega;
    public static volatile SingularAttribute<Pedido, Integer> numerofactura;
    public static volatile SingularAttribute<Pedido, Estadopedido> estado;
    public static volatile SingularAttribute<Pedido, Integer> numero;
    public static volatile SingularAttribute<Pedido, Date> fecharealizacion;
    public static volatile SingularAttribute<Pedido, String> notaentrega;
    public static volatile SingularAttribute<Pedido, Date> fecharecepcion;
    public static volatile SingularAttribute<Pedido, String> nif;
    public static volatile SingularAttribute<Pedido, Integer> abonado;
    public static volatile SingularAttribute<Pedido, Float> importe;
    public static volatile ListAttribute<Pedido, Lineapedido> lineapedidoList;

}