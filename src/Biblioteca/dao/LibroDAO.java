package biblioteca.dao;

import biblioteca.modelo.Libro;
import biblioteca.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAO {

    public void insertar(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autor, anio_publicacion) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setInt(3, libro.getAnioPublicacion());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Libro> listar() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                libros.add(new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getInt("anio_publicacion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return libros;
    }
}

