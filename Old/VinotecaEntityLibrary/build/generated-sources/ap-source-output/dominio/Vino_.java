package dominio;

import dominio.Bodega;
import dominio.Referencia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-30T23:44:09")
@StaticMetamodel(Vino.class)
public class Vino_ { 

    public static volatile SingularAttribute<Vino, Integer> id;
    public static volatile SingularAttribute<Vino, Character> categoria;
    public static volatile SingularAttribute<Vino, Bodega> idbodega;
    public static volatile SingularAttribute<Vino, String> nombrecomercial;
    public static volatile SingularAttribute<Vino, Short> ano;
    public static volatile SingularAttribute<Vino, Integer> iddenominacion;
    public static volatile CollectionAttribute<Vino, Referencia> referenciaCollection;
    public static volatile SingularAttribute<Vino, String> comentario;

}