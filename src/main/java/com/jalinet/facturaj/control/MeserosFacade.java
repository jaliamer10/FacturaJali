/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jalinet.facturaj.control;

import com.jalinet.facturaj.modelo.Meseros;
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
public class MeserosFacade extends AbstractFacade<Meseros> {

    @PersistenceContext(unitName = "com.jalinet_FacturaJ_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MeserosFacade() {
        super(Meseros.class);
    }
   


    
}
