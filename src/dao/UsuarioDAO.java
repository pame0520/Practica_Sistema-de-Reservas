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
import modelo.Usuario;
import util.Conexion;

public class UsuarioDAO {

    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nombre, correo, contrasena) VALUES (?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getCorreo());
            stmt.setString(3, usuario.getContrasena());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }

    public Usuario validarLogin(String correo, String contrasena) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE correo = ? AND contrasena = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, correo);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
            }

        } catch (SQLException e) {
            System.err.println("Error al validar login: " + e.getMessage());
        }

        return usuario;
    }

    public Usuario buscarUsuarioPorId(int id) {
        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE id = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar usuario: " + e.getMessage());
        }

        return usuario;
    }
}