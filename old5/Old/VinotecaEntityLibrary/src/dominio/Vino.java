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
@Table(name = "VINO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vino.findAll", query = "SELECT v FROM Vino v"),
    @NamedQuery(name = "Vino.findById", query = "SELECT v FROM Vino v WHERE v.id = :id"),
    @NamedQuery(name = "Vino.findByNombrecomercial", query = "SELECT v FROM Vino v WHERE v.nombrecomercial = :nombrecomercial"),
    @NamedQuery(name = "Vino.findByAno", query = "SELECT v FROM Vino v WHERE v.ano = :ano"),
    @NamedQuery(name = "Vino.findByComentario", query = "SELECT v FROM Vino v WHERE v.comentario = :comentario"),
    @NamedQuery(name = "Vino.findByIddenominacion", query = "SELECT v FROM Vino v WHERE v.iddenominacion = :iddenominacion"),
    @NamedQuery(name = "Vino.findByCategoria", query = "SELECT v FROM Vino v WHERE v.categoria = :categoria")})
public class Vino implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRECOMERCIAL")
    private String nombrecomercial;
    @Basic(optional = false)
    @Column(name = "ANO")
    private short ano;
    @Basic(optional = false)
    @Column(name = "COMENTARIO")
    private String comentario;
    @Basic(optional = false)
    @Column(name = "IDDENOMINACION")
    private int iddenominacion;
    @Basic(optional = false)
    @Column(name = "CATEGORIA")
    private Character categoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vinoid")
    private Collection<Referencia> referenciaCollection;
    @JoinColumn(name = "IDBODEGA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Bodega idbodega;

    public Vino() {
    }

    public Vino(Integer id) {
        this.id = id;
    }

    public Vino(Integer id, String nombrecomercial, short ano, String comentario, int iddenominacion, Character categoria) {
        this.id = id;
        this.nombrecomercial = nombrecomercial;
        this.ano = ano;
        this.comentario = comentario;
        this.iddenominacion = iddenominacion;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrecomercial() {
        return nombrecomercial;
    }

    public void setNombrecomercial(String nombrecomercial) {
        this.nombrecomercial = nombrecomercial;
    }

    public short getAno() {
        return ano;
    }

    public void setAno(short ano) {
        this.ano = ano;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIddenominacion() {
        return iddenominacion;
    }

    public void setIddenominacion(int iddenominacion) {
        this.iddenominacion = iddenominacion;
    }

    public Character getCategoria() {
        return categoria;
    }

    public void setCategoria(Character categoria) {
        this.categoria = categoria;
    }

    @XmlTransient
    public Collection<Referencia> getReferenciaCollection() {
        return referenciaCollection;
    }

    public void setReferenciaCollection(Collection<Referencia> referenciaCollection) {
        this.referenciaCollection = referenciaCollection;
    }

    public Bodega getIdbodega() {
        return idbodega;
    }

    public void setIdbodega(Bodega idbodega) {
        this.idbodega = idbodega;
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
        if (!(object instanceof Vino)) {
            return false;
        }
        Vino other = (Vino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Vino[ id=" + id + " ]";
    }
    
}
