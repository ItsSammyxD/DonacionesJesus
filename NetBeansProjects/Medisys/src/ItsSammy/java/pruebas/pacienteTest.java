/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ItsSammy.java.pruebas;

import ItsSammy.java.controladores.dao.pacienteDao;
import java.util.Date;

/**
 *
 * @author administrador
 */
public class pacienteTest {
    public static void main(String[] args) {
        
        pacienteDao pacienteDao = new pacienteDao();
        String nombrePaciente = "Maria Amelia";
        String apellidoPaciente = "";
        String cedulaPaciente = "1-544-312-7644";
        String sexoPaciente = "F";
        int edadPaciente = 16;
        double alturaPaciente = 151.0;
        double pesoPaciente = 110;
        double presionPaciente = 88;
        String notaPaciente = "Tiene salud!";
        String correoPaciente = "MariaAmelia@gmail.com";
        Date fechaNacimiento = new Date(2006, 07, 05);
        String numeroTelefono = "829-523-3421";
        String direccionPaciente = "";
        
        System.out.println(pacienteDao.registrarPaciente(nombrePaciente, apellidoPaciente, cedulaPaciente, sexoPaciente, edadPaciente, alturaPaciente, 
                pesoPaciente, presionPaciente, notaPaciente, correoPaciente, fechaNacimiento, numeroTelefono, direccionPaciente));
        
                }
}
