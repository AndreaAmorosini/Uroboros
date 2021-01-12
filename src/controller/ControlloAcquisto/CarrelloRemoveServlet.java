package controller.ControlloAcquisto;

import model.JavaBeans.Carrello;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/CarrelloRemove")
public class CarrelloRemoveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        rimuoviDalCarrello(request, response);
    }

    public void rimuoviDalCarrello(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        HttpSession session = request.getSession();
        Carrello carrello = (Carrello) session.getAttribute("carrello");
        String prodIdString = request.getParameter("prodId");
        int prodId = Integer.parseInt(prodIdString);
        carrello.remove(prodId);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineAcquisto/carrello.jsp");
        rd.forward(request,response);
    }
}
