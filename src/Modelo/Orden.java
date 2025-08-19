/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jainer Said Garcia Gonzalez
 * @author Emmanuel Gomez
 */
public class Orden {

    private int idOrden;
    private int idCliente;
    private double totalBruto;
    private double impuestos;
    private Double descuentos;
    private double totalNeto;
    private LocalDateTime fecha;

    // Constructor completo
    public Orden(int idOrden, int idCliente, double totalBruto, double impuestos, Double descuentos, double totalNeto, LocalDateTime fecha) {
        this.idOrden = idOrden;
        this.idCliente = idCliente;
        this.totalBruto = totalBruto;
        this.impuestos = impuestos;
        this.descuentos = descuentos;
        this.totalNeto = totalNeto;
        this.fecha = fecha;

    }

    // Constructor sin id (para inserts nuevos)
    public Orden(int idCliente, double totalBruto, double impuestos, Double descuentos, double totalNeto, LocalDateTime fecha) {
        this(0, idCliente, totalBruto, impuestos, descuentos, totalNeto, fecha);
    }

    // Getters y Setters
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotalBruto() {
        return totalBruto;
    }

    public void setTotalBruto(double totalBruto) {
        this.totalBruto = totalBruto;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public Double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(Double descuentos) {
        this.descuentos = descuentos;
    }

    public double getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(double totalNeto) {
        this.totalNeto = totalNeto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }



  
    @Override
    public String toString() {
        return "Orden{"
                + "idOrden=" + idOrden
                + ", idCliente=" + idCliente
                + ", totalBruto=" + totalBruto
                + ", impuestos=" + impuestos
                + ", descuentos=" + descuentos
                + ", totalNeto=" + totalNeto
                + ", fecha=" + fecha
                + '}';
    }
}
