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
@Table(name = "meseros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meseros.findAll", query = "SELECT m FROM Meseros m")
    , @NamedQuery(name = "Meseros.findByMEMeseroID", query = "SELECT m FROM Meseros m WHERE m.mEMeseroID = :mEMeseroID")
    , @NamedQuery(name = "Meseros.findByMENombreMesero", query = "SELECT m FROM Meseros m WHERE m.mENombreMesero = :mENombreMesero")
    , @NamedQuery(name = "Meseros.findByMEHorario", query = "SELECT m FROM Meseros m WHERE m.mEHorario = :mEHorario")
    })

public class Meseros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ME_MeseroID")
    private Long mEMeseroID;
    @Size(max = 45)
    @Column(name = "ME_NombreMesero")
    private String mENombreMesero;
    @Size(max = 45)
    @Column(name = "ME_Horario")
    private String mEHorario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mESEROSMEMeseroID")
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mESEROSMEMeseroID")
    private Collection<Pedidos> pedidosCollection;

    public Meseros() {
    }

    public Meseros(Long mEMeseroID) {
        this.mEMeseroID = mEMeseroID;
    }

    public Long getMEMeseroID() {
        return mEMeseroID;
    }

    public void setMEMeseroID(Long mEMeseroID) {
        this.mEMeseroID = mEMeseroID;
    }

    public String getMENombreMesero() {
        return mENombreMesero;
    }

    public void setMENombreMesero(String mENombreMesero) {
        this.mENombreMesero = mENombreMesero;
    }

    public String getMEHorario() {
        return mEHorario;
    }

    public void setMEHorario(String mEHorario) {
        this.mEHorario = mEHorario;
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
        hash += (mEMeseroID != null ? mEMeseroID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meseros)) {
            return false;
        }
        Meseros other = (Meseros) object;
        if ((this.mEMeseroID == null && other.mEMeseroID != null) || (this.mEMeseroID != null && !this.mEMeseroID.equals(other.mEMeseroID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  mEMeseroID + "-"+ mENombreMesero;
    }
    
}
