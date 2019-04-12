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
public class VentaMesero {
    Long meseroID;
    Long ventaMesero;
    String nombreMesero;

    public Long getMeseroID() {
        return meseroID;
    }

    public void setMeseroID(Long meseroID) {
        this.meseroID = meseroID;
    }

    public Long getVentaMesero() {
        return ventaMesero;
    }

    public void setVentaMesero(Long ventaMesero) {
        this.ventaMesero = ventaMesero;
    }

    public String getNombreMesero() {
        return nombreMesero;
    }

    public void setNombreMesero(String nombreMesero) {
        this.nombreMesero = nombreMesero;
    }

}
