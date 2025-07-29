/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author pame
 */
public class Vuelo {

    private int id;
    private String aerolinea;
    private String origen;
    private String destino;
    private LocalDate fecha;
    private LocalTime hora;
    private int escalas;
    private double precio;
    private int cupos;

    public Vuelo() {
    }

    public Vuelo(int id, String aerolinea, String origen, String destino, LocalDate fecha, LocalTime hora, int escalas, double precio, int cupos) {
        this.id = id;
        this.aerolinea = aerolinea;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.escalas = escalas;
        this.precio = precio;
        this.cupos = cupos;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAerolinea() { return aerolinea; }
    public void setAerolinea(String aerolinea) { this.aerolinea = aerolinea; }

    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHora() { return hora; }
    public void setHora(LocalTime hora) { this.hora = hora; }

    public int getEscalas() { return escalas; }
    public void setEscalas(int escalas) { this.escalas = escalas; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getCupos() { return cupos; }
    public void setCupos(int cupos) { this.cupos = cupos; }
}
