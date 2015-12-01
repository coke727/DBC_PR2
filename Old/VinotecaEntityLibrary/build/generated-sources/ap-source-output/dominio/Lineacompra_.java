package dominio;

import dominio.Compra;
import dominio.Lineapedido;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-30T23:44:09")
@StaticMetamodel(Lineacompra.class)
public class Lineacompra_ { 

    public static volatile SingularAttribute<Lineacompra, Integer> id;
    public static volatile SingularAttribute<Lineacompra, Integer> idbodega;
    public static volatile SingularAttribute<Lineacompra, Date> fecharecepcion;
    public static volatile CollectionAttribute<Lineacompra, Lineapedido> lineapedidoCollection;
    public static volatile SingularAttribute<Lineacompra, Short> unidades;
    public static volatile SingularAttribute<Lineacompra, Character> recibida;
    public static volatile SingularAttribute<Lineacompra, Compra> idcompra;

}