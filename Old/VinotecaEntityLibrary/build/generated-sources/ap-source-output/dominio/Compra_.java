package dominio;

import dominio.Lineacompra;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-30T23:44:09")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Float> importe;
    public static volatile SingularAttribute<Compra, Date> fechacompracompletada;
    public static volatile SingularAttribute<Compra, Character> pagada;
    public static volatile SingularAttribute<Compra, Date> fechainiciocompra;
    public static volatile SingularAttribute<Compra, Date> fechapago;
    public static volatile CollectionAttribute<Compra, Lineacompra> lineacompraCollection;
    public static volatile SingularAttribute<Compra, Integer> idcompra;
    public static volatile SingularAttribute<Compra, Character> recibidacompleta;

}