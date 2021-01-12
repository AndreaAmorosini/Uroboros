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

@WebServlet("/GestioneCategorie")
public class GestioneCategorieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraGestioneCategorie(request, response);
    }

    public void mostraGestioneCategorie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        var serviceCategorie = new CategoriaDAO();
        List<Categoria> categorie = serviceCategorie.doRetrieveAll();
        request.setAttribute("categorie",categorie);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineCategorie/gestioneCategorie.jsp");
        rd.forward(request,response);
    }
}
