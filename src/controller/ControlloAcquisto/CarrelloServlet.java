package controller.ControlloAcquisto;

import model.JavaBeans.Carrello;
import model.JavaBeans.Carrello.ProdottoQuantita;
import model.Connection.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Carrello")
public class CarrelloServlet extends HttpServlet {

    private final ProdottoDAO prodottoDAO = new ProdottoDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        aggiungiAlCarrello(request, response);
    }

    public void aggiungiAlCarrello(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        model.JavaBeans.Carrello carrello=(model.JavaBeans.Carrello) session.getAttribute("carrello");
        if(carrello==null) {
            carrello = new model.JavaBeans.Carrello();
            session.setAttribute("carrello", carrello);
        }
        String prodIdStr=request.getParameter("prodID");
        if(prodIdStr!=null){
            int prodId = Integer.parseInt(prodIdStr);
            String q = request.getParameter("quantita");
            if(q!=null){
                int quantita = Integer.parseInt(q);
                ProdottoQuantita prodQuant = carrello.get(prodId);
                if(prodQuant!=null){
                    prodQuant.setQuantita(prodQuant.getQuantita() + quantita);
                } else {
                    carrello.put(prodottoDAO.doRetrieveByID(prodId),quantita);
                }
            } else {
                String setNumString = request.getParameter("setNum");
                if(setNumString!=null){
                    int setNum = Integer.parseInt(setNumString);
                    if(setNum <= 0){
                        carrello.remove(prodId);
                    } else {
                        ProdottoQuantita prodQuant = carrello.get(prodId);
                        if(prodQuant!=null) {
                            prodQuant.setQuantita(setNum);
                        } else {
                            carrello.put(prodottoDAO.doRetrieveByID(prodId),setNum);
                        }
                    }
                }
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/PagineAcquisto/carrello.jsp");
        dispatcher.forward(request,response);
    }
}
