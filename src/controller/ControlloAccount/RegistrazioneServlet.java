package controller.ControlloAccount;

import model.Connection.*;
import model.JavaBeans.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registrazione")
public class RegistrazioneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           registrazione(request, response);
        }

        public void registrazione(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String username=request.getParameter("username");
                String password=request.getParameter("password");
                String verificaPassword = request.getParameter("password1");
                if(password.equals(verificaPassword)) {
                        String nome = request.getParameter("nome");
                        String cognome = request.getParameter("cognome");
                        int CF = Integer.parseInt(request.getParameter("CF"));
                        String dataDiNascita = request.getParameter("dataDiNascita");
                        String telefono = request.getParameter("telefono");
                        String mail = request.getParameter("mail");
                        int numCarta = Integer.parseInt(request.getParameter("#carta"));
                        String dataDiScadenza = request.getParameter("dataDiScadenza");
                        int CSV = Integer.parseInt(request.getParameter("CSV"));
                        String nomeTitolare = request.getParameter("nomeTitolare");
                        String cognomeTitolare = request.getParameter("cognomeTitolare");
                        String via = request.getParameter("via");
                        int CAP = Integer.parseInt(request.getParameter("CAP"));
                        String via2 = request.getParameter("via2");
                        String nazione = request.getParameter("nazione");
                        String regione = request.getParameter("regione");
                        String città = request.getParameter("città");
                        Contact contact = new Contact();
                        contact.setCF(CF);
                        contact.setNome(nome);
                        contact.setCognome(cognome);
                        contact.setEmail(mail);
                        contact.setTelefono(telefono);
                        contact.setDataDiNascita(dataDiNascita);
                        var serviceContact = new ContactDAO();
                        serviceContact.doSave(contact);
                        Carta carta = new Carta();
                        carta.setNumCarta(numCarta);
                        carta.setDataDiScadenza(dataDiScadenza);
                        carta.setCSV(CSV);
                        carta.setNomeTitolare(nomeTitolare);
                        carta.setCognomeTitolare(cognomeTitolare);
                        var serviceCarta = new CartaDAO();
                        serviceCarta.doSave(carta);
                        Indirizzo indirizzo = new Indirizzo();
                        indirizzo.setVia(via);
                        indirizzo.setCAP(CAP);
                        indirizzo.setVia2(via2);
                        indirizzo.setNazione(nazione);
                        indirizzo.setRegione(regione);
                        indirizzo.setCitta(città);
                        var serviceIndirizzo = new IndirizzoDAO();
                        serviceIndirizzo.doSave(indirizzo);
                        Account account = new Account();
                        account.setUsername(username);
                        account.setPassword(password);
                        account.setNumCarta(numCarta);
                        account.setCF(CF);
                        account.setIndirizzo(via);
                        var serviceAccount = new AccountDAO();
                        serviceAccount.doSave(account);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/PagineAccount/risultatoRegistrazione.jsp");
                        dispatcher.forward(request, response);
                }else{
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/PagineAccount/registrazioneFail.jsp");
                        dispatcher.forward(request,response);
                }
        }
            //manda ad una pagina di errore per il non avere inserito le due password uguali
}
