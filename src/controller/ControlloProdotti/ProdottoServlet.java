package controller.ControlloProdotti;

import controller.HomePage.MyServletException;
import model.JavaBeans.Prodotto;
import model.Connection.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Prodotto")
public class ProdottoServlet extends HttpServlet {

    private final ProdottoDAO prodottoDAO = new ProdottoDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraPaginaProdotto(request, response);
    }

    public void mostraPaginaProdotto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id;
        try{
            id = Integer.parseInt(request.getParameter("id"));
        }catch(NumberFormatException e){
            throw new MyServletException("ID Prodotto non valido");
        }
        Prodotto prodotto = prodottoDAO.doRetrieveByID(id);
        if(prodotto==null){
            throw new MyServletException("Prodotto non Trovato");
        }
        request.setAttribute("prodotto",prodotto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/PagineProdotti/prodotto.jsp");
        dispatcher.forward(request,response);
    }
}
