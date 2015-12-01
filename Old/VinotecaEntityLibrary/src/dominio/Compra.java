/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author coke
 */
@Entity
@Table(name = "COMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByIdcompra", query = "SELECT c FROM Compra c WHERE c.idcompra = :idcompra"),
    @NamedQuery(name = "Compra.findByFechainiciocompra", query = "SELECT c FROM Compra c WHERE c.fechainiciocompra = :fechainiciocompra"),
    @NamedQuery(name = "Compra.findByRecibidacompleta", query = "SELECT c FROM Compra c WHERE c.recibidacompleta = :recibidacompleta"),
    @NamedQuery(name = "Compra.findByFechacompracompletada", query = "SELECT c FROM Compra c WHERE c.fechacompracompletada = :fechacompracompletada"),
    @NamedQuery(name = "Compra.findByImporte", query = "SELECT c FROM Compra c WHERE c.importe = :importe"),
    @NamedQuery(name = "Compra.findByPagada", query = "SELECT c FROM Compra c WHERE c.pagada = :pagada"),
    @NamedQuery(name = "Compra.findByFechapago", query = "SELECT c FROM Compra c WHERE c.fechapago = :fechapago")})
public class Compra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOMPRA")
    private Integer idcompra;
    @Basic(optional = false)
    @Column(name = "FECHAINICIOCOMPRA")
    @Temporal(TemporalType.DATE)
    private Date fechainiciocompra;
    @Basic(optional = false)
    @Column(name = "RECIBIDACOMPLETA")
    private Character recibidacompleta;
    @Column(name = "FECHACOMPRACOMPLETADA")
    @Temporal(TemporalType.DATE)
    private Date fechacompracompletada;
    @Basic(optional = false)
    @Column(name = "IMPORTE")
    private float importe;
    @Basic(optional = false)
    @Column(name = "PAGADA")
    private Character pagada;
    @Column(name = "FECHAPAGO")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @OneToMany(mappedBy = "idcompra")
    private Collection<Lineacompra> lineacompraCollection;

    public Compra() {
    }

    public Compra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Compra(Integer idcompra, Date fechainiciocompra, Character recibidacompleta, float importe, Character pagada) {
        this.idcompra = idcompra;
        this.fechainiciocompra = fechainiciocompra;
        this.recibidacompleta = recibidacompleta;
        this.importe = importe;
        this.pagada = pagada;
    }

    public Integer getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Integer idcompra) {
        this.idcompra = idcompra;
    }

    public Date getFechainiciocompra() {
        return fechainiciocompra;
    }

    public void setFechainiciocompra(Date fechainiciocompra) {
        this.fechainiciocompra = fechainiciocompra;
    }

    public Character getRecibidacompleta() {
        return recibidacompleta;
    }

    public void setRecibidacompleta(Character recibidacompleta) {
        this.recibidacompleta = recibidacompleta;
    }

    public Date getFechacompracompletada() {
        return fechacompracompletada;
    }

    public void setFechacompracompletada(Date fechacompracompletada) {
        this.fechacompracompletada = fechacompracompletada;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public Character getPagada() {
        return pagada;
    }

    public void setPagada(Character pagada) {
        this.pagada = pagada;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    @XmlTransient
    public Collection<Lineacompra> getLineacompraCollection() {
        return lineacompraCollection;
    }

    public void setLineacompraCollection(Collection<Lineacompra> lineacompraCollection) {
        this.lineacompraCollection = lineacompraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcompra != null ? idcompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idcompra == null && other.idcompra != null) || (this.idcompra != null && !this.idcompra.equals(other.idcompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Compra[ idcompra=" + idcompra + " ]";
    }
    
}
