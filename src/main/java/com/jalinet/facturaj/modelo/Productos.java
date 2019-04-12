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
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByPRProductoID", query = "SELECT p FROM Productos p WHERE p.pRProductoID = :pRProductoID")
    , @NamedQuery(name = "Productos.findByPRNombreProducto", query = "SELECT p FROM Productos p WHERE p.pRNombreProducto = :pRNombreProducto")
    , @NamedQuery(name = "Productos.findByPRCostoUnitario", query = "SELECT p FROM Productos p WHERE p.pRCostoUnitario = :pRCostoUnitario")
    , @NamedQuery(name = "Productos.findByPRImpuestoUnidad", query = "SELECT p FROM Productos p WHERE p.pRImpuestoUnidad = :pRImpuestoUnidad")
    , @NamedQuery(name = "Productos.findByPRUnidadMedida", query = "SELECT p FROM Productos p WHERE p.pRUnidadMedida = :pRUnidadMedida")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PR_ProductoID")
    private Long pRProductoID;
    @Size(max = 45)
    @Column(name = "PR_NombreProducto")
    private String pRNombreProducto;
    @Column(name = "PR_CostoUnitario")
    private Long pRCostoUnitario;
    @Column(name = "PR_ImpuestoUnidad")
    private Long pRImpuestoUnidad;
    @Size(max = 45)
    @Column(name = "PR_UnidadMedida")
    private String pRUnidadMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pRODUCTOSPRProductoID")
    private Collection<Detallefactura> detallefacturaCollection;

    public Productos() {
    }

    public Productos(Long pRProductoID) {
        this.pRProductoID = pRProductoID;
    }

    public Long getPRProductoID() {
        return pRProductoID;
    }

    public void setPRProductoID(Long pRProductoID) {
        this.pRProductoID = pRProductoID;
    }

    public String getPRNombreProducto() {
        return pRNombreProducto;
    }

    public void setPRNombreProducto(String pRNombreProducto) {
        this.pRNombreProducto = pRNombreProducto;
    }

    public Long getPRCostoUnitario() {
        return pRCostoUnitario;
    }

    public void setPRCostoUnitario(Long pRCostoUnitario) {
        this.pRCostoUnitario = pRCostoUnitario;
    }

    public Long getPRImpuestoUnidad() {
        return pRImpuestoUnidad;
    }

    public void setPRImpuestoUnidad(Long pRImpuestoUnidad) {
        this.pRImpuestoUnidad = pRImpuestoUnidad;
    }

    public String getPRUnidadMedida() {
        return pRUnidadMedida;
    }

    public void setPRUnidadMedida(String pRUnidadMedida) {
        this.pRUnidadMedida = pRUnidadMedida;
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
        hash += (pRProductoID != null ? pRProductoID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.pRProductoID == null && other.pRProductoID != null) || (this.pRProductoID != null && !this.pRProductoID.equals(other.pRProductoID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return pRProductoID + "-" + pRNombreProducto;
    }
    
}
