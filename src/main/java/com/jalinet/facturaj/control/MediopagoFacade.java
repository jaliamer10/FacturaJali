/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jalinet.facturaj.control;

import com.jalinet.facturaj.modelo.Mediopago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alberto
 */
@Stateless
public class MediopagoFacade extends AbstractFacade<Mediopago> {

    @PersistenceContext(unitName = "com.jalinet_FacturaJ_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MediopagoFacade() {
        super(Mediopago.class);
    }
    
}
