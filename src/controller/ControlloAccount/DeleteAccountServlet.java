package controller.ControlloAccount;

import model.Connection.*;
import model.JavaBeans.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteAccount")
public class DeleteAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cancellaAccount(request, response);
    }

    public void cancellaAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        var serviceAccount = new AccountDAO();
        var serviceContact = new ContactDAO();
        var serviceCarta = new CartaDAO();
        var serviceIndirizzo = new IndirizzoDAO();
        var serviceTransazioni = new TransazioneDAO();
        Account account = serviceAccount.doRetrieveByUsername(username);
        serviceIndirizzo.doDelete(account.getIndirizzo());
        serviceCarta.doDelete(account.getNumCarta());
        serviceContact.doDelete(account.getCF());
        serviceTransazioni.doDelete(username);
        serviceAccount.doDelete(username);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineAccount/adminAccount.jsp");
        rd.forward(request,response);
    }
}
