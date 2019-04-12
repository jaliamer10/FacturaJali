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
 * @author Alberto
 */
@Entity
@Table(name = "pedidos")
@XmlRootElement
@NamedQueries({
     @NamedQuery(name = "Pedidos.findAll", query = "SELECT p FROM Pedidos p")
    , @NamedQuery(name = "Pedidos.findByPEPedidoID", query = "SELECT p FROM Pedidos p WHERE p.pEPedidoID = :pEPedidoID")
    , @NamedQuery(name = "Pedidos.findByPEFacturado", query = "SELECT p FROM Pedidos p WHERE p.pEFacturado = :pEFacturado")})
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PE_PedidoID")
    private Long pEPedidoID;
    @Column(name = "PE_Facturado")
    private Boolean pEFacturado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pEDIDOSPEPedidoID")
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pEDIDOSPEPedidoID")
    private Collection<Detallefactura> detallefacturaCollection;
    @JoinColumn(name = "MESAS_MS_MesaID", referencedColumnName = "MS_MesaID")
    @ManyToOne(optional = false)
    private Mesas mESASMSMesaID;
    @JoinColumn(name = "MESEROS_ME_MeseroID", referencedColumnName = "ME_MeseroID")
    @ManyToOne(optional = false)
    private Meseros mESEROSMEMeseroID;

    public Pedidos() {
    }

    public Pedidos(Long pEPedidoID) {
        this.pEPedidoID = pEPedidoID;
    }

    public Long getPEPedidoID() {
        return pEPedidoID;
    }

    public void setPEPedidoID(Long pEPedidoID) {
        this.pEPedidoID = pEPedidoID;
    }

    public Boolean getPEFacturado() {
        return pEFacturado;
    }

    public void setPEFacturado(Boolean pEFacturado) {
        this.pEFacturado = pEFacturado;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @XmlTransient
    public Collection<Detallefactura> getDetallefacturaCollection() {
        return detallefacturaCollection;
    }

    public void setDetallefacturaCollection(Collection<Detallefactura> detallefacturaCollection) {
        this.detallefacturaCollection = detallefacturaCollection;
    }

    public Mesas getMESASMSMesaID() {
        return mESASMSMesaID;
    }

    public void setMESASMSMesaID(Mesas mESASMSMesaID) {
        this.mESASMSMesaID = mESASMSMesaID;
    }

    public Meseros getMESEROSMEMeseroID() {
        return mESEROSMEMeseroID;
    }

    public void setMESEROSMEMeseroID(Meseros mESEROSMEMeseroID) {
        this.mESEROSMEMeseroID = mESEROSMEMeseroID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pEPedidoID != null ? pEPedidoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidos)) {
            return false;
        }
        Pedidos other = (Pedidos) object;
        if ((this.pEPedidoID == null && other.pEPedidoID != null) || (this.pEPedidoID != null && !this.pEPedidoID.equals(other.pEPedidoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  pEPedidoID + "-[" + pEPedidoID+ "]";
    }
    
}
