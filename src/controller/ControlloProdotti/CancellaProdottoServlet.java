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

@WebServlet("/CancellaProdotto")
public class CancellaProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cancellaProdotto(request, response);
    }

    public void cancellaProdotto(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        int prodID = Integer.parseInt(request.getParameter("prodID"));
        var serviceProdotti = new ProdottoDAO();
        serviceProdotti.doDelete(prodID);
        serviceProdotti.doDeleteCategoria(prodID);
        List<Prodotto> prodotti = serviceProdotti.doRetrieveAll(0,10);
        request.setAttribute("prodotti",prodotti);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineProdotti/gestioneProdotti.jsp");
        rd.forward(request,response);
    }
}
