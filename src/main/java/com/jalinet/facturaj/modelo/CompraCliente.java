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
public class CompraCliente {
    Long compraTotal;
    Long clienteID;
    int  cantidadCompras;
    String nombreCliente;

    public Long getCompraTotal() {
        return compraTotal;
    }

    public void setCompraTotal(Long compraTotal) {
        this.compraTotal = compraTotal;
    }

    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public int getCantidadCompras() {
        return cantidadCompras;
    }

    public void setCantidadCompras(int cantidadCompras) {
        this.cantidadCompras = cantidadCompras;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
