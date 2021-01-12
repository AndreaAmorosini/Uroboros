package controller.ControlloAccount;

import model.Connection.*;
import model.JavaBeans.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        login(request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        var serviceAccount=new AccountDAO();
        var serviceContact=new ContactDAO();
        var serviceCarta=new CartaDAO();
        var serviceIndirizzo=new IndirizzoDAO();
        var serviceTransazioni = new TransazioneDAO();
        Account account=serviceAccount.doRetrieveByUsernameAndPassword(username,password);
        if (account != null) {
            Contact contact = serviceContact.doRetrieveByCF(account.getCF());
            Carta carta = serviceCarta.doRetrieveBynumCarta(account.getNumCarta());
            Indirizzo indirizzo = serviceIndirizzo.doRetrieveByVia(account.getIndirizzo());
            ArrayList<Transazione> transazioni = serviceTransazioni.doRetrieveAllByUsername(username);
            request.setAttribute("account", account);
            HttpSession session = request.getSession(true);
            session.setAttribute("account", account);
            session.setAttribute("contact", contact);
            session.setAttribute("carta", carta);
            session.setAttribute("indirizzo", indirizzo);
            session.setAttribute("transazioni", transazioni);
            String dest = request.getHeader("referer");
            if(dest==null || dest.contains("/Login") || dest.trim().isEmpty()){
                dest = ".";
            }
            response.sendRedirect(dest);
        }
        else {
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineAccount/loginFail.jsp");
            rd.forward(request,response);
        }
    }
}
