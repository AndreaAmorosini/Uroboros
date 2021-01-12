package controller.ControlloAcquisto;

import model.Connection.TransazioneDAO;
import model.JavaBeans.Account;
import model.JavaBeans.Carrello;
import model.JavaBeans.Prodotto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/Acquisto")
public class AcquistoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        acquisto(request, response);
    }

    public void acquisto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Carrello carrello = (Carrello) session.getAttribute("carrello");
        Account account = (Account) session.getAttribute("account");
        if(account!=null) {
            TransazioneDAO serviceTransazione = new TransazioneDAO();
            double prezzoTot = 0;
            for (Carrello.ProdottoQuantita prodotto : carrello.getProdotti()) {
                Prodotto prod = prodotto.getProdotto();
                prezzoTot += prod.getPrezzoProdotto();
            }
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            serviceTransazione.doSave(date, account.getUsername(), prezzoTot);
            int lastId = serviceTransazione.doRetrieveLastId();
            for (Carrello.ProdottoQuantita prodotto : carrello.getProdotti()) {
                Prodotto prod = prodotto.getProdotto();
                serviceTransazione.doSaveProdotti(lastId, prod.getIDprodotto(), account.getUsername());
                carrello.remove(prod.getIDprodotto());
            }
            RequestDispatcher rd = request.getRequestDispatcher("Storico");
            rd.forward(request, response);
        }else {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineAcquisto/errorAcquisto.jsp");
            rd.forward(request, response);
        }
    }
}
