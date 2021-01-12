package controller.ControlloOrdini;

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

@WebServlet("/showStoricoAdmin")
public class ShowStoricoAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraStoricoAdmin(request,response);
    }

    public void mostraStoricoAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        var serviceTransazioni = new TransazioneDAO();
        ArrayList<Transazione> transazioni = serviceTransazioni.doRetrieveAllByUsername(username);
        HttpSession session = request.getSession();
        session.setAttribute("transazioni",transazioni);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineOrdini/storicoOrdini.jsp");
        rd.forward(request,response);
    }
}
