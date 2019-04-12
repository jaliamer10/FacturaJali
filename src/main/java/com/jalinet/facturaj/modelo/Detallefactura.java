/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jalinet.facturaj.modelo;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alberto
 */
@Entity
@Table(name = "detallefactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallefactura.findAll", query = "SELECT d FROM Detallefactura d")
    , @NamedQuery(name = "Detallefactura.findByDFCantidad", query = "SELECT d FROM Detallefactura d WHERE d.dFCantidad = :dFCantidad")
    , @NamedQuery(name = "Detallefactura.findByDFCostoPedido", query = "SELECT d FROM Detallefactura d WHERE d.dFCostoPedido = :dFCostoPedido")
    , @NamedQuery(name = "Detallefactura.findByDFImpuestoPedido", query = "SELECT d FROM Detallefactura d WHERE d.dFImpuestoPedido = :dFImpuestoPedido")
    , @NamedQuery(name = "Detallefactura.findByDFValorPedido", query = "SELECT d FROM Detallefactura d WHERE d.dFValorPedido = :dFValorPedido")
    , @NamedQuery(name = "Detallefactura.findByDFIndice", query = "SELECT d FROM Detallefactura d WHERE d.dFIndice = :dFIndice")})
public class Detallefactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DF_Cantidad")
    private long dFCantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DF_CostoPedido")
    private long dFCostoPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DF_ImpuestoPedido")
    private long dFImpuestoPedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DF_ValorPedido")
    private long dFValorPedido;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DF_Indice")
    private Long dFIndice;
    @JoinColumn(name = "PEDIDOS_PE_PedidoID", referencedColumnName = "PE_PedidoID")
    @ManyToOne(optional = false)
    private Pedidos pEDIDOSPEPedidoID;
    @JoinColumn(name = "PRODUCTOS_PR_ProductoID", referencedColumnName = "PR_ProductoID")
    @ManyToOne(optional = false)
    private Productos pRODUCTOSPRProductoID;
    @JoinColumn(name = "FACTURA_FA_FacturaID", referencedColumnName = "FA_FacturaID")
    @ManyToOne(optional = false)
    private Factura fACTURAFAFacturaID;

    public Detallefactura() {
    }

    public Detallefactura(Long dFIndice) {
        this.dFIndice = dFIndice;
    }

    public Detallefactura(Long dFIndice, long dFCantidad, long dFCostoPedido, long dFImpuestoPedido, long dFValorPedido) {
        this.dFIndice = dFIndice;
        this.dFCantidad = dFCantidad;
        this.dFCostoPedido = dFCostoPedido;
        this.dFImpuestoPedido = dFImpuestoPedido;
        this.dFValorPedido = dFValorPedido;
    }

    public long getDFCantidad() {
        return dFCantidad;
    }

    public void setDFCantidad(long dFCantidad) {
        this.dFCantidad = dFCantidad;
    }

    public long getDFCostoPedido() {
        return dFCostoPedido;
    }

    public void setDFCostoPedido(long dFCostoPedido) {
        this.dFCostoPedido = dFCostoPedido;
    }

    public long getDFImpuestoPedido() {
        return dFImpuestoPedido;
    }

    public void setDFImpuestoPedido(long dFImpuestoPedido) {
        this.dFImpuestoPedido = dFImpuestoPedido;
    }

    public long getDFValorPedido() {
        return dFValorPedido;
    }

    public void setDFValorPedido(long dFValorPedido) {
        this.dFValorPedido = dFValorPedido;
    }

    public Long getDFIndice() {
        return dFIndice;
    }

    public void setDFIndice(Long dFIndice) {
        this.dFIndice = dFIndice;
    }

    public Pedidos getPEDIDOSPEPedidoID() {
        return pEDIDOSPEPedidoID;
    }

    public void setPEDIDOSPEPedidoID(Pedidos pEDIDOSPEPedidoID) {
        this.pEDIDOSPEPedidoID = pEDIDOSPEPedidoID;
    }

    public Productos getPRODUCTOSPRProductoID() {
        return pRODUCTOSPRProductoID;
    }

    public void setPRODUCTOSPRProductoID(Productos pRODUCTOSPRProductoID) {
        this.pRODUCTOSPRProductoID = pRODUCTOSPRProductoID;
    }

    public Factura getFACTURAFAFacturaID() {
        return fACTURAFAFacturaID;
    }

    public void setFACTURAFAFacturaID(Factura fACTURAFAFacturaID) {
        this.fACTURAFAFacturaID = fACTURAFAFacturaID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dFIndice != null ? dFIndice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallefactura)) {
            return false;
        }
        Detallefactura other = (Detallefactura) object;
        if ((this.dFIndice == null && other.dFIndice != null) || (this.dFIndice != null && !this.dFIndice.equals(other.dFIndice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jalinet.facturaj.modelo.Detallefactura[ dFIndice=" + dFIndice + " ]";
    }
    
}
