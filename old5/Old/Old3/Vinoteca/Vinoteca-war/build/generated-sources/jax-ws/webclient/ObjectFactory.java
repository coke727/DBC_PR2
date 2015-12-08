
package webclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the webclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPedidosAbonado_QNAME = new QName("http://webservice/", "getPedidosAbonado");
    private final static QName _NewPedido_QNAME = new QName("http://webservice/", "newPedido");
    private final static QName _GetPedidosAbonadoResponse_QNAME = new QName("http://webservice/", "getPedidosAbonadoResponse");
    private final static QName _GetPedidosPendientes_QNAME = new QName("http://webservice/", "getPedidosPendientes");
    private final static QName _Estadopedido_QNAME = new QName("http://webservice/", "estadopedido");
    private final static QName _EditPedido_QNAME = new QName("http://webservice/", "editPedido");
    private final static QName _Pedido_QNAME = new QName("http://webservice/", "pedido");
    private final static QName _GetPedidosPendientesResponse_QNAME = new QName("http://webservice/", "getPedidosPendientesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: webclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NewPedido }
     * 
     */
    public NewPedido createNewPedido() {
        return new NewPedido();
    }

    /**
     * Create an instance of {@link GetPedidosAbonadoResponse }
     * 
     */
    public GetPedidosAbonadoResponse createGetPedidosAbonadoResponse() {
        return new GetPedidosAbonadoResponse();
    }

    /**
     * Create an instance of {@link GetPedidosAbonado }
     * 
     */
    public GetPedidosAbonado createGetPedidosAbonado() {
        return new GetPedidosAbonado();
    }

    /**
     * Create an instance of {@link Estadopedido }
     * 
     */
    public Estadopedido createEstadopedido() {
        return new Estadopedido();
    }

    /**
     * Create an instance of {@link GetPedidosPendientes }
     * 
     */
    public GetPedidosPendientes createGetPedidosPendientes() {
        return new GetPedidosPendientes();
    }

    /**
     * Create an instance of {@link Pedido }
     * 
     */
    public Pedido createPedido() {
        return new Pedido();
    }

    /**
     * Create an instance of {@link EditPedido }
     * 
     */
    public EditPedido createEditPedido() {
        return new EditPedido();
    }

    /**
     * Create an instance of {@link GetPedidosPendientesResponse }
     * 
     */
    public GetPedidosPendientesResponse createGetPedidosPendientesResponse() {
        return new GetPedidosPendientesResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPedidosAbonado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getPedidosAbonado")
    public JAXBElement<GetPedidosAbonado> createGetPedidosAbonado(GetPedidosAbonado value) {
        return new JAXBElement<GetPedidosAbonado>(_GetPedidosAbonado_QNAME, GetPedidosAbonado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "newPedido")
    public JAXBElement<NewPedido> createNewPedido(NewPedido value) {
        return new JAXBElement<NewPedido>(_NewPedido_QNAME, NewPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPedidosAbonadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getPedidosAbonadoResponse")
    public JAXBElement<GetPedidosAbonadoResponse> createGetPedidosAbonadoResponse(GetPedidosAbonadoResponse value) {
        return new JAXBElement<GetPedidosAbonadoResponse>(_GetPedidosAbonadoResponse_QNAME, GetPedidosAbonadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPedidosPendientes }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getPedidosPendientes")
    public JAXBElement<GetPedidosPendientes> createGetPedidosPendientes(GetPedidosPendientes value) {
        return new JAXBElement<GetPedidosPendientes>(_GetPedidosPendientes_QNAME, GetPedidosPendientes.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Estadopedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "estadopedido")
    public JAXBElement<Estadopedido> createEstadopedido(Estadopedido value) {
        return new JAXBElement<Estadopedido>(_Estadopedido_QNAME, Estadopedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditPedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "editPedido")
    public JAXBElement<EditPedido> createEditPedido(EditPedido value) {
        return new JAXBElement<EditPedido>(_EditPedido_QNAME, EditPedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pedido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "pedido")
    public JAXBElement<Pedido> createPedido(Pedido value) {
        return new JAXBElement<Pedido>(_Pedido_QNAME, Pedido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPedidosPendientesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice/", name = "getPedidosPendientesResponse")
    public JAXBElement<GetPedidosPendientesResponse> createGetPedidosPendientesResponse(GetPedidosPendientesResponse value) {
        return new JAXBElement<GetPedidosPendientesResponse>(_GetPedidosPendientesResponse_QNAME, GetPedidosPendientesResponse.class, null, value);
    }

}
