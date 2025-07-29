/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author pame
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.Vuelo;
import util.Conexion;
import java.time.LocalDate;
import java.time.LocalTime;

public class VueloDAO {

    public boolean insertarVuelo(Vuelo vuelo) {
        String sql = "INSERT INTO Vuelo (aerolinea, origen, destino, fecha, hora, escalas, precio, cupos) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, vuelo.getAerolinea());
            stmt.setString(2, vuelo.getOrigen());
            stmt.setString(3, vuelo.getDestino());
            stmt.setDate(4, Date.valueOf(vuelo.getFecha()));
            stmt.setTime(5, Time.valueOf(vuelo.getHora()));
            stmt.setInt(6, vuelo.getEscalas());
            stmt.setDouble(7, vuelo.getPrecio());
            stmt.setInt(8, vuelo.getCupos());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al insertar vuelo: " + e.getMessage());
            return false;
        }
    }

    public List<Vuelo> listarVuelos() {
        List<Vuelo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Vuelo";
        try (Connection con = Conexion.conectar();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vuelo vuelo = new Vuelo();
                vuelo.setId(rs.getInt("id"));
                vuelo.setAerolinea(rs.getString("aerolinea"));
                vuelo.setOrigen(rs.getString("origen"));
                vuelo.setDestino(rs.getString("destino"));
                vuelo.setFecha(rs.getDate("fecha").toLocalDate());
                vuelo.setHora(rs.getTime("hora").toLocalTime());
                vuelo.setEscalas(rs.getInt("escalas"));
                vuelo.setPrecio(rs.getDouble("precio"));
                vuelo.setCupos(rs.getInt("cupos"));

                lista.add(vuelo);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar vuelos: " + e.getMessage());
        }
        return lista;
    }

    public Vuelo buscarVueloPorId(int id) {
        Vuelo vuelo = null;
        String sql = "SELECT * FROM Vuelo WHERE id = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                vuelo = new Vuelo();
                vuelo.setId(rs.getInt("id"));
                vuelo.setAerolinea(rs.getString("aerolinea"));
                vuelo.setOrigen(rs.getString("origen"));
                vuelo.setDestino(rs.getString("destino"));
                vuelo.setFecha(rs.getDate("fecha").toLocalDate());
                vuelo.setHora(rs.getTime("hora").toLocalTime());
                vuelo.setEscalas(rs.getInt("escalas"));
                vuelo.setPrecio(rs.getDouble("precio"));
                vuelo.setCupos(rs.getInt("cupos"));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar vuelo por ID: " + e.getMessage());
        }
        return vuelo;
    }
}
