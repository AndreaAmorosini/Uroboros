package controller.ControlloAccount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ShowAccount")
public class ShowAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        mostraPagina(request, response);
    }

    public void mostraPagina(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession(false);
        if(session.getAttribute("account")!=null){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineAccount/showAccount.jsp");
            rd.forward(request,response);
            return;
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/PagineAccount/login.jsp");
        dispatcher.forward(request,response);
    }
}
