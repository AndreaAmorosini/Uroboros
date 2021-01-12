package controller.ControlloProdotti;

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

@WebServlet("/Catalogo")
public class CatalogoServlet extends HttpServlet {

    private final ProdottoDAO prodottoDAO = new ProdottoDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       visualizzaCatalogo(request, response);
    }

    public void visualizzaCatalogo(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        List<Prodotto> prodotti = prodottoDAO.doRetrieveAll(0,10);
        request.setAttribute("prodotti",prodotti);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/results/PagineProdotti/catalogo.jsp");
        requestDispatcher.forward(request,response);
    }
}
