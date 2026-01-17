package org.osantos.java.jdbc;

import org.osantos.java.jdbc.modelo.Producto;
import org.osantos.java.jdbc.repositorio.ProductoRespositorioImp;
import org.osantos.java.jdbc.repositorio.Respositorio;
import org.osantos.java.jdbc.util.ConexionBaseDatos;

import javax.management.loading.ClassLoaderRepository;
import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getIntance()) {

            Respositorio<Producto> repositorio = new ProductoRespositorioImp();
            repositorio.listar().forEach(p -> System.out.println(p.getNombre()));

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
