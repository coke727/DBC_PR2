/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author coke
 */
@Entity
@Table(name = "PREFERENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preferencia.findAll", query = "SELECT p FROM Preferencia p"),
    @NamedQuery(name = "Preferencia.findById", query = "SELECT p FROM Preferencia p WHERE p.id = :id"),
    @NamedQuery(name = "Preferencia.findByDenominacion", query = "SELECT p FROM Preferencia p WHERE p.denominacion = :denominacion"),
    @NamedQuery(name = "Preferencia.findByCategoria", query = "SELECT p FROM Preferencia p WHERE p.categoria = :categoria")})
public class Preferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DENOMINACION")
    private String denominacion;
    @Basic(optional = false)
    @Column(name = "CATEGORIA")
    private Character categoria;
    @JoinColumn(name = "NIF", referencedColumnName = "NIF")
    @ManyToOne(optional = false)
    private Persona nif;
    @JoinColumn(name = "NUMEROABONADO", referencedColumnName = "NUMEROABONADO")
    @ManyToOne(optional = false)
    private Abonado numeroabonado;

    public Preferencia() {
    }

    public Preferencia(Integer id) {
        this.id = id;
    }

    public Preferencia(Integer id, String denominacion, Character categoria) {
        this.id = id;
        this.denominacion = denominacion;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public Character getCategoria() {
        return categoria;
    }

    public void setCategoria(Character categoria) {
        this.categoria = categoria;
    }

    public Persona getNif() {
        return nif;
    }

    public void setNif(Persona nif) {
        this.nif = nif;
    }

    public Abonado getNumeroabonado() {
        return numeroabonado;
    }

    public void setNumeroabonado(Abonado numeroabonado) {
        this.numeroabonado = numeroabonado;
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
        if (!(object instanceof Preferencia)) {
            return false;
        }
        Preferencia other = (Preferencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Preferencia[ id=" + id + " ]";
    }
    
}
