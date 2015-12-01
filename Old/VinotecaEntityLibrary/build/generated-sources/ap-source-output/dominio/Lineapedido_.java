package dominio;

import dominio.Lineacompra;
import dominio.Pedido;
import dominio.Referencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-30T23:44:09")
@StaticMetamodel(Lineapedido.class)
public class Lineapedido_ { 

    public static volatile SingularAttribute<Lineapedido, Integer> id;
    public static volatile SingularAttribute<Lineapedido, Character> completada;
    public static volatile SingularAttribute<Lineapedido, Referencia> codigoreferencia;
    public static volatile SingularAttribute<Lineapedido, Lineacompra> idlineacompra;
    public static volatile SingularAttribute<Lineapedido, Integer> unidades;
    public static volatile SingularAttribute<Lineapedido, Pedido> numeropedido;

}