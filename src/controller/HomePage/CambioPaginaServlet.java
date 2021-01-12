package controller.HomePage;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cambioPagina")
public class CambioPaginaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String click = request.getParameter("link");
        String button = request.getParameter("button");
        if(click!=null) {
            if (click.equals("aboutus")) {
                mostraPaginaAboutUs(request, response);
            } else if (click.equals("contact")) {
                mostraPaginaContact(request, response);
            } else if (click.equals("dashboard")) {
                mostraDashBoardGestore(request, response);
            } else if (click.equals("registrazione")) {
                mostraPaginaRegistrazione(request, response);
            }
        } else if(button!=null){
            if(button.equals("Modifica Dati")){
                mostraPaginaModificaAccount(request, response);
            } else if(button.equals("Aggiungi un Prodotto")){
                mostraPaginaAggiungiProdotto(request, response);
            } else if(button.equals("Aggiungi Categoria")){
                mostraPaginaAggiungiCategoria(request, response);
            } else if(button.equals("Registrati")){
                mostraPaginaRegistrazione(request, response);
            }
        }
    }

    public void mostraPaginaAboutUs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/HomePage/aboutUs.jsp");
        dispatcher.forward(request,response);
    }

    public void mostraPaginaAggiungiCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineCategorie/aggiungiCategoriaPage.jsp");
        rd.forward(request,response);
    }

    public void mostraPaginaAggiungiProdotto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineProdotti/aggiungiProdotto.jsp");
        rd.forward(request,response);
    }

    public void mostraPaginaContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/results/HomePage/contact.jsp");
        dispatcher.forward(request,response);
    }

    public void mostraDashBoardGestore(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineAccount/adminAccount.jsp");
        rd.forward(request,response);
    }

    public void mostraPaginaModificaAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineAccount/modificaDati.jsp");
        rd.forward(request,response);
    }

    public void mostraPaginaRegistrazione(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/PagineAccount/registrazione.jsp");
        dispatcher.forward(request,response);
    }
}
