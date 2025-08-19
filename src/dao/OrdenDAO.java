/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import Modelo.Orden;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jainer Said Garcia Gonzalez
 * @author Emmanuel Gomez
 */

public class OrdenDAO {

    // Insertar una orden
    public void insertar(Orden orden) {
        String sql = "INSERT INTO Ordenes (idCliente, totalBruto, impuestos, descuentos, totalNeto, fecha) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, orden.getIdCliente());
            ps.setDouble(2, orden.getTotalBruto());
            ps.setDouble(3, orden.getImpuestos());

            if (orden.getDescuentos() != null) {
                ps.setDouble(4, orden.getDescuentos());
            } else {
                ps.setNull(4, Types.DOUBLE);
            }

            ps.setDouble(5, orden.getTotalNeto());
            ps.setTimestamp(6, Timestamp.valueOf(orden.getFecha()));

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    orden.setIdOrden(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar una orden
    public void actualizar(Orden orden) {
        String sql = "UPDATE Ordenes SET idCliente=?, totalBruto=?, impuestos=?, descuentos=?, totalNeto=?, fecha=? WHERE idOrden=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, orden.getIdCliente());
            ps.setDouble(2, orden.getTotalBruto());
            ps.setDouble(3, orden.getImpuestos());

            if (orden.getDescuentos() != null) {
                ps.setDouble(4, orden.getDescuentos());
            } else {
                ps.setNull(4, Types.DOUBLE);
            }

            ps.setDouble(5, orden.getTotalNeto());
            ps.setTimestamp(6, Timestamp.valueOf(orden.getFecha()));
            ps.setInt(7, orden.getIdOrden());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar una orden
    public void eliminar(int idOrden) {
        String sql = "DELETE FROM Ordenes WHERE idOrden=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idOrden);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Buscar una orden por ID
    public Orden buscarPorId(int idOrden) {
        String sql = "SELECT * FROM Ordenes WHERE idOrden=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idOrden);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapearOrden(rs);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Listar todas las órdenes
    public List<Orden> listar() {
        List<Orden> lista = new ArrayList<>();
        String sql = "SELECT * FROM Ordenes";
        try (Connection conn = ConexionBD.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(mapearOrden(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

   
    private Orden mapearOrden(ResultSet rs) throws SQLException {
        int idOrden = rs.getInt("idOrden");
        int idCliente = rs.getInt("idCliente");
        double totalBruto = rs.getDouble("totalBruto");
        double impuestos = rs.getDouble("impuestos");
        Double descuentos = rs.getObject("descuentos") != null ? rs.getDouble("descuentos") : null;
        double totalNeto = rs.getDouble("totalNeto");
        LocalDateTime fecha = rs.getTimestamp("fecha").toLocalDateTime();

        return new Orden(idOrden, idCliente, totalBruto, impuestos, descuentos, totalNeto, fecha);
    }
}



