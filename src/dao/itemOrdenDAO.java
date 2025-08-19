/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import Modelo.ItemOrden;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author jainer Said Garcia
 * @author Emmanuel Gomez
 */

public class itemOrdenDAO {

    // Insertar un item en una orden
    public void insertar(ItemOrden item, int idOrden) {
        String sql = "INSERT INTO ItemsOrden (idOrden, codigoProducto, cantidad, precioUnitario) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, idOrden);
            ps.setString(2, item.getCodigoProducto());
            ps.setInt(3, item.getCantidad());
            ps.setDouble(4, item.getPrecioUnitario());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    item.setIdItem(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar item
    public void actualizar(ItemOrden item) {
        String sql = "UPDATE ItemsOrden SET codigoProducto=?, cantidad=?, precioUnitario=? WHERE idItem=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, item.getCodigoProducto());
            ps.setInt(2, item.getCantidad());
            ps.setDouble(3, item.getPrecioUnitario());
            ps.setInt(4, item.getIdItem());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Eliminar item
    public void eliminar(int idItem) {
        String sql = "DELETE FROM ItemsOrden WHERE idItem=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idItem);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar items de una orden
    public List<ItemOrden> listarPorOrden(int idOrden) {
        List<ItemOrden> lista = new ArrayList<>();
        String sql = "SELECT * FROM ItemsOrden WHERE idOrden=?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idOrden);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapearItem(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

  
    private ItemOrden mapearItem(ResultSet rs) throws SQLException {
        int idItem = rs.getInt("idItem");
        String codigoProducto = rs.getString("codigoProducto");
        int cantidad = rs.getInt("cantidad");
        double precioUnitario = rs.getDouble("precioUnitario");

        return new ItemOrden(idItem, codigoProducto, cantidad, precioUnitario);
    }
}

