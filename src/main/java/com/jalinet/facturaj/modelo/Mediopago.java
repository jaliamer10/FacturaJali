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
@Table(name = "mediopago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mediopago.findAll", query = "SELECT m FROM Mediopago m")
    , @NamedQuery(name = "Mediopago.findByMPMedioPagoID", query = "SELECT m FROM Mediopago m WHERE m.mPMedioPagoID = :mPMedioPagoID")
    , @NamedQuery(name = "Mediopago.findByMPDescripcion", query = "SELECT m FROM Mediopago m WHERE m.mPDescripcion = :mPDescripcion")})
public class Mediopago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MP_MedioPagoID")
    private Long mPMedioPagoID;
    @Size(max = 45)
    @Column(name = "MP_Descripcion")
    private String mPDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mEDIOPAGOMPMedioPagoID")
    private Collection<Factura> facturaCollection;

    public Mediopago() {
    }

    public Mediopago(Long mPMedioPagoID) {
        this.mPMedioPagoID = mPMedioPagoID;
    }

    public Long getMPMedioPagoID() {
        return mPMedioPagoID;
    }

    public void setMPMedioPagoID(Long mPMedioPagoID) {
        this.mPMedioPagoID = mPMedioPagoID;
    }

    public String getMPDescripcion() {
        return mPDescripcion;
    }

    public void setMPDescripcion(String mPDescripcion) {
        this.mPDescripcion = mPDescripcion;
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
        hash += (mPMedioPagoID != null ? mPMedioPagoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mediopago)) {
            return false;
        }
        Mediopago other = (Mediopago) object;
        if ((this.mPMedioPagoID == null && other.mPMedioPagoID != null) || (this.mPMedioPagoID != null && !this.mPMedioPagoID.equals(other.mPMedioPagoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  mPMedioPagoID + "-"+ mPDescripcion;
    }
    
}
