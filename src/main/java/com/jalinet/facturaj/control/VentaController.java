/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jalinet.facturaj.control;

import com.jalinet.facturaj.control.util.JsfUtil;
import com.jalinet.facturaj.modelo.Detallefactura;
import com.jalinet.facturaj.modelo.Factura;
import com.jalinet.facturaj.modelo.Pedidos;
import com.jalinet.facturaj.modelo.Productos;
import com.jalinet.facturaj.modelo.VentaDetalle;
import com.jalinet.facturaj.modelo.Venta;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

/**
 *
 * @author Alberto
 */
@Named("ventaController")
@ManagedBean
@ViewScoped
public class VentaController implements Serializable {
    private Productos producto = new Productos();
    private Long cantidad;
    private Long valorTotal;
    private Long costoTotal;
    private Long impuestoTotal;
    private Long valorTotalFactura;
    private Long valorTotalImpuesto;
    private Long costoTotalFactura;
    private Pedidos pedido = new Pedidos();
    private Venta venta = new Venta();
    
    private List<VentaDetalle> ventaDetalle = new ArrayList();
    private List<Detallefactura> listaDetalle = new ArrayList();

    @ManagedProperty("#{facturaController}")
    @Inject
    private FacturaController facturaController;

    @ManagedProperty("#{detallefacturaController}")
    @Inject
    private DetallefacturaController detallefacturaController;

    @ManagedProperty("#{pedidosController}")
    @Inject
    private PedidosController pedidosController;

    public FacturaController getFacturaController() {
        return facturaController;
    }

    public void setFacturaController(FacturaController facturaController) {
        this.facturaController = facturaController;
    }

    public DetallefacturaController getDetalleFacturaController() {
        return detallefacturaController;
    }

    public void setDetalleFacturaController(DetallefacturaController detalleFacturaController) {
        this.detallefacturaController = detalleFacturaController;
    }


    
    public Long getValorTotalFactura() {
        return valorTotalFactura;
    }

    public void setValorTotalFactura(Long valorTotalFactura) {
        this.valorTotalFactura = valorTotalFactura;
    }
    
    public VentaController() {
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }


    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public List<VentaDetalle> getVentaDetalle() {
        return ventaDetalle;
    }

    public void setVentaDetalle(List<VentaDetalle> ventaDetalle) {
        this.ventaDetalle = ventaDetalle;
    }

    
    
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    public void agregar ()
    {
           venta = this.getVenta();
           cantidad = venta.getCantidad();
           costoTotalFactura = cantidad - cantidad;
           valorTotalFactura = cantidad - cantidad;
           valorTotalImpuesto = cantidad - cantidad;
           valorTotal = cantidad *( venta.getProducto().getPRCostoUnitario() + venta.getProducto().getPRImpuestoUnidad() );
           costoTotal = cantidad *( venta.getProducto().getPRCostoUnitario() );
           impuestoTotal = cantidad *( venta.getProducto().getPRImpuestoUnidad());
           venta.setValorTotal(valorTotal); 
           
           //Llenando el DataTable 
           VentaDetalle detalle = new VentaDetalle();
           detalle.setCantidad(venta.getCantidad());
           detalle.setValorTotal(venta.getValorTotal());
           detalle.setProducto(venta.getProducto());
           detalle.setPedido(venta.getPedido());
           detalle.setCostoTotal(costoTotal);
           detalle.setImpuestoTotal(impuestoTotal);
           this.ventaDetalle.add(detalle);
           //Llenando el DetalleFactura
           Detallefactura fDetalle = new Detallefactura();
           fDetalle.setDFCantidad(venta.getCantidad());
           fDetalle.setDFCostoPedido(costoTotal);
           fDetalle.setDFImpuestoPedido(impuestoTotal);
           fDetalle.setDFIndice(cantidad);
           fDetalle.setDFValorPedido(venta.getValorTotal());
           fDetalle.setDFIndice(cantidad);
           fDetalle.setPEDIDOSPEPedidoID(venta.getPedido());
           fDetalle.setPRODUCTOSPRProductoID(venta.getProducto());
           this.listaDetalle.add(fDetalle);
           venta.setListaDetalle(listaDetalle);
           
           for (VentaDetalle det : ventaDetalle)
           {
             valorTotalFactura += det.getValorTotal();
             valorTotalImpuesto += det.getImpuestoTotal();
             costoTotalFactura += det.getCostoTotal();
           }
           venta.setValorTotal(valorTotalFactura);
           venta.setImpuestoTotal(valorTotalImpuesto);
           venta.setCostoTotal(costoTotalFactura);
           venta.setListaDetalle(listaDetalle);
    }
    
