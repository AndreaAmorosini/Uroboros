package controller.ControlloAccount;

import model.JavaBeans.Account;
import model.Connection.AccountDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/GestioneAccount")
public class GestioneAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraGestioneAccount(request, response);
    }

    public void mostraGestioneAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        var serviceAccount = new AccountDAO();
        ArrayList<Account> accounts = serviceAccount.doRetrieveAll();
        request.setAttribute("accounts",accounts);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineAccount/gestioneAccount.jsp");
        rd.forward(request,response);
    }
}
