package controller.ControlloCategorie;

import model.JavaBeans.Categoria;
import model.Connection.CategoriaDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Categoria")
public class CategoriaServlet extends HttpServlet {

    private final CategoriaDAO categoriaDAO = new CategoriaDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraCategoria(request, response);
    }

    public void mostraCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        model.JavaBeans.Categoria categoria = categoriaDAO.doRetrieveByID(id);
        request.setAttribute("categoria",categoria);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/PagineCategorie/categoria.jsp");
        dispatcher.forward(request,response);
    }
}