    public void registrar() 
    {
            Long facturaId;
            Long pedidoId;
            Factura factura = new Factura();
            java.util.Date ahora = new java.util.Date();
            cantidad = venta.getCantidad();
        try {    
            facturaController.prepareCreate();
            
            facturaController.getSelected().setCLIENTESCLClienteID(venta.getCliente());
            facturaController.getSelected().setFACostoFactura(venta.getCostoTotal());
            facturaController.getSelected().setFAFacturaID(cantidad);
            facturaController.getSelected().setFAFechaHora(ahora);
            facturaController.getSelected().setFAImpuestoFactura(venta.getImpuestoTotal());
            facturaController.getSelected().setFAValorTotal(venta.getValorTotal());
            facturaController.getSelected().setMEDIOPAGOMPMedioPagoID(venta.getMedioPago());
            facturaController.getSelected().setMESASMSMesaID(venta.getPedido().getMESASMSMesaID());
            facturaController.getSelected().setMESEROSMEMeseroID(venta.getPedido().getMESEROSMEMeseroID());
            facturaController.getSelected().setPEDIDOSPEPedidoID(venta.getPedido());
            
            List<Detallefactura> detallefacturaAct = new ArrayList();
            List<Detallefactura> detallefactura = venta.getListaDetalle();
            for (Detallefactura det : detallefactura)
            {
                det.setFACTURAFAFacturaID(facturaController.getSelected());
                detallefacturaAct.add(det);
            }
            venta.setListaDetalle(detallefacturaAct);
            facturaController.getSelected().setDetallefacturaCollection(venta.getListaDetalle());

            String valorFactura = facturaController.create();
            

/*            facturaId = facturaController.getFacturaMax();
            factura = facturaController.getFactura(facturaId);
            List<Detallefactura> detallefactura = new ArrayList();
            detallefactura = venta.getListaDetalle();
            for (Detallefactura det : detallefactura)
            {
                detallefacturaController.getSelected().setDFCantidad(det.getDFCantidad());
                detallefacturaController.getSelected().setDFCostoPedido(det.getDFCostoPedido());
                detallefacturaController.getSelected().setDFImpuestoPedido(det.getDFImpuestoPedido());
                detallefacturaController.getSelected().setDFIndice(cantidad);
                detallefacturaController.getSelected().setDFValorPedido(det.getDFValorPedido());
                detallefacturaController.getSelected().setFACTURAFAFacturaID(factura);
                detallefacturaController.getSelected().setPEDIDOSPEPedidoID(det.getPEDIDOSPEPedidoID());
                detallefacturaController.getSelected().setPRODUCTOSPRProductoID(det.getPRODUCTOSPRProductoID());
                detallefacturaController.create();
            }
*/
            pedido = venta.getPedido();
             
            pedido.setPEFacturado(Boolean.TRUE);
            pedidosController.getSelected().setDetallefacturaCollection(pedido.getDetallefacturaCollection());
            pedidosController.getSelected().setFacturaCollection(pedido.getFacturaCollection());
            pedidosController.getSelected().setMESASMSMesaID(pedido.getMESASMSMesaID());
            pedidosController.getSelected().setMESEROSMEMeseroID(pedido.getMESEROSMEMeseroID());
            pedidosController.getSelected().setPEFacturado(pedido.getPEFacturado());
            pedidosController.getSelected().setPEPedidoID(pedido.getPEPedidoID());
//            pedidosController.prepareEdit();
            String valorPedido= pedidosController.update();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Factura Fue creada Exitosamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Aviso","Error en Creaciòn " + e.getLocalizedMessage()));
        }
        finally
        {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }

    }
}
