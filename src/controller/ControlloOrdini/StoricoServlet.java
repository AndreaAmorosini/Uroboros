package controller.ControlloOrdini;

import model.JavaBeans.Account;
import model.JavaBeans.Transazione;
import model.Connection.TransazioneDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/Storico")
public class StoricoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraStorico(request, response);
    }

    public void mostraStorico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account= (Account) session.getAttribute("account");
        var serviceTransazioni = new TransazioneDAO();
        ArrayList<Transazione> transazioni = serviceTransazioni.doRetrieveAllByUsername(account.getUsername());
        session.setAttribute("transazioni",transazioni);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineOrdini/storicoOrdini.jsp");
        rd.forward(request,response);
    }
}
