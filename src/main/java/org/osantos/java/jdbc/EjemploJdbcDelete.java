package org.osantos.java.jdbc;

import org.osantos.java.jdbc.modelo.Producto;
import org.osantos.java.jdbc.repositorio.ProductoRespositorioImp;
import org.osantos.java.jdbc.repositorio.Respositorio;
import org.osantos.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJdbcDelete {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getIntance()) {

            Respositorio<Producto> repositorio = new ProductoRespositorioImp();
            System.out.println("============= [Listar] =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= [Obtener por id] =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============= [Eliminar producto] =============");
            repositorio.eliminar(4L);
            System.out.println("Producto eliminado con éxito");

            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
