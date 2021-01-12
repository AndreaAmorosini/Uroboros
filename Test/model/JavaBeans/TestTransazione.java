package model.JavaBeans;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

public class TestTransazione extends TestCase {

    Transazione transazione;

    @Before
    public void setUp(){
        transazione = new Transazione();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testTransazione(){
        transazione.setIdTransazione(12);
        transazione.setUsername("Username");
        transazione.setData(Date.valueOf("2000-03-24"));
        transazione.setSpesa(35.40);
        System.out.println("Dati transazione");
        System.out.println(transazione.getIdTransazione());
        System.out.println(transazione.getUsername());
        System.out.println(transazione.getData());
        System.out.println(transazione.getSpesa() + "\n");
    }


}
