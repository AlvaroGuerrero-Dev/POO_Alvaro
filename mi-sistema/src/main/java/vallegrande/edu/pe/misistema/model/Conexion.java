package vallegrande.edu.pe.misistema.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3307/mi_sistema";
    private static final String USER = "root";
    private static final String PASSWORD = "123456"; // Agrega la clave de tu MySQL si la utilizas

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}