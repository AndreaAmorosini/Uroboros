package controller.ControlloAccount;

import model.Connection.AccountDAO;
import model.Connection.CartaDAO;
import model.Connection.ContactDAO;
import model.Connection.IndirizzoDAO;
import model.JavaBeans.Account;
import model.JavaBeans.Carta;
import model.JavaBeans.Contact;
import model.JavaBeans.Indirizzo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showAccountDetail")
public class ShowAccountDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraDettagliAccountAdmin(request, response);
    }

    public void mostraDettagliAccountAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        var serviceAccount = new AccountDAO();
        var serviceContact = new ContactDAO();
        var serviceCarta = new CartaDAO();
        var serviceIndirizzo = new IndirizzoDAO();
        Account account = serviceAccount.doRetrieveByUsername(username);
        Contact contact = serviceContact.doRetrieveByCF(account.getCF());
        Carta carta = serviceCarta.doRetrieveBynumCarta(account.getNumCarta());
        Indirizzo indirizzo = serviceIndirizzo.doRetrieveByVia(account.getIndirizzo());
        request.setAttribute("accountC",account);
        request.setAttribute("contactC",contact);
        request.setAttribute("cartaC",carta);
        request.setAttribute("indirizzoC",indirizzo);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineAccount/showAccountAdmin.jsp");
        rd.forward(request,response);
    }
}
