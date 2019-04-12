/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jalinet.facturaj.control;

import com.jalinet.facturaj.modelo.Factura;
import com.jalinet.facturaj.modelo.Pedidos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alberto
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> {

    @PersistenceContext(unitName = "com.jalinet_FacturaJ_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }
    
    public Long findMax() {
        Long facturaId = Long.getLong("0");
        Query q = this.em.createNamedQuery("Factura.findMax");
        List<Factura> facturas = q.getResultList();
        
        for(Factura fac : facturas)
        {
            facturaId =  fac.getFAFacturaID();
        }
        return (facturaId);
    }

        public List<Factura> findBill(int mes) {
        Query q = this.em.createNamedQuery("Factura.findBill");
        q.setParameter("fAMesFactura", mes);
        return q.getResultList();
    }

}
