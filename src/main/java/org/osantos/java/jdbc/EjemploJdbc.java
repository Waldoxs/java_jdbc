package org.osantos.java.jdbc;

import org.osantos.java.jdbc.modelo.Categoria;
import org.osantos.java.jdbc.modelo.Producto;
import org.osantos.java.jdbc.repositorio.ProductoRespositorioImp;
import org.osantos.java.jdbc.repositorio.Respositorio;
import org.osantos.java.jdbc.util.ConexionBaseDatos;
import java.sql.*;
import java.util.Date;

public class EjemploJdbc {
    public static void main(String[] args) {

        try (Connection conn = ConexionBaseDatos.getIntance()) {

            Respositorio<Producto> repositorio = new ProductoRespositorioImp();
            System.out.println("============= [Listar] =============");
            repositorio.listar().forEach(System.out::println);

            System.out.println("============= [Obtener por id] =============");
            System.out.println(repositorio.porId(1L));

            System.out.println("============= [Insertar nuevo producto] =============");
            Producto producto = new Producto();
            producto.setNombre("Teclado Red Dragón mecánico");
            producto.setPrecio(450);
            producto.setFechaRegistro(new Date());
            Categoria categoria = new Categoria();
            categoria.setId(3L);
            producto.setCategoria(categoria);

            repositorio.guardar(producto);
            System.out.println("Producto guardado con éxito");

            repositorio.listar().forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
