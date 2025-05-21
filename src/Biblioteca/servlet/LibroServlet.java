package biblioteca.servlet;

import biblioteca.dao.LibroDAO;
import biblioteca.modelo.Libro;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class LibroServlet extends HttpServlet {

    private LibroDAO libroDAO = new LibroDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        int anio = Integer.parseInt(request.getParameter("anio"));

        Libro libro = new Libro(0, titulo, autor, anio);
        libroDAO.insertar(libro);

        response.sendRedirect("listarLibros.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Libro> libros = libroDAO.listar();
        request.setAttribute("libros", libros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listarLibros.jsp");
        dispatcher.forward(request, response);
    }
}
