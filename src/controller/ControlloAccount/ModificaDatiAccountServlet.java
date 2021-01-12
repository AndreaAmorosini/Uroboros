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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ModificaDatiAccount")
public class ModificaDatiAccountServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            modificaDatiAccount(request, response);
        }

        public void modificaDatiAccount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String username=request.getParameter("username");
                String password=request.getParameter("password");
                String nome=request.getParameter("nome");
                String cognome=request.getParameter("cognome");
                int CF=Integer.parseInt(request.getParameter("CF"));
                String dataDiNascita = request.getParameter("dataDiNascita");
                String telefono=request.getParameter("telefono");
                String mail=request.getParameter("mail");
                int numCarta=Integer.parseInt(request.getParameter("#carta"));
                String dataDiScadenza=request.getParameter("dataDiScadenza");
                int CSV=Integer.parseInt(request.getParameter("CSV"));
                String nomeTitolare=request.getParameter("nomeTitolare");
                String cognomeTitolare=request.getParameter("cognomeTitolare");
                String via=request.getParameter("via");
                int CAP=Integer.parseInt(request.getParameter("CAP"));
                String via2=request.getParameter("via2");
                String nazione=request.getParameter("nazione");
                String regione=request.getParameter("regione");
                String città=request.getParameter("città");
                HttpSession session = request.getSession();
                Account account = (Account) session.getAttribute("account");
                Contact contact = (Contact) session.getAttribute("contact");
                Carta carta = (Carta) session.getAttribute("carta");
                Indirizzo indirizzo = (Indirizzo) session.getAttribute("indirizzo");
                var serviceAccount = new AccountDAO();
                var serviceContact = new ContactDAO();
                var serviceCarta = new CartaDAO();
                var serviceIndirizzo = new IndirizzoDAO();
                serviceAccount.doUpdate(account.getUsername(),username,password,CF,numCarta,via);
                serviceContact.doUpdate(contact.getCF(),CF,nome,cognome,dataDiNascita,telefono,mail);
                serviceCarta.doUpdate(carta.getNumCarta(),numCarta,dataDiScadenza,CSV,nomeTitolare,cognomeTitolare);
                serviceIndirizzo.doUpdate(indirizzo.getVia(),via,CAP,via2,nazione,regione,città);
                RequestDispatcher rd = request.getRequestDispatcher("/ShowAccount");
                rd.forward(request,response);
        }
    }
