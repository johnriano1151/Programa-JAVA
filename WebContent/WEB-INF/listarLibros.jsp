<%@ page import="java.util.List" %>
<%@ page import="biblioteca.modelo.Libro" %>
<%
    List<Libro> libros = (List<Libro>) request.getAttribute("libros");
%>
<!DOCTYPE html>
<html>
<head><title>Listado de Libros</title></head>
<body>
    <h1>Libros Registrados</h1>
    <table border="1">
        <tr><th>ID</th><th>Título</th><th>Autor</th><th>Año</th></tr>
        <%
            for (Libro libro : libros) {
        %>
        <tr>
            <td><%= libro.getId() %></td>
            <td><%= libro.getTitulo() %></td>
            <td><%= libro.getAutor() %></td>
            <td><%= libro.getAnioPublicacion() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
