package model.Connection;

import model.JavaBeans.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class TestAccountDAO {

    AccountDAO accountDAO;
    Account account;
    Account account1;
    ArrayList<Account> accounts;

    @Before
    public void setUp(){
        accountDAO = new AccountDAO();
        account = new Account();
        account.setUsername("Username");
        account.setPassword("Password");
        account.setNumCarta(12345);
        account.setNomeAzienda("Azienda");
        account.setIndirizzo("indirizzo");
        account.setCF(12345);
        account.setAdmin(true);
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testAccountDAO(){
        accountDAO.doSave(account);
        account1 = accountDAO.doRetrieveByUsernameAndPassword("Username", "Password");
        account1 = accountDAO.doRetrieveByUsername("Username");
        accounts = accountDAO.doRetrieveAll();
        accountDAO.doUpdate("Username", "Username", "Password", 12345, 12345, "Indirizzo");
        accountDAO.doDelete("Username");
    }
}
