/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Modelo.Clientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jainer Said Garcia Gonzalez
 * @author Emmanuel Gomez
 */


public class ClientesDAO {

    // Insertar un cliente
    public void insertar(Clientes cliente) {
        String sql = "INSERT INTO Clientes (nombre, correo, telefono, cedulaCifrada) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getTelefono());
            ps.setBytes(4, cliente.getCedulaCifrada());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    cliente.setIdCliente(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar cliente
    public void actualizar(Clientes cliente) {
        String sql = "UPDATE Clientes SET nombre=?, correo=?, telefono=?, cedulaCifrada=? WHERE idCliente=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getCorreo());
            ps.setString(3, cliente.getTelefono());
            ps.setBytes(4, cliente.getCedulaCifrada());
            ps.setInt(5, cliente.getIdCliente());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar cliente
    public void eliminar(int idCliente) {
        String sql = "DELETE FROM Clientes WHERE idCliente=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Buscar cliente por ID
    public Clientes buscarPorId(int idCliente) {
        String sql = "SELECT * FROM Clientes WHERE idCliente=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearCliente(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Listar todos los clientes
    public List<Clientes> listar() {
        List<Clientes> lista = new ArrayList<>();
        String sql = "SELECT * FROM Clientes";
        try (Connection conn = ConexionBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapearCliente(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    
    private Clientes mapearCliente(ResultSet rs) throws SQLException {
        int id = rs.getInt("idCliente");
        String nombre = rs.getString("nombre");
        String correo = rs.getString("correo");
        String telefono = rs.getString("telefono");
        byte[] cedula = rs.getBytes("cedulaCifrada");
        return new Clientes(id, nombre, correo, telefono, cedula);
    }
}

