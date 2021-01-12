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

@WebServlet("/ModificaDatiProdotto")
public class ModificaDatiProdottoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modificaDatiProdotto(request, response);
    }

    public void modificaDatiProdotto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
        int quantita = Integer.parseInt(request.getParameter("quantita"));
        int prodID = Integer.parseInt(request.getParameter("prodID"));
        var serviceProdotto = new ProdottoDAO();
        serviceProdotto.doUpdate(prodID,nome,descrizione,prezzo,quantita);
        List<Prodotto> prodotti = serviceProdotto.doRetrieveAll(0,10);
        request.setAttribute("prodotti",prodotti);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineProdotti/gestioneProdotti.jsp");
        rd.forward(request,response);
    }
}
