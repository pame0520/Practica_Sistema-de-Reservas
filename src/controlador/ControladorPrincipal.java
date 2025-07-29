/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.JFrame;
import modelo.Usuario;
import vista.HacerReserva;
import vista.LoginUsuario;
import vista.RegistroUsuario;
import vista.VerItinerario;

/**
 *
 * @author pame
 */
public class ControladorPrincipal {

    private Usuario usuario;

    public void mostrarLogin(JFrame parent) {
        LoginUsuario login = new LoginUsuario(parent, true);
        login.setVisible(true);
        usuario = login.getUsuarioLogueado();
    }

    public void mostrarRegistro(JFrame parent) {
        RegistroUsuario registro = new RegistroUsuario(parent, true);
        registro.setVisible(true);
    }

    public void mostrarReservas(JFrame parent) {
        if (usuario != null) {
            HacerReserva reserva = new HacerReserva(parent, true, usuario);
            reserva.setVisible(true);
        }
    }

    public void mostrarItinerario(JFrame parent) {
        if (usuario != null) {
            VerItinerario ver = new VerItinerario(parent, true, usuario);
            ver.setVisible(true);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }
}