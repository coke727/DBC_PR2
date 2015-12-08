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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author coke
 */
@Entity
@Table(name = "LINEACOMPRA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineacompra.findAll", query = "SELECT l FROM Lineacompra l"),
    @NamedQuery(name = "Lineacompra.findById", query = "SELECT l FROM Lineacompra l WHERE l.id = :id"),
    @NamedQuery(name = "Lineacompra.findByUnidades", query = "SELECT l FROM Lineacompra l WHERE l.unidades = :unidades"),
    @NamedQuery(name = "Lineacompra.findByRecibida", query = "SELECT l FROM Lineacompra l WHERE l.recibida = :recibida"),
    @NamedQuery(name = "Lineacompra.findByFecharecepcion", query = "SELECT l FROM Lineacompra l WHERE l.fecharecepcion = :fecharecepcion"),
    @NamedQuery(name = "Lineacompra.findByIdbodega", query = "SELECT l FROM Lineacompra l WHERE l.idbodega = :idbodega")})
public class Lineacompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "UNIDADES")
    private short unidades;
    @Basic(optional = false)
    @Column(name = "RECIBIDA")
    private Character recibida;
    @Column(name = "FECHARECEPCION")
    @Temporal(TemporalType.DATE)
    private Date fecharecepcion;
    @Column(name = "IDBODEGA")
    private Integer idbodega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlineacompra")
    private Collection<Lineapedido> lineapedidoCollection;
    @JoinColumn(name = "IDCOMPRA", referencedColumnName = "IDCOMPRA")
    @ManyToOne
    private Compra idcompra;

    public Lineacompra() {
    }

    public Lineacompra(Integer id) {
        this.id = id;
    }

    public Lineacompra(Integer id, short unidades, Character recibida) {
        this.id = id;
        this.unidades = unidades;
        this.recibida = recibida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getUnidades() {
        return unidades;
    }

    public void setUnidades(short unidades) {
        this.unidades = unidades;
    }

    public Character getRecibida() {
        return recibida;
    }

    public void setRecibida(Character recibida) {
        this.recibida = recibida;
    }

    public Date getFecharecepcion() {
        return fecharecepcion;
    }

    public void setFecharecepcion(Date fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
    }

    public Integer getIdbodega() {
        return idbodega;
    }

    public void setIdbodega(Integer idbodega) {
        this.idbodega = idbodega;
    }

    @XmlTransient
    public Collection<Lineapedido> getLineapedidoCollection() {
        return lineapedidoCollection;
    }

    public void setLineapedidoCollection(Collection<Lineapedido> lineapedidoCollection) {
        this.lineapedidoCollection = lineapedidoCollection;
    }

    public Compra getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Compra idcompra) {
        this.idcompra = idcompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineacompra)) {
            return false;
        }
        Lineacompra other = (Lineacompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Lineacompra[ id=" + id + " ]";
    }
    
}
