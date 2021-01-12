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

@WebServlet("/GestioneProdotti")
public class GestioneProdottiServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraGestioneProdotti(request, response);
    }

    public void mostraGestioneProdotti(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        var serviceProdotti= new ProdottoDAO();
        List<Prodotto> prodotti = serviceProdotti.doRetrieveAll(0,10);
        request.setAttribute("prodotti",prodotti);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineProdotti/gestioneProdotti.jsp");
        rd.forward(request,response);
    }
}
