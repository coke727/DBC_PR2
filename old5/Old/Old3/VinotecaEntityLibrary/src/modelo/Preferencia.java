/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @NamedQuery(name = "Preferencia.findByCategoria", query = "SELECT p FROM Preferencia p WHERE p.categoria = :categoria"),
    @NamedQuery(name = "Preferencia.findByNif", query = "SELECT p FROM Preferencia p WHERE p.nif = :nif"),
    @NamedQuery(name = "Preferencia.findByNumeroabonado", query = "SELECT p FROM Preferencia p WHERE p.numeroabonado = :numeroabonado")})
public class Preferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DENOMINACION")
    private String denominacion;
    @Basic(optional = false)
    @Column(name = "CATEGORIA")
    private Character categoria;
    @Basic(optional = false)
    @Column(name = "NIF")
    private String nif;
    @Basic(optional = false)
    @Column(name = "NUMEROABONADO")
    private int numeroabonado;

    public Preferencia() {
    }

    public Preferencia(Integer id) {
        this.id = id;
    }

    public Preferencia(Integer id, String denominacion, Character categoria, String nif, int numeroabonado) {
        this.id = id;
        this.denominacion = denominacion;
        this.categoria = categoria;
        this.nif = nif;
        this.numeroabonado = numeroabonado;
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public int getNumeroabonado() {
        return numeroabonado;
    }

    public void setNumeroabonado(int numeroabonado) {
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
