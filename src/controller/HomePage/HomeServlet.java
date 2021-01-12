package controller.HomePage;

import model.JavaBeans.Categoria;
import model.Connection.CategoriaDAO;
import model.JavaBeans.Prodotto;
import model.Connection.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="/HomeServlet",urlPatterns="",loadOnStartup = 1)
public class HomeServlet extends HttpServlet {

    private final ProdottoDAO prodottoDAO = new ProdottoDAO();

    @Override
    public void init() throws ServletException {
        CategoriaDAO categoriaDAO=new CategoriaDAO();
        List<Categoria> categorie=categoriaDAO.doRetrieveAll();
        getServletContext().setAttribute("categorie",categorie);
        super.init();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraPaginaIniziale(request, response);
    }

    public void mostraPaginaIniziale(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Prodotto> prodotti = prodottoDAO.doRetrieveAll(0,10);
        request.setAttribute("prodotti",prodotti);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/results/HomePage/index.jsp");
        requestDispatcher.forward(request,response);
    }
}
