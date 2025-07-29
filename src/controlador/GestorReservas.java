/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import dao.ReservaDAO;
import java.util.List;
import modelo.Reserva;

/**
 *
 * @author pame
 */
public class GestorReservas {

    private final ReservaDAO reservaDAO;

    public GestorReservas() {
        reservaDAO = new ReservaDAO();
    }

    public boolean crearReserva(Reserva reserva) {
        return reservaDAO.insertarReserva(reserva);
    }

    public List<Reserva> obtenerReservasDeUsuario(int idUsuario) {
        return reservaDAO.obtenerReservasPorUsuario(idUsuario);
    }

    public boolean cancelarReserva(int idReserva) {
        return reservaDAO.cancelarReserva(idReserva);
    }
}
