package biblioteca;

import biblioteca.dao.LibroDAO;
import biblioteca.modelo.Libro;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibroDAO dao = new LibroDAO();

        // Insertar libro
        Libro libro1 = new Libro(0, "Cien años de soledad", "Gabriel García Márquez", 1967);
        dao.insertarLibro(libro1);

        // Mostrar todos los libros
        List<Libro> libros = dao.obtenerTodos();
        libros.forEach(libro -> {
            System.out.println(libro.getId() + " - " + libro.getTitulo());
        });

        // Actualizar un libro
        if (!libros.isEmpty()) {
            Libro libroActualizado = libros.get(0);
            libroActualizado.setTitulo("Cien años de soledad (Edición revisada)");
            dao.actualizarLibro(libroActualizado);
        }

        // Eliminar un libro
        if (!libros.isEmpty()) {
            dao.eliminarLibro(libros.get(0).getId());
        }
    }
}
