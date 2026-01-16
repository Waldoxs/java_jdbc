package org.osantos.java.jdbc;

import org.osantos.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {


        try (Connection conn = ConexionBaseDatos.getIntance();
             Statement stmt = conn.createStatement();
             ResultSet resultado = stmt.executeQuery("SELECT * FROM productos")) {

            while (resultado.next()) {
                System.out.print(resultado.getInt("id") + " | ");
                System.out.print(resultado.getString("nombre") + " | ");
                System.out.print(resultado.getInt("precio") + " | ");
                System.out.println(resultado.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
