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

@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       cercaProdotto(request, response);
    }

    public void cercaProdotto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm=request.getParameter("searchTerm");
        ProdottoDAO prodottoDAO = new ProdottoDAO();
        List<Prodotto> prodotti=prodottoDAO.getProdottiByNameLikeness(searchTerm);
        request.setAttribute("searchResult",prodotti);
        request.setAttribute("searchTerm",searchTerm);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineProdotti/searchResult.jsp");
        rd.forward(request,response);
    }
}
