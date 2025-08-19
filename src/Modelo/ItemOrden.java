/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author jainer Said Garcia Gonzalez
 * @author Emmanuel Gomez
 */
public class ItemOrden {

    private int idItem;
    private int idOrden;
    private String codigoProducto;
    private int cantidad;
    private double precioUnitario;

    // Constructor 
    public ItemOrden(int idItem, int idOrden, String codigoProducto, int cantidad, double precioUnitario) {
        this.idItem = idItem;
        this.idOrden = idOrden;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    // Constructor sin id (para inserts)
    public ItemOrden(int idOrden, String codigoProducto, int cantidad, double precioUnitario) {
        this(0, idOrden, codigoProducto, cantidad, precioUnitario);
    }

    // Getters y Setters
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "ItemOrden{"
                + "idItem=" + idItem
                + ", idOrden=" + idOrden
                + ", codigoProducto='" + codigoProducto + '\''
                + ", cantidad=" + cantidad
                + ", precioUnitario=" + precioUnitario
                + '}';
    }
}
