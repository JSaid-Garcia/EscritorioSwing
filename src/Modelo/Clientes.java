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

public class Clientes {

    private int idCliente;
    private String nombre;
    private String correo;
    private String telefono;
    private byte[] cedulaCifrada;

    public Clientes(int idCliente, String nombre, String correo, String telefono, byte[] cedulaCifrada) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedulaCifrada = cedulaCifrada;
    }

    // Constructor sin id (para inserts)
    public Clientes(String nombre, String correo, String telefono, byte[] cedulaCifrada) {
        this(0, nombre, correo, telefono, cedulaCifrada);
    }

    // Getters y setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public byte[] getCedulaCifrada() {
        return cedulaCifrada;
    }

    public void setCedulaCifrada(byte[] cedulaCifrada) {
        this.cedulaCifrada = cedulaCifrada;
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "idCliente=" + idCliente
                + ", nombre='" + nombre + '\''
                + ", correo='" + correo + '\''
                + ", telefono='" + telefono + '\''
                + ", cedulaCifrada=" + (cedulaCifrada != null ? "[***]" : "null")
                + '}';
    }

}
