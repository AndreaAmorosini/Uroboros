package controller.ControlloAccount;

import model.Connection.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/VerificaUsername")
public class VerificaUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        verificaUsername(request, response);
    }

    public void verificaUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
        var serviceAccount = new AccountDAO();
        String username = request.getParameter("username");
        response.setContentType("text/xml");
        if(username != null && username.length() >= 6 && username.matches("^[0-9a-zA-Z]+$")&& serviceAccount.doRetrieveByUsername(username) == null){
            response.getWriter().append("<ok/>");
        }else{
            response.getWriter().append("<no/>");
        }
    }
}
