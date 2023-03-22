package main.java.controladores;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// @author administrador
public class ConexionBD implements Serializable {

    private final Dotenv config;

    private final String host;
    private String mensaje = "";

    private Connection connection;

    public ConexionBD(Dotenv config) {
        this.config = Dotenv.configure().load();
        host = config.get("host");
    }

    public Dotenv getConfig() {
        return config;
    }

    public Connection abrirConexion() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(host);
            mensaje = "|BD|> Se ha conectado correctamente!";
            System.out.println(mensaje);
        } catch (SQLException e) {
            mensaje = "|BD|> Ha fallado la conexion!" + "\n" + " Log:" + e.getMessage();
            System.out.println(mensaje);
            return connection;
        }
        return connection;
    }

    public Connection cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("|BD| Se ha desconectado correctamente");
            }
        } catch (SQLException e) {
            mensaje = "|BD|> Ha fallado la conexion!" + "\n" + " Log:" + e.getMessage();
            System.out.println(mensaje);
            return connection;
        }
        return connection;
    }

}
