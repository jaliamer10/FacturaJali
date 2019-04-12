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
@Table(name = "mesas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mesas.findAll", query = "SELECT m FROM Mesas m")
    , @NamedQuery(name = "Mesas.findByMSMesaID", query = "SELECT m FROM Mesas m WHERE m.mSMesaID = :mSMesaID")
    , @NamedQuery(name = "Mesas.findByMSUbicacion", query = "SELECT m FROM Mesas m WHERE m.mSUbicacion = :mSUbicacion")})
public class Mesas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MS_MesaID")
    private Long mSMesaID;
    @Size(max = 45)
    @Column(name = "MS_Ubicacion")
    private String mSUbicacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mESASMSMesaID")
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mESASMSMesaID")
    private Collection<Pedidos> pedidosCollection;

    public Mesas() {
    }

    public Mesas(Long mSMesaID) {
        this.mSMesaID = mSMesaID;
    }

    public Long getMSMesaID() {
        return mSMesaID;
    }

    public void setMSMesaID(Long mSMesaID) {
        this.mSMesaID = mSMesaID;
    }

    public String getMSUbicacion() {
        return mSUbicacion;
    }

    public void setMSUbicacion(String mSUbicacion) {
        this.mSUbicacion = mSUbicacion;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @XmlTransient
    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mSMesaID != null ? mSMesaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mesas)) {
            return false;
        }
        Mesas other = (Mesas) object;
        if ((this.mSMesaID == null && other.mSMesaID != null) || (this.mSMesaID != null && !this.mSMesaID.equals(other.mSMesaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  mSMesaID + "-" + mSUbicacion;
    }
    
}
