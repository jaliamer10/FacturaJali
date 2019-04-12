/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jalinet.facturaj.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alberto
 */
public class Venta {
    Long cantidad;
    Long valorTotal;
    Long impuestoTotal;
    Long costoTotal;
    Productos producto = new Productos();
    Clientes cliente = new Clientes();
    Mediopago medioPago = new Mediopago();
    Pedidos pedido = new Pedidos();
    Detallefactura detallefactura = new Detallefactura();
    List<Detallefactura> listaDetalle = new ArrayList();
      
    public Long getImpuestoTotal() {
        return impuestoTotal;
    }

    public void setImpuestoTotal(Long impuestoTotal) {
        this.impuestoTotal = impuestoTotal;
    }

    public List<Detallefactura> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<Detallefactura> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public Long getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Long costoTotal) {
        this.costoTotal = costoTotal;
    }

    
    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Mediopago getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(Mediopago medioPago) {
        this.medioPago = medioPago;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }
    
    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Long valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }
    
}
