package controller.ControlloProdotti;

import model.JavaBeans.Prodotto;
import model.Connection.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;



@MultipartConfig
@WebServlet("/AggiungiProdotto")
public class AggiungiProdottoServlet extends HttpServlet {
    private static final String CARTELLA_UPLOAD = "img";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        aggiungiProdotto(request, response);
    }

    public void aggiungiProdotto(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        /*Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        String destinazione = CARTELLA_UPLOAD + File.separator + fileName;
        Path pathDestinazione = Paths.get(filePart.getSubmittedFileName().getFileName().toString());
        for(int i = 2; Files.exists(pathDestinazione);i++){
            destinazione = CARTELLA_UPLOAD + File.separator + i + "_" + fileName;
            pathDestinazione = Paths.get(getServletContext().getRealPath(destinazione));
        }
        InputStream fileInputStream = filePart.getInputStream();
        Files.createDirectories(pathDestinazione.getParent());
        Files.copy(fileInputStream,pathDestinazione);
        request.setAttribute("uploaded",destinazione);*/
        int prodID=Integer.parseInt(request.getParameter("prodID"));
        String nome = request.getParameter("nome");
        String descrizione = request.getParameter("descrizione");
        Double prezzo = Double.parseDouble(request.getParameter("prezzo"));
        int quantita = Integer.parseInt(request.getParameter("quantita"));
        int idCategoria = Integer.parseInt(request.getParameter("categoria"));
        var serviceProdotto = new ProdottoDAO();
        serviceProdotto.doSave(prodID,nome,descrizione,prezzo,quantita);
        serviceProdotto.doSaveCategoria(prodID,idCategoria);
        List<Prodotto> prodotti = serviceProdotto.doRetrieveAll(0,10);
        request.setAttribute("prodotti",prodotti);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/results/PagineProdotti/gestioneProdotti.jsp");
        rd.forward(request,response);
    }
}
