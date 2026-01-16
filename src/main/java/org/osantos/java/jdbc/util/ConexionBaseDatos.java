package org.osantos.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Santiago";
    private static String username = "root";
    private static String password = "root";   //Debe ser la misma que se definió en MySQL

    private static Connection connection;

    public static Connection getIntance() throws SQLException {
        if ((connection == null)){
            connection = DriverManager.getConnection(url,username, password);
        }
        return connection;
    }

}
