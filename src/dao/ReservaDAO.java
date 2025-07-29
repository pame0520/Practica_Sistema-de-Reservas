/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Reserva;
import util.Conexion;

/**
 *
 * @author pame
 */
public class ReservaDAO {

    public boolean insertarReserva(Reserva reserva) {
        String sql = "INSERT INTO Reserva (id_usuario, id_vuelo, fecha_reserva) VALUES (?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, reserva.getIdUsuario());
            stmt.setInt(2, reserva.getIdVuelo());
            stmt.setDate(3, Date.valueOf(reserva.getFechaReserva()));

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar reserva: " + e.getMessage());
            return false;
        }
    }

    public List<Reserva> obtenerReservasPorUsuario(int idUsuario) {
        List<Reserva> lista = new ArrayList<>();
        String sql = "SELECT * FROM Reserva WHERE id_usuario = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Reserva r = new Reserva();
                r.setId(rs.getInt("id"));
                r.setIdUsuario(rs.getInt("id_usuario"));
                r.setIdVuelo(rs.getInt("id_vuelo"));
                r.setFechaReserva(rs.getDate("fecha_reserva").toLocalDate());
                lista.add(r);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener reservas: " + e.getMessage());
        }
        return lista;
    }

    public boolean cancelarReserva(int idReserva) {
        String sql = "DELETE FROM Reserva WHERE id = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, idReserva);
            int filas = stmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e) {
            System.err.println("Error al cancelar reserva: " + e.getMessage());
            return false;
        }
    }
}
