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

@WebServlet("/showCategoriaDetails")
public class ShowCategoriaDetailsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraDettagliCategoria(request,response);
    }

    public void mostraDettagliCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int IDCategoria = Integer.parseInt(request.getParameter("IDCategoria"));
        var serviceCategoria = new CategoriaDAO();
        Categoria categoria = serviceCategoria.doRetrieveByID(IDCategoria);
        request.setAttribute("categoria",categoria);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineCategorie/showCategoriaDetails.jsp");
        rd.forward(request,response);
    }
}
