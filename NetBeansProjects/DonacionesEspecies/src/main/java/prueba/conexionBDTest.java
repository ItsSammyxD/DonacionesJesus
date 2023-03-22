package main.java.prueba;

import io.github.cdimascio.dotenv.Dotenv;
import main.java.controladores.ConexionBD;
import java.util.logging.Level;
import java.util.logging.Logger;

// @author administrador
public class conexionBDTest {

    public static void main(String[] args) {

        try {
            Dotenv dotenv = Dotenv.configure().load();
            ConexionBD con = new ConexionBD(dotenv);
            con.abrirConexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexionBDTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
