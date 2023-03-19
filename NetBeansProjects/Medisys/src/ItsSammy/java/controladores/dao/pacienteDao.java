/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ItsSammy.java.controladores.dao;

import ItsSammy.java.controladores.jpaControl.InformacionPacienteJpaController;
import ItsSammy.java.controladores.jpaControl.PacienteJpaController;
import ItsSammy.java.controladores.jpaControl.exceptions.IllegalOrphanException;
import ItsSammy.java.controladores.jpaControl.exceptions.NonexistentEntityException;
import ItsSammy.java.controladores.modelos.InformacionPaciente;
import ItsSammy.java.controladores.modelos.Paciente;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author administrador
 */
public class pacienteDao {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MedisysPU");
    PacienteJpaController pacienteJpa = new PacienteJpaController(emf);
    InformacionPacienteJpaController infoPacienteJpa = new InformacionPacienteJpaController(emf);
    Paciente paciente = new Paciente();
    InformacionPaciente infoPaciente = new InformacionPaciente();
    String mensaje = "";

    public String registrarPaciente(String nombrePaciente, String apellidoPaciente, String cedulaPaciente, String sexoPaciente,
            int edadPaciente, double alturaPaciente, double pesoPaciente, double presionPaciente, String notaPaciente,
            String correoPaciente, Date fechaNacimiento, String numeroTelefono, String direccionPaciente) {
        try {

            paciente.setIdPaciente(Integer.SIZE);
            paciente.setNombrePaciente(nombrePaciente);
            paciente.setApellidoPaciente(apellidoPaciente);
            paciente.setCedulaPaciente(cedulaPaciente);
            paciente.setSexoPaciente(sexoPaciente);
            paciente.setEdadPaciente(edadPaciente);
            paciente.setAlturaPaciente(alturaPaciente);
            paciente.setPesoPaciente(pesoPaciente);
            paciente.setPresionPaciente(presionPaciente);
            paciente.setNotaPaciente(notaPaciente);
            paciente.setIdInfoPaciente(infoPaciente);

            infoPaciente.setIdInfoPaciente(Integer.SIZE);
            infoPaciente.setCorreoPaciente(correoPaciente);
            infoPaciente.setFechaNacimiento(fechaNacimiento);
            infoPaciente.setNumeroTelefono(numeroTelefono);
            infoPaciente.setDireccionPaciente(direccionPaciente);

            infoPacienteJpa.create(infoPaciente);
            pacienteJpa.create(paciente);

            mensaje = "El paciente se ha registrado correctamente.";

        } catch (Exception e) {

            mensaje = "No se pudo registrar al paciente debido a un error en el sistema. Por favor, inténtelo de nuevo más tarde o póngase en contacto con el soporte técnico para obtener ayuda.";
            System.out.println("ERROR: " + e.getMessage());

        }

        return mensaje;
    }

    public String actualizarPaciente(int idPaciente, int idInfoPaciente, String nombrePaciente, String apellidoPaciente, String cedulaPaciente, String sexoPaciente,
            int edadPaciente, double alturaPaciente, double pesoPaciente, double presionPaciente, String notaPaciente,
            String correoPaciente, Date fechaNacimiento, String numeroTelefono, String direccionPaciente) {
        try {
            infoPaciente = infoPacienteJpa.findInformacionPaciente(idInfoPaciente);
            paciente = pacienteJpa.findPaciente(idPaciente);

            infoPaciente.setIdInfoPaciente(idInfoPaciente);
            infoPaciente.setCorreoPaciente(correoPaciente);
            infoPaciente.setFechaNacimiento(fechaNacimiento);
            infoPaciente.setNumeroTelefono(numeroTelefono);
            infoPaciente.setDireccionPaciente(direccionPaciente);

            paciente.setIdPaciente(idPaciente);
            paciente.setNombrePaciente(nombrePaciente);
            paciente.setApellidoPaciente(apellidoPaciente);
            paciente.setCedulaPaciente(cedulaPaciente);
            paciente.setSexoPaciente(sexoPaciente);
            paciente.setEdadPaciente(edadPaciente);
            paciente.setAlturaPaciente(alturaPaciente);
            paciente.setPesoPaciente(pesoPaciente);
            paciente.setPresionPaciente(presionPaciente);
            paciente.setNotaPaciente(notaPaciente);
            paciente.setIdInfoPaciente(infoPaciente);

            pacienteJpa.edit(paciente);
            infoPacienteJpa.edit(infoPaciente);

            mensaje = "El paciente con ID " + idPaciente + " ha sido actualizado correctamente";

        } catch (Exception e) {

            mensaje = "Error al actualizar el paciente con ID " + idPaciente + ": " + e.getMessage();
            System.out.println("Error al actualizar el paciente con ID " + idPaciente + ": " + e.getLocalizedMessage());
        }
        return mensaje;

    }

    public String borrarPaciente(int idPaciente) {
        try {
            pacienteJpa.destroy(idPaciente);
            infoPacienteJpa.destroy(idPaciente);

            mensaje = "El paciente con id " + idPaciente + " ha sido borrado correctamente.";

        } catch (IllegalOrphanException | NonexistentEntityException e) {

            mensaje = "ERROR: No se ha podido borrar el paciente con id " + idPaciente + ".";
            System.out.println("ERROR: " + e.getMessage());
        }
        return mensaje;
    }

}
