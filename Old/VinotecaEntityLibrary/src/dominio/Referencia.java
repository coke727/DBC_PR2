/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author coke
 */
@Entity
@Table(name = "REFERENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referencia.findAll", query = "SELECT r FROM Referencia r"),
    @NamedQuery(name = "Referencia.findByCodigo", query = "SELECT r FROM Referencia r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Referencia.findByEsporcajas", query = "SELECT r FROM Referencia r WHERE r.esporcajas = :esporcajas"),
    @NamedQuery(name = "Referencia.findByContenidoencl", query = "SELECT r FROM Referencia r WHERE r.contenidoencl = :contenidoencl"),
    @NamedQuery(name = "Referencia.findByPrecio", query = "SELECT r FROM Referencia r WHERE r.precio = :precio"),
    @NamedQuery(name = "Referencia.findByDisponible", query = "SELECT r FROM Referencia r WHERE r.disponible = :disponible")})
public class Referencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Basic(optional = false)
    @Column(name = "ESPORCAJAS")
    private Character esporcajas;
    @Basic(optional = false)
    @Column(name = "CONTENIDOENCL")
    private short contenidoencl;
    @Basic(optional = false)
    @Column(name = "PRECIO")
    private float precio;
    @Basic(optional = false)
    @Column(name = "DISPONIBLE")
    private Character disponible;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoreferencia")
    private Collection<Lineapedido> lineapedidoCollection;
    @JoinColumn(name = "VINOID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Vino vinoid;

    public Referencia() {
    }

    public Referencia(Integer codigo) {
        this.codigo = codigo;
    }

    public Referencia(Integer codigo, Character esporcajas, short contenidoencl, float precio, Character disponible) {
        this.codigo = codigo;
        this.esporcajas = esporcajas;
        this.contenidoencl = contenidoencl;
        this.precio = precio;
        this.disponible = disponible;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Character getEsporcajas() {
        return esporcajas;
    }

    public void setEsporcajas(Character esporcajas) {
        this.esporcajas = esporcajas;
    }

    public short getContenidoencl() {
        return contenidoencl;
    }

    public void setContenidoencl(short contenidoencl) {
        this.contenidoencl = contenidoencl;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Character getDisponible() {
        return disponible;
    }

    public void setDisponible(Character disponible) {
        this.disponible = disponible;
    }

    @XmlTransient
    public Collection<Lineapedido> getLineapedidoCollection() {
        return lineapedidoCollection;
    }

    public void setLineapedidoCollection(Collection<Lineapedido> lineapedidoCollection) {
        this.lineapedidoCollection = lineapedidoCollection;
    }

    public Vino getVinoid() {
        return vinoid;
    }

    public void setVinoid(Vino vinoid) {
        this.vinoid = vinoid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referencia)) {
            return false;
        }
        Referencia other = (Referencia) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Referencia[ codigo=" + codigo + " ]";
    }
    
}
