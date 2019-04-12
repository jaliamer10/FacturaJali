/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jalinet.facturaj.control;

import com.jalinet.facturaj.modelo.Factura;
import com.jalinet.facturaj.modelo.Meseros;
import com.jalinet.facturaj.modelo.VentaMesero;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;

import javax.inject.Inject;
import javax.inject.Named;
import javax.faces.model.SelectItem; 
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author Alberto
 */
@Named("ventaMeserosController")
@ManagedBean
@ViewScoped
public class VentaMeserosController implements Serializable {
    int mesFactura;
    Long valorVentas = Long.valueOf("0");
    Factura factura = new Factura();
    Meseros meseros = new Meseros();
    List<VentaMesero> ventaMeseros = new ArrayList();
    
    @ManagedProperty("#{facturaController}")
    @Inject
    private FacturaController facturaController;

    @ManagedProperty("#{meserosController}")
    @Inject
    private MeserosController meserosController;

    public int getMesFactura() {
        return mesFactura;
    }

    public void setMesFactura(int mesFactura) {
        this.mesFactura = mesFactura;
    }

    
    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Meseros getMeseros() {
        return meseros;
    }

    public void setMeseros(Meseros meseros) {
        this.meseros = meseros;
    }

    public List<VentaMesero> getVentaMeseros() {
        return ventaMeseros;
    }

    public void setVentaMeseros(List<VentaMesero> ventaMeseros) {
        this.ventaMeseros = ventaMeseros;
    }

    public FacturaController getFacturaController() {
        return facturaController;
    }

    public void setFacturaController(FacturaController facturaController) {
        this.facturaController = facturaController;
    }

    public MeserosController getMeserosController() {
        return meserosController;
    }

    public void setMeserosController(MeserosController meserosController) {
        this.meserosController = meserosController;
    }

    public void consultar()
    {
                SelectItem facturas[] = facturaController.getItemsAvailableSelectOne();
                SelectItem meseros[] = meserosController.getItemsAvailableSelectOne();
                for (SelectItem mes : meseros)
                {
                    
                    if (!mes.getLabel().toString().equals("---"))
                    {    
                        Meseros mesero = (Meseros) mes.getValue();
                        VentaMesero ventaMesero = new VentaMesero();

                        ventaMesero.setMeseroID(mesero.getMEMeseroID());
                        ventaMesero.setNombreMesero(mesero.getMENombreMesero());
                        valorVentas = valorVentas * 0;
                        for (SelectItem fac : facturas)
                        {    
                            if (!fac.getLabel().toString().equals("---"))
                            {    
                                Factura factura = (Factura) fac.getValue();
                                DateFormat formatoVigencia = new SimpleDateFormat("yyyyMM");
                                
                                if (
                                        mesFactura ==  Integer.parseInt(formatoVigencia.format(factura.getFAFechaHora()))
                                         && 
                                        factura.getMESEROSMEMeseroID().getMEMeseroID() == mesero.getMEMeseroID()
                                        )
                                {
                                    valorVentas += factura.getFAValorTotal();
                                }   
                            }
                        }
                        ventaMesero.setVentaMesero(valorVentas);
                        this.ventaMeseros.add(ventaMesero);
                    }
                }
    }
    
    public VentaMeserosController() {
    }
    
}
