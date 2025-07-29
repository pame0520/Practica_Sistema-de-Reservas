/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author pame
 */
import java.time.LocalDate;

public class Reserva {

    private int id;
    private int idUsuario;
    private int idVuelo;
    private LocalDate fechaReserva;

    public Reserva() {
    }

    public Reserva(int id, int idUsuario, int idVuelo, LocalDate fechaReserva) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idVuelo = idVuelo;
        this.fechaReserva = fechaReserva;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getIdVuelo() { return idVuelo; }
    public void setIdVuelo(int idVuelo) { this.idVuelo = idVuelo; }

    public LocalDate getFechaReserva() { return fechaReserva; }
    public void setFechaReserva(LocalDate fechaReserva) { this.fechaReserva = fechaReserva; }
}
