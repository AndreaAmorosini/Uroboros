package controller.ControlloOrdini;

import model.JavaBeans.Prodotto;
import model.Connection.TransazioneDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ProdottiOrdine")
public class ProdottiOrdineServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        recuperaProdottiTransazione(request, response);
    }

    public void recuperaProdottiTransazione(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int IdTransazione = Integer.parseInt(request.getParameter("IdTransazione"));
        TransazioneDAO serviceTransazione = new TransazioneDAO();
        ArrayList<Prodotto> prodottiOrdine = serviceTransazione.doRetrieveProdotti(IdTransazione);
        request.setAttribute("prodottiOrdine",prodottiOrdine);
        request.setAttribute("idTransazione",IdTransazione);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineOrdini/showProdottiOrdine.jsp");
        rd.forward(request,response);
    }
}
