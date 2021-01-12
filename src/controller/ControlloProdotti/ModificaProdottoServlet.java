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

@WebServlet("/ModificaProdotto")
public class ModificaProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraPaginaModificaProdotto(request, response);
    }

    public void mostraPaginaModificaProdotto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int prodID=Integer.parseInt(request.getParameter("prodID"));
        var serviceProdotto = new ProdottoDAO();
        Prodotto prodotto = serviceProdotto.doRetrieveByID(prodID);
        request.setAttribute("prodotto",prodotto);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineProdotti/modificaProdotto.jsp");
        rd.forward(request,response);
    }
}
