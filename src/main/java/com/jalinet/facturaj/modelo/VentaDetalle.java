/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jalinet.facturaj.modelo;

/**
 *
 * @author Alberto
 */
public class VentaDetalle {
    Long cantidad;
    Long valorTotal;
    Long costoTotal;

    public Long getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Long costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Long getImpuestoTotal() {
        return impuestoTotal;
    }

    public void setImpuestoTotal(Long impuestoTotal) {
        this.impuestoTotal = impuestoTotal;
    }
    Long impuestoTotal;
    
    Productos producto = new Productos();
    Pedidos pedido = new Pedidos();

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }
    
    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
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
}
