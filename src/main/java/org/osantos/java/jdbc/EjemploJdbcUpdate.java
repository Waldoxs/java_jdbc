package org.osantos.java.jdbc;

import org.osantos.java.jdbc.modelo.Categoria;
import org.osantos.java.jdbc.modelo.Producto;
import org.osantos.java.jdbc.repositorio.ProductoRespositorioImp;
import org.osantos.java.jdbc.repositorio.Respositorio;
import org.osantos.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class EjemploJdbcUpdate {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getIntance()) {

            Respositorio<Producto> repositorio = new ProductoRespositorioImp();
            System.out.println("============= [Listar] =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= [Obtener por id] =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============= [Editar producto] =============");
            Producto producto = new Producto();

            producto.setId(9L);

            producto.setNombre("Teclado Corsair mecánico");
            producto.setPrecio(1200);
            Categoria categoria = new Categoria();
            categoria.setId(2L);
            producto.setCategoria(categoria);

            repositorio.guardar(producto);
            System.out.println("Producto editado con éxito");

            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
