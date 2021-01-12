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
import java.util.List;

@WebServlet("/DeleteCategoria")
public class DeleteCategoriaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cancellaCategoria(request, response);
    }

    public void cancellaCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int IDCategoria = Integer.parseInt(request.getParameter("IDCategoria"));
        var serviceCategoria = new CategoriaDAO();
        serviceCategoria.doDelete(IDCategoria);
        List<Categoria> categorie = serviceCategoria.doRetrieveAll();
        request.setAttribute("categorie", categorie);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineCategorie/gestioneCategorie.jsp");
        rd.forward(request,response);

    }
}
