package model.JavaBeans;

import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAccount extends TestCase {

    Account account;

    @Before
    public void setUp(){
        account = new Account();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testAccount(){
        account.setUsername("Username");
        account.setPassword("Password");
        account.setNumCarta(12345);
        account.setNomeAzienda("Azienda");
        account.setIndirizzo("indirizzo");
        account.setCF(12345);
        account.setAdmin(true);
        System.out.println("Dati Account");
        System.out.println(account.getUsername());
        System.out.println(account.getPassword());
        System.out.println(account.getCF());
        System.out.println(account.getIndirizzo());
        System.out.println(account.getNomeAzienda());
        System.out.println(account.getNumCarta());
        System.out.println(account.isAdmin());
        System.out.println(account.equals(account) + "\n");

    }


}
