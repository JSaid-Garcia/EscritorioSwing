/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author jainer Said Garcia Gonzalez
 * @author Emmanuel Gomez
 */

public class ConexionBD {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=EscritorioSwing;encrypt=false";
    private static final String USER = "Said";  // cambia según tu usuario
    private static final String PASSWORD = "123456"; // cambia según tu contraseña

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
