/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jalinet.facturaj.modelo;

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
 * @author Alberto
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByFAFacturaID", query = "SELECT f FROM Factura f WHERE f.fAFacturaID = :fAFacturaID")
    , @NamedQuery(name = "Factura.findByFAFechaHora", query = "SELECT f FROM Factura f WHERE f.fAFechaHora = :fAFechaHora")
    , @NamedQuery(name = "Factura.findByFACostoFactura", query = "SELECT f FROM Factura f WHERE f.fACostoFactura = :fACostoFactura")
    , @NamedQuery(name = "Factura.findByFAImpuestoFactura", query = "SELECT f FROM Factura f WHERE f.fAImpuestoFactura = :fAImpuestoFactura")
    , @NamedQuery(name = "Factura.findByFAValorTotal", query = "SELECT f FROM Factura f WHERE f.fAValorTotal = :fAValorTotal")
    , @NamedQuery(name = "Factura.findMax", query = "SELECT f FROM Factura f order by f.fAFacturaID desc")
    , @NamedQuery(name = "Factura.findBill", query = "SELECT f FROM Factura f where f.fAFechaHora = :fAFechaHora ")
}
)
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FA_FacturaID")
    private Long fAFacturaID;
    @Column(name = "FA_FechaHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fAFechaHora;
    @Column(name = "FA_CostoFactura")
    private Long fACostoFactura;
    @Column(name = "FA_ImpuestoFactura")
    private Long fAImpuestoFactura;
    @Column(name = "FA_ValorTotal")
    private Long fAValorTotal;
    @JoinColumn(name = "CLIENTES_CL_ClienteID", referencedColumnName = "CL_ClienteID")
    @ManyToOne(optional = false)
    private Clientes cLIENTESCLClienteID;
    @JoinColumn(name = "MEDIOPAGO_MP_MedioPagoID", referencedColumnName = "MP_MedioPagoID")
    @ManyToOne(optional = false)
    private Mediopago mEDIOPAGOMPMedioPagoID;
    @JoinColumn(name = "MESAS_MS_MesaID", referencedColumnName = "MS_MesaID")
    @ManyToOne(optional = false)
    private Mesas mESASMSMesaID;
    @JoinColumn(name = "PEDIDOS_PE_PedidoID", referencedColumnName = "PE_PedidoID")
    @ManyToOne(optional = false)
    private Pedidos pEDIDOSPEPedidoID;
    @JoinColumn(name = "MESEROS_ME_MeseroID", referencedColumnName = "ME_MeseroID")
    @ManyToOne(optional = false)
    private Meseros mESEROSMEMeseroID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fACTURAFAFacturaID")
    private Collection<Detallefactura> detallefacturaCollection;
    
     
    public Factura() {
    }

    public Factura(Long fAFacturaID) {
        this.fAFacturaID = fAFacturaID;
    }

    public Long getFAFacturaID() {
        return fAFacturaID;
    }

    public void setFAFacturaID(Long fAFacturaID) {
        this.fAFacturaID = fAFacturaID;
    }

    public Date getFAFechaHora() {
        return fAFechaHora;
    }

    public void setFAFechaHora(Date fAFechaHora) {
        this.fAFechaHora = fAFechaHora;
    }

    public Long getFACostoFactura() {
        return fACostoFactura;
    }

    public void setFACostoFactura(Long fACostoFactura) {
        this.fACostoFactura = fACostoFactura;
    }

    public Long getFAImpuestoFactura() {
        return fAImpuestoFactura;
    }

    public void setFAImpuestoFactura(Long fAImpuestoFactura) {
        this.fAImpuestoFactura = fAImpuestoFactura;
    }

    public Long getFAValorTotal() {
        return fAValorTotal;
    }

    public void setFAValorTotal(Long fAValorTotal) {
        this.fAValorTotal = fAValorTotal;
    }

    public Clientes getCLIENTESCLClienteID() {
        return cLIENTESCLClienteID;
    }

    public void setCLIENTESCLClienteID(Clientes cLIENTESCLClienteID) {
        this.cLIENTESCLClienteID = cLIENTESCLClienteID;
    }

    public Mediopago getMEDIOPAGOMPMedioPagoID() {
        return mEDIOPAGOMPMedioPagoID;
    }

    public void setMEDIOPAGOMPMedioPagoID(Mediopago mEDIOPAGOMPMedioPagoID) {
        this.mEDIOPAGOMPMedioPagoID = mEDIOPAGOMPMedioPagoID;
    }

    public Mesas getMESASMSMesaID() {
        return mESASMSMesaID;
    }

    public void setMESASMSMesaID(Mesas mESASMSMesaID) {
        this.mESASMSMesaID = mESASMSMesaID;
    }

    public Pedidos getPEDIDOSPEPedidoID() {
        return pEDIDOSPEPedidoID;
    }

    public void setPEDIDOSPEPedidoID(Pedidos pEDIDOSPEPedidoID) {
        this.pEDIDOSPEPedidoID = pEDIDOSPEPedidoID;
    }

    public Meseros getMESEROSMEMeseroID() {
        return mESEROSMEMeseroID;
    }

    public void setMESEROSMEMeseroID(Meseros mESEROSMEMeseroID) {
        this.mESEROSMEMeseroID = mESEROSMEMeseroID;
    }

    @XmlTransient
    public Collection<Detallefactura> getDetallefacturaCollection() {
        return detallefacturaCollection;
    }

    public void setDetallefacturaCollection(Collection<Detallefactura> detallefacturaCollection) {
        this.detallefacturaCollection = detallefacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fAFacturaID != null ? fAFacturaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.fAFacturaID == null && other.fAFacturaID != null) || (this.fAFacturaID != null && !this.fAFacturaID.equals(other.fAFacturaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        
        return "com.jalinet.facturaj.modelo.Factura[ fAFacturaID=" + fAFacturaID + " ]";
    }
    
}
