/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "BODEGA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b"),
    @NamedQuery(name = "Bodega.findById", query = "SELECT b FROM Bodega b WHERE b.id = :id"),
    @NamedQuery(name = "Bodega.findByNombre", query = "SELECT b FROM Bodega b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Bodega.findByCif", query = "SELECT b FROM Bodega b WHERE b.cif = :cif"),
    @NamedQuery(name = "Bodega.findByDireccion", query = "SELECT b FROM Bodega b WHERE b.direccion = :direccion")})
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "CIF")
    private String cif;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbodega")
    private List<Vino> vinoList;

    public Bodega() {
    }

    public Bodega(Integer id) {
        this.id = id;
    }

    public Bodega(Integer id, String nombre, String cif, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.cif = cif;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public List<Vino> getVinoList() {
        return vinoList;
    }

    public void setVinoList(List<Vino> vinoList) {
        this.vinoList = vinoList;
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
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Bodega[ id=" + id + " ]";
    }
    
}
