/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jalinet.facturaj.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alberto
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByCLClienteID", query = "SELECT c FROM Clientes c WHERE c.cLClienteID = :cLClienteID")
    , @NamedQuery(name = "Clientes.findByCLNombre", query = "SELECT c FROM Clientes c WHERE c.cLNombre = :cLNombre")
    , @NamedQuery(name = "Clientes.findByCLEmail", query = "SELECT c FROM Clientes c WHERE c.cLEmail = :cLEmail")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CL_ClienteID")
    private Long cLClienteID;
    @Size(max = 45)
    @Column(name = "CL_Nombre")
    private String cLNombre;
    @Size(max = 45)
    @Column(name = "CL_Email")
    private String cLEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cLIENTESCLClienteID")
    private Collection<Factura> facturaCollection;

    public Clientes() {
    }

    public Clientes(Long cLClienteID) {
        this.cLClienteID = cLClienteID;
    }

    public Long getCLClienteID() {
        return cLClienteID;
    }

    public void setCLClienteID(Long cLClienteID) {
        this.cLClienteID = cLClienteID;
    }

    public String getCLNombre() {
        return cLNombre;
    }

    public void setCLNombre(String cLNombre) {
        this.cLNombre = cLNombre;
    }

    public String getCLEmail() {
        return cLEmail;
    }

    public void setCLEmail(String cLEmail) {
        this.cLEmail = cLEmail;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cLClienteID != null ? cLClienteID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.cLClienteID == null && other.cLClienteID != null) || (this.cLClienteID != null && !this.cLClienteID.equals(other.cLClienteID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  cLNombre + "-"+ cLEmail;
    }
    
}
