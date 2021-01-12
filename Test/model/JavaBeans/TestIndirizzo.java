package model.JavaBeans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIndirizzo {
    Indirizzo indirizzo;

    @Before
    public void setUp(){
        indirizzo = new Indirizzo();
    }

    @After
    public void tearDown(){

    }

    @Test
    public void testIndirizzo(){
        indirizzo.setVia("via");
        indirizzo.setVia2("via2");
        indirizzo.setNazione("nazione");
        indirizzo.setRegione("regione");
        indirizzo.setCitta("citta");
        indirizzo.setCAP(12345);
        System.out.print("Dati Indirizzo");
        System.out.println(indirizzo.getVia());
        System.out.println(indirizzo.getVia2());
        System.out.println(indirizzo.getNazione());
        System.out.println(indirizzo.getRegione());
        System.out.println(indirizzo.getCitta());
        System.out.println(indirizzo.getCAP() + "\n");
    }
}
