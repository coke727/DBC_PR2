
package webclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para pedido complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="pedido">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="abonado" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://webservice/}estadopedido" minOccurs="0"/>
 *         &lt;element name="fechaentrega" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecharealizacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fecharecepcion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="importe" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="nif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notaentrega" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="numerofactura" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pedido", propOrder = {
    "abonado",
    "estado",
    "fechaentrega",
    "fecharealizacion",
    "fecharecepcion",
    "importe",
    "nif",
    "notaentrega",
    "numero",
    "numerofactura"
})
public class Pedido {

    protected Integer abonado;
    protected Estadopedido estado;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaentrega;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecharealizacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fecharecepcion;
    protected float importe;
    protected String nif;
    protected String notaentrega;
    protected Integer numero;
    protected Integer numerofactura;

    /**
     * Obtiene el valor de la propiedad abonado.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAbonado() {
        return abonado;
    }

    /**
     * Define el valor de la propiedad abonado.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAbonado(Integer value) {
        this.abonado = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link Estadopedido }
     *     
     */
    public Estadopedido getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link Estadopedido }
     *     
     */
    public void setEstado(Estadopedido value) {
        this.estado = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaentrega.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaentrega() {
        return fechaentrega;
    }

    /**
     * Define el valor de la propiedad fechaentrega.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaentrega(XMLGregorianCalendar value) {
        this.fechaentrega = value;
    }

    /**
     * Obtiene el valor de la propiedad fecharealizacion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecharealizacion() {
        return fecharealizacion;
    }

    /**
     * Define el valor de la propiedad fecharealizacion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecharealizacion(XMLGregorianCalendar value) {
        this.fecharealizacion = value;
    }

    /**
     * Obtiene el valor de la propiedad fecharecepcion.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFecharecepcion() {
        return fecharecepcion;
    }

    /**
     * Define el valor de la propiedad fecharecepcion.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFecharecepcion(XMLGregorianCalendar value) {
        this.fecharecepcion = value;
    }

    /**
     * Obtiene el valor de la propiedad importe.
     * 
     */
    public float getImporte() {
        return importe;
    }

    /**
     * Define el valor de la propiedad importe.
     * 
     */
    public void setImporte(float value) {
        this.importe = value;
    }

    /**
     * Obtiene el valor de la propiedad nif.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNif() {
        return nif;
    }

    /**
     * Define el valor de la propiedad nif.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNif(String value) {
        this.nif = value;
    }

    /**
     * Obtiene el valor de la propiedad notaentrega.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotaentrega() {
        return notaentrega;
    }

    /**
     * Define el valor de la propiedad notaentrega.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotaentrega(String value) {
        this.notaentrega = value;
    }

    /**
     * Obtiene el valor de la propiedad numero.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Define el valor de la propiedad numero.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumero(Integer value) {
        this.numero = value;
    }

    /**
     * Obtiene el valor de la propiedad numerofactura.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumerofactura() {
        return numerofactura;
    }

    /**
     * Define el valor de la propiedad numerofactura.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumerofactura(Integer value) {
        this.numerofactura = value;
    }

}
