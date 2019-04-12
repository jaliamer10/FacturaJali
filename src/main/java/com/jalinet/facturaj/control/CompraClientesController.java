/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jalinet.facturaj.control;

import com.jalinet.facturaj.modelo.Clientes;
import com.jalinet.facturaj.modelo.CompraCliente;
import com.jalinet.facturaj.modelo.Factura;
import com.jalinet.facturaj.modelo.Meseros;
import com.jalinet.facturaj.modelo.VentaMesero;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author Alberto
 */
@Named("compraClientesController")
@ManagedBean
@ViewScoped
public class CompraClientesController implements Serializable {
    Long valorCompras = Long.valueOf("0");
    int cantidadCompras = 0;
    Factura factura = new Factura();
    Clientes clientes = new Clientes();
    
    List<CompraCliente> compraClientes = new ArrayList();

    @ManagedProperty("#{facturaController}")
    @Inject
    private FacturaController facturaController;

    @ManagedProperty("#{clientesController}")
    @Inject
    private ClientesController clientesController;

    public CompraClientesController() {
    }

    public Long getValorCompras() {
        return valorCompras;
    }

    public void setValorCompras(Long valorCompras) {
        this.valorCompras = valorCompras;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public List<CompraCliente> getCompraClientes() {
        return compraClientes;
    }

    public void setCompraClientes(List<CompraCliente> compraClientes) {
        this.compraClientes = compraClientes;
    }

    public FacturaController getFacturaController() {
        return facturaController;
    }

    public void setFacturaController(FacturaController facturaController) {
        this.facturaController = facturaController;
    }

    public ClientesController getClientesController() {
        return clientesController;
    }

    public void setClientesController(ClientesController clientesController) {
        this.clientesController = clientesController;
    }

    public void consultar ()    
    {
                SelectItem facturas[] = facturaController.getItemsAvailableSelectOne();
                SelectItem clientes[] = clientesController.getItemsAvailableSelectOne();
                for (SelectItem cli : clientes)
                {
                    
                    if (!cli.getLabel().toString().equals("---"))
                    {    
                        Clientes cliente = (Clientes) cli.getValue();
                        CompraCliente compraCliente = new CompraCliente();

                        compraCliente.setClienteID(cliente.getCLClienteID());
                        compraCliente.setNombreCliente(cliente.getCLNombre());
                        valorCompras = valorCompras * 0;
                        cantidadCompras = cantidadCompras * 0;
                        for (SelectItem fac : facturas)
                        {    
                            if (!fac.getLabel().toString().equals("---"))
                            {    
                                Factura factura = (Factura) fac.getValue();
                                DateFormat formatoVigencia = new SimpleDateFormat("yyyyMM");
                                
                                if (
                                        factura.getCLIENTESCLClienteID().getCLClienteID() == cliente.getCLClienteID()
                                        )
                                {
                                    valorCompras += factura.getFAValorTotal();
                                    cantidadCompras++;
                                }   
                            }
                        }
                        compraCliente.setCompraTotal(valorCompras);
                        compraCliente.setCantidadCompras(cantidadCompras);
                        if (compraCliente.getCompraTotal()> Long.parseLong("100000"))
                        {
                            this.compraClientes.add(compraCliente);
                        }
                    }
                }
    
    }
    
    
}
